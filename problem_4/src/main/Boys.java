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
public class Boys {
    String name, status, girlfriend, type;
    int attractiveness, girlfriend_budget, intelligence, happiness,minimum_attraction;
    Boys(String name,int attractiveness,int girlfriend_budget, int intelligence, String type, int minimum_attraction)throws Exception
    {
        this.name = name;
        this.attractiveness = attractiveness;
        this.girlfriend_budget = girlfriend_budget;
        this.intelligence = intelligence;
        this.status = "single";
        this.girlfriend = "";
        this.happiness = 0;
        this.type = type;
        this.minimum_attraction = minimum_attraction;
    }
    
    int happiness(String name, String type, int total_cost)throws Exception
    {
        int ans = 0;
        Girls girl = null;
        if(type == "Miser"){
           ans = girlfriend_budget - total_cost;
        }
        if(type == "Generous"){
            ans = girl.happiness;
        }
        if(type == "Geeks"){
           ans = girl.intelligence;
        }
        this.happiness = ans;
        return ans;
    }
    
    public boolean Is_Boy_Affordable(int budget)
    {
        if(budget <= girlfriend_budget)
            return true;
        return false;
    }
}
