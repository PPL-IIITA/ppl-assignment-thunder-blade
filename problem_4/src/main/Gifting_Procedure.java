
package main;

import java.io.IOException;
import static java.lang.Math.abs;
import java.util.List;
import java.util.Random;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Gifting_Procedure {
    
    public void gifting_technique(List<Couples> couples_list, List<Gifts> gifts){
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
        for(Couples couple : couples_list){
            logger.info("Exchange of Gifts between "+ couple.boy_name + " and " + couple.girl_name);
            System.out.println("Exchange of Gifts between "+ couple.boy_name + " and " + couple.girl_name);
            int boy_happiness = 0, girl_happiness = 0;
            int current_budget = 0, current_value = 0;
           for(Gifts gift : gifts){
               logger.info(couple.boy_name + " gifted " + gift.name + " to " + couple.girl_name);
               logger.info("Type : " + gift.type);
               logger.info("Price : " + gift.price);
               System.out.println(couple.boy_name + " gifted " + gift.name + " to " + couple.girl_name);
               System.out.println("Type : " + gift.type);
               System.out.println("Price : " + gift.price);
               if(current_budget + gift.price  > couple.girl_budget && couple.boy_type.equals("Miser"))
                   break;
               if(current_budget + gift.price > couple.boy_budget && couple.boy_type.equals("Generous"))
                   break;
               if(current_budget > couple.girl_budget && couple.boy_type.equals("Geeks"))
                   break;
               current_budget += gift.price;
               if(gift.type.equals("Luxury"))
                   current_value += gift.value;
               current_value += gift.value;
              
           }
           if(couple.girl_type.equals("Choosy")){
               girl_happiness = current_budget > 0 ? (int) Math.log10(current_budget):0;
            }
           if(couple.girl_type.equals("Normal")){
               girl_happiness = current_budget + current_value;
           }
           if(couple.girl_type.equals("Desparate")){
               girl_happiness = current_budget;
           }
           if(couple.boy_type.equals("Miser")){
               boy_happiness = couple.boy_budget- current_budget;
           }
           if(couple.boy_type.equals("Generous")){
               boy_happiness = girl_happiness;
           }
           if(couple.boy_type.equals("Geeks")){
               boy_happiness = couple.girl_intelligence;
           }
           couple.happiness = boy_happiness + girl_happiness;
           couple.compatability = current_budget + abs(couple.boy_intelligence - couple.girl_intelligence
                    + abs(couple.boy_attractiveness - couple.girl_attractiveness));
        }
    }
    
}
    
