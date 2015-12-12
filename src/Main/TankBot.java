package Main;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon ;

public class TankBot {

	final int NORTH = 2;
	final int EAST = 4;
	final int SOUTH = 1;
	final int WEST = 3;
	int direction;
	public int x,y,dx,dy;
	boolean isAlive, isMoving;
	private Image image;
	private Image image_NORTH, image_WEST, image_SOUTH, image_EAST;
	private ArrayList bullets;
	Random random;

	public TankBot(int dy) {
		initTankBot(dy);
	}
	
	private void initTankBot(int dy){
		
		ImageIcon tankSprite_NORTH = new ImageIcon("src/images/tank_NORTH.png");
		ImageIcon tankSprite_SOUTH = new ImageIcon("src/images/tank_SOUTH.png");
		ImageIcon tankSprite_WEST = new ImageIcon("src/images/tank_WEST.png");
		ImageIcon tankSprite_EAST = new ImageIcon("src/images/tank_EAST.png");

		image = tankSprite_NORTH.getImage();
		image_NORTH = tankSprite_NORTH.getImage();
		image_WEST = tankSprite_WEST.getImage();
		image_SOUTH = tankSprite_SOUTH.getImage();
		image_EAST = tankSprite_EAST.getImage();
		
		this.dy = dy;
        Random random = new Random(System.currentTimeMillis()*dy);
		
		x=random.nextInt(600);
		y=random.nextInt(400);
		
		bullets = new ArrayList();
	}
	
	public void move() {
		
        Random random = new Random(System.currentTimeMillis()*dy);

		dx = random.nextInt(200);
		if (dx>100 && dx <= 104 ){direction = dx-100;}
		isMoving = true;
		
		switch (direction){
			case WEST: if (isMoving==true){ 
				image = image_WEST;
				if (x <= 1 ){isMoving=false;} 
				else x -= 1; 
				break;
				}
			case EAST: if (isMoving==true){ 
				image = image_EAST;
				if (x >= 620){isMoving=false;} 
				else  x += 1; 
				break;
				}
			case NORTH: if (isMoving==true){ 
				image = image_NORTH;
				if ( y <= 1 ){isMoving=false;} 
				else y -= 1; 
				break;
				}
			case SOUTH: if (isMoving==true){ 
				image = image_SOUTH;
				if ( y >= 440 ){isMoving=false;} 
				else y += 1; 
				break;
				}
		}
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public Image getImage() {
		return image;
	}
	
	public ArrayList getBullets(){
		return bullets;
	}
	
	//пули добавляем в список, а его обрабатывает уже поле.
	public void shoot() {
		bullets.add(new Bullet(x+5, y+5, direction));
	}
	
	public void explode(){}
}







