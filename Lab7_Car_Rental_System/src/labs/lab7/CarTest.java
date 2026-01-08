package labs.lab7;

import org.junit.Test;
import static org.junit.Assert.*;

public class CarTest {
    
    @Test
    public void testCalculateRentalPriceAutomatic() {
        Car automaticCar = new Car("ABC-123", "Toyota Corolla", 2020, true);
        double expected = 65.0 * 3; // 195.0
        double actual = automaticCar.calculateRentalPrice(3);
        assertEquals(expected, actual, 0.01);
    }
    
    @Test
    public void testCalculateRentalPriceManual() {
        Car manualCar = new Car("XYZ-456", "Honda Civic", 2021, false);
        double expected = 55.0 * 2; // 110.0
        double actual = manualCar.calculateRentalPrice(2);
        assertEquals(expected, actual, 0.01);
    }
    
    @Test
    public void testCalculateRentalPriceWithGPS() {
        Car car = new Car("XYZ-456", "Honda Civic", 2021, false);
        double expected = (55.0 * 3) + (10.0 * 3); // 165 + 30 = 195.0
        double actual = car.calculateRentalPrice(3, true);
        assertEquals(expected, actual, 0.01);
    }
    
    @Test
    public void testCalculateRentalPriceWithoutGPS() {
        Car car = new Car("XYZ-456", "Honda Civic", 2021, false);
        double expected = 55.0 * 3; // 165.0
        double actual = car.calculateRentalPrice(3, false);
        assertEquals(expected, actual, 0.01);
    }
    
    @Test
    public void testCalculateInsurancePremium() {
        Car car = new Car("ABC-123", "Toyota Corolla", 2020, true);
        // Base rate is 20.0, increased by 10% = 22.0 per day
        double expected = 20.0 * 1.10 * 4; // 88.0
        double actual = car.calculateInsurancePremium(4);
        assertEquals(expected, actual, 0.01);
    }
    
    @Test
    public void testToString() {
        Car automaticCar = new Car("ABC-123", "Toyota Corolla", 2020, true);
        String expected = "Car: 2020 Toyota Corolla (ABC-123) [Automatic]";
        String actual = automaticCar.toString();
        assertEquals(expected, actual);
    }
    
    @Test
    public void testIsAutomatic() {
        Car automaticCar = new Car("ABC-123", "Toyota Corolla", 2020, true);
        assertTrue(automaticCar.isAutomatic());
        
        Car manualCar = new Car("XYZ-456", "Honda Civic", 2021, false);
        assertFalse(manualCar.isAutomatic());
    }
}