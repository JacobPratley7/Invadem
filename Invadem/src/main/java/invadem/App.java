package invadem;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PFont;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class App extends PApplet {

    //here we introduce objects lists that will be used later by the program
    Tank player;
    List<Invader> invaders;
    List<BarrierComponent> Barrier1;
    List<BarrierComponent> Barrier2;
    List<BarrierComponent> Barrier3;
    List<InvaderProjectile> invader_projectiles;
    List<TankProjectile> tank_projectiles;
    PImage projectile_image;
    boolean tank_fired;

    private boolean LEFT;
    private boolean RIGHT;
    private boolean SHOOT;


    public App() {
        
    }

    public void setup() {
        frameRate(60);
        //below we load all the images from the resources folder and assign them to variables
        PImage BARRIER_LEFT1 = loadImage("barrier_left1.png");
        PImage BARRIER_LEFT2 = loadImage("barrier_left2.png");
        PImage BARRIER_LEFT3 = loadImage("barrier_left3.png");
        PImage BARRIER_RIGHT1 = loadImage("barrier_right1.png");
        PImage BARRIER_RIGHT2 = loadImage("barrier_right2.png");
        PImage BARRIER_RIGHT3 = loadImage("barrier_right3.png");
        PImage BARRIER_SOLID1 = loadImage("barrier_solid1.png");
        PImage BARRIER_SOLID2 = loadImage("barrier_solid2.png");
        PImage BARRIER_SOLID3 = loadImage("barrier_solid3.png");
        PImage BARRIER_TOP1 = loadImage("barrier_top1.png");
        PImage BARRIER_TOP2 = loadImage("barrier_top2.png");
        PImage BARRIER_TOP3 = loadImage("barrier_top3.png");
        PImage EMPTY = loadImage("empty.png");
        PImage GAMEOVER = loadImage("gameover.png");
        PImage INVADER1 = loadImage("invader1.png");
        PImage INVADER2 = loadImage("invader2.png");
        PImage ARMOURED1 = loadImage("invader1_armoured.png");
        PImage ARMOURED2 = loadImage("invader2_armoured.png");
        PImage POWER1 = loadImage("invader1_power.png");
        PImage POWER2 = loadImage("invader2_power.png");
        PImage NEXTLEVEL = loadImage("nextlevel.png");
        PImage PROJECTILE = loadImage("projectile.png");
        PImage BOMB = loadImage("projectile_lg.png");
        PImage TANK = loadImage("tank1.png");
        PFont MAINTEXT = createFont("PressStart2P-Regular.ttf", 12);

        //here we create the textFont that will be used to display the players current score and hishscore
        textFont(MAINTEXT);

        projectile_image = PROJECTILE;

        tank_projectiles = new ArrayList<TankProjectile>(); //initialise an array that will store all projectiles fired by the tank
        invader_projectiles = new ArrayList<InvaderProjectile>(); //initialise an array that will store all projectiles fired by invaders

        //these are the booleans that will track whether or not a key has been pressed
        //these are initially set to false
        LEFT = false;
        RIGHT = false;
        SHOOT = false;

        //create a new list storing only the Invader images
        List<PImage> invader_images = new ArrayList<PImage>();
        invader_images.add(INVADER1);
        invader_images.add(INVADER2);



        //initialies a new Tank
        player = new Tank(this, TANK, 312, 464);
        //initialises a new List that will store all Invaders
        invaders = new ArrayList<Invader>();


        //below all the invaders are created and added to the invaders list
        int X1 = 220; //initial x coordinate
        int Y1 = 16; //initial y coordinate

        //in this for loop, 10 invaders are created with the same y coordinate, whilst the x coordinate is incremented by 20 each time
        //these invaders will also be the armoured invaders
        for(int i = 0; i < 10; i++) {
            Invader new_invader = new Invader(this, ARMOURED1, ARMOURED2, X1, Y1, 3, false, 250);
            invaders.add(i, new_invader);
            X1 += (10 * 2);
        }

        X1 = 220; //resets the x value back to the initial
        Y1 += (16 * 2); //increments the y value

        //this for loop creates another 10 invaders similary to how the last ones were generated
        //this time the powered invaders are being created
        for(int i = 10; i < 20; i++) {
            Invader new_invader = new Invader(this, POWER1, POWER2, X1, Y1, 1, true, 250);
            invaders.add(i, new_invader);
            X1 += (10 * 2);
        }

        X1 = 220; //resets the x value back to the initial
        Y1 += (16 * 2); //increments the y value

        //this for loop works in the same manner as the previous
        //this time the normal invaders are being created
        for(int i = 20; i < 30; i++) {
            Invader new_invader = new Invader(this, INVADER1, INVADER2, X1, Y1, 1, false, 100);
            invaders.add(i, new_invader);
            X1 += (10 * 2);
        }

        X1 = 220; //resets the x value back to the initial
        Y1 += (16 * 2); //increments the y value

        //same function as previous for loop
        for(int i = 30; i < 40; i++) {
            Invader new_invader = new Invader(this, INVADER1, INVADER2, X1, Y1, 1, false, 100);
            invaders.add(i, new_invader);
            X1 += (10 * 2);
        }

        //below the Barrier1, Barrier2 and Barrier3 Lists are initialised
        //in each, seven BarrierComponents are added
        Barrier1 = new ArrayList<BarrierComponent>();
        BarrierComponent Top1 = new BarrierComponent(this, BARRIER_TOP1, BARRIER_TOP2, BARRIER_TOP3, 320, 428);
        Barrier1.add(Top1);
        BarrierComponent Top_Left1 = new BarrierComponent(this, BARRIER_LEFT1, BARRIER_LEFT2, BARRIER_LEFT3, 312, 428);
        Barrier1.add(Top_Left1);
        BarrierComponent Top_Right1 = new BarrierComponent(this, BARRIER_RIGHT1, BARRIER_RIGHT2, BARRIER_SOLID3, 328, 428);
        Barrier1.add(Top_Right1);
        BarrierComponent Mid_Left1 = new BarrierComponent(this, BARRIER_SOLID1, BARRIER_SOLID2, BARRIER_SOLID3, 312, 436);
        Barrier1.add(Mid_Left1);
        BarrierComponent Mid_Right1 = new BarrierComponent(this, BARRIER_SOLID1, BARRIER_SOLID2, BARRIER_SOLID3, 328, 436);
        Barrier1.add(Mid_Right1);
        BarrierComponent Bot_Left1 = new BarrierComponent(this, BARRIER_SOLID1, BARRIER_SOLID2, BARRIER_SOLID3, 312, 444);
        Barrier1.add(Bot_Left1);
        BarrierComponent Bot_Right1 = new BarrierComponent(this, BARRIER_SOLID1, BARRIER_SOLID2, BARRIER_SOLID3, 328, 444);
        Barrier1.add(Bot_Right1);

        Barrier2 = new ArrayList<BarrierComponent>();
        BarrierComponent Top2 = new BarrierComponent(this, BARRIER_TOP1, BARRIER_TOP2, BARRIER_TOP3, 208, 428);
        Barrier2.add(Top2);
        BarrierComponent Top_Left2 = new BarrierComponent(this, BARRIER_LEFT1, BARRIER_LEFT2, BARRIER_LEFT3, 200, 428);
        Barrier2.add(Top_Left2);
        BarrierComponent Top_Right2 = new BarrierComponent(this, BARRIER_RIGHT1, BARRIER_RIGHT2, BARRIER_SOLID3, 216, 428);
        Barrier2.add(Top_Right2);
        BarrierComponent Mid_Left2 = new BarrierComponent(this, BARRIER_SOLID1, BARRIER_SOLID2, BARRIER_SOLID3, 200, 436);
        Barrier2.add(Mid_Left2);
        BarrierComponent Mid_Right2 = new BarrierComponent(this, BARRIER_SOLID1, BARRIER_SOLID2, BARRIER_SOLID3, 216, 436);
        Barrier2.add(Mid_Right2);
        BarrierComponent Bot_Left2 = new BarrierComponent(this, BARRIER_SOLID1, BARRIER_SOLID2, BARRIER_SOLID3, 200, 444);
        Barrier2.add(Bot_Left2);
        BarrierComponent Bot_Right2 = new BarrierComponent(this, BARRIER_SOLID1, BARRIER_SOLID2, BARRIER_SOLID3, 216, 444);
        Barrier2.add(Bot_Right2);

        
        Barrier3 = new ArrayList<BarrierComponent>();
        BarrierComponent Top3 = new BarrierComponent(this, BARRIER_TOP1, BARRIER_TOP2, BARRIER_TOP3, 424, 428);
        Barrier3.add(Top3);
        BarrierComponent Top_Left3 = new BarrierComponent(this, BARRIER_LEFT1, BARRIER_LEFT2, BARRIER_LEFT3, 416, 428);
        Barrier3.add(Top_Left3);
        BarrierComponent Top_Right3 = new BarrierComponent(this, BARRIER_RIGHT1, BARRIER_RIGHT2, BARRIER_SOLID3, 432, 428);
        Barrier3.add(Top_Right3);
        BarrierComponent Mid_Left3 = new BarrierComponent(this, BARRIER_SOLID1, BARRIER_SOLID2, BARRIER_SOLID3, 416, 436);
        Barrier3.add(Mid_Left3);
        BarrierComponent Mid_Right3 = new BarrierComponent(this, BARRIER_SOLID1, BARRIER_SOLID2, BARRIER_SOLID3, 432, 436);
        Barrier3.add(Mid_Right3);
        BarrierComponent Bot_Left3 = new BarrierComponent(this, BARRIER_SOLID1, BARRIER_SOLID2, BARRIER_SOLID3, 416, 444);
        Barrier3.add(Bot_Left3);
        BarrierComponent Bot_Right3 = new BarrierComponent(this, BARRIER_SOLID1, BARRIER_SOLID2, BARRIER_SOLID3, 432, 444);
        Barrier3.add(Bot_Right3);
    }




    public void settings() {
        size(640, 480);
    }

    //method will update booleans if one of the significant keys has been pressed
    public void keyPressed() {
        //checks if space bar has been pressed
        if(key == ' ') {
            SHOOT = true;
        }

        //checks if left arrow key has been pressed
        if(keyCode == 37) {
            LEFT = true;
        }

        //checks if right arrow key has been pressed
        if(keyCode == 39) {
            RIGHT = true;
        }

    }

    //this method resets the boolean once the key has been released
    public void keyReleased() {
        //checks if space bar has been released
        if(key == ' ') {
            SHOOT = false;
            tank_fired = false;
        }

        //checks if left arrow key has been released
        if(keyCode == 37) {
            LEFT = false;
        }

        //checks if right arrow key has been released
        if(keyCode == 39) {
            RIGHT = false;
        }
    }

    //generates a new TankProjectile 
    //adds it to the tank_projectiles list
    //changes tank fired boolean to true
    public void generateTankProjectile() {
        TankProjectile tp = new TankProjectile(this, loadImage("projectile.png"), player.getX() + 11, player.getY());
        tank_projectiles.add(tp);
        tank_fired = true;
    }

    //generates a new InvaderProjectile
    public void generateInvaderProjectile() {
        //checks to see if there is still an Invader left to fire the projectile
        if(invaders.size() > 0) {
            Random rand = new Random(); 
            int index = rand.nextInt(invaders.size()); //generates a random number within the range of the number of invaders left
            Invader selected = invaders.get(index); 
            //if the invader is a powered invader, the InvaderProjectile must be passed a different PImage and must be given a damage of 3
            if(selected.getPower() == true) {
                InvaderProjectile ip = new InvaderProjectile(this, loadImage("projectile_lg.png"), selected.getX() + 8, selected.getY() + 16, 3);
                invader_projectiles.add(ip);
            //else, a normal InvaderProjectile is created
            } else {
                InvaderProjectile ip = new InvaderProjectile(this, loadImage("projectile.png"), selected.getX() + 8, selected.getY() + 16, 1);
                invader_projectiles.add(ip);
            }
            
        }

    } 

    //initialises a direction float that will be utilised by moveInvaders()
    float direction = -0.5f;

    public void moveInvaders() {
        //ensures that the invaders on move every second frame
        if(this.frameCount % 2 == 0) {
            for(Invader inv: this.invaders) {
                //if the invaders have moved too far right, they move down 8 pixels and the direction is reversed
                if(inv.getX() >= inv.getMaxPos()) {
                    inv.moveDown();
                    direction = -1f;
                    inv.moveLeft();
                    inv.setImage(inv.getImage2());
                //if the invaders have moved too far left, the move down 8 pixels and the direction is reversed
                } else if(inv.getX() <= inv.getMinPos()) {
                    inv.moveDown();
                    direction = 1f;
                    inv.moveRight();
                    inv.setImage(inv.getImage());
                //else, the invaders continue to move in the direction specified
                } else {
                    inv.move(direction);
                }
            }

        }
        
    }

    //collision detection method
    //same algorithm as provided in the specification sheet
    public boolean checkCollision(Entity r1, Entity r2) {
        if ( (r1.getX() < (r2.getX() + r2.getWidth())) 
            && ((r1.getX() + r1.getWidth()) > r2.getX()) 
            && (r1.getY() < (r2.getY() + r2.getHeight())) 
            && ((r1.getY() + r1.getHeight()) > r2.getY())) {
                return true;
            } else {
                return false;
            }
    }

    //checks if a TankProjectile has collided with any Barriers or Invaders
    public void TankProjectileCollisions() {
        for(TankProjectile tp: tank_projectiles) {

            //iterates through invaders to check if the current projectile has collided with any of the invaders
            for(Invader inv: invaders) {
                if(checkCollision(tp, inv) == true && tp.getStatus() == false) {
                    inv.Hit();
                    tp.Hit();
                }
            }

            //iterates through Barrier1 to see if the current Projectile has collided with any of the components
            for(BarrierComponent b1: Barrier1) {
                if(checkCollision(tp, b1) == true && tp.getStatus() == false) {
                    b1.Hit(1);
                    tp.Hit();
                }
            }

            //iterates through Barrier2 to see if the current Projectile has collided with any of the components
            for(BarrierComponent b2: Barrier2) {
                if(checkCollision(tp, b2) == true && tp.getStatus() == false) {
                    b2.Hit(1);
                    tp.Hit();
                }
            }

            //iterates through Barrier3 to see if the current Projectile has collided with any of the components
            for(BarrierComponent b3: Barrier3) {
                if(checkCollision(tp, b3) == true && tp.getStatus() == false) {
                    b3.Hit(1);
                    tp.Hit();
                }
            }
        }
    }

    //checks if an InvaderProjectile has collided with any Barriers or the Player
    public void InvaderProjectileCollisions() {
        for(InvaderProjectile ip: invader_projectiles) {

            //iterates through Barrier1 to see if the current Projectile has collided with any of the components
            for(BarrierComponent b1: Barrier1) {
                if(checkCollision(b1, ip) == true && ip.getCollided() == false) {
                    b1.Hit(ip.getDamage());
                    ip.collide();
                }
            }

            //iterates through Barrier2 to see if the current Projectile has collided with any of the components
            for(BarrierComponent b2: Barrier2) {
                if(checkCollision(b2, ip) == true && ip.getCollided() == false) {
                    b2.Hit(ip.getDamage());
                    ip.collide();
                }
            }

            //iterates through Barrier3 to see if the current Projectile has collided with any of the components
            for(BarrierComponent b3: Barrier3) {
                if(checkCollision(b3, ip) == true && ip.getCollided() == false) {
                    b3.Hit(ip.getDamage());
                    ip.collide();
                }
            }

            //checks to see if the current Projectile has collided with the Tank
            if(checkCollision(player, ip) == true && ip.getCollided() == false) {
                player.Hit(ip.getDamage());
                ip.collide();
            }

            
        }
    }

    //booleans to keep track of whether the level has been cleared or the game is over
    boolean win = false;
    boolean lose = false;

    //checks to see if the player has one
    public void checkPlayerWins() {
        //if all invaders are dead, then win is set to true
        if(invaders.size() == 0) {
            win = true;
        } else {
            win = false;
        }
    }

    //checks to see if the player has lost the game
    public void gameover() {
        //if the player has been hit too many times, then lose is set to true
        if(player.isDead() == true) {
            lose =  true;
        //alternatively if the invaders reach the barriers then lose is also set to true
        } else if(invaders.size() > 0 && invaders.get(invaders.size() - 1).getY() >= 418) {
            lose =  true;
        } else {
            lose =  false;
        }
    }



    int framecount = 0; //used to keep track of the frames
    int leveltimer = 1; //used to time the duration of the next level screen
    int overtimer = 1; //used to time the duration of the game over screen
    int firerate = 300; //initial fire rate of the invaders, once every 5 seconds (300 frames)
    int highscore = 10000; //default high score
    int finalscore = 0; //players final score
    int currentscore = 0; //players current score
    

    public void draw() {
        background(0);

        //before any objects are drawn we check if the player has cleared the levle or lost the game first
        checkPlayerWins();
        gameover();
        if(lose == true) {
            //if player has lost, the gameover screen image is displayed for 3 seconds
            image(loadImage("gameover.png"), 259, 232);
            firerate = 300; //resets the fire rate to once every 5 seconds
            //if the players final score was higher than the high score, then the high score is set to the player's final score
            //final score and current score are also reset
            if(currentscore > highscore) {
                highscore = 0;
                highscore += currentscore;
                finalscore += currentscore;
                currentscore = 0;
            //else, only the final score and current score are reset
            } else {
                finalscore += currentscore;
                currentscore = 0;
            }
            //the players current score is also dsiplayed 
            text("YOUR SCORE: " + finalscore, 220, 290);

            //once 3 seconds have passed, the game is restarted
            if(overtimer % 181 == 0) {
                setup();
                overtimer = 1;
            } else {
                overtimer++;
            }

            
        } else if(win == true) {
            //if the palyer has cleared the level, then the next level screen image is displayed for 2 seconds
            image(loadImage("nextlevel.png"), 259, 232);


            //once two seconds have passed, the next level is loaded
            //the firerate is also increased so long as it does not exceed one projectile per second
            if(leveltimer % 121 == 0) {
                if(firerate > 60) {
                    firerate -= 60;
                }
                setup();
                leveltimer = 1;
            } else {
                leveltimer++;
            }
            //resetGame();
            //setup();
            
        //the player has neither won nor lost, the level is still in progress
        } else {

            player.display(); //displays the player
            //iterates through invaders and displays each Invader which has not been killed
            //any dead Invaders are removed from the List
            //if an Invader is dead, its points are also added to the Player's current score
            for(int i = 0; i < invaders.size(); i++) {
                Invader current = invaders.get(i);
                if(current.isDead() == false) {
                    current.display();
                } else {
                    currentscore += current.getPoints();
                    invaders.remove(current);

                }
               
            }
    
            //the following three for loops iterate though the Barrier Lists and display each BarrierComponent
            //any dead BarrierComponents are removed from their list and not displayed
            for(int j = 0; j < Barrier1.size(); j++) {
                BarrierComponent part1 = Barrier1.get(j);
                if(part1.isDead() == false) {
                    part1.display();
                } else {
                    Barrier1.remove(part1);
                }
                
            }
    
            for(int k = 0; k < Barrier2.size(); k++) {
                BarrierComponent part2 = Barrier2.get(k);
                if(part2.isDead() == false) {
                    part2.display();
                } else {
                    Barrier2.remove(part2);
                }
                
            }
    
            for(int m = 0; m < Barrier3.size(); m++) {
                BarrierComponent part3 = Barrier3.get(m);
                if(part3.isDead() == false) {
                    part3.display();
                } else {
                    Barrier3.remove(part3);
                }
            }
    
            //displays all active TankProjectiles
            //if a Projectile has collided with something or is no longer visible on the screen, it is removed and not displayed
            for(int n = 0; n < tank_projectiles.size(); n++) {
                TankProjectile current_tp = tank_projectiles.get(n);
                if(current_tp.getStatus() == false) {
                    current_tp.display();
                } else if (current_tp.getY() <= 0) {
                    tank_projectiles.remove(current_tp);
                } else {
                    tank_projectiles.remove(current_tp);
                }
    
            }
    

            //if a certain amount of time has passed, a new invader projectile is fired
            //this time is dependent of the value of firerate
            if(framecount % firerate == 0) {
                generateInvaderProjectile();
            }
            
    
            //iterates through invader_projectiles and displays all active Projectiles
            //if a projectile has collided with something or if it is no longer visible on the screen, it is removed from the list and not displayed
            for(int p = 0; p < invader_projectiles.size(); p++) {
                InvaderProjectile current_ip = invader_projectiles.get(p);

                if(current_ip.getY() >= 480) {
                    invader_projectiles.remove(current_ip);
                }

                if(current_ip.getCollided() == false) {
                    current_ip.display();
                } else {
                    invader_projectiles.remove(current_ip);
                }
            }
    
    
            //if the space bar has been pressed, a new Tank Projectile has been created
            //will only occur if tank_fired is set to false
            //tank fired is only reset to false upon the space bar being released, hence obly one projectile can be created per key press
            if(SHOOT == true) {
                if(tank_fired == false) {
                    this.generateTankProjectile();
                    tank_fired = true;
                }
            }
    
            //handles the player movement
            //ensures player does not exceed left and right boundaries
            //also ensures movement does not occur if both arrow keys are pressed at the same time
            if(LEFT == true && RIGHT == false && player.getX() > 180) {
                player.moveLeft();
            } else if(RIGHT == true && LEFT == false &&  player.getX() < 460 - 22) {
                player.moveRight();
            }
    
    
            //calls moveInvaders() method
            moveInvaders();
            
    
            //performs collision detection method for all Projectiles
            TankProjectileCollisions();
            InvaderProjectileCollisions();

            //displays players current score in the top left corner
            text("CURRENT SCORE", 10, 30);
            text(currentscore, 10, 45);

            //displays players current score in the top right corner
            text("HIGH SCORE", 500, 30);
            text(highscore, 500, 45);
    
            //increments framecount
            framecount += 1;
            //resets final score
            finalscore = 0;
        }

    }

    public static void main(String[] args) {
        PApplet.main("invadem.App");
    }

}