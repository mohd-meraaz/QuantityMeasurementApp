package com.apps.quantitymeasurementapp;
import com.apps.quantitymeasurementapp.QuantityMeasurementApp.FeetEquality; 
import com.apps.quantitymeasurementapp.QuantityMeasurementApp.InchEquality;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class QuantityMeasurementMainTest {
	
	Length len1;
	Length len2;
	Weight w1;
	Weight w2;
	
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
	
	// Length

	@Test
	public void testFeetEquality() {
	    len1 = new Length(1, LengthUnit.FEET);
	    len2 = new Length(1, LengthUnit.FEET);
	    assertTrue(len1.equals(len1));
	}

	@Test
	public void testInchEquality() {
	    len1 = new Length(11, LengthUnit.INCHES);
	    len2 = new Length(11, LengthUnit.INCHES);
	    assertTrue(len1.equals(len1));
	}

	@Test
	public void testFeetInchesComparison() {
	    len1 = new Length(1, LengthUnit.FEET);
	    len2 = new Length(12, LengthUnit.INCHES);
	    assertTrue(len1.equals(len1));
	}

	@ParameterizedTest
	@ValueSource(doubles = {1,2,3,4})
	public void testMultipleFeetComparison(double feet) {
	    len1 = new Length(feet, LengthUnit.FEET);
	    len2 = new Length(feet*12, LengthUnit.INCHES);
	    assertTrue(len1.equals(len1));
	}

	// Yard

	@Test
	public void yardEquals36Inches() {
	    assertTrue(new Length(1.0, LengthUnit.YARD)
	            .equals(new Length(36.0, LengthUnit.INCHES)));
	}

	@Test
	public void centimeterEquals39Point3701Inches() {
	    assertTrue(new Length(100.0, LengthUnit.CENTIMETERS)
	            .equals(new Length(39.37, LengthUnit.INCHES)));
	}

	@Test
	public void threeFeetEqualsOneYard() {
	    assertTrue(new Length(3.0, LengthUnit.FEET)
	            .equals(new Length(1.0, LengthUnit.YARD)));        
	}

	@Test
	public void thirtyPoint48CmEqualsOneFoot() {
	    assertTrue(new Length(30.48, LengthUnit.CENTIMETERS)
	            .equals(new Length(1.0, LengthUnit.FEET)));
	}

	@Test
	public void yardNotEqualToInches() {
	    assertFalse(new Length(100.0, LengthUnit.YARD)
	            .equals(new Length(39.37, LengthUnit.INCHES)));
	}

	@Test
	public void referenceEqualitySameObject() {
	    len1 = new Length(1.0, LengthUnit.YARD);
	    len2 = len1;
	    assertTrue(len1.equals(len1));
	}

	@Test
	public void equalsReturnsFalseForNull() {
	    len1 = new Length(1.0, LengthUnit.YARD);
	    assertFalse(len1.equals(null));
	}

	@Test
	public void reflexiveSymmetricAndTransitiveProperty() {
	    Length a = new Length(1.0, LengthUnit.YARD);
	    Length b = new Length(3.0, LengthUnit.FEET);
	    Length c = new Length(36.0, LengthUnit.INCHES);

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
	    assertFalse(new Length(10.5, LengthUnit.FEET)
	            .equals(new Length(123.2, LengthUnit.FEET)));
	}

	@Test
	public void crossUnitEqualityDemonstrateMethod() {
	    Length yard = new Length(1.0, LengthUnit.YARD);
	    Length inch = new Length(36.0, LengthUnit.INCHES);

	    assertTrue(yard.equals(inch));
	}

	@Test
	public void convertFeetToInches() throws InvalidUnitMeasurementException {
	    Length lengthInches = QuantityMeasurementApp
	            .demonstrateLengthConversion(3.0, LengthUnit.FEET, LengthUnit.INCHES);
	    Length expectedInches = new Length(36.0, LengthUnit.INCHES);
	    assertTrue(QuantityMeasurementApp
	            .demonstrateLengthEquality(lengthInches, expectedInches));
	}

	@Test
	public void convertYardToInchesUsingOverloadMethod() throws InvalidUnitMeasurementException {
	    Length lengthInYard = new Length(2.0, LengthUnit.YARD);
	    Length lengthInInches = QuantityMeasurementApp
	            .demonstrateLengthConversion(lengthInYard, LengthUnit.INCHES);
	    Length expected = new Length(72.0, LengthUnit.INCHES);
	    assertTrue(QuantityMeasurementApp
	            .demonstrateLengthEquality(lengthInInches, expected));
	}

	@Test
	public void addFeetAndInches() throws InvalidUnitMeasurementException {
	    Length Feet = new Length(1.0, LengthUnit.FEET);
	    Length Inches = new Length(24.0, LengthUnit.INCHES);
	    Length output = QuantityMeasurementApp
	            .convertFromBaseToTargetUnit(Feet, Inches);
	    Length result = new Length(3.0, LengthUnit.FEET);
	    assertTrue(output.equals(result));
	}

	@Test
	void addFeetAndInchesWithTargetUnitInches() throws InvalidUnitMeasurementException {
	    Length Feet = new Length(1.0, LengthUnit.FEET);
	    Length Inches = new Length(24.0, LengthUnit.INCHES);
	    Length output = QuantityMeasurementApp
	            .demonstrateLengthAddition(Feet, Inches, LengthUnit.INCHES);
	    Length result = new Length(3.0, LengthUnit.FEET);
	    assertTrue(output.equals(result));
	}
	


	//Verifies that Quantity(1.0, KILOGRAM).equals(Quantity(1.0, KILOGRAM)) returns true.
	//Tests: equals() returns true for identical kilogram measurements.
	@Test
	public void testEquality_KilogramToKilogram_SameValue(){
		w1 = new Weight(1.0,WeightUnit.KILOGRAM);
		w2 = new Weight(1.0,WeightUnit.KILOGRAM);
		assertTrue(w1.equals(w2));
	}
	

	//Verifies that Quantity(1.0, KILOGRAM).equals(Quantity(2.0, KILOGRAM)) returns false.
	//Tests: equals() returns false for different kilogram measurements.
	@Test
	public void testEquality_KilogramToKilogram_DifferentValue() {
		w1 = new Weight(12.0,WeightUnit.KILOGRAM);
		w2 = new Weight(1.0,WeightUnit.KILOGRAM);
		assertFalse(w1.equals(w2));
	}


	//Verifies that Quantity(1.0, KILOGRAM).equals(Quantity(1000.0, GRAM)) returns true.
	//Tests: equals() returns true for kilogram-to-gram conversion.
	@Test
	public void testEquality_KilogramToGram_EquivalentValue(){
		w1 = new Weight(12.0,WeightUnit.KILOGRAM);
		w2 = new Weight(12000.0,WeightUnit.GRAM);
		assertTrue(w1.equals(w2));
	}

	//Verifies that Quantity(1000.0, GRAM).equals(Quantity(1.0, KILOGRAM)) returns true.
	//Tests: equals() returns true (tests symmetry of conversion).
	@Test
	public void testEquality_GramToKilogram_EquivalentValue() {
		w1 = new Weight(12000.0,WeightUnit.GRAM);
		w2 = new Weight(12.0,WeightUnit.KILOGRAM);
		assertTrue(w1.equals(w2));
	}

	//Verifies that Quantity(1.0, KILOGRAM).equals(Quantity(1.0, FOOT)) returns false.
	//Tests: equals() returns false when comparing incompatible measurement categories.
	@Test
	public void testEquality_WeightVsLength_Incompatible() {
		w1 = new Weight(10.0,WeightUnit.KILOGRAM);
		len1 = new Length(1.0,LengthUnit.FEET);
		assertFalse(w1.equals(w2));
	}

	//Verifies that Quantity(1.0, KILOGRAM).equals(null) returns false.
	//Tests: equals() returns false when comparing with null.
	@Test
	public void testEquality_NullComparison() {
		w1 = new Weight(10.0,WeightUnit.KILOGRAM);
		assertFalse(w1.equals(null));
	}

	//Verifies that a weight object equals itself (reflexive property).
	//Tests: equals() returns true when comparing an object with itself.
	@Test
	public void testEquality_SameReference() {
		w1 = new Weight(12000.0,WeightUnit.GRAM);
		w2 = w1;
		assertTrue(w1.equals(w2));
	}

	//Verifies that Quantity(1.0, null) throws IllegalArgumentException.
	//Tests: Exception thrown for null unit in constructor.
	@Test
	public void testEquality_NullUnit() {
		assertThrows(IllegalArgumentException.class,()-> {
			w1 = new Weight(12000.0,null);
		});
	}

	//Verifies transitive property: if A equals B and B equals C, then A equals C.
	//Example: Quantity(1.0, KILOGRAM) equals Quantity(1000.0, GRAM) and Quantity(1000.0, GRAM) equals Quantity(1.0, KILOGRAM), therefore Quantity(1.0, KILOGRAM) equals Quantity(1.0, KILOGRAM).
	@Test
	public void testEquality_TransitiveProperty() {
		w1 = new Weight(12000.0,WeightUnit.GRAM);
		w2 = new Weight(12.0,WeightUnit.KILOGRAM);
		assertTrue((w1.equals(w2)) && (w2.equals(w1)));
	}
	

	//Verifies that Quantity(0.0, KILOGRAM).equals(Quantity(0.0, GRAM)) returns true.
	//Tests: Zero values are considered equal across units.
	@Test
	public void testEquality_ZeroValue() {
		w1 = new Weight(0.0,WeightUnit.KILOGRAM);
		w2 = new Weight(0.0,WeightUnit.GRAM);
		assertTrue(w1.equals(w2));
	}

	//Verifies that Quantity(-1.0, KILOGRAM).equals(Quantity(-1000.0, GRAM)) returns true.
	//Tests: Negative weight values are handled correctly in conversions.
	@Test
	public void testEquality_NegativeWeight() {
		w1 = new Weight(-1.0,WeightUnit.KILOGRAM);
		w2 = new Weight(-1000.0,WeightUnit.GRAM);
		assertTrue(w1.equals(w2));
	}

	
	//Verifies that Quantity(1000000.0, GRAM).equals(Quantity(1000.0, KILOGRAM)) returns true.
	//Tests: Large magnitude values maintain precision across conversions.
	@Test
	public void testEquality_LargeWeightValue() {
		w1 = new Weight(1000000.0,WeightUnit.GRAM);
		w2 = new Weight(1000.0,WeightUnit.KILOGRAM);
		assertTrue(w1.equals(w2));
	}

	//Verifies that Quantity(0.001, KILOGRAM).equals(Quantity(1.0, GRAM)) returns true.
	//Tests: Small magnitude values maintain precision across conversions.
	@Test
	public void testEquality_SmallWeightValue() {
		w1 = new Weight(0.001,WeightUnit.KILOGRAM);
		w2 = new Weight(1.0,WeightUnit.GRAM);
		assertTrue(w1.equals(w2));
	}

	//Verifies that Quantity(2.20462, POUND).convertTo(KILOGRAM) returns Quantity(~1.0, KILOGRAM) (within epsilon).
	//Tests: Conversion from pound to kilogram.
	@Test
	public void testConversion_PoundToKilogram() throws InvalidUnitMeasurementException {
		w1 = new Weight(2.20462,WeightUnit.POUND);
		Weight output = QuantityMeasurementApp.demonstrateWeightConversion(w1, WeightUnit.KILOGRAM);
		Weight result = new Weight(1.0,WeightUnit.KILOGRAM);
		assertTrue(output.equals(result));
	}

	//Verifies that Quantity(1.0, KILOGRAM).convertTo(POUND) returns Quantity(~2.20462, POUND) (within epsilon).
	//Tests: Conversion from kilogram to pound.
	@Test
	public void testConversion_KilogramToPound() throws InvalidUnitMeasurementException {
		w1 = new Weight(1.0,WeightUnit.KILOGRAM);
		Weight output = QuantityMeasurementApp.demonstrateWeightConversion(w1, WeightUnit.POUND);
		Weight result = new Weight(2.20462,WeightUnit.POUND);
		assertTrue(output.equals(result));
	}

	//Verifies that Quantity(5.0, KILOGRAM).convertTo(KILOGRAM) returns Quantity(5.0, KILOGRAM).
	//Tests: Converting to the same unit returns unchanged value.
	@Test
	public void testConversion_SameUnit() throws InvalidUnitMeasurementException {
		w1 = new Weight(5.0,WeightUnit.KILOGRAM);
		Weight output = QuantityMeasurementApp.demonstrateWeightConversion(w1, WeightUnit.KILOGRAM);
		Weight result = new Weight(5.0,WeightUnit.KILOGRAM);
		assertTrue(output.equals(result));
	}

	//Verifies that Quantity(0.0, KILOGRAM).convertTo(GRAM) returns Quantity(0.0, GRAM).
	//Tests: Zero value conversion across units.
	@Test
	public void testConversion_ZeroValue() throws InvalidUnitMeasurementException {
		w1 = new Weight(0.0,WeightUnit.KILOGRAM);
		Weight output = QuantityMeasurementApp.demonstrateWeightConversion(w1, WeightUnit.GRAM);
		Weight result = new Weight(0.0,WeightUnit.GRAM);
		assertTrue(output.equals(result));
	}

	//Verifies that Quantity(-1.0, KILOGRAM).convertTo(GRAM) returns Quantity(-1000.0, GRAM).
	//Tests: Negative weight conversion preserves sign.
	@Test
	public void testConversion_NegativeValue() throws InvalidUnitMeasurementException {
		w1 = new Weight(-1.0,WeightUnit.KILOGRAM);
		Weight output = QuantityMeasurementApp.demonstrateWeightConversion(w1, WeightUnit.GRAM);
		Weight result = new Weight(-1000.0,WeightUnit.GRAM);
		assertTrue(output.equals(result));
	}

	//Verifies that Quantity (1.5, KILOGRAM).convertTo(GRAM) .convertTo(KILOGRAM) returns Quantity(~1.5, KILOGRAM) (within epsilon).
	//Tests: Round-trip conversions preserve value within floating-point tolerance.
	@Test
	public void testConversion_RoundTrip() throws InvalidUnitMeasurementException {
		w1 = new Weight(1.5,WeightUnit.KILOGRAM);
		Weight output = QuantityMeasurementApp.demonstrateWeightConversion(w1, WeightUnit.GRAM);
		Weight result = new Weight(1.5,WeightUnit.KILOGRAM);
		assertTrue(output.equals(result));
	}

	//Verifies that Quantity(1.0, KILOGRAM).add(Quantity(2.0, KILOGRAM)) returns Quantity(3.0, KILOGRAM).
	//Tests: Same-unit addition without conversion.
	@Test
	public void testAddition_SameUnit_KilogramPlusKilogram() throws InvalidUnitMeasurementException {
		w1 = new Weight(1.0,WeightUnit.KILOGRAM);
		w2 = new Weight(2.0,WeightUnit.KILOGRAM);
		Weight output = QuantityMeasurementApp.demonstrateWeightAddition(w1, w2);
		Weight result = new Weight(3.0,WeightUnit.KILOGRAM);
		assertTrue(output.equals(result));
	} 

	//Verifies that Quantity(1.0, KILOGRAM).equals(Quantity(1.0, KILOGRAM)) returns true.
	//Tests: equals() returns true for identical kilogram measurements.
	@Test
	public void testAddition_CrossUnit_KilogramPlusGram() throws InvalidUnitMeasurementException {
		w1 = new Weight(1.0,WeightUnit.KILOGRAM);
		w2 = new Weight(1.0,WeightUnit.KILOGRAM);
		assertTrue(w1.equals(w2));
	}

	//Verifies that Quantity(1.0, KILOGRAM).add(Quantity(1000.0, GRAM)) returns Quantity(2.0, KILOGRAM).
	//Tests: Cross-unit addition will result in the first operand's unit.
	@Test
	public void testLengthUnitEnum_InchesConstant() throws InvalidUnitMeasurementException {
		w1 = new Weight(1.0,WeightUnit.KILOGRAM);
		w2 = new Weight(1000.0,WeightUnit.GRAM);
		Weight output = QuantityMeasurementApp.demonstrateWeightAddition(w1, w2);
		Weight result = new Weight(2.0,WeightUnit.KILOGRAM);
		assertTrue(output.equals(result));
	}

	//Verifies that Quantity(2.20462, POUND).add(Quantity(1.0, KILOGRAM)) returns Quantity(~4.40924, POUND).
	//Tests: Cross-unit addition with mixed metric and imperial units.
	@Test
	public void testAddition_CrossUnit_PoundPlusKilogram() throws InvalidUnitMeasurementException {
		w1 = new Weight(2.20462,WeightUnit.POUND);
		w2 = new Weight(1.0,WeightUnit.KILOGRAM);
		Weight output = QuantityMeasurementApp.demonstrateWeightAddition(w1, w2);
		Weight result = new Weight(4.40924,WeightUnit.POUND);
		assertTrue(output.equals(result));
	} 

	//Verifies that Quantity(1.0, KILOGRAM).add(Quantity(1000.0, GRAM), GRAM) returns Quantity(2000.0, GRAM).
	//Tests: Explicit target unit specification in gram.
	@Test
	public void testAddition_ExplicitTargetUnit_Kilogram() throws InvalidUnitMeasurementException {
		w1 = new Weight(1.0,WeightUnit.KILOGRAM);
		w2 = new Weight(1000.0,WeightUnit.GRAM);
		Weight output = QuantityMeasurementApp.demonstrateWeightAddition(w1, w2, WeightUnit.GRAM);
		Weight result = new Weight(2000.0,WeightUnit.GRAM);
		assertTrue(output.equals(result));
	}

	//Verifies that Quantity(1.0, KILOGRAM).add(Quantity(1000.0, GRAM)) equals Quantity(1000.0, GRAM).add(Quantity(1.0, KILOGRAM)) in their respective units.
	//Tests: Addition is commutative with appropriate unit conversions.
	@Test
	public void testAddition_Commutativity() throws InvalidUnitMeasurementException {
		w1 = new Weight(1.0,WeightUnit.KILOGRAM);
		w2 = new Weight(1000.0,WeightUnit.GRAM);
		Weight output1 = QuantityMeasurementApp.demonstrateWeightAddition(w1, w2);
		Weight output2 = QuantityMeasurementApp.demonstrateWeightAddition(w2, w1);
		assertTrue(output1.equals(output2));
	}

	//Verifies that Quantity(5.0, KILOGRAM).add(Quantity(0.0, GRAM)) returns Quantity(5.0, KILOGRAM).
	//Tests: Adding zero acts as an identity element.
	@Test
	public void testAddition_WithZero() throws InvalidUnitMeasurementException {
		w1 = new Weight(5.0,WeightUnit.KILOGRAM);
		w2 = new Weight(0.0,WeightUnit.GRAM);
		Weight output1 = QuantityMeasurementApp.demonstrateWeightAddition(w1, w2);
		Weight result = new Weight(5.0,WeightUnit.KILOGRAM);
		assertTrue(output1.equals(result));
	}

	//Verifies that Quantity(5.0, KILOGRAM).add(Quantity(-2000.0, GRAM)) returns Quantity(3.0, KILOGRAM).
	//Tests: Addition with negative measurements.
	@Test
	public void testAddition_NegativeValues() throws InvalidUnitMeasurementException {
		w1 = new Weight(5.0,WeightUnit.KILOGRAM);
		w2 = new Weight(-2000.0,WeightUnit.GRAM);
		Weight output1 = QuantityMeasurementApp.demonstrateWeightAddition(w1, w2);
		Weight result = new Weight(3.0,WeightUnit.KILOGRAM);
		assertTrue(output1.equals(result));
	}

	//Verifies that Quantity(1e6, KILOGRAM).add(Quantity(1e6, KILOGRAM)) returns Quantity(2e6, KILOGRAM).
	//Tests: Addition with large magnitude values.
	@Test
	public void testAddition_LargeValues() throws InvalidUnitMeasurementException {
		w1 = new Weight(1e6,WeightUnit.KILOGRAM);
		w2 = new Weight(1e6,WeightUnit.KILOGRAM);
		Weight output1 = QuantityMeasurementApp.demonstrateWeightAddition(w1, w2);
		Weight result = new Weight(2e6,WeightUnit.KILOGRAM);
		assertTrue(output1.equals(result));
	}
}