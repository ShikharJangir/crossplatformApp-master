package com.example.project;

import jakarta.persistence.*;

@Entity
@Table(name="userdetails1")
public class UserDetailEntity {
    @Id
    private String username;
      @Column(name = "usertype",nullable = false)
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String usertype;



   @Column(name ="fname",nullable = false)
    private String firstname;

   @Column(name = "lname", nullable = false)
    private String lastname;

   @Column(name = "phone",nullable = false)
    private String phonenumber;

    public UserDetailEntity(String usertype, String username, String firstname, String lastname, String phonenumber) {
        this.username = username;
        this.usertype = usertype;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phonenumber = phonenumber;
    }

    public UserDetailEntity() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    @Override
    public String toString() {
        return "UserDetailEntity{" +
                "username='" + username + '\'' +
                ", usertype='" + usertype + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                '}';
    }
}
