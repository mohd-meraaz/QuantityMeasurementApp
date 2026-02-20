package com.apps.quantitymanagementsystem;

import com.apps.qualitymanagementsystem.QualityManagementApp.Feet;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class QuantityMeasurementAppTest {
	 @Test
    public void equalsTest1() {
        Feet f1 = new Feet(1.0);
        Feet f2 = new Feet(1.0);

        assertTrue(f1.equals(f2));
    }
	 
	 @Test
	    public void equalsTest2() {
	        Feet f1 = new Feet(1.0);
//	        Feet f2 = new Feet(null);
	        assertFalse(f1.equals(null));
	    }
	 
	 @Test
	    public void equalsTest3() {
	        Feet f1 = new Feet(1.0);
	        Double f2 = 1.0;

	        assertFalse(f1.equals(f2));
	    }
	 
	 @Test
	    public void equalsTest4() {
	        Feet f1 = new Feet(2.0);
	        Feet f2 = new Feet(1.0);

	        assertFalse(f1.equals(f2));
	    }
}
