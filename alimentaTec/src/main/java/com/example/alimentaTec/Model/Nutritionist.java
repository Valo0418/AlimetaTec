package com.example.alimentaTec.Model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Nutritionist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int nutritionistId;
    private String nutritionistName;
    private String paternalSurnameN;
    private String maternalSurnameN;
    private int ageN;
    private String genderN;
    private String nutritionistPassword;
    private String mailNutritionist;
    private String nutritionistRegistration;


    public int getNutritionistId() {
        return nutritionistId;
    }

    public void setNutritionistId(int nutritionistId) {
        this.nutritionistId = nutritionistId;
    }

    public String getNutritionistName() {
        return nutritionistName;
    }

    public void setNutritionistName(String nutritionistName) {
        this.nutritionistName = nutritionistName;
    }

    public String getPaternalSurnameN() {
        return paternalSurnameN;
    }

    public void setPaternalSurnameN(String paternalSurnameN) {
        this.paternalSurnameN = paternalSurnameN;
    }

    public String getMaternalSurnameN() {
        return maternalSurnameN;
    }

    public void setMaternalSurnameN(String maternalSurnameN) {
        this.maternalSurnameN = maternalSurnameN;
    }

    public int getAgeN() {
        return ageN;
    }

    public void setAgeN(int ageN) {
        this.ageN = ageN;
    }

    public String getGenderN() {
        return genderN;
    }

    public void setGenderN(String genderN) {
        this.genderN = genderN;
    }

    public String getNutritionistPassword() {
        return nutritionistPassword;
    }

    public void setNutritionistPassword(String nutritionistPassword) {
        this.nutritionistPassword = nutritionistPassword;
    }

    public String getMailNutritionist() {
        return mailNutritionist;
    }

    public void setMailNutritionist(String mailNutritionist) {
        this.mailNutritionist = mailNutritionist;
    }

    public String getNutritionistRegistration() {
        return nutritionistRegistration;
    }

    public void setNutritionistRegistration(String nutritionistRegistration) {
        this.nutritionistRegistration = nutritionistRegistration;
    }

    @Override
    public String toString() {
        return + nutritionistId + "::" + nutritionistName + "::" + paternalSurnameN + "::"
                + maternalSurnameN + "::" + ageN + "::" + genderN + "::" + nutritionistPassword
                + "::" + mailNutritionist + "::"+ nutritionistRegistration + "::" ;
    }
}
