package invadem;

import processing.core.PApplet;
import processing.core.PImage;


//these projectiles will be the projectiles fired by the invaders
public class InvaderProjectile extends Entity implements Projectile {

    private PApplet main;
    private PImage img;
    private float x;
    private float y;
    private boolean has_collided;
    private boolean alien;
    private boolean proj;
    private float width;
    private float height;
    private int damage;
    
    //the constructor is passed a PApplet object, a PImage, the x and y coordinates as well as the damage of the projectile
    public InvaderProjectile(PApplet main, PImage img, float x, float y, int damage) {
        super(main, img, x, y);
        this.main = main;
        this.img = img;
        this.x = x;
        this.y = y;
        this.has_collided = false;
        this.alien = false;
        this.proj = true; //this is set to true as the Entity is a Projectile
        this.width = 1;
        this.height = 3;
        this.damage = damage;
    }

    //returns the projectiles's image
    public PImage getImage() {
        return this.img;
    }

    //returns the projectile's x coordinate
    public float getX() {
        return this.x;
    }

    //returns the projectile's y coordinate
    public float getY() {
        return this.y;
    }

    //displays the projectile to output and increments the y value so it moves downwards
    public void display() {
        this.main.image(this.img, this.x, this.y);
        y += 1;
    }

    //sets has_collided to true
    public void collide() {
        this.has_collided = true;
    }

    //returns whether or not the projectile has collided with another Entity
    public boolean getCollided() {
        return this.has_collided;
    }

    //returns whether or not the Entity is an Invader
    public boolean isAlien() {
        return this.alien;
    }

    //returns whether or not the Entity is a projectile
    public boolean isProjectile() {
        return this.proj;
    }

    //returns the projectile's width
    public float getWidth() {
        return this.width;
    }

    //returns the projectile's height
    public float getHeight() {
        return this.height;
    }

    //returns the projectile's damage
    public int getDamage() {
        return this.damage;
    }
}