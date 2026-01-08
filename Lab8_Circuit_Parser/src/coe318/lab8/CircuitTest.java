package coe318.lab8;

import org.junit.Test;
import static org.junit.Assert.*;

/*
 * JUnit test class for testing the Circuit class.
 * @author Shriya Gill
 */
public class CircuitTest {
    
    /*
     * Test adding resistors to the circuit.
     */
    @Test
    public void testAddResistor() {
        System.out.println("Testing addResistor");
        Circuit circuit = new Circuit();
        
        // Add first resistor
        circuit.addResistor(1, 2, 0.25);
        assertEquals("Should have 1 resistor", 1, circuit.getResistorCount());
        
        // Add second resistor
        circuit.addResistor(2, 3, 0.5);
        assertEquals("Should have 2 resistors", 2, circuit.getResistorCount());
        
        // Add third resistor
        circuit.addResistor(3, 0, 1.0);
        assertEquals("Should have 3 resistors", 3, circuit.getResistorCount());
        
        // No voltage sources added
        assertEquals("Should have 0 voltage sources", 0, circuit.getVoltageSourceCount());
    }
    
    /*
     * Test adding voltage sources to the circuit.
     */
    @Test
    public void testAddVoltageSource() {
        System.out.println("Testing addVoltageSource");
        Circuit circuit = new Circuit();
        
        // Add first voltage source
        circuit.addVoltageSource(1, 0, 2.0);
        assertEquals("Should have 1 voltage source", 1, circuit.getVoltageSourceCount());
        
        // Add second voltage source
        circuit.addVoltageSource(2, 0, 3.0);
        assertEquals("Should have 2 voltage sources", 2, circuit.getVoltageSourceCount());
        
        // No resistors added
        assertEquals("Should have 0 resistors", 0, circuit.getResistorCount());
    }
    
    /*
     * Test SPICE output generation.
     */
    @Test
    public void testToSpice() {
        System.out.println("Testing toSpice");
        Circuit circuit = new Circuit();
        
        // The example circuit from lab 
        circuit.addVoltageSource(1, 0, 2.0);
        circuit.addResistor(1, 2, 0.25);
        circuit.addVoltageSource(2, 0, 3.0);
        circuit.addResistor(2, 3, 0.5);
        circuit.addResistor(3, 0, 1.0);
        
        String spice = circuit.toSpice();
        
        // Check that all components are present in output
        assertTrue("Should contain V1", spice.contains("V1 1 0 DC 2.0"));
        assertTrue("Should contain V2", spice.contains("V2 2 0 DC 3.0"));
        assertTrue("Should contain R1", spice.contains("R1 1 2 0.2"));
        assertTrue("Should contain R2", spice.contains("R2 2 3 0.5"));
        assertTrue("Should contain R3", spice.contains("R3 3 0 1.0"));
        
        // Format should be: voltage sources should come before resistors
        int v1Index = spice.indexOf("V1");
        int v2Index = spice.indexOf("V2");
        int r1Index = spice.indexOf("R1");
        
        assertTrue("V1 should come before R1", v1Index < r1Index);
        assertTrue("V2 should come before R1", v2Index < r1Index);
    }
    
    /*
     * Test empty circuit SPICE output.
     */
    @Test
    public void testEmptyCircuit() {
        System.out.println("Testing empty circuit");
        Circuit circuit = new Circuit();
        
        String spice = circuit.toSpice();
        assertTrue("Empty circuit should produce empty string", 
                   spice.isEmpty() || spice.trim().isEmpty());
        
        assertEquals("Should have 0 resistors", 0, circuit.getResistorCount());
        assertEquals("Should have 0 voltage sources", 0, circuit.getVoltageSourceCount());
    }
}