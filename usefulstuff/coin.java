package usefulstuff;

import java.awt.*;
import javax.swing.*;

public class coin
{

    private int h;
    private int x, y;
    public coin ()
    {
	h = 20;
	x = 200;
	y = 300;
    }


    public void draw (Graphics g)
    {
	g.setColor (Color.yellow);
	g.fillOval (x, y, h, h);
    }


    public void setPosition (int Nx, int Ny)
    {
	x = Nx;
	y = Ny;
    }


    public void setHeight (int Nh)
    {
	h = Nh;
    }


    public int getHeight ()
    {
	return h;
    }


    public int getX ()
    {
	return x;
    }


    public int getY ()
    {
	return y;
    }


    public boolean contains (int pointX, int pointY)
    {
	if (x < pointX && pointX < x + h && y < pointY && pointY < y + h)
	    return true;
	else
	    return false;
    }
}
