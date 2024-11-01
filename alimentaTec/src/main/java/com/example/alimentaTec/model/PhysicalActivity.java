package com.example.alimentaTec.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table (name="physicalactivity")
public class PhysicalActivity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idActivity")
    @JsonProperty("idActivity")
    private Integer idActivity;
    @NotBlank(message = "The content must not be null and must contain at least one non-whitespace character")
    @Size(min = 1, max = 500, message = "The content must be at most 500 characters, and has at least one character")
    @Column(name = "nameActivity")
    @JsonProperty("nameActivity")
    private String nameActivity;
    @Column(name = "duration")
    @JsonProperty("duration")
    private String duration;
    @Column(name = "caloriesBurned")
    @JsonProperty("caloriesBurned")
    private float caloriesBurned;
    @Column(name = "intensity")
    @JsonProperty("intensity")
    private String intensity;

    public Integer getIdActivity(){return idActivity;}
    public void setIdActivity(Integer idActivity){this.idActivity = idActivity;}

    public String getNameActivity(){return nameActivity;}
    public void setNameActivity(String nameActivity){this.nameActivity = nameActivity;}
    
    public String getDuration(){return duration;}
    public void setDuration(String duration){this.duration = duration;}

    public float getCaloriesBurned(){return caloriesBurned;}
    public void setCaloriesBurned(float caloriesBurned){this.caloriesBurned = caloriesBurned;}

    public String getIntensity(){return intensity;}
    public void setIntensity(String intensity){this.intensity = intensity;}

    /*
    @Override
    public String toString(){
        return idActivity + " :: " + nameActivity + " :: " + duration + " :: " + caloriesBurned + " :: " + intensity;
    }
     */
}
