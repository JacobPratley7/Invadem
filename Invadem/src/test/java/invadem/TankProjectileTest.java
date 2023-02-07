package invadem;

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Before;

import invadem.App;
import invadem.Entity;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PGraphics;

public class TankProjectileTest {

    PApplet p = new PApplet();

    //tests TankProjectile construction
    @Test
    public void testTankProjectileConstruction() {
        PImage img = new PImage(4,4);
        TankProjectile tp = new TankProjectile(p, img, 300f, 460f);
        assertNotNull(tp);
    }

    //tests TankProjectile getX() method
    @Test
    public void testTankProjectileGetX() {
        PImage img = new PImage(4,4);
        TankProjectile tp = new TankProjectile(p, img, 300f, 460f);
        assertEquals(tp.getX(), 300f, 0.01);
    }

    //tests TankProjectile getY() method
    @Test
    public void testTankProjectileGetY() {
        PImage img = new PImage(4,4);
        TankProjectile tp = new TankProjectile(p, img, 300f, 460f);
        assertEquals(tp.getY(), 460f, 0.01);
    }

    //tests TankProjectile Hit() method
    @Test
    public void testTankProjectileHit() {
        PImage img = new PImage(4,4);
        TankProjectile tp = new TankProjectile(p, img, 300f, 460f);
        tp.Hit();
        assertTrue(tp.getStatus());
    }

    //tests TankProjectile getStatus() method
    @Test
    public void testTankProjectileGetStatus() {
        PImage img = new PImage(4,4);
        TankProjectile tp = new TankProjectile(p, img, 300f, 460f);
        assertFalse(tp.getStatus());
    }

    //tests TankProjectile isProjectile() method
    @Test
    public void testTankProjectileIsProjectile() {
        PImage img = new PImage(4,4);
        TankProjectile tp = new TankProjectile(p, img, 300f, 460f);
        assertTrue(tp.isProjectile());
    }

    //tests TankProjectile isAlien() method
    @Test
    public void testTankProjectileIsAlien() {
        PImage img = new PImage(4,4);
        TankProjectile tp = new TankProjectile(p, img, 300f, 460f);
        assertFalse(tp.isAlien());
    }

    //tests TankProjectile getImage() method
    @Test
    public void testTankProjectileGetImage() {
        PImage img = new PImage(4,4);
        TankProjectile tp = new TankProjectile(p, img, 300f, 460f);
        assertNotNull(tp.getImage());
    }

    //tests Tankprojectile getWidth() method
    @Test
    public void testTankProjectileGetWidth() {
        PImage img = new PImage(4,4);
        TankProjectile tp = new TankProjectile(p, img, 300f, 460f);
        assertEquals(tp.getWidth(), 1, 0.01);
    }

    //tests TankProjectile getHeight() method
    @Test
    public void testTankProjectileGetHeight() {
        PImage img = new PImage(4,4);
        TankProjectile tp = new TankProjectile(p, img, 300f, 460f);
        assertEquals(tp.getHeight(), 3, 0.01);
    }

}