package com.example.alimentaTec.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Goal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idGoal;
    private String descriptionGoal;
    private boolean startGoal;
    private boolean endGoal;
    private String statusGoal;

    // Getters and Setters
    public int getIdGoal() {
        return idGoal;
    }

    public void setIdGoal(int idGoal) {
        this.idGoal = idGoal;
    }

    public String getDescriptionGoal() {
        return descriptionGoal;
    }

    public void setDescriptionGoal(String descriptionGoal) {
        this.descriptionGoal = descriptionGoal;
    }

    public boolean getStartGoal() {
        return startGoal;
    }

    public void setStartGoal(boolean startGoal) {
        this.startGoal = startGoal;
    }

    public boolean getEndGoal() {
        return endGoal;
    }

    public void setEndGoal(boolean endGoal) {
        this.endGoal = endGoal;
    }

    public String getStatusGoal() {
        return statusGoal;
    }

    public void setStatusGoal(String statusGoal) {
        this.statusGoal = statusGoal;
    }

    @Override
    public String toString() {
        return idGoal + " :: " + descriptionGoal + " :: " + startGoal + " :: " + endGoal + " :: " + statusGoal;
    }
}
