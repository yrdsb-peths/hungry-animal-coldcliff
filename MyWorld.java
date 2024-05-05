import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The World out hero lives in.
 * 
 * @author Clifford Fang 
 * @version May 1 2024
 */
public class MyWorld extends World
{
    public int score = 0;
    Label scoreLabel;
    int level = 1;
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false);

        //Create the bee object
        Bee bee = new Bee ();
        addObject(bee, 300, 300);

        // Create a label
        scoreLabel = new Label(0, 80);
        addObject(scoreLabel, 50, 50);

        createApple();
        prepare();
    }

    /**
     * End the game and draw 'GameOver'
     */
    public void gameOver()
    {
        Label gameOverLabel = new Label("Game Over", 100);
        addObject(gameOverLabel, 300, 200);
    }

    /**
     * Inscrease score
     */
    public void increaseScore()
    {
        score++;
        scoreLabel.setValue(score); 
        if(score % 5 == 0)
        {
            level += 1;
        }
    }

    /**
     * Create a new apple at random location at top of screen 
     */
    public void createApple()
    {
        Apple apple = new Apple();
        apple.setSpeed(level);
        int x = Greenfoot.getRandomNumber(getWidth());
        int y = 0;
        addObject(apple, x, y);
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Bee bee = new Bee();
        addObject(bee,478,87);
        bee.setLocation(467,125);
    }
}
