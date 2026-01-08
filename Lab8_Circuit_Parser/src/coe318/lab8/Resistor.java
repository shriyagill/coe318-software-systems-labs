package coe318.lab8;

/*
 * Represents a resistor component in an electric circuit
 * @author Shriya Gill
 */
public class Resistor {
    private final int id;
    private final Node node1;
    private final Node node2;
    private final double resistance;
    
    /*
     * Creates a new resistor.
     */
    public Resistor(int id, int node1, int node2, double resistance) {
        if (resistance <= 0) {
            throw new IllegalArgumentException("Resistance must be positive");
        }
        this.id = id;
        this.node1 = new Node(node1);
        this.node2 = new Node(node2);
        this.resistance = resistance;
    }
    
    /*
     * Gets the resistor ID.
     */
    public int getId() {
        return id;
    }
    
    /*
     * Gets the first node.
     */
    public Node getNode1() {
        return node1;
    }
    
    /*
     * Gets the second node.
     */
    public Node getNode2() {
        return node2;
    }
    
    /*
     * Gets the resistance value.
     */
    public double getResistance() {
        return resistance;
    }
    
    /*
     * Generates a SPICE description of this resistor.
     */
    public String toSpice() {
        return String.format("R%d %d %d %.1f", 
                           id, 
                           node1.getId(), 
                           node2.getId(), 
                           resistance);
    }
    
    /*
     * Returns a string representation of the resistor.
     */
    @Override
    public String toString() {
        return String.format("Resistor %d: %s to %s, %.2f Ohms", 
                           id, 
                           node1, 
                           node2, 
                           resistance);
    }
}