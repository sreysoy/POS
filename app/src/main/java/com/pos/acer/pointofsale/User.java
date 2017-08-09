package com.pos.acer.pointofsale;

/**
 * Created by Daly on 7/17/2017.
 */

public class User {
    private int userId;
    private int age;
    private String username;
    private String fullname;
    private String email;
    private String phoneNumber;
    private String gender;
    private String dateOfBirth;
    private String address;
    private String password;
    private String imgProfile;
    private String role;
    
    public User(){}
    public User(int userId, String username, String fullname, String gender, int age, String email,
                String phoneNumber, String password, String dateOfBirth, String address,
                String imgProfile, String role){

                setUserId(userId);
                setUsername(username);
                setFullname(fullname);
                setGender(gender);
                setAge(age);
                setEmail(email);
                setPhoneNumber(phoneNumber);
                setPassword(password);
                setDateOfBirth(dateOfBirth);
                setAddress(address);
                setImgProfile(imgProfile);
                setRole(role);
    }
    public int getUserId(){
        return userId;
    }
    
    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImgProfile() {
        return imgProfile;
    }

    public void setImgProfile(String imgProfile) {
        this.imgProfile = imgProfile;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

}