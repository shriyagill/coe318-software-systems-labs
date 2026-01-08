package coe318.lab8;

/*
 * Represents a DC voltage source in an electric circuit.
 * @author Shriya Gill
 */
public class VoltageSource {
    private final int id;
    private final Node positiveNode;
    private final Node negativeNode;
    private final double voltage;
    
    /*
     * Creates a new DC voltage source.
     */
    public VoltageSource(int id, int positiveNode, int negativeNode, double voltage) {
        this.id = id;
        this.positiveNode = new Node(positiveNode);
        this.negativeNode = new Node(negativeNode);
        this.voltage = voltage;
    }
    
    /*
     * Gets the voltage source ID.
     */
    public int getId() {
        return id;
    }
    
    /*
     * Gets the positive node.
     */
    public Node getPositiveNode() {
        return positiveNode;
    }
    
    /*
     * Gets the negative node.
     */
    public Node getNegativeNode() {
        return negativeNode;
    }
    
    /*
     * Gets the voltage value.
     */
    public double getVoltage() {
        return voltage;
    }
    
    /*
     * Generates a SPICE description of this voltage source.
     */
    public String toSpice() {
        return String.format("V%d %d %d DC %.1f", 
                           id, 
                           positiveNode.getId(), 
                           negativeNode.getId(), 
                           voltage);
    }
    
    /*
     * Returns a string representation of the voltage source.
     */
    @Override
    public String toString() {
        return String.format("VoltageSource %d: %s (+) to %s (-), %.2f Volts", 
                           id, 
                           positiveNode, 
                           negativeNode, 
                           voltage);
    }
}