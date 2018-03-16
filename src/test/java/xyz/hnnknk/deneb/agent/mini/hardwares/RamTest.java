package xyz.hnnknk.deneb.agent.mini.hardwares;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class RamTest {

    private Ram ram;

    @Before
    public void init() {
        ram = new Ram();
    }

    @Test
    public void setInfoTestWithOneRam() {
        ArrayList<String> info = new ArrayList<>(Arrays.asList("Corsair", "1333","2147483648"));
        ram.setInfo(info);
        assertEquals(1, ram.getRams().size());
        assertEquals("Corsair", ram.getRams().get("#1").get(0));
        assertEquals("1333", ram.getRams().get("#1").get(1));
        assertEquals("2048", ram.getRams().get("#1").get(2));
        assertEquals(1, ram.getRamCount());
    }

    @Test
    public void setInfoTestWithMultipleDrives() {
        ArrayList<String> info = new ArrayList<>(Arrays.asList("2","Corsair", "Kingston", "1333", "1600", "2147483648", "268435456"));
        ram.setInfo(info);
        assertEquals(2, ram.getRams().size());
        assertEquals("Corsair", ram.getRams().get("#1").get(0));
        assertEquals("1333", ram.getRams().get("#1").get(1));
        assertEquals("2048", ram.getRams().get("#1").get(2));

        assertEquals("Kingston", ram.getRams().get("#2").get(0));
        assertEquals("1600", ram.getRams().get("#2").get(1));
        assertEquals("256", ram.getRams().get("#2").get(2));
        assertEquals(2, ram.getRamCount());
    }

    @Test
    public void getRamsWithoutSetInfoShouldReturnZero() {
        assertNotNull(ram.getRams());
        assertEquals(0, ram.getRams().size());
    }

    @Test
    public void getRamCountWithoutSetInfoShouldReturnZero() {
        assertEquals(0, ram.getRamCount());
    }
}