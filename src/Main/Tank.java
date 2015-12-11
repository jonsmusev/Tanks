package Main;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon ;

public class Tank {

	final int NORTH = 1;
	final int EAST = 2;
	final int SOUTH = 3;
	final int WEST = 4;
	int direction;
	public int x,y,dx,dy;
	boolean isAlive, isMoving;
	private Image image;
	private Image image_NORTH, image_WEST, image_SOUTH, image_EAST;
	private ArrayList bullets;
	
	public Tank() {
		initTank();
	}
	
	private void initTank(){
	
		ImageIcon tankSprite_NORTH = new ImageIcon("src/images/tank_NORTH.png");
		ImageIcon tankSprite_SOUTH = new ImageIcon("src/images/tank_SOUTH.png");
		ImageIcon tankSprite_WEST = new ImageIcon("src/images/tank_WEST.png");
		ImageIcon tankSprite_EAST = new ImageIcon("src/images/tank_EAST.png");

		image = tankSprite_NORTH.getImage();
		image_NORTH = tankSprite_NORTH.getImage();
		image_WEST = tankSprite_WEST.getImage();
		image_SOUTH = tankSprite_SOUTH.getImage();
		image_EAST = tankSprite_EAST.getImage();
		x=10;
		y=100;
		
		bullets = new ArrayList();
	}
		
	//реализация поворота подменой спрайта, проверка на край карты и движение изменением координаты
	public void move() {
		
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
	
	public void keyPressed(KeyEvent e){
		
		int key = e.getKeyCode();
		
		switch(key) {
		case KeyEvent.VK_LEFT: { 
			direction = WEST; 
			isMoving=true; 
			break;
			}
		case KeyEvent.VK_RIGHT: {  
			direction = EAST; 
			isMoving=true; 
			break;
			}
		case KeyEvent.VK_UP: { 
			direction = NORTH; 
			isMoving=true; 
			break;
			}
		case KeyEvent.VK_DOWN: {  
			direction = SOUTH; 
			isMoving=true; 
			break;}	
		case KeyEvent.VK_SPACE: { shoot(); break;}
		}
	}
		
	public void keyReleased (KeyEvent e){
		
		int key = e.getKeyCode();
		
		switch(key) {
		case KeyEvent.VK_LEFT: { isMoving = false; break;}
		case KeyEvent.VK_RIGHT: { isMoving = false; break;}
		case KeyEvent.VK_UP: { isMoving = false; break;}
		case KeyEvent.VK_DOWN: {  isMoving = false; break;}			
		}
	}
}
