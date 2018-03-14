package xyz.hnnknk.deneb.agent.mini.hardwares;

import java.util.ArrayList;

public class Cpu extends Hardware{

    private String manufacturer;
    private String model;
    private String socket;
    private String numberOfCores;

    public Cpu() {
        manufacturer = "Неизвестно";
        model = "Неизвестно";
        socket = "Неизвестно";
        numberOfCores = "Неизвестно";
    }

    public String getManufacturer() {
        return manufacturer;
    }

    private void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    private void setModel(String model) {
        this.model = model;
    }

    public String getSocket() {
        return socket;
    }

    private void setSocket(String socket) {
        this.socket = socket;
    }

    public String getNumberOfCores() {
        return numberOfCores;
    }

    private void setNumberOfCores(String numberOfCores) {
        this.numberOfCores = numberOfCores;
    }

    public void setInfo(ArrayList<String> input) {
        setManufacturer(input.get(0));
        setModel(input.get(1));
        setSocket(input.get(2));
        setNumberOfCores(input.get(3));
    }
}
