package invadem;

import processing.core.PApplet;
import processing.core.PImage;

//base class of the program, in which Tank, TankProjectile, BarrierComponent, Invader and InvaderProjectile extend
//it is made as an abstract class, and all methods are abstract methods to ensure each class implements the methods on their own
//also ensures that all necessary attributes are passed into each classes constructor
public abstract class Entity {

    protected PApplet main;
    protected PImage img;
    protected float x;
    protected float y;
    protected boolean alien;
    protected boolean proj;
    protected float width;
    protected float height;

    public Entity(PApplet main, PImage img, float x, float y) {
        this.main = main;
        this.img = img;
        this.x = x;
        this.y = y;
    }

    public abstract PImage getImage();

    public abstract float getX();

    public abstract float getY();

    public abstract boolean isAlien();


    public abstract boolean isProjectile(); 

    public abstract float getWidth();

    public abstract float getHeight();

}