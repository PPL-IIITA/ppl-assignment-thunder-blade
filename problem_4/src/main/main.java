
package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author arun
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
     ArrayList<Boys> boys_list = new ArrayList<Boys>();
     ArrayList<Girls> girls_list = new ArrayList<Girls>();
     ArrayList<Couples> couples_list = new ArrayList<Couples>();
     
     util data = new util();
     data.create_data();
     List<Gifts> gift_list = readGifts("gifts_file.csv");
     
     Comparator<Gifts> comp;
        comp = (Gifts a, Gifts b) -> {
            return a.price > b.price ? 1:-1 ;
        };
    Collections.sort(gift_list, comp);
    
     Logger logger = Logger.getLogger("MyLog");  
     FileHandler fh;  
     util create = new util();
     create.create_data();
     List<Boys> b_list = readBoys("boys_file.csv");
     List<Girls> g_list = readGirls("girls_file.csv");
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

     for(Girls g : g_list){
        logger.info(g.name + " " + " is looking for a boyfriend ");
         for(Boys b : b_list){
             if(b.status == "single" && g.status == "single" && b.girlfriend_budget >= g.maintenance_budget && b.minimum_attraction<=g.attractiveness){
                 b.status = "relation";
                 g.status = "relation";
                 b.girlfriend = g.name;
                 g.boyfriend = b.name;
                 logger.info(g.name + " " + "is commited to " + b.name); 
                 couples_list.add(new Couples(b.name, g.name, b.girlfriend_budget, g.maintenance_budget, b.type, g.type, g.intelligence, g.attractiveness, b.intelligence, b.attractiveness));
                 break;
             }
         }
         
     }
     
   //  Gifting_Procedure gi = new Gifting_Procedure();
   //  gi.gifting_technique(couples_list, gift_list);
     Comparator<Couples> comp2;
        comp2 = (Couples a, Couples b) -> {
            return a.happiness < b.happiness ? 1:-1 ;
        };
    Comparator<Couples> comp3;
        comp3 = (Couples a, Couples b) -> {
            return a.compatability < b.compatability ? 1:-1 ;
        }; 
    calculate_happiness cp;
    cp = new calculate_happiness();
    Collections.sort(couples_list, comp2);
    System.out.println();
    System.out.println("Happiest Couples");
    System.out.println();
    cp.print_k_happiest(couples_list, 30);
    System.out.println();
     System.out.println("After Breakup New Couples are");
    Collections.sort(couples_list, comp3);
    int k=0;
    for(Couples coup : couples_list){
        coup.boy_name = "";
        k++;
        if(k>5)
            break;
    }
    for(Couples coup : couples_list){
         for(Couples gr : couples_list){
             if(gr.boy_name == ""){
                 gr.boy_name = coup.boy_name;
                 System.out.println("New couple formed" + " " + gr.boy_name + " commited to " + gr.girl_name);
                 gr.boy_name = coup.boy_name;
                 //coup = "commited";
                 //gr.boyfriend = coup.boy_name;
             }
         }
    }
    //System.out.println("Most Compatible Couples");
    //System.out.println();
    //cp.print_k_compatibility(couples_list, 30);
     
    }
    
    private static List<Boys> readBoys(String filename) throws IOException
    {
        List<Boys> boys = new ArrayList();
        Path pathToFile;
        pathToFile = Paths.get(filename);
        
        try(BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)){
            String line = br.readLine();
            
            while(line!=null)
            {
                String[] attributes = line.split(",");
                Boys boy;
                boy = createBoys(attributes);
                boys.add(boy);
                line = br.readLine();
                
            }
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
        return boys;
    }
    
    private static Boys createBoys(String[] metadata)
    {
        String name = metadata[0];
        int attractiveness = Integer.parseInt(metadata[1]);
        int girlfriend_budget = Integer.parseInt(metadata[2]);
        int intelligence = Integer.parseInt(metadata[3]);
        String type = metadata[4];
        int minimum_attraction = Integer.parseInt(metadata[5]);
        return new Boys(name, attractiveness, girlfriend_budget,intelligence, type, minimum_attraction);
    }
    
    
    
    
    
    private static List<Girls> readGirls(String filename) throws IOException
    {
        List<Girls> girls = new ArrayList();
        Path pathToFile;
        pathToFile = Paths.get(filename);
        
        try(BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)){
            String line = br.readLine();
            
            while(line!=null)
            {
                String[] attributes = line.split(",");
                Girls girl;
                girl = createGirls(attributes);
                girls.add(girl);
                line = br.readLine();
                
            }
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
        return girls;
    }
    
    private static Girls createGirls(String[] metadata)
    {
        String name = metadata[0];
        int attractiveness = Integer.parseInt(metadata[1]);
        int maintenance_budget = Integer.parseInt(metadata[2]);
        int intelligence = Integer.parseInt(metadata[3]);
        String type = metadata[4];
        return new Girls(name, attractiveness, maintenance_budget,intelligence, type);
    }
     private static List<Gifts> readGifts(String filename) throws IOException
    {
        List<Gifts> gifts = new ArrayList();
        Path pathToFile;
        pathToFile = Paths.get(filename);
        
        try(BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)){
            String line = br.readLine();
            
            while(line!=null)
            {
                String[] attributes = line.split(",");
                Gifts gift;
                gift = createGifts(attributes);
                gifts.add(gift);
                line = br.readLine();
                
            }
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
        return gifts;
    }
    
    private static Gifts createGifts(String[] metadata)
    {
        String name = metadata[0];
        int price = Integer.parseInt(metadata[1]);
        int value = Integer.parseInt(metadata[2]);
        String type = metadata[3];
        return new Gifts(name,price, value, type);
    }
}
