package xyz.hnnknk.deneb.agent.mini.hardwares;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class MotherboardTest {

    private Motherboard motherboard;

    @Before
    public void init() {
        motherboard = new Motherboard();
    }

    @Test
    public void setInfo() {
        ArrayList<String> info = new ArrayList<>(Arrays.asList("Asus", "H81M-C", "1150"));
        motherboard.setInfo(info);
        assertEquals("Asus", motherboard.getManufacturer());
        assertEquals("H81M-C", motherboard.getModel());
        assertEquals("1150", motherboard.getSocket());
    }
}