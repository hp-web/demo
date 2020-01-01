package com.example.mybatis;

public class Employee {
    private String id;
    private String last_name;
    private String email;
    private String gender;

    public Employee(String id ,String last_name, String email, String gender) {
        this.id = id;
        this.last_name = last_name;
        this.email = email;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
}
