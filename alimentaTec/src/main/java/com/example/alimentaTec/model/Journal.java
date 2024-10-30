package com.example.alimentaTec.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "journal")
public class Journal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idJournal")
    @JsonProperty("idJournal")
    private Integer idJournal;

    //@NotBlank(message = "The content must not be null and must contain at least one non-whitespace character")
    //@Size(min = 1, max = 500, message = "The content must be at most 500 characters, and has at least one character")

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idSaucer", referencedColumnName = "idSaucer")
    @JsonProperty("idSaucer")
    private Saucer saucer;

    //@Column(name = "idSaucer")
    //@JsonProperty("idSaucer")
    //private Integer idSaucer;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idActivity", referencedColumnName = "idActivity")
    @JsonProperty("idActivity")
    private PhysicalActivity physicalActivity;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idGoal", referencedColumnName = "idGoal")
    @JsonProperty("idGoal")
    private Goal goal;

    //@Column(name = "idGoal")
    //@JsonProperty("idGoal")
    //private Integer idGoal;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idUser", referencedColumnName = "idUser")
    @JsonProperty("idUser")
    private Login login;

    //@Column(name = "idUser")
    //@JsonProperty("idUser")
    //private Integer idUser;

    public Integer getIdJournal() {return idJournal;}
    public void setIdJournal(Integer idJournal) {this.idJournal = idJournal;}

    public Saucer getSaucer(){return saucer;}
    public void setSauser(Saucer saucer){this.saucer = saucer;}

    public PhysicalActivity getPhysicalActivity() {return physicalActivity;}
    public void setPhysicalActivity(PhysicalActivity physicalActivity) {this.physicalActivity = physicalActivity;}

    public Goal getGoal() {return goal;}
    public void setGoal(Goal goal) {this.goal = goal;}

    public Login getLogin() {return login;}
    public void setLogin(Login login) {this.login = login;}
}
