/**
 * Sound class for playing .au files
 *
 * @author Stu Dent
 * @version Feb 2010
 */
package usefulstuff;

import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.io.FileInputStream;
import sun.audio.*;

public class Sound
{
    private AudioData audioData;
    private AudioDataStream audioStream;
    private ContinuousAudioDataStream continuousAudioDataStream;


    /**
     * Constructor for the Sound class
     *
     * @param  filename   the sound file (must be a .au file)
     */
    public Sound (String filename)
    {
	try
	{
	    FileInputStream fis = new FileInputStream (filename);
	    AudioStream tempAudioStream = new AudioStream (fis);
	    audioData = tempAudioStream.getData ();
	    audioStream = null;
	    continuousAudioDataStream = null;
	}
	catch (Exception e)
	{
	    System.out.println (e.toString ());
	}
    }


    /**
     * Plays the sound
     *
     */
    public void play ()
    {
	audioStream = new AudioDataStream (audioData);
	AudioPlayer.player.start (audioStream);
    }
}


