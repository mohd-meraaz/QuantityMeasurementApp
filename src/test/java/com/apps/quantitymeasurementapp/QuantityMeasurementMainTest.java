package com.apps.quantitymeasurementapp;
import com.apps.quantitymeasurementapp.Length.LengthUnit;
import com.apps.quantitymeasurementapp.QuantityMeasurementApp.FeetEquality; 
import com.apps.quantitymeasurementapp.QuantityMeasurementApp.InchEquality;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class QuantityMeasurementMainTest {
	
	Length len1;
	Length len2;
	
	//Feet
	@Test
	public void testFeetEquality_SameValue()  {
		FeetEquality feet1 = new FeetEquality(10.1);
		FeetEquality feet2 = new FeetEquality(10.1);
		assertTrue(feet1.equals(feet2));
	}
	
	@Test
	public void testFeetEquality_DifferentValue() {
		FeetEquality feet1 = new FeetEquality(10.1);
		FeetEquality feet2 = new FeetEquality(1.1);
		assertFalse(feet1.equals(feet2));
	}

	@Test
	public void testFeetEquality_NullComparison() {
		FeetEquality feet1 = new FeetEquality(1.0);
		FeetEquality feet2 = null;
		assertFalse(feet1.equals(feet2));;
	}
	
	@Test
	public void testFeetEquality_NonNumericInput() {
		assertThrows(IllegalArgumentException.class, ()-> {
			new FeetEquality(Double.NaN);
		});
	}
	
	@Test
	public void testFeetEquality_SameReference() {
		FeetEquality feet1 = new FeetEquality(1.0);
		FeetEquality feet2 = feet1;
		assertTrue(feet1.equals(feet2));
	}
	
	//Inch

	@Test
	public void testInchEquality_SameValue()  {
		InchEquality Inch1 = new InchEquality(10.1);
		InchEquality Inch2 = new InchEquality(10.1);
		assertTrue(Inch1.equals(Inch2));
	}
	
	@Test
	public void testInchEquality_DifferentValue() {
		InchEquality Inch1 = new InchEquality(10.1);
		InchEquality Inch2 = new InchEquality(1.1);
		assertFalse(Inch1.equals(Inch2));
	}

	@Test
	public void testInchEquality_NullComparison() {
		InchEquality Inch1 = new InchEquality(1.0);
		InchEquality Inch2 = null;
		assertFalse(Inch1.equals(Inch2));;
	}
	
	@Test
	public void testInchEquality_NonNumericInput() {
		assertThrows(IllegalArgumentException.class, ()-> {
			new InchEquality(Double.NaN);
		});
	}
	
	@Test
	public void testInchEquality_SameReference() {
		InchEquality Inch1 = new InchEquality(1.0);
		InchEquality Inch2 = Inch1;
		assertTrue(Inch1.equals(Inch2));
	}
	
	//Length
	@Test
	public void testFeetEquality() {
		len1 = new Length(1,Length.LengthUnit.FEET);
		len2 = new Length(1,Length.LengthUnit.FEET);
		assertTrue(len1.equals(len1));
	}
	
	@Test
	public void testInchEquality() {
		len1 = new Length(11,Length.LengthUnit.INCHES);
		len2 = new Length(11,Length.LengthUnit.INCHES);
		assertTrue(len1.equals(len1));
	}
	
	@Test
	public void testFeetInchesComparison() {
		len1 = new Length(1,Length.LengthUnit.FEET);
		len2 = new Length(12,Length.LengthUnit.INCHES);
		assertTrue(len1.equals(len1));
	}
	
	@ParameterizedTest
	@ValueSource(doubles = {1,2,3,4})
	public void testMultipleFeetComparison(double feet) {
		len1 = new Length(feet,Length.LengthUnit.FEET);
		len2 = new Length(feet*12,Length.LengthUnit.INCHES);
		assertTrue(len1.equals(len1));
	}
	
	//Yard
	
	@Test
	public void yardEquals36Inches() {
		assertTrue(new Length(1.0, Length.LengthUnit.YARD).equals(new Length(36.0,Length.LengthUnit.INCHES)));
	}

	@Test
	public void centimeterEquals39Point3701Inches() {
		assertTrue(new Length(100.0, Length.LengthUnit.CENTIMETERS).equals(new Length(39.37,Length.LengthUnit.INCHES)));
	}

	@Test
	public void threeFeetEqualsOneYard() {
		assertTrue(new Length(3.0, Length.LengthUnit.FEET).equals(new Length(1.0,Length.LengthUnit.YARD)));		
	}

	@Test
	public void thirtyPoint48CmEqualsOneFoot() {
		assertTrue(new Length(30.48, Length.LengthUnit.CENTIMETERS).equals(new Length(1.0,Length.LengthUnit.FEET)));
	}

	@Test
	public void yardNotEqualToInches() {
		assertFalse(new Length(100.0, Length.LengthUnit.YARD).equals(new Length(39.37,Length.LengthUnit.INCHES)));
	}

	@Test
	public void referenceEqualitySameObject() {
		len1 = new Length(1.0, Length.LengthUnit.YARD);
		len2 = len1;
		assertTrue(len1.equals(len1));
	}

	@Test
	public void equalsReturnsFalseForNull() {
		len1 = new Length(1.0, Length.LengthUnit.YARD);
		assertFalse(len1.equals(null));
	}

	@Test
	public void reflexiveSymmetricAndTransitiveProperty() {
		Length a = new Length(1.0, Length.LengthUnit.YARD);
	    Length b = new Length(3.0, Length.LengthUnit.FEET);
	    Length c = new Length(36.0, Length.LengthUnit.INCHES);
	    
		// Reflexive
	    assertTrue(a.equals(a));
	
	    // Symmetric
	    assertTrue(a.equals(b));
	    assertTrue(b.equals(a));
	
	    // Transitive
	    assertTrue(a.equals(b));
	    assertTrue(b.equals(c));
	    assertTrue(a.equals(c));
	}

	@Test
	public void differentValuesSameUnitNotEqual() {
		assertFalse(new Length(10.5,Length.LengthUnit.FEET).equals(new Length(123.2, Length.LengthUnit.FEET)));
	}

	@Test
	public void crossUnitEqualityDemonstrateMethod() {
		Length yard = new Length(1.0, Length.LengthUnit.YARD);
	    Length inch = new Length(36.0, Length.LengthUnit.INCHES);

	    assertTrue(yard.equals(inch));
	}
	
	@Test
	public void convertFeetToInches() throws InvalidUnitMeasurementException {
		Length lengthInches = QuantityMeasurementApp.demonstrateLengthConversion(3.0, LengthUnit.FEET, LengthUnit.INCHES);
		Length expectedInches = new Length(36.0,Length.LengthUnit.INCHES);
		assertTrue(QuantityMeasurementApp.demonstrateLengthEquality(lengthInches, expectedInches));
	}
	
	@Test
	public void convertYardToInchesUsingOverloadMethod() throws InvalidUnitMeasurementException {
		Length lengthInYard = new Length(2.0, Length.LengthUnit.YARD);
		Length lengthInInches = QuantityMeasurementApp.demonstrateLengthConversion(lengthInYard, LengthUnit.INCHES);
		Length expected = new Length(72.0,Length.LengthUnit.INCHES);
		assertTrue(QuantityMeasurementApp.demonstrateLengthEquality(lengthInInches, expected));
	}
	
	@Test
	public void addFeetAndInches() throws InvalidUnitMeasurementException {
		Length Feet = new Length(1.0,Length.LengthUnit.FEET);
		Length Inches = new Length(24.0,Length.LengthUnit.INCHES);
		Length ouput = QuantityMeasurementApp.convertFromBaseToTargetUnit(Feet, Inches);
		Length result = new Length(3.0, Length.LengthUnit.FEET);
		assertTrue(ouput.equals(result));
	}
}