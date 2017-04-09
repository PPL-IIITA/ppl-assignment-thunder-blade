/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author arun
 */
public class Girls extends Person {
    String name, status, boyfriend, type;
    int attractiveness, maintenance_budget, intelligence, happiness;
    Girls(String name,int attractiveness,int maintenance_budget, int intelligence, String type)
    {
        super(name, intelligence, attractiveness);
        this.maintenance_budget = maintenance_budget;    
        this.boyfriend = "";
        this.type = type;
        
    }
    
    public boolean Is_Girl_Affordable(int girlfriend_budget, int minimum_attraction)
    {
        if(maintenance_budget <= girlfriend_budget && attractiveness >= minimum_attraction)
            return true;
        return false;
    }
    
    
}
