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
    GreenfootImage[] idle = new GreenfootImage[3];
    
    /**
     * Constructor
     */
    public Bee()
    {
        for(int i = 0; i< idle.length; i++)
        {
            idle[i] = new GreenfootImage("images/bee_idle/idle" + 1 + ".png");  
        }
       setImage(idle[0]); 
    }
    public void act()
    {
        // Add your action code here.
        if(Greenfoot.isKeyDown("left"))
        {
            move(-2);
        }
        else if(Greenfoot.isKeyDown("right"))
        {
            move(2);
        }
        // Remove apple if bee eats it
        eat();
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

