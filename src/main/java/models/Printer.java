package models;

public class Printer {
    private int id;
    private int size;
    private String name;
    private String brand;
    private String inkType;
    private boolean canConnectWifi;
    private boolean hasColorOutput;
    private boolean isForBusiness;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
