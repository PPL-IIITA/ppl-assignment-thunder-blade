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
public class Girls {
    String name, status, boyfriend, type;
    int attractiveness, maintenance_budget, intelligence, happiness;
    Girls(String name,int attractiveness,int maintenance_budget, int intelligence, String type)
    {
        this.name = name;
        this.attractiveness = attractiveness;
        this.maintenance_budget = maintenance_budget;
        this.intelligence = intelligence;
        this.status = "single";
        this.boyfriend = "";
        this.happiness = 0;
        this.type = type;
        
    }
    
    
    public boolean Is_Girl_Affordable(int girlfriend_budget, int minimum_attraction)
    {
        if(maintenance_budget <= girlfriend_budget && attractiveness >= minimum_attraction)
            return true;
        return false;
    }
    
    
}
