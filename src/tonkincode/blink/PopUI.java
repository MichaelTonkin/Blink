package tonkincode.blink;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;

public class PopUI extends Canvas{
	
	public void paint(Graphics g)
	{
		g.setColor(Color.white);
		g.drawString("It's time to give your eyes a break", PopMeasurements.pWidth/4, PopMeasurements.pHeight/2);
	}
	
}
