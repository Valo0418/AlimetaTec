package com.example.alimentaTec.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UserPatient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userPatientId;
    private String userName;
    private String paternalSurname;
    private String maternalSurname;
    private int age;
    private String gender;
    private float height;
    private String userPassword;
    private String mail;
    private float weight;
    private String suffering;


    public int getUserPatientId() {
        return userPatientId;
    }

    public void setUserPatientId(int userPatientId) {
        this.userPatientId = userPatientId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPaternalSurname() {
        return paternalSurname;
    }

    public void setPaternalSurmane(String paternalSurname) {
        this.paternalSurname = paternalSurname;
    }

    public String getMaternalSurname() {
        return maternalSurname;
    }

    public void setMaternalSurname(String maternalSurname) {
        this.maternalSurname = maternalSurname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getSuffering() {
        return suffering;
    }

    public void setSuffering(String suffering) {
        this.suffering = suffering;
    }

    @Override
    public String toString() {
        return  + userPatientId + "::" + userName + "::" + paternalSurname + "::"
                + maternalSurname + "::" + age + "::" + gender + "::" + height + "::"
                + userPassword + "::" + mail + "::" + weight + "::" + suffering + "::";
    }
}
