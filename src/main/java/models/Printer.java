package models;

public class Printer {
    private int id;
    private String name;
    private String brand;
    private String inkType;
    private boolean canConnectWifi;
    private boolean hasColorOutput;
    private boolean isForBusiness;


    public Printer() {
    }

    public Printer(int id, String name, String brand, String inkType, boolean canConnectWifi, boolean hasColorOutput, boolean isForBusiness) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.inkType = inkType;
        this.canConnectWifi = canConnectWifi;
        this.hasColorOutput = hasColorOutput;
        this.isForBusiness = isForBusiness;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }


    public String getInkType() {
        return inkType;
    }

    public void setInkType(String inkType) {
        this.inkType = inkType;
    }

    public boolean canWorkWithWifi() {
        return canConnectWifi;
    }

    public void setWifiConnectivity(boolean canConnectWifi) {
        this.canConnectWifi = canConnectWifi;
    }

    public boolean canPrintDifferentColor() {
        return hasColorOutput;
    }

    public void setColorOutputAbility(boolean hasColorOutput) {
        this.hasColorOutput = hasColorOutput;
    }


    public boolean canUseForBusiness() {
        return isForBusiness;
    }

    public void setBusinessAbility(boolean forBusiness) {
        isForBusiness = forBusiness;
    }
}
