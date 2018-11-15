package usefulstuff;

import java.awt.*;
import javax.swing.*;


public class enemy
{

    private int h;
    private int x, y;

    public enemy ()
    {

	h = 50;
	x = 200;
	y = 200;

    }


    public void draw (Graphics g)
    {
	g.setColor (Color.red);
	g.drawRect (x, y, h, h);
    }


    public void setHeight (int newh)
    {
	h = newh;
    }


    public int getHeight ()
    {
	return h;
    }



    public void setPosition (int newx, int newy)
    {
	x = newx;
	y = newy;
    }


    public int getX ()
    {
	return x;
    }


    public int getY ()
    {
	return y;
    }
}
