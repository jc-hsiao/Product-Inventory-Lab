package services;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.sun.org.apache.xpath.internal.operations.Bool;
import models.Printer;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class PrinterService {

    private static int nextId = 1;
    private ArrayList<Printer> inventory = new ArrayList<>();

    public Printer create(String name, String brand, String inkType, boolean canConnectWifi, boolean hasColorOutput, boolean isForBusiness)
    {
        Printer newPrinter = new Printer(nextId++,name, brand, inkType, canConnectWifi, hasColorOutput, isForBusiness);
        inventory.add(newPrinter);
        return newPrinter;
    }
    //read
    public Printer findPrinter(int id) {
        // should take an int and return an object with that id, if exists
        for(int i=0; i<inventory.size(); i++){
            if(inventory.get(i).getId()==id){
                return inventory.get(i);
            }
        }
        return null;
    }

    //read all
    public Printer[] findAll() {
        Printer[] a = new Printer[inventory.size()];
        for(int i=0; i<inventory.size(); i++){
            a[i] = inventory.get(i);
        }
        return a;
    }

    //delete
    public boolean delete(int id) {
        // should remove the object with this id from the ArrayList if exits and return true.
        // Otherwise return false
        if(findPrinter(id) != null){
            inventory.remove(findPrinter(id));
            return true;
        }else{
            return false;
        }

    }

    public void write() throws IOException {
        String csvFile = "/Users/lsiao/Desktop/Printer.csv";
        FileWriter writer = new FileWriter(csvFile); //(1)

        CSVUtils.writeLine(writer, new ArrayList<String>(Arrays.asList(String.valueOf(nextId))));  // (2)

        for (Printer p : inventory) {
            List<String> list = new ArrayList<>(); // (3)
            list.add(String.valueOf(p.getId()));
            list.add(p.getName());
            list.add(p.getBrand());
            list.add(p.getInkType());
            list.add(String.valueOf(p.canWorkWithWifi()));
            list.add(String.valueOf(p.canPrintDifferentColor()));
            list.add(String.valueOf(p.canUseForBusiness()));


            CSVUtils.writeLine(writer, list);  // (4)
        }


        writer.flush();
        writer.close();
    }


    public void loadData(){
        String csvFile = "/Users/lsiao/Desktop/Printer.csv";
        String line = "";
        String csvSplitBy = ",";

        // (2)
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            nextId = Integer.parseInt(br.readLine());  // (3)

            while ((line = br.readLine()) != null) {
                // split line with comma
                String[] beer = line.split(csvSplitBy);

                // (4)
                int id = Integer.parseInt(beer[0]);
                String name = beer[1];
                String brand = beer[2];
                String inkType = beer[3];
                boolean wifi = Boolean.parseBoolean(beer[4]);
                boolean color = Boolean.parseBoolean(beer[5]);
                boolean bus = Boolean.parseBoolean(beer[6]);

                // (5)
                inventory.add(new Printer(id, name, brand, inkType, wifi, color,bus));
                System.out.println(id +", " +name+", "+ brand+", " +inkType+", "+ wifi+", "+ color+", "+bus);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void jsonWrite() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        writer.writeValue(new File("printer.json"), inventory);
    }


    public void jsonLoadData() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        this.inventory = objectMapper.readValue(new File("printer.json"), new TypeReference<ArrayList<Printer>>() {
        });
        System.out.println(objectMapper.writeValueAsString(inventory));
    }

}

