package services;
import models.Printer;
import java.util.ArrayList;

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


}

