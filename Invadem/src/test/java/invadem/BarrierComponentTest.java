package invadem;

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Before;

import invadem.App;
import invadem.Entity;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PGraphics;


public class BarrierComponentTest {

    PApplet p = new PApplet();

    //tests BarrierComponent Construction
    @Test
    public void testBarrierComponentConstruction() {
        PImage first = new PImage(4, 4);
        PImage second = new PImage(4, 4);
        PImage third = new PImage(4, 4);
        BarrierComponent bc = new BarrierComponent(p, first, second, third, 300f, 440f);
        assertNotNull(bc);
    }


    //tests BarrierComponent getMax() method
    @Test
    public void testBarrierComponentGetMax() {
        PImage first = new PImage(4, 4);
        PImage second = new PImage(4, 4);
        PImage third = new PImage(4, 4);
        BarrierComponent bc = new BarrierComponent(p, first, second, third, 300f, 440f);
        assertEquals(bc.getMax(), 3);
    }

    //tests BarrierComponent getCurrent() method
    @Test
    public void testBarrierComponentgetCurrent() {
        PImage first = new PImage(4, 4);
        PImage second = new PImage(4, 4);
        PImage third = new PImage(4, 4);
        BarrierComponent bc = new BarrierComponent(p, first, second, third, 300f, 440f);
        assertEquals(bc.getCurrent(), 0);
    }

    //tests BarrierComponent isDead() method
    @Test
    public void testBarrierComponentIsDead() {
        PImage first = new PImage(4, 4);
        PImage second = new PImage(4, 4);
        PImage third = new PImage(4, 4);
        BarrierComponent bc = new BarrierComponent(p, first, second, third, 300f, 440f);
        assertFalse(bc.isDead());
    }

    //tests BarrierComponent Hit() method to see if current hits is updated
    @Test
    public void testBarrierComponentHit() {
        PImage first = new PImage(4, 4);
        PImage second = new PImage(4, 4);
        PImage third = new PImage(4, 4);
        BarrierComponent bc = new BarrierComponent(p, first, second, third, 300f, 440f);
        bc.Hit(1);
        assertEquals(bc.getCurrent(), 1);
    }

    //tests BarrierComponent Hit() method to see if dead is updated
    @Test
    public void testBarrierComponentHit2() {
        PImage first = new PImage(4, 4);
        PImage second = new PImage(4, 4);
        PImage third = new PImage(4, 4);
        BarrierComponent bc = new BarrierComponent(p, first, second, third, 300f, 440f);
        bc.Hit(3);
        assertTrue(bc.isDead());
    }

    //test BarrierComponent Update() method
    @Test
    public void testBarrierComponentUpdate() {
        PImage first = new PImage(4, 4);
        PImage second = new PImage(4, 4);
        PImage third = new PImage(4, 4);
        BarrierComponent bc = new BarrierComponent(p, first, second, third, 300f, 440f);
        bc.Hit(1);
        assertEquals(bc.getImage(), first);
    }

    //test BarrierComponent getImage() method
    @Test
    public void testBarrierComponentGetImage() {
        PImage first = new PImage(4, 4);
        PImage second = new PImage(4, 4);
        PImage third = new PImage(4, 4);
        BarrierComponent bc = new BarrierComponent(p, first, second, third, 300f, 440f);
        assertEquals(bc.getImage(), first);
    }

    //test BarrierComponent getAll() method
    @Test
    public void testBarrierComponentGetAll() {
        PImage first = new PImage(4, 4);
        PImage second = new PImage(4, 4);
        PImage third = new PImage(4, 4);
        BarrierComponent bc = new BarrierComponent(p, first, second, third, 300f, 440f);
        assertNotNull(bc.getAll());
    }

    //test BarrierComponent getX() method
    @Test
    public void testBarrierComponentGetX() {
        PImage first = new PImage(4, 4);
        PImage second = new PImage(4, 4);
        PImage third = new PImage(4, 4);
        BarrierComponent bc = new BarrierComponent(p, first, second, third, 300f, 440f);
        assertEquals(bc.getX(), 300f, 0.01);
    }

    //test Barrier Component getY() method
    @Test
    public void testBarrierComponentGetY() {
        PImage first = new PImage(4, 4);
        PImage second = new PImage(4, 4);
        PImage third = new PImage(4, 4);
        BarrierComponent bc = new BarrierComponent(p, first, second, third, 300f, 440f);
        assertEquals(bc.getY(), 440f, 0.01);
    }

    //tests BarrierComponent isProjectile() method
    @Test
    public void testBarrierComponentIsProjectile() {
        PImage first = new PImage(4, 4);
        PImage second = new PImage(4, 4);
        PImage third = new PImage(4, 4);
        BarrierComponent bc = new BarrierComponent(p, first, second, third, 300f, 440f);
        assertFalse(bc.isProjectile());
    }

    //tests BarrierComponent isAlien() method
    @Test
    public void testBarrierComponentIsAlien() {
        PImage first = new PImage(4, 4);
        PImage second = new PImage(4, 4);
        PImage third = new PImage(4, 4);
        BarrierComponent bc = new BarrierComponent(p, first, second, third, 300f, 440f);
        assertFalse(bc.isAlien());
    }

    //tests BarrierComponent getWidth() method
    @Test
    public void testBarrierComponentGetWidth() {
        PImage first = new PImage(4, 4);
        PImage second = new PImage(4, 4);
        PImage third = new PImage(4, 4);
        BarrierComponent bc = new BarrierComponent(p, first, second, third, 300f, 440f);
        assertEquals(bc.getWidth(), 8f, 0.01);
    }

    //test BarrierComponent getHeight() method
    @Test
    public void testBarrierComponentGetHeight() {
        PImage first = new PImage(4, 4);
        PImage second = new PImage(4, 4);
        PImage third = new PImage(4, 4);
        BarrierComponent bc = new BarrierComponent(p, first, second, third, 300f, 440f);
        assertEquals(bc.getHeight(), 8f, 0.01);
    }

}   