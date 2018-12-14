package usefulstuff;

import java.awt.*;
import javax.swing.*;


public class enemy
{

    private int h;
    private int x, y;
    private double angle;

    public enemy ()
    {

	h = 50;
	x = 200;
	y = 200;
	angle = 0;

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


    public boolean collision (int cx, int cy)
    {

	if (cx == x && cy == y)
	    return true;

	else
	    return false;

    }
    public void bounce ()
    {
      if (angle == 0)
      {
         angle = Math.PI;
      }
      else
      {
         angle = 0;
      }
   }


    public void setAngle (double newAngle)
    {
	angle = newAngle;
    }


    public double getAngle ()
    {
	return angle;
    }


    public void move (int distance)
    {
	int dx = (int) (distance * Math.cos (angle));
	int dy = (int) (distance * Math.sin (angle));

	x = x + dx;
	y = y - dy;
    }
}
