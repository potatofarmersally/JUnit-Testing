/**
 * TCSS 305 - Winter 2018 
 * Assignment 1
 */
package test;

import static org.junit.Assert.*;

import java.awt.Color;
import java.awt.Point;
import org.junit.Before;
import org.junit.Test;
import shapes.Circle;

/**
 * This is the class to test the Circle class. 
 * 
 * @author Sally Ho
 * @version January 10, 2018
 */
public class CircleTest {
    
    /** This tests for the default circle. */
    private Circle myDefaultCircle; 
    
    /** This tests for a circle with 1. */
    private Circle myPos1Circle; 
    
    /** This tests for a positive integer other than 1. */
    private Circle myExtremePosCircle; 
    
    /**
     * Initial setup.
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() {
        myDefaultCircle = new Circle();
        myPos1Circle = new Circle(1.0, new Point(0, 3), Color.RED); 
        myExtremePosCircle = new Circle(6.4, new Point(5, 1), Color.WHITE); 
    }
    
    //TESTING CONSTRUCTOR
    
    /**
     * Tests constructor for positive 1 (myPos1Circle).
     * Test method for {@link shapes.Circle#Circle(double, java.awt.Point, java.awt.Color)}.
     */
    @Test 
    public void testCircleDoublePointColor() {
        final Point expectedP = new Point(0, 3);
        final Color expectedC = Color.RED;
        assertEquals(expectedP, myPos1Circle.getCenter());
        assertEquals(expectedC, myPos1Circle.getColor());
        assertEquals(1.0, myPos1Circle.getRadius(), 0.0001);
    }

    /**
     * This tests for the positive value of the positive number. 
     * (myExtremePosCircle).
     */
    @Test
    public void testCircleDoublePointColor2() {
        final Point expectedP = new Point(5, 1);
        final Color expectedC = Color.WHITE;
        assertEquals(expectedP, myExtremePosCircle.getCenter());
        assertEquals(expectedC, myExtremePosCircle.getColor());
        assertEquals(6.4, myExtremePosCircle.getRadius(), 0.0001);
    }
    
    /**
     * This tests for the default circle. (myDefaultCircle).
     * Test method for {@link shapes.Circle#Circle()}.
     */
    @Test
    public void testCircle() {
        final double expectedR = 1.0;
        final Point expectedP = new Point(0, 0);
        final Color expectedC = Color.BLACK;
        assertEquals(expectedP, myDefaultCircle.getCenter());
        assertEquals(expectedC, myDefaultCircle.getColor());
        assertEquals(expectedR, myDefaultCircle.getRadius(), 0.0001);
        
    }
    
    /**
     * Test method for IAE in the radius (myZeroCircle).
     */
    @Test (expected = IllegalArgumentException.class)
    public void testCircleDoublePointColorIAE() {
        final Circle zeroCircle = new Circle(0.0, new Point(0, 0), Color.BLACK);

        final Point expectedP = new Point(0, 0);
        final Color expectedC = Color.BLACK;
                
        assertEquals(expectedP, zeroCircle.getCenter());
        assertEquals(expectedC, zeroCircle.getColor());
        assertEquals(0.0, zeroCircle.getRadius(), 0.0001);
    }

    /**
     * Tests for negative value in radius (myExtremeNegCircle).
     */
    @Test (expected = IllegalArgumentException.class)
    public void testCircleDoublePointColorIAE2() {
        final Circle extremeNegCircle = new Circle(-8.0, new Point(0, 0), Color.BLACK);

        final Point expectedP = new Point(0, 0);
        final Color expectedC = Color.BLACK;
                
        assertEquals(expectedP, extremeNegCircle.getCenter());
        assertEquals(expectedC, extremeNegCircle.getColor());
        assertEquals(-8.0, extremeNegCircle.getRadius(), 0.0001);
    } 
    
    /**
     * This tests for a null in the point (center using myNullPointCircle).
     */
    @Test (expected = NullPointerException.class)
    public void testCircleDoublePointColorNull() {
        final Circle nullPointCircle = new Circle(1.0, new Point(null), Color.BLUE);
        
        final Point expectedP = new Point(null);
        final Color expectedC = Color.BLACK;
                
        assertEquals(expectedP, nullPointCircle.getCenter());
        assertEquals(expectedC, nullPointCircle.getColor());
        assertEquals(1.0, nullPointCircle.getRadius(), 0.0001);
    }
    
    /**
     * This tests for a null in the color (myNullColorCircle).
     */
    @Test (expected = NullPointerException.class)
    public void testCircleDoublePointColorNull2() {
        final Circle nullColorCircle = new Circle(1.0, new Point(0, 0), null);
        
        final Point expectedP = new Point(0, 0);
        final Color expectedC = null;
        
        assertEquals(expectedP, nullColorCircle.getCenter());
        assertEquals(expectedC, nullColorCircle.getColor());
        assertEquals(1.0, nullColorCircle.getRadius(), 0.0001);
    }
    //TESTING FOR THE MUTATOR METHODS
    /**
     * Test method for {@link shapes.Circle#setRadius(double)}.
     * (myDefaultCircle)
     */
    @Test
    public void testSetRadius() {
        myDefaultCircle.setRadius(4.0);
        assertEquals(4.0, myDefaultCircle.getRadius(), 0.0001);
    }

    /**
     * Test method for an illegal argument exception in the default 
     * circle. 
     * (myDefaultCircle).
     */
    @Test (expected = IllegalArgumentException.class)
    public void testSetRadiusIAE() {
        myDefaultCircle.setRadius(-4.0);
    }
    
    
    /**
     * Tests for a center that is valid. 
     * Test method for {@link shapes.Circle#setCenter(java.awt.Point)}.
     */
    @Test
    public void testSetCenter() {
        final Point expectedP = new Point(6, 3);
        
        myDefaultCircle.setCenter(expectedP);
        
        assertEquals(expectedP, myDefaultCircle.getCenter());
    }

    /**
     * Test method for a center that is null.
     */
    @Test (expected = NullPointerException.class)
    public void testSetCenterNull() {
        final Point expectedP = new Point(null);
        
        myDefaultCircle.setCenter(expectedP);
    }
    
    /**
     * Tests for a valid color. 
     * Test method for {@link shapes.Circle#setColor(java.awt.Color)}.
     */
    @Test
    public void testSetColor() {
        final Color expectedC = Color.PINK;
        
        myDefaultCircle.setColor(expectedC);
        
        assertEquals(expectedC, myDefaultCircle.getColor());
    }
    
    /**
     * Test method for null color.
     */ 
    @Test (expected = NullPointerException.class)
    public void testSetColorNull() {
        final Color expectedC = null;
        
        myDefaultCircle.setColor(expectedC);
    }

    //TESTING ACCESSOR METHODS
    
    /**
     * Tests for a valid radius. 
     * Test method for {@link shapes.Circle#getRadius()}.
     */
    @Test
    public void testGetRadius() {
        assertEquals(1.0, myDefaultCircle.getRadius(), 0.0001);
    }
  
    /**
     * Test method for iAE in the radius. 
     */
    @Test (expected = IllegalArgumentException.class)
    public void testGetRadiusIAE() {
        new Circle(-6.5, new Point(0, 0), Color.BLACK);
    }
    
    /**
     * Tests for a valid center 
     * Test method for {@link shapes.Circle#getCenter()}.
     */
    @Test
    public void testGetCenter() {
        final Point expectedP = new Point(0, 0);
        assertEquals(expectedP, myDefaultCircle.getCenter());
    }
    
    /**
     * Test method for null center. 
     */
    @Test (expected = NullPointerException.class)
    public void testGetCenterNull() {
        new Circle(1.0, null, Color.BLACK);
    }

    /**
     * Tests for a valid color. 
     * Test method for {@link shapes.Circle#getColor()}.
     */
    @Test
    public void testGetColor() { 
        final Color expectedC = Color.BLACK;
        assertEquals(expectedC, myDefaultCircle.getColor());
    }
    
    /**
     * Test for null color. 
     */
    @Test (expected = NullPointerException.class)
    public void testGetColorNull() {
        new Circle(1.0, new Point(0, 0), null);
    }

    //TESTING CALCULATIONS (and toString)
    
    /**
     * Testing the diameter.
     * Test method for {@link shapes.Circle#calculateDiameter()}.
     * (myDefaultCircle).
     */
    @Test
    public void testCalculateDiameter() {
        assertEquals(2.0, myDefaultCircle.calculateDiameter(), 0.00001);
    }
    
    /**
     * Test method for positive number in diameter. (myExtremePosCircle).
     */
    @Test
    public void testCalculateDiameter2() {
        assertEquals(12.8, myExtremePosCircle.calculateDiameter(), 0.00001);
    }
    
    /**
     * Tests for okay circumference.
     * Test method for {@link shapes.Circle#calculateCircumference()}.
     * 
     */
    @Test
    public void testCalculateCircumference() {
        assertEquals(6.2831, myDefaultCircle.calculateCircumference(), 0.0001);
    }
    
    /**
     * Tests for positive number circumference. 
     */
    @Test
    public void testCalculateCircumference2() {
        assertEquals(40.2123, myExtremePosCircle.calculateCircumference(), 0.0001);
    }
    
    /**
     * Tests for valid area. 
     * Test method for {@link shapes.Circle#calculateArea()}.
     */
    @Test
    public void testCalculateArea() {
        assertEquals(Math.PI, myDefaultCircle.calculateArea(), 0.001);
    }

    /**
     * Test method for positive area other than 1. 
     */
    @Test
    public void testCalculateArea2() {
        assertEquals(128.6796, myExtremePosCircle.calculateArea(), 0.0001);
    }
    
    /**
     * Tests the toString method. 
     * Test method for {@link shapes.Circle#toString()}. For toString method
     */
    @Test
    public void testToString() {
        assertEquals("Circle [radius=(1.00), center=(" 
                      + myDefaultCircle.getCenter().toString()
                      + "), " + "color=(" + myDefaultCircle.getColor().toString() + ")]", 
                      myDefaultCircle.toString());
    }

}
