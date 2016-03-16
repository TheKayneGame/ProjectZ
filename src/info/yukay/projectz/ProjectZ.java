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
    int Field[][];
    int FieldWidth = 31;
    int FieldHeight = 40;
    int ticks = 0;
    int BulletCount = 2;
    
    private BufferedImage SpaceShip; 
    //Image SpaceShip1;
    Timer timer;
    Image Buffer;
    Graphics gBuff;
    Dimension dim;

    
    public void init()
    {
        addKeyListener(new InputKeyEvents());
        this.setSize(600, 500);
        this.setFocusable(true);
        
        //SpaceShip1 = getImage(getCodeBase(), "SpaceShip.png");
       
    	
        timer = new Timer(10, this);
    	timer.start();
        
    	dim = getSize();
    	Buffer = createImage(dim.width, dim.height);
    	gBuff = Buffer.getGraphics();
    	
    	//Load Textures
    	try
    	{
    		SpaceShip = ImageIO.read(new File("SpaceShip.png"));
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
    	gBuff.drawRect(10, 10, 400, 450 );
    	gBuff.fillOval(50, 50, 20, 20);
    	g.drawImage(Buffer,0,0,this);
    }
    
    public void update(Graphics g)
    {
    	paint(g);
    }
}
