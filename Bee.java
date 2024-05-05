import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Elephant, our hero.
 * 
 * @author (Clifford Fang) 
 * @version May 1 2024
 */
public class Bee extends Actor
{
    GreenfootSound beeSound = new GreenfootSound("Single Bee Buzzing.mp3");
    GreenfootImage[] idleRight = new GreenfootImage[3];
    GreenfootImage[] idleLeft = new GreenfootImage[3];
    
    // Direction the bee is facing
    String facing = "right";
    SimpleTimer animationTimer = new SimpleTimer();
    /**
     * Constructor - the code that gets ru one time when object is created
     */
    public Bee()
    {
        for(int i = 1; i < idleRight.length; i++)
        {
            idleRight[i] = new GreenfootImage("images/bee_idle/idle" + i + ".png");
            idleRight[i].scale(90, 90);
        }
        
        for(int i = 1; i < idleLeft.length; i++)
        {
            idleLeft[i] = new GreenfootImage("images/bee_idle/idle" + i + ".png");
            idleLeft[i].mirrorHorizontally();
            idleRight[i].scale(90, 90);
        }
        
    animationTimer.mark();
    
        //Initial bee image
    setImage(idleRight[1]); 
    }
    /**
     * Animate the bee
     */
    int imageIndex = 1;
    public void animateBee()
    {
        if(animationTimer.millisElapsed() < 50)
        {
            return;
        }
        animationTimer.mark();
        
        if(facing.equals("right"))
        {
        setImage(idleRight[imageIndex]);
        imageIndex = (imageIndex + 1) % idleRight.length;
        }  else 
        {
            setImage(idleLeft[imageIndex]);
            imageIndex = (imageIndex + 1) % idleLeft.length;
        }
    }
    
    public void act()
    {
        // Add your action code here.
        if(Greenfoot.isKeyDown("left"))
        {
            move(-2);
            facing ="left";
        }
        else if(Greenfoot.isKeyDown("right"))
        {
            move(2);
            facing ="right";
        }
        // Remove apple if bee eats it
        eat();
        
        // Animate the elephant
        animateBee();
    }

    /**
     * Eat the apple and soawn new apple if an apple is eaten
     */
    public void eat()
    {
        if(isTouching(Apple.class))
        {
            removeTouching(Apple.class);
            MyWorld world =(MyWorld) getWorld();
            world.createApple();
            world.increaseScore();
            beeSound.play();
        }

       
    }

}

