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
    private BufferedImage FBullet;
    private BufferedImage EBullet;
    FriendlyBullets FriendlyBullets = new FriendlyBullets ();
    InputKeyEvents InputKeyEvents = new InputKeyEvents();
    Enemy1 Enemy1 = new Enemy1();
    Collision Collision = new Collision();
	//Image SpaceShip1;
    Timer timer;
    Image Buffer;
    Graphics gBuff;
    Dimension dim;
    
    public void init()
    {
    	
    	
    	
        addKeyListener(new InputKeyEvents());
        setFocusable(true);
        
        
        setSize(600, 500);
        System.out.println("ProjectZ INIT");
        
        //Initializes Supplementary Classes
        FriendlyBullets.init();
        InputKeyEvents.init();
        Enemy1.init();
        Collision.init();
        
       
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
    		FBullet = ImageIO.read(new File("Bullet.png"));
    		EBullet = ImageIO.read(new File("BulletEnemy.png"));
    	} catch (IOException ex) { } 
    }
    
   
    
    public void actionPerformed(ActionEvent e)
    {
    this.repaint();    	
    }
    
    @SuppressWarnings("static-access")
	public void paint(Graphics g)
    {
    	super.paint(g);
    	dim = getSize();
    	gBuff.clearRect(0, 0, dim.width, dim.height);
    	gBuff.drawImage(SpaceShip, Player.getX(), Player.getY(), this); 
    	gBuff.fillRect(Enemy1.x, Enemy1.y, 10, 10);
    	gBuff.drawRect(10, 10, 400, 450 );
    	//controller.render(g);
    	//Adds List To Buffer
    	for(int i = 0; i < FriendlyBullets.FProjectilesY.size() ; i++)
		{
			gBuff.drawImage(FBullet, FriendlyBullets.FProjectilesX.get(i), FriendlyBullets.FProjectilesY.get(i), this);
		}
    	
    	for(int i = 0; i < Enemy1.E1ProjectilesY.size() ; i++)
		{
			gBuff.drawImage(EBullet, Enemy1.E1ProjectilesX.get(i), Enemy1.E1ProjectilesY.get(i), this);
		}
    	
    	g.drawImage(Buffer,0,0,this);
    	
    }
    
    public void update(Graphics g)
    {
    	paint(g);
    	setSize(600, 500);
    	//controller.tick();
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
