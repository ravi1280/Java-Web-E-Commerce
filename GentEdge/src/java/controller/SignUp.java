package controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.Response_DTO;
import dto.User_DTO;
import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.HibernateUtil;
import org.hibernate.Session;

@WebServlet(name = "SignUp", urlPatterns = {"/SignUp"})
public class SignUp extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
Response_DTO  response_DTO = new Response_DTO();
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        User_DTO udto = gson.fromJson(request.getReader(), User_DTO.class);
//        System.out.println(udto.getEmail());
//        System.out.println(udto.getMobile());
//        System.out.println(udto.getfName());
//        System.out.println(udto.getlName());
//        System.out.println(udto.getPassword());
//        
//        System.out.println(gson.toJson(udto));

        if (udto.getfName().isEmpty()) {
            response_DTO.setContent("Please fill First Name filed");

        } else if (udto.getlName().isEmpty()) {
            response_DTO.setContent("Please fill Last Name Field");

        } else if (udto.getMobile().isEmpty()) {
            response_DTO.setContent("Please fill Mobile Field");

        } else if (udto.getEmail().isEmpty()) {
            response_DTO.setContent("Please fill  Email Field");

        } else if (udto.getEmail().validate) {

        } else if (udto.getPassword().isEmpty()) {
            response_DTO.setContent("Please fill  Passwod Field");

        } else if (udto.getPassword().validate) {
            
            Session session = HibernateUtil.getSessionFactory().openSession();
           User user = new User();
//           user.setEmail(email);
//           user.setEmail(email);
//           user.setEmail(email);
//           user.setEmail(email)
                   
                   session.save(user);
                   session.close();

        }

    }

}
