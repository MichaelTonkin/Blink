package tonkincode.blink;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;

import tonkincode.blink.utilities.PopupTimer;

public class PopUI extends Canvas{
	
	private int exercise = PopupTimer.getExercise();
	
	public void paint(Graphics g)
	{
		g.setColor(Color.white);
		g.drawString("It's time to give your eyes a break", PopMeasurements.pWidth/4, PopMeasurements.pHeight/2);
		
		switch(exercise)
		{
		case 0:
			g.drawString("Move your eyes left to right", PopMeasurements.pWidth/4, PopMeasurements.pHeight/2+20);
			break;
		case 1:
			g.drawString("Blink your eyes", PopMeasurements.pWidth/4, PopMeasurements.pHeight/2+20);
			break;
		case 2:
			g.drawString("Roll your eyes in any direction", PopMeasurements.pWidth/4, PopMeasurements.pHeight/2+20);
			break;

			
		}
	}
	
}
