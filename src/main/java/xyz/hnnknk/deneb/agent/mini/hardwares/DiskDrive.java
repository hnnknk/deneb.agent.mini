package xyz.hnnknk.deneb.agent.mini.hardwares;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;
import java.util.HashMap;

public class DiskDrive extends Hardware{

    private HashMap<String, ArrayList<StringProperty>> diskDrives;
    private int diskCount;

    public DiskDrive() {
        diskDrives = new HashMap<>();
        diskCount = 1;
        ArrayList<StringProperty> list = new ArrayList<>();
        list.add(new SimpleStringProperty("Сбор информации"));
        list.add(new SimpleStringProperty("Сбор информации"));
        for(int i = 1; i < 11; i++) {
            diskDrives.put("#" + i, list);
        }
    }

    @Override
    public void setInfo(ArrayList<String> input) {
        if(input.size() % 2 == 1) {
            for(int i = 1; i < input.size()/2 + 1; i++) {
                ArrayList<StringProperty> list = new ArrayList<>();
                list.add(new SimpleStringProperty(input.get(i)));
                list.add(new SimpleStringProperty(input.get(i+2)));
                diskDrives.put("#" + diskCount, list);
                diskCount++;
            }
        } else {
            ArrayList<StringProperty> list = new ArrayList<>();
            for(String s : input) {
                list.add(new SimpleStringProperty(s));
            }
            diskDrives.put("#1", list);
        }
    }

    public HashMap<String, ArrayList<StringProperty>> getDiskDrives() {
        return diskDrives;
    }

    public int getDiskCount() {
        return diskCount;
    }
}
