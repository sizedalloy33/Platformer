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

class PlatformerPanel extends JPanel implements KeyListener, ActionListener, MouseListener
{
    private javax.swing.Timer timer;
    private javax.swing.Timer gravityTimer;
    UFO m;        //this is just so we can test some things
    int velocityX, velocityY, dvelocityX, dvelocityY; // current velocity in each direction
    int maxVelocityU, maxVelocityD, maxVelocityL, maxVelocityR; // max velocitys in each direction
    int direction; // what direction the player is facing
    int step; //what stage the game is on
    int mX, mY; //?

    ImageShape play; // play button

    boolean onBlock, onSide, donBlock, donSide; // to keep track of if the player or enemy is on the block

    Block_1 block; // the test block for the player to stand on

    enemy d; // the first enemy

    coin c; // A coin for the player to interact with

    boolean collision;

    public PlatformerPanel ()
    {

	collision = false;

	m = new UFO ();
	m.setPosition (300, 300);
	m.setColor (Color.red);
	m.setSize (50);
	direction = 0;

	d = new enemy ();
	d.setPosition (450, 50);
	d.setHeight (50);

	c = new coin ();

	velocityX = 0;
	velocityY = 0;
	dvelocityX = 0;
	dvelocityY = 0;
	maxVelocityU = -100;
	maxVelocityD = 100;
	maxVelocityL = 100;
	maxVelocityR = -100;

	timer = new javax.swing.Timer (20, this);
	// timer.start ();

	gravityTimer = new javax.swing.Timer (50, this);
	gravityTimer.start ();

	step = 1;

	block = new Block_1 ();
	block.setDimentions (70, 30);
	block.setPosition (150, 150);

	onBlock = false;
	onSide = false;

	play = new ImageShape ();
	play.setPicture ("buttons/play1.png");
	play.setHeight (150);
	play.setPosition (300, 300);

	addKeyListener (this);
	addMouseListener (this);

    }


    public void gravity ()
    {
      if (velocityY < 20)
	    {
        velocityY = velocityY + 1;
	    }

	    if (dvelocityY < 20)
	    {
	      dvelocityY = dvelocityY + 1;
	    }
    }


    public void wall (int y, int x)
    {
	    mX = m.getX ();
	    mY = m.getY ();
      if (block.contains(mX, mY) && velocityX <= 0)
        onBlock = true;
      else
        onBlock = false;
    }


    public void move (char direction)
    {
	if (direction == 'L')
	{
	    velocityX = -10;
	}
	else if (direction == 'R')
	{
	    velocityX = 10;
	}
	else if (direction == 'S')
	{
	    velocityX = 0;
	}


    }


    public void paintComponent (Graphics g)
    {
	super.paintComponent (g);

	if (step == 1)
	{
	    play.draw (g);
	}
	else if (step == 2)
	{

	    m.draw (g);
	    block.draw (g);
	    d.draw (g);
	    c.draw (g);
	}
	else if (step == 3)
	{
	    play.draw (g);
	}

	requestFocus ();
    }


    public void keyPressed (KeyEvent e)
    {
	if (e.getKeyChar () == 'w')
	{
	    velocityY = -10;

	}
	if (e.getKeyChar () == 'd')
	{
	    move ('R');
	}
	else if (e.getKeyChar () == 'a')
	{
	    move ('L');
	}
	else if (e.getKeyChar () == 's')
	{

	}

    }


    public void keyReleased (KeyEvent e)
    {
	if (e.getKeyChar () != 'w')
	{
	    move ('S');
	}
    }


    public void keyTyped (KeyEvent e)
    {

    }


    public void actionPerformed (ActionEvent e)
    {


	if (e.getSource () == timer)
	{


	    d.move (4);

	    if (d.getX () >= 740)
	    {
		d.bounce ();
	    }
	    else if (d.getX () <= 0)
	    {
		d.bounce ();
	    }

	    if (m.getY () < 410 && onBlock == false && onSide == false)
	    {
		m.setPosition (m.getX () + velocityX, m.getY () + velocityY);
	    }
	    else if (velocityY < 0 && onBlock == false && onSide == false)
	    {
		m.setPosition (m.getX () + velocityX, m.getY () + velocityY);
	    }
	    else if (onBlock == true)
	    {
		m.setPosition (m.getX () + velocityX, m.getY ());
	    }
	    else if (onSide == true)
	    {
		m.setPosition (m.getX (), m.getY () + velocityY);
	    }
	    else
	    {
		m.setPosition (m.getX () + velocityX, 410);
	    }

	    if (d.getY () < 410 && donBlock == false && donSide == false)
	    {
		d.setPosition (d.getX () + dvelocityX, d.getY () + dvelocityY);
	    }
	    else if (dvelocityY < 0 && donBlock == false && donSide == false)
	    {
		d.setPosition (d.getX () + dvelocityX, d.getY () + dvelocityY);
	    }
	    else if (donBlock == true)
	    {
		d.setPosition (d.getX () + dvelocityX, d.getY ());
	    }
	    else if (donSide == true)
	    {
		d.setPosition (d.getX (), d.getY () + dvelocityY);
	    }
	    else
	    {
		d.setPosition (d.getX () + dvelocityX, 410);
	    }

	    if (d.collision (m.getX (), m.getY ()))
	    {
		collision = true;

	    }

	    if (collision)
	    {
		step = 3;
		timer.stop ();

		m.setPosition (300, 50);

		d.setPosition (450, 50);

		d.setAngle (0);
	    }

	}
	if (e.getSource () == gravityTimer)
	{
      if(block.collide(m)) {
        onBlock = true;
      }
      else {
        onBlock = false;
      }
	    wall (block.getY (), block.getX ());
	    if (onBlock == false)
	    {
		gravity ();
	    }
	    else if (onBlock == true)
	    {
		velocityY = 1;
	    }

	    if (donBlock == false)
	    {
		gravity ();
	    }
	    else if (donBlock == true)
	    {
		dvelocityY = 1;
	    }
	}

	repaint ();
    }


    public void mouseClicked (MouseEvent e)
    {
	if (play.contains (e.getX (), e.getY ()))
	{
	    collision = false;
	    step = 2;
	    timer.start ();
	}
    }


    public void mousePressed (MouseEvent e)
    {

    }


    public void mouseReleased (MouseEvent e)
    {
    }


    public void mouseEntered (MouseEvent e)
    {
    }


    public void mouseExited (MouseEvent e)
    {
    }
}
