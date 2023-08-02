package com.example.clubmanagement;

public class User_helper {

    String name;
    String roll;
    String department;

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    String last_name;

    public User_helper(String name, String last_name, String roll, String department,String email, String bkash) {
        this.name = name;
        this.last_name = last_name;
        this.roll = roll;
        this.department = department;
        this.email = email;
        this.bkash = bkash;
    }
    String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getBkash() {
        return bkash;
    }

    public void setBkash(String bkash) {
        this.bkash = bkash;
    }

    String bkash;

    public User_helper() {
    }
}
