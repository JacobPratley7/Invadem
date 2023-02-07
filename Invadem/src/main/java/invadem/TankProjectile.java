package invadem;

import processing.core.PApplet;
import processing.core.PImage;

public class TankProjectile extends Entity {

    private PApplet main;
    private PImage img;
    private float x;
    private float y;
    private boolean has_collided;
    private boolean alien;
    private boolean proj;
    private float width;
    private float height;

    //constructor is passed a PApplet object, a PImage object, as well as it's x and y coordinates
    public TankProjectile(PApplet main, PImage img, float x, float y) {
        super(main, img, x, y);
        this.main = main;
        this.img = img;
        this.x = x;
        this.y = y;
        this.has_collided = false; //this is initially set to false
        this.alien = false;
        this.proj = true;
        this.width = 1;
        this.height = 3;
    }

    //returns x coordinate
    public float getX() {
        return this.x;
    }

    //returns y coordinate
    public float getY() {
        return this.y;
    }

    //as a Projectile can only collide with something one, we set has_collided to true
    public void Hit() {
        this.has_collided = true;
    }

    //displays the Projectile on the screen and decrements the y coordiante so that the projectile travles upwards
    public void display() {
        this.main.image(this.img, this.x, this.y);
        this.y -= 1;
    }


    //returns the whether or not the projectile has collided
    public boolean getStatus() {
        return this.has_collided;
    }

    //returns whether or not the Entity is a projectile
    public boolean isProjectile() {
        return this.proj;
    }

    //returns the projectile's image
    public PImage getImage() {
        return this.img;
    }

    //returns whether or not the Entity is an Invader
    public boolean isAlien() {
        return this.alien;
    }

    //returns the projectile's width
    public float getWidth() {
        return this.width;
    }

    //returns the projectile's height
    public float getHeight() {
        return this.height;
    }
}