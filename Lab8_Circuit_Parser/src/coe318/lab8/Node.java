package coe318.lab8;

/*
 * Represents a node in an electric circuit
 * @author Shriya Gill
 */
public class Node {
    private final int id;
    
    /*
     * Creates a new node with the specified ID.
     */
    public Node(int id) {
        this.id = id;
    }
    
    /*
     * Gets the node ID
     */
    public int getId() {
        return id;
    }
    
    /*
     * Returns a string representation of the node.
     */
    @Override
    public String toString() {
        return String.valueOf(id);
    }
    
    /*
     * Checks if this node is equal to another object.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Node other = (Node) obj;
        return this.id == other.id;
    }
    
    /*
     * Returns a hash code for this node.
     */
    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
}