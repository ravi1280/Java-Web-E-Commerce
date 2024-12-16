package controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.Response_DTO;
import dto.User_DTO;
import entity.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.HibernateUtil;
import model.Mail;
import model.Validation;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

@WebServlet(name = "SignUp", urlPatterns = {"/SignUp"})
public class SignUp extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Response_DTO response_DTO = new Response_DTO();
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        User_DTO udto = gson.fromJson(request.getReader(), User_DTO.class);

        if (udto.getfName().isEmpty()) {
            response_DTO.setContent("Please fill First Name filed");

        } else if (udto.getlName().isEmpty()) {
            response_DTO.setContent("Please fill Last Name Field");

        } else if (udto.getMobile().isEmpty()) {
            response_DTO.setContent("Please fill Mobile Field");

        } else if (udto.getEmail().isEmpty()) {
            response_DTO.setContent("Please fill  Email Field");

        } else if (!Validation.isEmailValid(udto.getEmail())) {
            response_DTO.setContent("Please fill  Valid Email");

        } else if (udto.getPassword().isEmpty()) {
            response_DTO.setContent("Please fill  Passwod Field");

        }  else {

            Session session = HibernateUtil.getSessionFactory().openSession();
            Criteria criteria1 = session.createCriteria(User.class);
            criteria1.add(Restrictions.eq("email", udto.getEmail()));

            if (!criteria1.list().isEmpty()) {
                response_DTO.setContent("Email  Already Exists . please use another Email to signUp process!");

            } else {
                //create verification code 
                int code = (int) (Math.random() * 1000000);

                //Insert User data 
                User user = new User();
                user.setFirstName(udto.getfName());
                user.setLastName(udto.getlName());
                user.setMobile(udto.getMobile());
                user.setEmail(udto.getEmail());
                user.setPassword(udto.getPassword());
                user.setVeificatiion(String.valueOf(code));

                //Send Email Verification
                Thread sendMail = new Thread(){
                    @Override
                    public void run() {
                                        Mail.sendMail(udto.getEmail(), "GentEdge Account Verification code", 
                        "<h1 style=\"color:#6699ff\">Yor Verification code is :"+user.getVeificatiion()+"</h1>" );
                    }
                    
                };
                sendMail.start();
                
                session.save(user);
                session.beginTransaction().commit();
                
                response_DTO.setSuccess(true);
                response_DTO.setContent("Registaion complete !!");
                
            }
            session.close();

        }
        response.getWriter().write(gson.toJson(response_DTO));

    }

}
