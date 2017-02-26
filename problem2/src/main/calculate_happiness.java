/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.IOException;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


/**
 *
 * @author arun
 */
public class calculate_happiness {
    
    
    public void print_k_happiest(List<Couples>couples, int k)
    {
        Logger logger = Logger.getLogger("MyLog");  
     FileHandler fh;  
     try {  
        fh = new FileHandler("log.txt");  
        logger.addHandler(fh);
        SimpleFormatter formatter = new SimpleFormatter();  
        fh.setFormatter(formatter);  
        logger.setUseParentHandlers(false);
        logger.info("thunder-blade-logger");  

    } catch (SecurityException e) {  
        e.printStackTrace();  
    } catch (IOException e) {  
        e.printStackTrace();  
    } 
        int count = 0;
        for(Couples coup : couples){
           System.out.println("Boy_name" + coup.boy_name + " " + "Girl_name " + coup.girl_name + " " + " with happiness "+ coup.happiness);
           logger.info("Boy_name: " + coup.boy_name + " " + "Girl_name : " + coup.girl_name + " " + " happiness : "+ coup.happiness);
            count++;
            if(count == k)
                break;
        }
    }
    public void print_k_compatibility(List<Couples>couples, int k)
    {
        Logger logger = Logger.getLogger("MyLog");  
     FileHandler fh;  
     try {  
        fh = new FileHandler("log.txt");  
        logger.addHandler(fh);
        SimpleFormatter formatter = new SimpleFormatter();  
        fh.setFormatter(formatter);  
        logger.info("thunder-blade-logger");  

    } catch (SecurityException e) {  
        e.printStackTrace();  
    } catch (IOException e) {  
        e.printStackTrace();  
    } 
        int count = 0;
        for(Couples coup : couples){
            System.out.println("Compatible " + coup.boy_name + " " + coup.girl_name + " " + " with compatibility " + coup.compatability);
           logger.info("Boy_name: " + coup.boy_name + " " + "Girl_name : " + coup.girl_name + " " + " happiness : "+ coup.compatability);
            count++;
            if(count == k)
                break;
        }
    }
   
    
}
