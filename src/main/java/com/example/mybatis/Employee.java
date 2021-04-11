package com.example.mybatis;

public class Employee {
    private String id;
    private String last_name;
    private String email;
    private String gender;
    private String caseNumber;

    public String getCaseNumber() {
        return caseNumber;
    }

    public void setCaseNumber(String caseNumber) {
        this.caseNumber = caseNumber;
    }

    public Employee(String id, String last_name, String email, String gender, String caseNumber) {
        this.id = id;
        this.last_name = last_name;
        this.email = email;
        this.gender = gender;
        this.caseNumber = caseNumber;
    }

    public Employee(String id, String last_name, String email, String gender) {
        this.id = id;
        this.last_name = last_name;
        this.email = email;
        this.gender = gender;

    }
    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
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

    @Override
    public boolean equals(Object obj) {
        if(obj==null){
            return false;
        }
        if(this==obj){
            return true;
        }
        if(obj instanceof Employee){
            Employee Employee=(Employee)obj;
            if(Employee.last_name.equals(this.last_name) &&Employee.email.equals(this.email)  && Employee.gender.equals(this.gender) ){
                return true;
            }else{
                return false;
            }
        }
        return false;
    }
}
