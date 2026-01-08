package coe318.lab8;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents an electric circuit containing resistors and voltage sources.
 * @author Shriya Gill
 */
public class Circuit {
    private List<Resistor> resistors;
    private List<VoltageSource> voltageSources;
    private int resistorCount;
    private int voltageSourceCount;
    
    
    public Circuit() {
        this.resistors = new ArrayList<>();
        this.voltageSources = new ArrayList<>();
        this.resistorCount = 0;
        this.voltageSourceCount = 0;
    }
    
    /**
     * Adds a resistor to the circuit.
     */
    public void addResistor(int node1, int node2, double resistance) {
        resistorCount++;
        Resistor resistor = new Resistor(resistorCount, node1, node2, resistance);
        resistors.add(resistor);
    }
    
    /**
     * Adds a voltage source to the circuit.
     */
    public void addVoltageSource(int node1, int node2, double voltage) {
        voltageSourceCount++;
        VoltageSource source = new VoltageSource(voltageSourceCount, node1, node2, voltage);
        voltageSources.add(source);
    }
    
    
    public String toSpice() {
        StringBuilder spice = new StringBuilder();
        
        // Add all voltage sources first
        for (VoltageSource source : voltageSources) {
            spice.append(source.toSpice()).append("\n");
        }
        
        // Add all resistors
        for (Resistor resistor : resistors) {
            spice.append(resistor.toSpice()).append("\n");
        }
        
        return spice.toString().trim();
    }
    
    
    public int getResistorCount() {
        return resistorCount;
    }
    
    
    public int getVoltageSourceCount() {
        return voltageSourceCount;
    }
    
    
    public List<Resistor> getResistors() {
        return new ArrayList<>(resistors);
    }
    
    
    public List<VoltageSource> getVoltageSources() {
        return new ArrayList<>(voltageSources);
    }
}