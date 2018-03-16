package xyz.hnnknk.deneb.agent.mini.hardwares;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class CpuTest {

    private Cpu cpu;

    @Before
    public void init() {
        cpu = new Cpu();
    }

    @Test
    public void setInfo() {
        ArrayList<String> info = new ArrayList<>(Arrays.asList("Intel", "G3240", "1150", "2"));
        cpu.setInfo(info);
        assertEquals("Intel", cpu.getManufacturer());
        assertEquals("G3240", cpu.getModel());
        assertEquals("1150", cpu.getSocket());
        assertEquals("2", cpu.getNumberOfCores());
    }
}