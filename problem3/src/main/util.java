/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.FileWriter;
import java.io.IOException;
import static java.lang.Math.random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 *
 * @author arun
 */
public class util {
    List<String> gift_types = Arrays.asList("Essential","Luxury","Utiltiy");
    List<String> boys_types = Arrays.asList("Miser","Generous","Geek");
    List<String> girls_types = Arrays.asList("Choosy","Normal","Desperate");
    
    ArrayList<Boys> boys_list = new ArrayList<Boys>();
    ArrayList<Girls> girls_list = new ArrayList<Girls>();
         
    public void create_data() throws IOException{
        Random random = new Random();
       
        for(int i = 1 ; i < 200; i++)
            boys_list.add(new Boys("Boy"+String.valueOf(i),
                    random.nextInt(250),
                    random.nextInt(100),
                    random.nextInt(100),
                    boys_types.get(random.nextInt(2)),
                    random.nextInt(100)
            ));
        
        for(int i = 1 ; i < 50; i++)
            girls_list.add(new Girls("Girl"+String.valueOf(i),
                    random.nextInt(250),
                    random.nextInt(100),
                    random.nextInt(100),
                    girls_types.get(random.nextInt(2))
            ));
        
        String csvFile1 = "boys_file.csv";
        String csvFile2 = "girls_file.csv";
        FileWriter writer1 = new FileWriter(csvFile1);
        FileWriter writer2 = new FileWriter(csvFile2);
        
        for(Boys b : boys_list){
            List<String> list = new ArrayList<>();
            list.add(b.name);
            list.add(String.valueOf(b.attractiveness));
            list.add(String.valueOf(b.girlfriend_budget));
            list.add(String.valueOf(b.intelligence));
            list.add(b.type);
            list.add(String.valueOf(b.minimum_attraction));
            CSVUtils.writeLine(writer1, list);
        }
        for(Girls b : girls_list){
            List<String> list = new ArrayList<>();
            list.add(b.name);
            list.add(String.valueOf(b.attractiveness));
            list.add(String.valueOf(b.maintenance_budget));
            list.add(String.valueOf(b.intelligence));
            list.add(b.type);
            CSVUtils.writeLine(writer2, list);
        }
        
        writer1.flush();
        writer2.flush();
        writer1.close();
        writer2.close();
    }
    
}
