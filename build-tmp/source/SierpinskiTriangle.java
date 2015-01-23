import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class SierpinskiTriangle extends PApplet {

int sizeFactor, triangleSize, limitInt, redMeter, greenMeter, blueMeter;
public void setup()
{
	frameRate(8);
	sizeFactor = 800;
	triangleSize = 600;
	limitInt = 100;
	redMeter = 1;
	greenMeter = 1;
	blueMeter = 1;
	size(sizeFactor,sizeFactor);
	background(150);
}
public void draw()
{
	background(150);
	sierpinski(100,700,triangleSize);
	noLoop();

}


public void keyPressed()
{
	System.out.println(limitInt);
	loop();
	if (keyCode == UP) {
		if(limitInt < 220)
		{
			redMeter += 3;
			blueMeter += 3;
			greenMeter += 3;
			limitInt += 5;
		}
      
    } else if (keyCode == DOWN) {
    	if (limitInt > 1)
    	{
    		redMeter -= 3;
			blueMeter -= 3;
			greenMeter -= 3;
    		limitInt -= 1;
    	}
    } else if (key == ENTER || key == RETURN)
    {
    	limitInt = 100;
    	redMeter = 1;
		greenMeter = 1;
		 blueMeter = 1;
    }
}

public void sierpinski(int x, int y, int len) 
{
	int redColor = redMeter + (int)(Math.random()*256);
	int greenColor = greenMeter + (int)(Math.random()*256);
	int blueColor = blueMeter + (int)(Math.random()*256);
	fill(redColor, greenColor, blueColor);
	stroke(redColor, greenColor, blueColor);
	
	if (len > limitInt)
	{
		sierpinski(x, y, len/2);
		sierpinski(x + len/2, y, len/2);
		sierpinski(x + len/4, y - len/2, len/2);
	}else
	{
		
		triangle(x, y, x + len, y, x + (len/2), y - (len/1));
	}

}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "SierpinskiTriangle" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
