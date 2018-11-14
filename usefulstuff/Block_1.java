package usefulstuff;

import java.awt.*;
import javax.swing.*;

public class Block_1
{

    private int h;
    private int x, y;

    public Block_1 ()
    {
	h = 50;
	x = 0;
	y = 0;
    }


    public void draw (Graphics g)
    {
	g.setColor (Color.black);
	g.fillRect (x, y, h, h);
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
}
