package com.elearning.model;

public class User {

    private int id;
    private String name, phone, email, address, pincode, password, city, role;

    public User(String email,String password,String role){
        this.email = email;
        this.password = password;
        this.role = role;
    }
    public User(String name, String phone, String email, String address, String pincode, String password, String city, String role) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.pincode = pincode;
        this.password = password;
        this.city = city;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "email=" + email +
                ", password=" + password +
                ", role='" + role + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
