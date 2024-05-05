import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Title Screen.
 * 
 * @author Clifford Fang
 * @version May 2024
 */
public class TitleScreen extends World
{
    Label titleLabel = new Label("The Bee", 60);
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        
        addObject(titleLabel,200, getHeight()/2);
        prepare();
    }
    /**
     * The main world act loop
     */
    public void act()
    {
        // Start the game if user presses the space bar
        if(Greenfoot.isKeyDown("space"))
        {
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld);
        }
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Bee bee = new Bee();
        addObject(bee,478,86);
        bee.setLocation(500,100);
        Label label = new Label("Use \u2190 and \2192 to Move", 40);
        addObject(label,220,257);
        label.setLocation(305,205);
        label.setLocation(299,235);
        Label label2 = new Label("Press<space> to start", 40);
        addObject(label2,250,246);
        label2.setLocation(300,200);
        label.setLocation(327,256);
        label2.setLocation(290,392);
        label.setLocation(289,255);
        
    
    }
}
