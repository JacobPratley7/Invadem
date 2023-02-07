package invadem;

import invadem.App;
import invadem.Entity;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PGraphics;



public class Tank extends Entity {


    private PImage img;
    private float x;
    private float y;
    private int max_hits;
    private int current_hits;
    private boolean dead;
    private boolean alien;
    private boolean proj;
    private float width;
    private float height;

    //the constructor is passed a PApplet object, a PImage as well as the x and y coordinates of the tank
    public Tank(PApplet main, PImage img, float x, float y) {
        super(main, img, x, y);
        this.main = main;
        this.img = img;
        this.x = x;
        this.y = y;
        this.max_hits = 3;
        this.current_hits = 0;
        this.dead = false;
        this.alien = false;
        this.proj = false;
        this.width = 22;
        this.height = 16;
    }

    //returns the tank's current hits
    public int getCurrent() {
        return this.current_hits;
    }

    //returns the tank's maximum hits
    public int getMax() {
        return this.max_hits;
    }

    //returns whether or not the tank is dead
    public boolean isDead() {
        return this.dead;
    }

    //immidiately kills the tank
    public void kill() {
        this.dead = true;
    }


    //increments the tank's current hits by the amount specified
    //if current hits exceeds maximum hits, the the tank is set to dead
    public void Hit(int n) {
        this.current_hits += n;
        if(current_hits >= max_hits) {
            this.dead = true;
        }
    }

    //returns the tank's image
    public PImage getImage() {
        return this.img;
    }

    //returns the tank's x coordinate
    public float getX() {
        return this.x;
    }

    //returns the tank's y coordinate
    public float getY() {
        return this.y;
    }

    //moves the tank to the left by one pixel
    public void moveLeft() {
        this.x -= 1;
    }

    //moves the tank to the right by one pixel
    public void moveRight() {
        this.x += 1;
    }

    //displays the tank to the game screen
    public void display() {
        main.image(this.img, this.x, this.y);
    }


    //returns whether or not the Entity is an Invader
    public boolean isAlien() {
        return this.alien;
    }

    //returns whether or not the Entity is a projectile
    public boolean isProjectile() {
        return this.proj;
    }

    //returns the tank's width
    public float getWidth() {
        return this.width;
    }

    //returns the tank's height
    public float getHeight() {
        return this.height;
    }

}