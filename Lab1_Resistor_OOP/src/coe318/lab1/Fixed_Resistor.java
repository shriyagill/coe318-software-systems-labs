/**
 * A Resistor models an ideal resistor that obeys Ohm's Law.
 *
 * @author Shriya Gill 501224132
 */
package coe318.lab1;

public class Resistor {
    //Instance (state) variables
    private double resistanceValue;  // The resistance in Ohms
    private double currentValue;     // The current through the resistor in Amps

    /**
     * Create an ideal Resistor. The initial current through and voltage across
     * the Resistor are zero.
     *
     * @param resistance resistance in Ohms
     */
    public Resistor(double resistance) {
        //Set values of state variables
        this.resistanceValue = resistance;
        this.currentValue = 0.0;  // Initial current is zero
    }

    /**
     * Returns the value of the resistor in Ohms.
     *
     * @return the resistance
     */
    public double getResistance() {
        return resistanceValue;
    }

    /**
     * Returns the voltage across the resistor.
     *
     * @return the voltage
     */
    public double getVoltage() {
        // Use Ohm's Law: V = I * R
        return currentValue * resistanceValue;
    }

    /**
     * Sets the value of the voltage across the resistor.
     *
     * @param voltage the voltage to set
     */
    public void setVoltage(double voltage) {
        // Only set the voltage value if the parameter is between -50 and 50 otherwise error
        if (voltage >= -50.0 && voltage <= 50.0) {
            // Using Ohm's Law: I = V / R
            this.currentValue = voltage / resistanceValue;
        } else {
            System.out.println("Error: voltage value is beyond the limit");
        }
    }

    /**
     * Returns the current through the Resistor.
     *
     * @return the current
     */
    public double getCurrent() {
        return currentValue;
    }

    /**
     * Sets the value of the current through the resistor.
     *
     * @param current the current to set
     */
    public void setCurrent(double current) {
        // Only set the current value if the parameter is between -5 and 5 otherwise error
        if (current >= -5.0 && current <= 5.0) {
            this.currentValue = current;
        } else {
            System.out.println("Error: current value is beyond the limit");
        }
    }

    /**
     * Returns the power (in Watts) dissipated by the Resistor.
     *
     * @return the power
     */
    public double getPower() {
        // Use Power formula: P = I^ * R
        return currentValue * currentValue * resistanceValue;
    }

    /**
     * A simple example of using a Resistor.
     * <p>
     * The output should be:
     * <pre>
     * Creating a 50 Ohm resistor (r1)
     * Its resistance is 50.0 Ohms
     * Its current is 0.0 Amps
     * Its voltage is 0.0 Volts
     * * Its power is 0.0 Watts
     * Creating a 100 Ohm resistor (r2)
     * Its resistance is 100.0 Ohms
     * Setting r1's current to 10 Amps
     * Error: current value beyond limit
     * Setting r1's current to 2 Amps
     * Its current is 2.0 Amps
     * Its voltage is 100.0 Volts
     * Its power is 200.0 Watts
     * Setting r1's voltage to 90 Volts
     * Error: voltage value beyond limit
     * Setting r1's voltage to 50 Volts
     * Its current is 1.0 Amps
     * Setting r2's current to 3 Amps
     * Its voltage is 300.0 Volts
     * </pre>
     *
     * @param args (Command line arguments not used.)
     */
    public static void main(String[] args) {
        Resistor r1, r2;
        System.out.println("Creating a 50 Ohm resistor (r1)");
        r1 = new Resistor(50.0);
        System.out.println("Its resistance is "
                + r1.getResistance() + " Ohms");
        System.out.println("Its current is "
                + r1.getCurrent() + " Amps");
        System.out.println("Its voltage is "
                + r1.getVoltage() + " Volts");
        System.out.println("Its power is "
                + r1.getPower() + " Watts");
        System.out.println("Creating a 100 Ohm resistor (r2)");
        r2 = new Resistor(100.0);
        System.out.println("Its resistance is "
                + r2.getResistance() + " Ohms");
        System.out.println("Setting r1's current to 10 Amps");
        r1.setCurrent(10.0);
        System.out.println("Setting r1's current to 2 Amps");
        r1.setCurrent(2.0);
        System.out.println("Its current is "
                + r1.getCurrent() + " Amps");
        System.out.println("Its voltage is "
                + r1.getVoltage() + " Volts");
        System.out.println("Its power is "
                + r1.getPower() + " Watts");
        System.out.println("Setting r1's voltage to 90 Volts");
        r1.setVoltage(90.0);
        System.out.println("Setting r1's voltage to 50 Volts");
        r1.setVoltage(50.0);
        System.out.println("Its current is "
                + r1.getCurrent() + " Amps");
        System.out.println("Setting r2's current to 3 Amps");
        r2.setCurrent(3.0);
        System.out.println("Its voltage is "
                + r2.getVoltage() + " Volts");
    }
}