package com.example.alimentaTec.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SaucerModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int dishId;
    private String nameSaucer;
    private String category;
    private String preparation;

    public int getdishId(){return dishId;}
    public void setdishId(int dishId){this.dishId = dishId;}

    public String getnameSaucer(){return nameSaucer;}
    public void setnameSaucer(String nameSaucer){this.nameSaucer = nameSaucer;}
    
    public String getCategory(){return category;}
    public void setCategory(String category){this.category = category;}

    public String getpreparation(){return preparation;}
    public void setpreparation(String preparation){this.preparation = preparation;}

    @Override
    public String toString(){
        return dishId + " :: " + nameSaucer + " :: " + category  + " :: " + preparation;
    }
}