package invadem;

import invadem.Entity;
import processing.core.PApplet;
import processing.core.PImage;

//class responsible for creation of Invaders
public class Invader extends Entity {

    private PApplet main;
    private PImage img;
    private PImage img2;
    private PImage current_image;
    private float x;
    private float y;
    private int max_hits;
    private int current_hits;
    private boolean dead;
    private float min;
    private float max;
    private boolean alien;
    private float width;
    private float height;
    private boolean power;
    private int points;

    //constructor is passed a PApplet object, two PImages, the x and y coordinates
    //in addition, it is also passed the lives, points and wether or not the Invader is a powered Invader
    public Invader(PApplet main, PImage img, PImage img2, float x, float y, int lives, boolean power, int points) {
        super(main, img, x, y);
        this.main = main;
        this.img = img;
        this.img2 = img2;
        this.x = x;
        this.y = y;
        this.max_hits = lives;
        this.current_hits = 0;
        this.dead = false;
        this.max = x + 30;
        this.min = x - 30;
        this.alien = true; //this is set to true as the Entity is an Invader
        this.proj = false;
        this.width = 16;
        this.height = 16;
        this.current_image = img;
        this.power = power;
        this.points = points;
    }


    //returns the Invaders max hits
    public int getMax() {
        return this.max_hits;
    }

    //returns the Invader's current hits
    public int getCurrent() {
        return this.current_hits;
    }

    //increments the Invader's current hits by one
    //if current hits equals or exceeds max hits, the Invader is set to dead
    public void Hit() {
        this.current_hits += 1;
        if(current_hits == max_hits) {
            this.dead = true;
        }
        
    }


    //returns whether or not the Invader is dead
    public boolean isDead() {
        return this.dead;
    }


    //returns the Invaders first image
    public PImage getImage() {
        return this.img;
    }

    //returns the Invaders second image
    public PImage getImage2() {
        return this.img2;
    }

    //returns the Invaders x coordinate
    public float getX() {
        return this.x;
    }

    //returns the Invader's y coordinate
    public float getY() {
        return this.y;
    }

    //moves the Invader left by half a pixel
    public void moveLeft() {
        this.x -= 0.5;
    }

    //moves the invader right by half a pixel
    public void moveRight() {
        this.x += 0.5;
    }

    //displays the Invader to output
    public void display() {
        main.image(this.current_image, this.x, this.y);
    }


    //moves the invader down by 8 pixels
    public void moveDown() {
        this.y += 8;
    }

    //move Invader either left or right depending on the value given
    public void move(float i) {
        this.x += i;
    }

    //returns the Invaders maximum x value
    public float getMaxPos() {
        return this.max;
    }

    //returns the invaders minimum x value
    public float getMinPos() {
        return this.min;
    }

    //returns whether or not the Entity is an Invader
    public boolean isAlien() {
        return this.alien;
    }

    //returns whether or not the Entity in a Projectile
    public boolean isProjectile() {
        return this.proj;
    }

    //returns the Invaders width
    public float getWidth() {
        return this.width;
    }

    //returns the invaders height
    public float getHeight() {
        return this.height;
    }

    //changes the Invaders current image to the image specified
    public void setImage(PImage n) {
        this.current_image = n;
    
    }

    //returns whether or not the Invader is a Powered Invader
    public boolean getPower() {
        return this.power;
    }

    //returns the Invaders points
    public int getPoints() {
        return this.points;
    }


}