package com.example.alimentaTec.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Saucer")
public class Saucer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSaucer;
    private String nameSaucer;
    private String category;
    private String preparation;

    public int getIdSaucer(){return idSaucer;}
    public void setIdSaucer(int idSaucer){this.idSaucer = idSaucer;}

    public String getNameSaucer(){return nameSaucer;}
    public void setNameSaucer(String nameSaucer){this.nameSaucer = nameSaucer;}
    
    public String getCategory(){return category;}
    public void setCategory(String category){this.category = category;}

    public String getPreparation(){return preparation;}
    public void setPreparation(String preparation){this.preparation = preparation;}

    @Override
    public String toString(){
        return idSaucer + " :: " + nameSaucer + " :: " + category + " :: " + preparation;
    }
}
