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

class PlatformerPanel extends JPanel implements KeyListener, ActionListener
{
  private javax.swing.Timer timer;
  UFO m;        //this is just so we can test some things
  int velocity1, velocity2, velocity3, velocity4;
  int maxVelocity;
  int step;
  int direction ;
  public PlatformerPanel ()
  {
    m = new UFO();
    m.setPosition(300, 50);
    m.setColor (Color.red);
    m.setSize(50);
    direction = 0;

step = 2;

    velocity1 = 0;
    velocity2 = 0;
    velocity3 = 0;
    velocity4 = 0;
    maxVelocity = 100;

    addKeyListener(this);
    timer = new javax.swing.Timer(10, this);
    timer.start();
  }

  public void accelerate (int velocityDirection)
  {
    if (velocityDirection != maxVelocity)
    {
      velocityDirection++;
    }
  }
  public void stop(int velocityDirection)
  {
    if (velocityDirection > 0)
    {
      velocityDirection--;
    }
  }

  public void paintComponent (Graphics g)
  {
  super.paintComponent(g);
  if (step = 2);
  m.draw(g);
    requestFocus();
  }

  public void keyPressed (KeyEvent e)
  {
    if (e.getKeyChar() == 'w')
    {


    }
    else if (e.getKeyChar() == 'd')
    {

    }
    else if (e.getKeyChar() == 'a')
    {

    }
    else if (e.getKeyChar() == 's')
    {


    }

  }


  public void keyReleased (KeyEvent e)
  {

  }


  public void keyTyped (KeyEvent e)
  {

  }

  public void actionPerformed (ActionEvent e)
  {
    if (e.getSource() == timer)
    {


    }

    repaint();
  }
}
