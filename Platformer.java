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
  private javax.swing.Timer gravityTimer;
  UFO m;        //this is just so we can test some things
  int velocityX, velocityY;
  int maxVelocityU, maxVelocityD, maxVelocityL, maxVelocityR;
  int direction;
  int step;
  public PlatformerPanel ()
  {
    m = new UFO();
    m.setPosition(300, 50);
    m.setColor (Color.red);
    m.setSize(50);
    direction = 0;

    velocityX = 0;
    velocityY = 0;
    maxVelocityU = -100;
    maxVelocityD = 100;
    maxVelocityL = 100;
    maxVelocityR = -100;

    timer = new javax.swing.Timer(20, this);
    timer.start();

    gravityTimer = new javax.swing.Timer(70, this);
    gravityTimer.start();
    
    step = 2;

    addKeyListener(this);

  }

  public void gravity ()
  {
    if (velocityY < 100)
    {
      velocityY = velocityY + 1;
    }
  }

  public void paintComponent (Graphics g)
  {
  super.paintComponent(g);
  if (step == 2)
  m.draw(g);
    requestFocus();
  }

  public void keyPressed (KeyEvent e)
  {
    if (e.getKeyChar() == 'w')
    {
      velocityY = -12;

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
    repaint();

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
      m.setPosition(m.getX() + velocityX, m.getY() + velocityY);
    }
    if(e.getSource() == gravityTimer)
    {
      gravity();
    }

    repaint();
  }
}
