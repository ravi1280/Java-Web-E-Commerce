package controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.User_DTO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SignUp", urlPatterns = {"/SignUp"})
public class SignUp extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        User_DTO udto = gson.fromJson(request.getReader(), User_DTO.class);
        System.out.println(udto.getEmail());
        System.out.println(udto.getMobile());
        System.out.println(udto.getfName());
        System.out.println(udto.getlName());
        System.out.println(udto.getPassword());
        
        System.out.println(gson.toJson(udto));

    }

}
