package com.example.alimentaTec.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "journal")
public class Journal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idJournal")
    @JsonProperty("idJournal")
    private Integer idJournal;

    @ManyToOne
    @JoinColumn(name = "idSaucer", nullable = false)
    @JsonProperty("saucer")
    private Saucer saucer;

    @ManyToOne
    @JoinColumn(name = "idActivity", nullable = false)
    @JsonProperty("physicalActivity")
    private PhysicalActivity physicalActivity;

    @ManyToOne
    @JoinColumn(name = "idGoal", nullable = false)
    @JsonProperty("goal")
    private Goal goal;

    @ManyToOne
    @JoinColumn(name = "idUser", nullable = false)
    @JsonProperty("login")
    private Login login;

    public Journal(){
    }

    public Journal(Integer idJournal, Saucer saucer, PhysicalActivity physicalActivity, Goal goal, Login login){
        this.idJournal = idJournal;
        this.saucer = saucer;
        this.physicalActivity  = physicalActivity;
        this.goal = goal;
        this.login = login;
    }

    public Integer getIdJournal() {return idJournal;}
    public void setIdJournal(Integer idJournal) {this.idJournal = idJournal;}

    public Saucer getSaucer(){return saucer;}
    public void setSaucer(Saucer saucer){this.saucer = saucer;}

    public PhysicalActivity getPhysicalActivity() {return physicalActivity;}
    public void setPhysicalActivity(PhysicalActivity physicalActivity) {this.physicalActivity = physicalActivity;}

    public Goal getGoal() {return goal;}
    public void setGoal(Goal goal) {this.goal = goal;}

    public Login getLogin() {return login;}
    public void setLogin(Login login) {this.login = login;}
}
