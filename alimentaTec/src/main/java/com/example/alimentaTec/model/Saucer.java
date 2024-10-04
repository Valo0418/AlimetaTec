package com.example.alimentaTec.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Saucer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSauser;
    private String nameSaucer;
    private String category;
    private String preparation;

    public int getIdSauser(){return idSauser;}
    public void setIdSauser(int idSauser){this.idSauser = idSauser;}

    public String getNameSaucer(){return nameSaucer;}
    public void setNameSaucer(String nameSaucer){this.nameSaucer = nameSaucer;}
    
    public String getCategory(){return category;}
    public void setCategory(String category){this.category = category;}

    public String getPreparation(){return preparation;}
    public void setPreparation(String preparation){this.preparation = preparation;}

    @Override
    public String toString(){
        return idSauser + " :: " + nameSaucer + " :: " + category + " :: " + preparation;
    }
}
