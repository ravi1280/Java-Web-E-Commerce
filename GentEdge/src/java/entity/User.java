
package entity;

import java.io.Serializable;
import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User implements Serializable{
    
   @Id
    @Column(name = "email", length = 100, nullable = false)
    private String email;
   
   @Column(name = "fname",length = 50,nullable = false)
   private String firstName;
   
   @Column(name = "lname",length = 50,nullable = false)
   private String lastName;

   @Column(name = "mobile",length = 15,nullable = false)
   private String mobile;
   
   @Column(name = "password",length = 20,nullable = false)
   private String password;
   
   @Column(name = "verification",length = 50,nullable = false)
   private String veificatiion;

    public User() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVeificatiion() {
        return veificatiion;
    }

    public void setVeificatiion(String veificatiion) {
        this.veificatiion = veificatiion;
    }
    
   
    
}
