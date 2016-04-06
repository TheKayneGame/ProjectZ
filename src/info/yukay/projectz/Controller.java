package info.yukay.projectz; 
import java.awt.Graphics;
import java.util.LinkedList;

public class Controller 
{ 
	public LinkedList<Projectile> b = new LinkedList<Projectile>(); 
	Projectile TempProjectile; 

	

	public void tick(){ 
		for(int i = 0; i < b.size(); i++)
		{
			TempProjectile = b.get(i);
			TempProjectile.tick(); 
		}
	}


	public void render(Graphics g)
	{ 
		for(int i = 0; i < b.size(); i++)
			b.get(i).render(g);
	}
}