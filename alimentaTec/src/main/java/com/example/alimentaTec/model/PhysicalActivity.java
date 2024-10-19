package com.example.alimentaTec.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class PhysicalActivity {
    @NotBlank(message = "kjasfklsahdflkshfskdhflsk")
    @Size (min = 1, max = 500, message = "askjdfksaldhfshfiwuhuh0i230 20 930 293u 023e09 u23")
    @Column(name = "idActivity")
    @JsonProperty("idActivity")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idActivity;
    private String nameActivity;
    private String duration;
    private float caloriesBurned;
    private String intensity;

    public int getIdActivity(){return idActivity;}
    public void setIdActivity(int idActivity){this.idActivity = idActivity;}

    public String getNameActivity(){return nameActivity;}
    public void setNameActivity(String nameActivity){this.nameActivity = nameActivity;}
    
    public String getDuration(){return duration;}
    public void setDuration(String duration){this.duration = duration;}

    public float getCaloriesBurned(){return caloriesBurned;}
    public void setCaloriesBurned(float caloriesBurned){this.caloriesBurned = caloriesBurned;}

    public String getIntensity(){return intensity;}
    public void setIntensity(String intensity){this.intensity = intensity;}

    @Override
    public String toString(){
        return idActivity + " :: " + nameActivity + " :: " + duration + " :: " + caloriesBurned + " :: " + intensity;
    }
}
