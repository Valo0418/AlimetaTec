package com.example.alimentaTec.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Nutritionist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idNutritionist;
    private String nameActivity;
    private String nutritionistName;
    private String paternalSurnameN;
    private String maternalSurnameN;
    private int ageN;
    private String genderN;
    private String passwordNutritionist;
    private String mailNutritionist;
    private String nutritionistRegistration;

    public int getIdNutritionist(){return idNutritionist;}
    public void setIdNutritionist(int idNutritionist){this.idNutritionist = idNutritionist;}

    public String getNameActivity(){return nameActivity;}
    public void setNameActivity(String nameActivity){this.nameActivity = nameActivity;}
    
    public String getNutritionistName(){return nutritionistName;}
    public void setNutritionistName(String nutritionistName){this.nutritionistName = nutritionistName;}

    public String getPaternalSurnameN(){return paternalSurnameN;}
    public void setPaternalSurnameN(String paternalSurnameN){this.paternalSurnameN = paternalSurnameN;}

    public String getMaternalSurnameN(){return maternalSurnameN;}
    public void setMaternalSurnameN(String maternalSurnameN){this.maternalSurnameN = maternalSurnameN;}
    
    public int getAgeN(){return ageN;}
    public void setAgeN(int ageN){this.ageN = ageN;}
    
    public String getGenderN(){return genderN;}
    public void setGenderN(String genderN){this.genderN = genderN;}

    public String getPasswordNutritionist(){return passwordNutritionist;}
    public void setPasswordNutritionist(String passwordNutritionist){this.passwordNutritionist = passwordNutritionist;}

    public String getMailNutritionist(){return mailNutritionist;}
    public void setMailNutritionist(String mailNutritionist){this.mailNutritionist = mailNutritionist;}

    public String getNutritionistRegistration(){return nutritionistRegistration;}
    public void setNutritionistRegistration(String nutritionistRegistration){this.nutritionistRegistration = nutritionistRegistration;}

    @Override
    public String toString(){
        return idNutritionist + " :: " + nameActivity + " :: " + nutritionistName + " :: " + paternalSurnameN + " :: " + maternalSurnameN + " :: " + ageN + " :: " +genderN + " :: " + passwordNutritionist + " :: " + mailNutritionist + " :: " + nutritionistRegistration;
    }

}
