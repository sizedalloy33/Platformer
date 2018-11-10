import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.util.*;
import usefulstuff.*;


public class Platformer
{

    public static void main (String[] args)
    {
	JFrame j = new JFrame ("Platformer");
	j.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
	j.getContentPane ().add (new PlatformerPanel (), BorderLayout.CENTER);
  j.setSize (800, 500);
  j.setVisible (true);
    }
}

class PlatformerPanel extends JPanel implements KeyListener
{

  public PlatformerPanel ()
  {

    addKeyListener(this);
  }
}

public void paintComponent (Graphics g)
{

  requestFocus();
}

public void keyPressed (KeyEvent e)
{

}


public void keyReleased (KeyEvent e)
{

}


public void keyTyped (KeyEvent e)
{
  
}
