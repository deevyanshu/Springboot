package com.deevyanshu.validation.entitity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull(message = "name cannot be empty")
    @NotBlank(message = "name cannot be empty")
    private String name;

    @Email(message = "wrong format")
    private String email;
    
    @NotNull(message = "cannot be empty")
    @NotBlank(message = "cannot be blank")
    @Pattern(regexp = "^[0-9]*$")
    @Size(min = 10,max = 10)
    private String mobile;
    
    public User()
    {

    }

    public User(int id, String name,String email,String mobile)
    {
        this.id=id;
        this.name=name;
        this.email=email;
        this.mobile=mobile;
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }

    public String getMobile() {
        return mobile;
    }

    public String getName() {
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
}
