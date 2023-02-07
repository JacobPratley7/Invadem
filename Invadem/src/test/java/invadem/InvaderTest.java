package invadem;

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Before;

import invadem.App;
import invadem.Entity;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PGraphics;


public class InvaderTest {

    PApplet p = new PApplet();

    //tests Invader construction
    @Test
    public void testInvaderConstruction() {
        PImage first = new PImage(4, 4);
        PImage second = new PImage(4, 4);
        Invader inv = new Invader(p, first, second, 260f, 60f, 1, false, 100);
        assertNotNull(inv);
    }

    //tests Invader getMax() method
    @Test
    public void testInvaderGetMax() {
        PImage first = new PImage(4, 4);
        PImage second = new PImage(4, 4);
        Invader inv = new Invader(p, first, second, 260f, 60f, 1, false, 100);
        assertEquals(inv.getMax(), 1);
    }

    //tests Invader getCurrent() method
    @Test
    public void testInvaderGetCurrent() {
        PImage first = new PImage(4, 4);
        PImage second = new PImage(4, 4);
        Invader inv = new Invader(p, first, second, 260f, 60f, 1, false, 100);
        assertEquals(inv.getCurrent(), 0);
    }

    //tests Invader Hit() method test ensure current hits is updated
    @Test
    public void testInvaderHit() {
        PImage first = new PImage(4, 4);
        PImage second = new PImage(4, 4);
        Invader inv = new Invader(p, first, second, 260f, 60f, 1, false, 100);
        inv.Hit();
        assertEquals(inv.getCurrent(), 1);
    }

    //tests Invader Hit() to ensure dead is updated
    @Test
    public void testInvaderHit2() {
        PImage first = new PImage(4, 4);
        PImage second = new PImage(4, 4);
        Invader inv = new Invader(p, first, second, 260f, 60f, 1, false, 100);
        inv.Hit();
        assertTrue(inv.isDead());
    }

    //tests Invader isDead() method
    @Test
    public void testInvaderIsDead() {
        PImage first = new PImage(4, 4);
        PImage second = new PImage(4, 4);
        Invader inv = new Invader(p, first, second, 260f, 60f, 1, false, 100);
        assertFalse(inv.isDead());
    }

    //tests Invader getImage() method
    @Test
    public void testInvaderGetImage() {
        PImage first = new PImage(4, 4);
        PImage second = new PImage(4, 4);
        Invader inv = new Invader(p, first, second, 260f, 60f, 1, false, 100);
        assertEquals(inv.getImage(), first);
    }

    //tests Invader getImage2() method
    @Test
    public void testInvaderGetImage2() {
        PImage first = new PImage(4, 4);
        PImage second = new PImage(4, 4);
        Invader inv = new Invader(p, first, second, 260f, 60f, 1, false, 100);
        assertEquals(inv.getImage2(), second);
    }

    //tests Invader getX() method
    @Test
    public void testInvaderGetX() {
        PImage first = new PImage(4, 4);
        PImage second = new PImage(4, 4);
        Invader inv = new Invader(p, first, second, 260f, 60f, 1, false, 100);
        assertEquals(inv.getX(), 260f, 0.01);
    }

    //tests Invader getY() method
    @Test
    public void testInvaderGetY() {
        PImage first = new PImage(4, 4);
        PImage second = new PImage(4, 4);
        Invader inv = new Invader(p, first, second, 260f, 60f, 1, false, 100);
        assertEquals(inv.getY(), 60f, 0.01);
    }

    //tests Invader moveLeft() method
    @Test
    public void testInvaderMoveLeft() {
        PImage first = new PImage(4, 4);
        PImage second = new PImage(4, 4);
        Invader inv = new Invader(p, first, second, 260f, 60f, 1, false, 100);
        inv.moveLeft();
        assertEquals(inv.getX(), 259.5f, 0.01);
    }

    //tests Invader moveRight() method
    @Test
    public void testInvaderMoveRight() {
        PImage first = new PImage(4, 4);
        PImage second = new PImage(4, 4);
        Invader inv = new Invader(p, first, second, 260f, 60f, 1, false, 100);
        inv.moveRight();
        assertEquals(inv.getX(), 260.5f, 0.01);
    }

    //tests Invader moveDown() method
    @Test
    public void testInvaderMoveDown() {
        PImage first = new PImage(4, 4);
        PImage second = new PImage(4, 4);
        Invader inv = new Invader(p, first, second, 260f, 60f, 1, false, 100);
        inv.moveDown();
        assertEquals(inv.getY(), 68f, 0.01);
    }

    //tests Invader move() method
    @Test
    public void testInvaderMove() {
        PImage first = new PImage(4, 4);
        PImage second = new PImage(4, 4);
        Invader inv = new Invader(p, first, second, 260f, 60f, 1, false, 100);
        inv.move(5);
        assertEquals(inv.getX(), 265f, 0.01);
    }

    //tests Invader getMaxPos() method
    @Test
    public void testInvaderGetMaxPos() {
        PImage first = new PImage(4, 4);
        PImage second = new PImage(4, 4);
        Invader inv = new Invader(p, first, second, 260f, 60f, 1, false, 100);
        assertEquals(inv.getMaxPos(), 290f, 0.01);
    }

    //tests Invader getMinPos() method
    @Test
    public void testInvaderGetMinPos() {
        PImage first = new PImage(4, 4);
        PImage second = new PImage(4, 4);
        Invader inv = new Invader(p, first, second, 260f, 60f, 1, false, 100);
        assertEquals(inv.getMinPos(), 230f, 0.01);
    }

    //tests Invader isAlien() method
    @Test
    public void testInvaderIsAlien() {
        PImage first = new PImage(4, 4);
        PImage second = new PImage(4, 4);
        Invader inv = new Invader(p, first, second, 260f, 60f, 1, false, 100);
        assertTrue(inv.isAlien());
    }

    //tests Invader isProjectile() method
    @Test
    public void testInvaderIsProjectile() {
        PImage first = new PImage(4, 4);
        PImage second = new PImage(4, 4);
        Invader inv = new Invader(p, first, second, 260f, 60f, 1, false, 100);
        assertFalse(inv.isProjectile());
    }

    //tests Invader getWidth() method
    @Test
    public void testInvaderGetWidth() {
        PImage first = new PImage(4, 4);
        PImage second = new PImage(4, 4);
        Invader inv = new Invader(p, first, second, 260f, 60f, 1, false, 100);
        assertEquals(inv.getWidth(), 16, 0.01);
    }

    //tests Invader getHeight() method
    @Test
    public void testInvaderGetHeight() {
        PImage first = new PImage(4, 4);
        PImage second = new PImage(4, 4);
        Invader inv = new Invader(p, first, second, 260f, 60f, 1, false, 100);
        assertEquals(inv.getHeight(), 16, 0.01);
    }

    //tests invader getPower() method
    @Test
    public void testInvaderGetPower() {
        PImage first = new PImage(4, 4);
        PImage second = new PImage(4, 4);
        Invader inv = new Invader(p, first, second, 260f, 60f, 1, false, 100);
        assertFalse(inv.getPower());
    }

    //tests Invader getPoints() method
    @Test
    public void testInvaderGetPoints() {
        PImage first = new PImage(4, 4);
        PImage second = new PImage(4, 4);
        Invader inv = new Invader(p, first, second, 260f, 60f, 1, false, 100);
        assertEquals(inv.getPoints(), 100);
    }


}
