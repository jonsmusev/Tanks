package Main;

import java.awt.Image;
import javax.swing.ImageIcon ;

public class Bullet {
	
	public int x,y;
	final int NORTH = 1;
	final int EAST = 2;
	final int SOUTH = 3;
	final int WEST = 4;
	int direction;
	boolean isAlive, isMoving;
	private Image image;
	private Image image_NORTH, image_WEST, image_SOUTH, image_EAST;

	
	public Bullet(int x, int y, int direction){
		this.x = x;
		this.y = y;
		this.direction = direction;
		initBullet(x, y, direction);
	}
	
	private void initBullet(int x, int y, int direction){
		
		ImageIcon bulletSprite_NORTH = new ImageIcon("src/images/bullet_NORTH.png");
		ImageIcon bulletSprite_SOUTH = new ImageIcon("src/images/bullet_SOUTH.png");
		ImageIcon bulletSprite_WEST = new ImageIcon("src/images/bullet_WEST.png");
		ImageIcon bulletSprite_EAST = new ImageIcon("src/images/bullet_EAST.png");

		switch (direction){
			case NORTH: {image = bulletSprite_NORTH.getImage(); break;}
			case WEST: {image = bulletSprite_WEST.getImage(); break;}
			case EAST: {image = bulletSprite_EAST.getImage(); break;}
			case SOUTH: {image = bulletSprite_SOUTH.getImage(); break;}
		}
		
		this.x = x;
		this.y = y;
		this.isAlive = true;
	}
	
	public void move(){
		
		switch (direction){
		case WEST: { x -= 2; break;	}
		case EAST: { x += 2; break;	}
		case NORTH: { y -= 2; break; }
		case SOUTH: { y += 2; break; }
		}
		
		if (x <= 0 || y <= 0 || x >= 640 || y >= 480 ){this.isAlive = false;} 
	}
	
	public Image getImage(){
		return image;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}

}
