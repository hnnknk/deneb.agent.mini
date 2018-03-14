package xyz.hnnknk.deneb.agent.mini.wmic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class WmiUtility {

    private ArrayList<String> information;
    private ArrayList<String> results;
    private String lastPart;

    public WmiUtility() {

        System.out.println(System.getenv());
        String[] command = {"CMD", "/C", "WMIC /user:savineu /password:deathmushi /node:192.168.2.34 BASEBOARD GET manufacturer"};
    }

    public ArrayList<String> getMotherboardInformation() {
        information = new ArrayList<>();
        for(String s : executeCommand("baseboard", "manufacturer")) {
            information.add(s);
        }
        for(String s : executeCommand("baseboard", "product")) {
            information.add(s);
        }
        for(String s : executeCommand("cpu","socketdesignation")) {
            information.add(s);
        }
        return information;
    }

    public ArrayList<String> getDiskDriveInformation() {
        information = new ArrayList<>();
        ArrayList<String> list = executeCommand("diskdrive", "caption");
        if(list.size() > 1) {
            information.add(Integer.toString(list.size()));
        }
        for(String s : list) {
            information.add(s.split("\\s+")[0]);
        }
        for(String s : executeCommand("diskdrive", "size")) {
            long l = Long.parseLong(s.trim());
            l = l / (1000 * 1000 * 1000);
            information.add(Long.toString(l));
        }
        return information;
    }

    public ArrayList<String> getCpuInformation() {
        information = new ArrayList<>();
        for(String s : executeCommand("cpu","manufacturer")) {
            information.add(s);
        }
        for(String s : executeCommand("cpu","name")) {
            information.add(s);
        }
        for(String s : executeCommand("cpu","socketdesignation")) {
            information.add(s);
        }
        for(String s : executeCommand("cpu","numberofcores")) {
            information.add(s);
        }
        return information;
    }

    public ArrayList<String> getRamInformation() {
        information = new ArrayList<>();
        for(String s : executeCommand("memorychip","manufacturer")) {
            information.add(s);
        }
        for(String s : executeCommand("memorychip","speed")) {
            information.add(s);
        }
        for(String s : executeCommand("memorychip","capacity")) {
            long l = Long.parseLong(s.trim());
            l = l / (1024 * 1024);
            information.add(Long.toString(l));
        }
        return information;
    }

    private synchronized ArrayList<String> executeCommand(String hardware, String type) {
        results = new ArrayList<>();
        lastPart = "WMIC " + hardware + " GET " + type;
        String[] command = {"CMD", "/C", lastPart};

        try {
            Process p = Runtime.getRuntime().exec(command);
            p.getOutputStream().close();

            String s;
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

            while ((s = reader.readLine()) != null) {
                if(s.length() > 0) {
                    results.add(s);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(int i = 0; i < results.size(); i++) {
            if(results.get(i).toLowerCase().contains(type)) {
                results.remove(i);
            }
        }
        for(String s : results) {
            System.out.println("string = " + s);
            System.out.println("size this string = " + s.length());
        }
        return results;
    }
}
