
package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.FileHandler;
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
          logger.info(g.name + " " + "is looking for boyfriend "); 
         for(Boys b : b_list){
             if(b.status == "single" && g.status == "single" && b.girlfriend_budget >= g.maintenance_budget && b.minimum_attraction<=g.attractiveness){
                 b.status = "relation";
                 g.status = "relation";
                 b.girlfriend = g.name;
                 g.boyfriend = b.name;
                 System.out.println(g.name + " " + "is commited to " + b.name);
                 logger.info(g.name + " " + "is commited to " + b.name); 
                 break;
             }
         }
     }   
     
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
    
    private static Boys createBoys(String[] metadata)throws Exception
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
    
    private static Girls createGirls(String[] metadata)throws Exception
    {
        String name = metadata[0];
        int attractiveness = Integer.parseInt(metadata[1]);
        int maintenance_budget = Integer.parseInt(metadata[2]);
        int intelligence = Integer.parseInt(metadata[3]);
        String type = metadata[4];
        return new Girls(name, attractiveness, maintenance_budget,intelligence, type);
    }
    
}
