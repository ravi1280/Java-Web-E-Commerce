
package model;

public class Validation {
    
    public static boolean isEmailValid(String email){
        
        return email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
    
    }
    
        public static boolean isPasswordValid(String passwod){
        
        return passwod.matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$");
    
    }
    
}
