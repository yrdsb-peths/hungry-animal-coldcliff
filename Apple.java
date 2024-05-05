import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Food for our bee.
 * 
 * @author Clifford Fang 
 * @version May 1 2024
 */
public class Apple extends Actor
{
    /**
     * Act - do whatever the Apple wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int speed = 1;
    
    public void act()
    {
        // Apple falls downwards.
        int x =getX();
        int y = getY() + speed;
        setLocation(x,y);
        
        //Remove apple and draw game over when apple gets to bottom
        MyWorld world = (MyWorld) getWorld();
        if(getY() >= world.getHeight())
        {
            world.gameOver();
            world.removeObject(this);
        }    
    }
    public void setSpeed(int spd)
    {
        speed = spd;
    }
}
