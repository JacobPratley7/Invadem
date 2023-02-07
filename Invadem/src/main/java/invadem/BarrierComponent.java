package invadem;

import processing.core.PApplet;
import processing.core.PImage;

import java.util.List;
import java.util.ArrayList;

//class in charge of creating the Barrier Components of the game
public class BarrierComponent extends Entity {

    private PApplet main;
    private PImage first;
    private PImage second;
    private PImage third;
    private List<PImage> images;
    private PImage currentImage;
    private float x;
    private float y;
    private int max_hits;
    private int current_hits;
    private boolean dead;
    private boolean alien;
    private boolean proj;
    private float width;
    private float height;

    //constructor is passed a PApplet object, three PImages, and the x and y coordiantes
    public BarrierComponent(PApplet main, PImage img, PImage second, PImage third, float x, float y) {
        super(main, img, x, y);
        this.main = main;
        this.first = img;
        this.second = second;
        this.third = third;
        this.images = new ArrayList<PImage>();
        this.images.add(this.first);
        this.images.add(this.second);
        this.images.add(this.third);

        this.currentImage = first;
        this.x = x;
        this.y = y;
        this.max_hits = 3;
        this.current_hits = 0;
        this.dead = false;
        this.alien = false;
        this.proj = false;

        this.width = 8;
        this.height = 8;
        

    }

    //returns the maximum hits of the BarrierComponent
    public int getMax() {
        return this.max_hits;
    }
    
    //returns the BarrierComponent's current hits
    public int getCurrent() {
        return this.current_hits;
    }

    //returns whether or not the BarrierComponent is dead
    public boolean isDead() {
        return this.dead;
    }

    //increments the BarrierComponent's current hits by the amount specified
    //if current hits is equal to or exceeds  max hits, the BarrierComponent is set to dead
    public void Hit(int n) {
        current_hits += n;
        if(current_hits >= max_hits) {
            this.dead = true;
        }
    }

    //updates the BarrierComponent's image
    public void update() {
        this.currentImage = this.images.get(this.current_hits);
    }

    //returns the BarrierComponent's current image
    public PImage getImage() {
        return this.currentImage;
    }

    //returns the list containing all the BarrierComponent's images
    public List<PImage> getAll() {
        return this.images;
    }

    //displays the BarrierComponent to output
    public void display() {
        main.image(this.images.get(this.current_hits), this.x, this.y);
    }

    //returns the BarrierComponent's x coordinate
    public float getX() {
        return this.x;
    }

    //returns the BarrierComponent's y coordinate
    public float getY() {
        return this.y;
    }

    //returns whether or not the Entity is an Invader
    public boolean isAlien() {
        return this.alien;
    }
    
    //returns whether or not the Entity is a Projectile
    public boolean isProjectile() {
        return this.proj;
    }

    //returns the BarrierComponent's width
    public float getWidth() {
        return this.width;
    }

    //returns the BarrierComponent's height
    public float getHeight() {
        return this.height;
    }



}