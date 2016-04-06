package info.yukay.projectz;

import java.util.ArrayList;
import java.util.List;

public class Projectile {
	List<Integer> Projectiles = new ArrayList<Integer>();
	private int x;
	private int y;
	
	public void init(){
		addProjectile();
	}
	
	public void addProjectile() {
		Projectiles.add(x, y);
	}
}
	



