package invadem;

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Before;

import invadem.App;
import invadem.Entity;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PGraphics;

public class TankTest {

    //@Before

    PApplet p = new PApplet();
    //new_app.setup();
   
    //tests Tank construction
    @Test
    public void testTankConstruction() {
        //p.setup();
        PImage img = new PImage(4,4);
        Tank tank = new Tank(p, img, 300f, 460f);
        assertNotNull(tank);
   }

   //tests Tank getCurrent() method
   @Test
   public void testTankGetCurrent() {
       PImage img = new PImage(4, 4);
       Tank tank = new Tank(p, img, 300f, 460f);
       assertEquals(tank.getCurrent(), 0);
   }

   //tests Tank getMax() method
   @Test
   public void testTankGetMax() {
        PImage img = new PImage(4, 4);
        Tank tank = new Tank(p, img, 300f, 460f);
        assertEquals(tank.getMax(), 3);
   }

   //tests Tank isDead() method
   @Test
   public void testTankIsDead() {
        PImage img = new PImage(4, 4);
        Tank tank = new Tank(p, img, 300f, 460f);
        assertFalse(tank.isDead());
   }

   //tests Tank kill() method
   @Test
   public void testTankKill() {
        PImage img = new PImage(4, 4);
        Tank tank = new Tank(p, img, 300f, 460f);
        tank.kill();
        assertTrue(tank.isDead());
   }

   //tests Tank getX() method
   @Test
   public void testTankGetX() {
        PImage img = new PImage(4, 4);
        Tank tank = new Tank(p, img, 300f, 460f);
        assertEquals(tank.getX(), 300f, 0.01);
   }

   //tests Tank getY() method
   @Test
   public void testTankGetY() {
        PImage img = new PImage(4, 4);
        Tank tank = new Tank(p, img, 300f, 460f);
        assertEquals(tank.getY(), 460f, 0.01);
   }

   //tests Tank moveLeft() method
   @Test
   public void testTankMoveLeft() {
        PImage img = new PImage(4, 4);
        Tank tank = new Tank(p, img, 300f, 460f);
        tank.moveLeft();
        assertEquals(tank.getX(), 299f, 0.01);
   }

   //tests Tank moveRight() method
   @Test
   public void testTankMoveRight() {
        PImage img = new PImage(4, 4);
        Tank tank = new Tank(p, img, 300f, 460f);
        tank.moveRight();
        assertEquals(tank.getX(), 301f, 0.01);
   }

   //tests Tank isAlien() method
   @Test
   public void testTankIsAlien() {
        PImage img = new PImage(4, 4);
        Tank tank = new Tank(p, img, 300f, 460f);
        assertFalse(tank.isAlien());
   }

   //tests Tank isProjectile() method
   @Test
   public void testTankIsProjectile() {
        PImage img = new PImage(4, 4);
        Tank tank = new Tank(p, img, 300f, 460f);
        assertFalse(tank.isProjectile());
   }

   //tests Tank getHeight() method
   @Test
   public void testTankGetHeight() {
        PImage img = new PImage(4, 4);
        Tank tank = new Tank(p, img, 300f, 460f);
        assertEquals(tank.getHeight(), 16, 0.01);
   }

   //tests Tank getWidth() method
   @Test
   public void testTankGetWidth() {
        PImage img = new PImage(4, 4);
        Tank tank = new Tank(p, img, 300f, 460f);
        assertEquals(tank.getWidth(), 22, 0.01);
   }

   //tests Tank Hit() method
   @Test
   public void testTankHit() {
          PImage img = new PImage(4, 4);
          Tank tank = new Tank(p, img, 300f, 460f);
          tank.Hit(1);
          assertEquals(tank.getCurrent(), 1);
   }

   //tests Tank getImage() method
   @Test
   public void testTankGetImage() {
          PImage img = new PImage(4, 4);
          Tank tank = new Tank(p, img, 300f, 460f);
          assertNotNull(tank.getImage());
   }

   //tests Tank Hit() method to ensure dead is updated
   @Test
   public void testTankHit2() {
          PImage img = new PImage(4, 4);
          Tank tank = new Tank(p, img, 300f, 460f);
          tank.Hit(3);
          assertTrue(tank.isDead());
   }



}
