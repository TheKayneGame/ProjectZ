package info.yukay.projectz;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Projectile {
	private double projectileX;
	private double projectileY;
	BufferedImage image;
	
	public Projectile(double X, double Y)
	{
		projectileX = X;
		projectileY = Y;
		
    	try
    	{
    		image = ImageIO.read(new File("Bullet.png"));
    	} catch (IOException ex) { } 
	}
	
	public void tick() 
	{
		projectileY -= 10;
	}
	
	public void render(Graphics g)
	{
		g.drawImage(image, (int) projectileX, (int) projectileY, null);
	}
}
	



