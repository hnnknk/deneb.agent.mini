package xyz.hnnknk.deneb.agent.mini.hardwares;

import java.util.ArrayList;
import java.util.HashMap;

public class Ram extends Hardware{

    private final HashMap<String, ArrayList<String>> rams;
    private int ramCount;

    public Ram() {
        rams = new HashMap<>();
        ramCount = 0;
    }

    @Override
    public void setInfo(ArrayList<String> input) {
        if(input.size() % 3 == 1) {
            for(int i = 1; i < input.size()/3 + 1; i++) {
                ArrayList<String> list = new ArrayList<>();
                list.add(input.get(i));
                list.add(input.get(i+2));
                list.add(optimizeCapacity(input.get(i+4)));
                ramCount++;
                rams.put("#" + ramCount, list);

            }
        } else {
            ArrayList<String> list = new ArrayList<>();
            list.add(input.get(0));
            list.add(input.get(1));
            list.add(optimizeCapacity(input.get(2)));
            ramCount = 1;
            rams.put("#1", list);
        }
    }

    private String optimizeCapacity(String input) {
        long l = Long.parseLong(input.trim());
        l = l / (1024 * 1024);
        return Long.toString(l);
    }

    public HashMap<String, ArrayList<String>> getRams() {
        return rams;
    }

    public int getRamCount() {
        return ramCount;
    }
}
