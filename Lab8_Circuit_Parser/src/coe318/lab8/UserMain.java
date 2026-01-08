package coe318.lab8;

import java.util.Scanner;

/**
 * Main class for the Analog Circuit Solver.
 * Reads circuit descriptions from stdin and processes commands.
 * 
 * @author Shriya Gill
 */
public class UserMain {
    
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Circuit circuit = new Circuit();
        
        System.out.println("Circuit Solver - Enter circuit components or commands:");
        System.out.println("Format: r node1 node2 resistance");
        System.out.println("        v node1 node2 voltage");
        System.out.println("Commands: spice, end");
        
        while (scanner.hasNext()) {
            String command = scanner.next().toLowerCase();
            
            switch (command) {
                case "v":
                    // Read voltage source: v node1 node2 voltage
                    if (scanner.hasNextInt()) {
                        int node1 = scanner.nextInt();
                        int node2 = scanner.nextInt();
                        double voltage = scanner.nextDouble();
                        circuit.addVoltageSource(node1, node2, voltage);
                    }
                    break;
                    
                case "r":
                    // Read resistor: r node1 node2 resistance
                    if (scanner.hasNextInt()) {
                        int node1 = scanner.nextInt();
                        int node2 = scanner.nextInt();
                        double resistance = scanner.nextDouble();
                        circuit.addResistor(node1, node2, resistance);
                    }
                    break;
                    
                case "spice":
                    // Print SPICE description
                    System.out.println(circuit.toSpice());
                    break;
                    
                case "end":
                    // Terminate program
                    System.out.println("All Done");
                    scanner.close();
                    return;
                    
                default:
                    System.out.println("Unknown command: " + command);
                    scanner.nextLine(); // Clear the line
                    break;
            }
        }
        
        scanner.close();
    }
}