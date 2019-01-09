package usefulstuff;
/**
 * ImageShape Class (Grade 11)
 *
 * @author Stu Dent
 * @version 1
 */
import java.awt.*;
import javax.swing.*;

public class ImageShape
{
    // INSTANCE VARIABLES
    private int x; // upper left corner x coordinate
    private int y; // upper left corner y coordinate
    private int height;    // height of the image

    private Image im;  // the image

    /**
     * Constructor for objects of class ImageShape
     */
    public ImageShape ()
    {
	x = 100;
	y = 100;
	height = 160;
	im = new ImageIcon ("Cshamrockorange.jpg").getImage ();
    }


    /**
     * Constructor for objects of class ImageShape
     *
     * @param  x    x coordinate
     * @param  y    y coordinate
     * @param  h    height (and width)
     * @param  file image file name
     */
    public ImageShape (int x, int y, int h, String file)
    {
	this.x = x;
	this.y = y;
	height = h;
	im = new ImageIcon (file).getImage ();
    }



    /**
    * Draws the ImageShape
    *
    * @param g   the Graphics context to draw on
    */
    public void draw (Graphics g)
    {
	g.drawImage (im, x, y, height, height, null);
    }


    /**
     * Sets the picture of the ImageShape
     *
     * @param  file   image file name
     */
    public void setPicture (String file)
    {
	im = new ImageIcon (file).getImage ();
    }


    /**
     * Sets the (x,y) coordinates of upper left corner of the ImageShape
     *
     * @param  newx   new x coordinate
     * @param  newy   new y coordinate
     */
    public void setPosition (int newx, int newy)
    {
	x = newx;
	y = newy;
    }


    /**
     * Returns the x coordinate of the upper left corner of the ImageShape
     *
     * @return  the x coordinate of the ImageShape
     */
    public int getX ()
    {
	return x;
    }


    /**
     * Returns the y coordinate of the upper left corner of the ImageShape
     *
     * @return  the y coordinate of the ImageShape
     */
    public int getY ()
    {
	return y;
    }


    /**
     * Returns the x coordinate of the center of the ImageShape
     *
     * @return  the x coordinate of the center
     */
    public int getCenterX ()
    {
	return x + height / 2;
    }


    /**
     * Returns the y coordinate of the center of the ImageShape
     *
     * @return  the y coordinate of the center
     */
    public int getCenterY ()
    {
	return y + height / 2;
    }


    /**
     * Sets the height of a ImageShape
     *
     * @param  newh   new height of the ImageShape
     */
    public void setHeight (int newh)
    {
	height = newh;
    }


    /**
    * Returns the height of the ImageShape
    *
    * @return  the height
    */
    public int getHeight ()
    {
	return height;
    }


    /**
     * Sets the size (height & width) of a ImageShape
     *
     * @param  newh   new height of the ImageShape
     */
    public void setSize (int newh)
    {
	height = newh;
    }


    public boolean contains (int pointX, int pointY)
    {
	if (x < pointX && pointX < x + height && y < pointY && pointY < y + height)
	    return true;
	else
	    return false;
    }


    public boolean collide (enemy v)
    {
	if (contains (v.getX (), v.getY ()))
	    return true;
	else if (contains (v.getX () + v.getHeight (), v.getY ()))
	    return true;
	else if (v.contains (x, y)
		return true;
	else if (v.contains (x + h, y))
	    return true;
	else
	    return false;
    }



} // ImageShape class

