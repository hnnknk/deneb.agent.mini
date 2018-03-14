package xyz.hnnknk.deneb.agent.mini.hardwares;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;
import java.util.HashMap;

public class Ram extends Hardware{

    private HashMap<String, ArrayList<StringProperty>> rams;
    private int ramCount;

    public Ram() {
        rams = new HashMap<>();
        ramCount = 1;
        ArrayList<StringProperty> list = new ArrayList<>();
        list.add(new SimpleStringProperty("Сбор информации"));
        list.add(new SimpleStringProperty("Сбор информации"));
        list.add(new SimpleStringProperty("Сбор информации"));
        for(int i = 1; i < 11; i++) {
            rams.put("#" + i, list);
        }
    }

    @Override
    public void setInfo(ArrayList<String> input) {
        if(input.size() % 3 == 1) {
            for(int i = 1; i < input.size()/3 + 1; i++) {
                ArrayList<StringProperty> list = new ArrayList<>();
                list.add(new SimpleStringProperty(input.get(i)));
                list.add(new SimpleStringProperty(input.get(i+2)));
                list.add(new SimpleStringProperty(input.get(i+4)));
                rams.put("#" + ramCount, list);
                ramCount++;
            }
        } else {
            ArrayList<StringProperty> list = new ArrayList<>();
            for(String s : input) {
                list.add(new SimpleStringProperty(s));
            }
            rams.put("#1", list);
        }
    }

    public HashMap<String, ArrayList<StringProperty>> getRams() {
        return rams;
    }

    public int getRamCount() {
        return ramCount;
    }
}
