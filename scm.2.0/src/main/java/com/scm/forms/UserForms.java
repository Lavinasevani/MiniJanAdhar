package com.scm.forms;

import java.util.Objects;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserForms {
	
	@NotBlank(message="Name is required")
    private String name;
	@NotBlank(message="Email is required")
	@Email(message="Invalid email address")
    private String email;
    @Size(min=12,max=12,message = "Adhar number must be in 12 digits")
    private String adhar;
	@NotBlank(message="dob is required")
    private String dob;
	@Size(min=6,message = "password lenth should be grater than 6. ")
    private String password;

    // Default Constructor
    public UserForms() {
    }

    // Parameterized Constructor
    public UserForms(String name, String email, String adhar, String dob, String password) {
        this.name = name;
        this.email = email;
        this.adhar = adhar;
        this.dob = dob;
        this.password = password;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdhar() {
        return adhar;
    }

    public void setAdhar(String adhar) {
        this.adhar = adhar;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Override hashCode method
    @Override
    public int hashCode() {
        return Objects.hash(adhar, dob, email, name, password);
    }

    // Override equals method
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        UserForms other = (UserForms) obj;
        return Objects.equals(adhar, other.adhar) &&
                Objects.equals(dob, other.dob) &&
                Objects.equals(email, other.email) &&
                Objects.equals(name, other.name) &&
                Objects.equals(password, other.password);
    }

    // Override toString method
    @Override
    public String toString() {
        return "UserForms [name=" + name + ", email=" + email + ", adhar=" + adhar + ", dob=" + dob + ", password=" + password + "]";
    }
}
