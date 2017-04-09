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
public class Couples {
    
    String boy_name, girl_name, boy_type, girl_type;
    int boy_budget, girl_budget, happiness, girl_intelligence = 0,compatability, girl_attractiveness, boy_intelligence, boy_attractiveness;
    
    Couples(String boy_name, String girl_name, int boy_budget, int girl_budget, String boy_type, String girl_type, int girl_intelligence, int girl_attractiveness, int boy_intelligence, int boy_attractiveness){
        this.boy_name = boy_name;
        this.girl_name = girl_name;
        this.boy_budget = boy_budget;
        this.girl_budget = girl_budget;
        this.boy_type = boy_type;
        this.girl_type = girl_type;
        this.girl_intelligence = girl_intelligence;
        this.girl_attractiveness = girl_attractiveness;
        this.boy_attractiveness = boy_attractiveness;
        this.boy_intelligence = boy_intelligence;
    }
    
}
