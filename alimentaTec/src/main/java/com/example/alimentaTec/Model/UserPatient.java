package com.example.alimentaTec.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "userpatient")
public class UserPatient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="userPatientId")
    @JsonProperty("userPatientId")
    private Integer userPatientId;

    @Column(name ="userName")
    @JsonProperty("userName")
    private String userName;

    @Column(name ="paternalSurname")
    @JsonProperty("paternalSurname")
    private String paternalSurname;

    @Column(name ="maternalSurname")
    @JsonProperty("maternalSurname")
    private String maternalSurname;

    @Column(name ="age")
    @JsonProperty("age")
    private int age;

    @Column(name ="gender")
    @JsonProperty("gender")
    private String gender;

    @Column(name ="height")
    @JsonProperty("height")
    private float height;

    @Column(name ="weight")
    @JsonProperty("weight")
    private float weight;

    @Column(name ="suffering")
    @JsonProperty("suffering")
    private String suffering;

    public Integer getUserPatientId() {
        return userPatientId;
    }

    public void setUserPatientId(Integer userPatientId) {
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

    //@Override
    //public String toString() {
    //    return  + userPatientId + "::" + userName + "::" + paternalSurname + "::"
    //            + maternalSurname + "::" + age + "::" + gender + "::" + height + "::"
    //            + userPassword + "::" + mail + "::" + weight + "::" + suffering + "::";
    //}
}
