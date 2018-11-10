
package usefulstuff;
/**
 * Mine Class (Grade 11)
 *
 * @author Joseph Robertson
 * @version 1
 */
import java.awt.*;
import javax.swing.*;
import hsa.Console;

public class Mine
{
    // INSTANCE VARIABLES
    private int h; // height of the mine
    private Color clr; //This is the color of the mine
    private int x, y; //position of the mine


    /**
     * Constructor for objects of class Mine
     * sets the default values for all of the variables
     */
    public Mine ()
    {
	     h = 100;
       clr = Color.red;
       x = 100;
       y = 100;

    }



    /**
    * Draws the Mine
    *
    * @param g   the Graphics context to draw on
    */
    public void draw (Console c)
    {
	c.setColor(clr);
	c.drawLine(x+h/2, y, x+h/2, y+h);
    }


    /**
     * Sets the height of a Mine
     *
     * @param  newh   new height of the Mine
     */
    public void setHeight (int newh)
    {
	h = newh;
    }


    /**
    * Returns the height of the Mine
    *
    * @return  the height
    */
    public int getHeight ()
    {
	return h;
    }


    /**
     * Sets the (x,y) coordinates of upper left corner of the Mine
     *
     * @param  newx   new x coordinate
     * @param  newy   new y coordinate
     */
    public void setPosition (int newx, int newy)
    {

    }






} // Mine class
