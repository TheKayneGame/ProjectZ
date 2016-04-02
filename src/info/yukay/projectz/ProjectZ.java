package info.yukay.projectz;


import java.applet.Applet;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Timer;


@SuppressWarnings("serial")
public class ProjectZ extends Applet implements ActionListener
{
    static boolean Debug;
	int Field[][];
    int FieldWidth = 31;
    int FieldHeight = 40;
    int ticks = 0;
    int BulletCount = 2;
    
    private BufferedImage SpaceShip;
    private BufferedImage Bullet;
 
    //Image SpaceShip1;
    Timer timer;
    Image Buffer;
    Graphics gBuff;
    Dimension dim;

    
    public void init()
    {
    	//set Values For Window
    	System.out.println("ProjectZ INIT");
        addKeyListener(new InputKeyEvents());
        setFocusable(true);
        setSize(600, 500);
        
        //Initializes Supplementary Classes
        //Projectile.init();
        InputKeyEvents.init();
        Projectile.init();
       
    	//Starts Timer For 
        timer = new Timer(10, this);
    	timer.start();
        
    	//Creates Buffer
    	dim = getSize();
    	Buffer = createImage(dim.width, dim.height);
    	gBuff = Buffer.getGraphics();
    	
    	//Load Textures
    	try
    	{
    		SpaceShip = ImageIO.read(new File("SpaceShip.png"));
    		Bullet = ImageIO.read(new File("Bullet.png"));
    	} catch (IOException ex) { } 
    }
    
   
    
    public void actionPerformed(ActionEvent e)
    {
    this.repaint();    	
    }
    
    public void paint(Graphics g)
    {
    	super.paint(g);
    	dim = getSize();
    	gBuff.clearRect(0, 0, dim.width, dim.height);
    	gBuff.drawImage(SpaceShip, Player.getX(), Player.getY(), this); 
    	gBuff.drawImage(Bullet, Projectile.posX, Projectile.posY, this);
    	gBuff.drawRect(10, 10, 400, 450 );
    	
    	
    	g.drawImage(Buffer,0,0,this);
    }
    
    public void update(Graphics g)
    {
    	paint(g);
    }
    
    public static void DebugSwitch(boolean i)
    {
    	Debug = i;
    }
    
    public static boolean DebugModeOn()
    {
    	return Debug;
    }
}
