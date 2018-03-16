package xyz.hnnknk.deneb.agent.mini.hardwares;

import java.util.ArrayList;
import java.util.HashMap;

public class DiskDrive extends Hardware{

    private final HashMap<String, ArrayList<String>> diskDrives;
    private int diskCount;

    public DiskDrive() {
        diskDrives = new HashMap<>();
        diskCount = 0;
    }

    @Override
    public void setInfo(ArrayList<String> input) {
        if(input.size() % 2 == 1) {
            for(int i = 1; i < input.size()/2 + 1; i++) {
                ArrayList<String> list = new ArrayList<>();
                list.add(optimizeDriveName(input.get(i)));
                list.add(optimizeSize(input.get(i+2)));
                diskCount++;
                diskDrives.put("#" + diskCount, list);
            }
        } else {
            diskCount = 1;
            ArrayList<String> list = new ArrayList<>();
            list.add(optimizeDriveName(input.get(0)));
            list.add(optimizeSize(input.get(1)));
            diskDrives.put("#1", list);
        }
    }

    private String optimizeDriveName(String input) {
        return input.split("\\s+")[0];
    }

    private String optimizeSize(String input) {
        long l = Long.parseLong(input.trim());
        l = l / (1000 * 1000 * 1000);
        if(l == 0) {
            return "< 1";
        } else {
            return Long.toString(l);
        }
    }

    public HashMap<String, ArrayList<String>> getDiskDrives() {
        return diskDrives;
    }

    public int getDiskCount() {
        return diskCount;
    }
}
