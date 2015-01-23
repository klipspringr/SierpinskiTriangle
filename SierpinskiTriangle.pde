int sizeFactor, triangleSize, limitInt, redMeter, greenMeter, blueMeter;
public void setup()
{
	frameRate(8);
	sizeFactor = 800;
	triangleSize = 600;
	limitInt = 80;
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
	loop();
	if (keyCode == UP) 
	{
		if(limitInt < 220)
		{
			redMeter += 3;
			blueMeter += 3;
			greenMeter += 3;
			limitInt += 2;
		}
    } else if (keyCode == DOWN) 
    {
    	if (limitInt > 1)
    	{
    		if (limitInt > 80)
    		{
    		redMeter -= 3;
			blueMeter -= 3;
			greenMeter -= 3;
    		limitInt -= 5;
    		}else 
    		{
    		redMeter -= 3;
			blueMeter -= 3;
			greenMeter -= 3;
    		limitInt --;
    		}
    	}
    } else if (key == ENTER || key == RETURN)
    {
    	limitInt = 80;
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