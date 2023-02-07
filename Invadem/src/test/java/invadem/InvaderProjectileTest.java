package invadem;

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Before;

import invadem.App;
import invadem.Entity;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PGraphics;

public class InvaderProjectileTest {

    PApplet p = new PApplet();

    //test InvaderProjectile construction
    @Test
    public void testInvaderProjectileConstruction() {
        PImage img = new PImage(4,4);
        InvaderProjectile ip = new InvaderProjectile(p, img, 300f, 40f, 1);
        assertNotNull(ip);
    }

    //tests InvaderProjectile getX() method
    @Test
    public void testInvaderProjectileGetX() {
        PImage img = new PImage(4,4);
        InvaderProjectile ip = new InvaderProjectile(p, img, 300f, 40f, 1);
        assertEquals(ip.getX(), 300f, 0.01);
    }

    //test InvaderProjectile getY() method
    @Test
    public void testInvaderProjectileGetY() {
        PImage img = new PImage(4,4);
        InvaderProjectile ip = new InvaderProjectile(p, img, 300f, 40f, 1);
        assertEquals(ip.getY(), 40f, 0.01);
    }

    // tests InvaderProjectile collide() method
    @Test
    public void testInvaderProjectileCollide() {
        PImage img = new PImage(4,4);
        InvaderProjectile ip = new InvaderProjectile(p, img, 300f, 40f, 1);
        ip.collide();
        assertTrue(ip.getCollided());
    }

    //tests InvaderProjectile getCollided() method
    @Test
    public void testInvaderProjectileGetCollided() {
        PImage img = new PImage(4,4);
        InvaderProjectile ip = new InvaderProjectile(p, img, 300f, 40f, 1);
        assertFalse(ip.getCollided());
    }

    //tests InvaderProjectile isProjectile() method
    @Test
    public void testInvaderProjectileIsProjectile() {
        PImage img = new PImage(4,4);
        InvaderProjectile ip = new InvaderProjectile(p, img, 300f, 40f, 1);
        assertTrue(ip.isProjectile());
    }

    //tests InvaderProjectile isAlien() method
    @Test
    public void testInvaderProjectileIsAlien() {
        PImage img = new PImage(4,4);
        InvaderProjectile ip = new InvaderProjectile(p, img, 300f, 40f, 1);
        assertFalse(ip.isAlien());
    }

    //tests InvaderProjectile getImage() method
    @Test
    public void testInvaderProjectileGetImage() {
        PImage img = new PImage(4,4);
        InvaderProjectile ip = new InvaderProjectile(p, img, 300f, 40f, 1);
        assertNotNull(ip.getImage());
    }

    //tests InvaderProjectile getWidth() method
    @Test
    public void testInvaderProjectileGetWidth() {
        PImage img = new PImage(4,4);
        InvaderProjectile ip = new InvaderProjectile(p, img, 300f, 40f, 1);
        assertEquals(ip.getWidth(), 1, 0.01);
    }

    //tests InvaderProjectile getHeight() method
    @Test
    public void testInvaderProjectileGetHeight() {
        PImage img = new PImage(4,4);
        InvaderProjectile ip = new InvaderProjectile(p, img, 300f, 40f, 1);
        assertEquals(ip.getHeight(), 3, 0.01);
    }

    //tests InvaderProjectile getDamage() method
    @Test
    public void testInvaderProjectileGetDamage() {
        PImage img = new PImage(4,4);
        InvaderProjectile ip = new InvaderProjectile(p, img, 300f, 40f, 1);
        assertEquals(ip.getDamage(), 1);
    }

}