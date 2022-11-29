package com.assignment.onebotanka.Model;

import java.util.Objects;

public class User {
    // Attributes
    public String firstName, lastName, email, gender, address, DOB, phoneNumber, password, rePassword;

    // Empty Constructor
    public User(){}

    // Constructor
    public User(String firstName, String lastName,
                String email, String gender,
                String address, String DOB,
                String phoneNumber, String password, String rePassword) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.address = address;
        this.DOB = DOB;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.rePassword = rePassword;
    }

    // Getters & Setters

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }

    // toString() methods
    @Override
    public String toString() {
        return "User[" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", DOB='" + DOB + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", password='" + password + '\'' +
                ", rePassword='" + rePassword + '\'' +
                ']';
    }

    // hashCodes() and equals()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return firstName.equals(user.firstName) && lastName.equals(user.lastName) && email.equals(user.email) && gender.equals(user.gender) && address.equals(user.address) && DOB.equals(user.DOB) && phoneNumber.equals(user.phoneNumber) && password.equals(user.password) && rePassword.equals(user.rePassword);
    }
    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email, gender, address, DOB, phoneNumber, password, rePassword);
    }
}
