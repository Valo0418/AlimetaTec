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
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

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
    @Column(name = "idSaucer")
    @JsonProperty("idSaucer")
    private Integer idSaucer;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idActivity", referencedColumnName = "idActivity")
    @JsonProperty("idActivity")
    private PhysicalActivity physicalActivity;

    @Column(name = "idGoal")
    @JsonProperty("idGoal")
    private Integer idGoal;

    @Column(name = "idUser")
    @JsonProperty("idUser")
    private Integer idUser;

    public Integer getIdJournal() {
        return idJournal;
    }

    public void setIdJournal(Integer idJournal) {
        this.idJournal = idJournal;
    }

    public PhysicalActivity getPhysicalActivity() {
        return physicalActivity;
    }

    public void setPhysicalActivity(PhysicalActivity physicalActivity) {
        this.physicalActivity = physicalActivity;
    }

    public Integer getIdGoal() {
        return idGoal;
    }

    public void setIdGoal(Integer idGoal) {
        this.idGoal = idGoal;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }
}
