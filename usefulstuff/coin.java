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
}
