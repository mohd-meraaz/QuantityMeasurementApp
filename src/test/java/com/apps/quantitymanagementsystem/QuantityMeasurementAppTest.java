package com.apps.quantitymanagementsystem;

import com.apps.qualitymanagementsystem.QuantityManagementApp.Feet;
import com.apps.qualitymanagementsystem.QuantityManagementApp.Inches;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class QuantityMeasurementAppTest {
	 /**
	  * Testing for Feet Values
	  */
	 @Test
	 public void testFeetEquality_SameValue() {
		 Feet f1 = new Feet(1.0);
	     Feet f2 = new Feet(1.0);
	     assertTrue(f1.equals(f2));
	 }
	 
	 @Test
	 public void testFeetEquality_DifferentValue () {
		 Feet f1 = new Feet(1.0);
	     Double f2 = 1.0;
	     assertFalse(f1.equals(f2));
	 }
	 
	 @Test
	 public void testFeetEquality_NullComparison() {
		 Feet f1 = new Feet(1.0);
		 assertFalse(f1.equals(null));
	 }
	 
	 @Test
	 public void testFeetEquality_DifferentClass() {
		 Feet f1 = new Feet(1.0);
		 Inches i1 = new Inches(1.0);
		 assertFalse(f1.equals(i1));
	 }
	 @Test
	 public void testFeetEquality_SameReference() {
		 Feet f1 = new Feet(1.0);
		 assertTrue(f1.equals(f1));
	 }
	 /**
	  * Testing for Inches Values
	  */
	 @Test
	 public void testInchesEquality_SameValue() {
		 Inches i1 = new Inches(1.0);
		 Inches i2 = new Inches(1.0);
	     assertTrue(i1.equals(i2));
	 }
	 
	 @Test
	 public void testInchesEquality_DifferentValue () {
		 Inches i1 = new Inches(1.0);
	     Double d = 1.0;
	     assertFalse(i1.equals(d));
	 }
	 
	 @Test
	 public void testInchesEquality_NullComparison() {
		 Inches i1 = new Inches(1.0);
		 assertFalse(i1.equals(null));
	 }
	 
	 @Test
	 public void testInchesEquality_DifferentClass() {
		 Feet f1 = new Feet(1.0);
		 Inches i1 = new Inches(1.0);
		 assertFalse(f1.equals(i1));
	 }
	 @Test
	 public void testInchesEquality_SameReference() {
		 Inches i1 = new Inches(1.0);
		 assertTrue(i1.equals(i1));
	 }
}
