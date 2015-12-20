package Main;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon ;

//Класс танка игрока. Расшряет базовый класс Tank, принимает кнопочое управление;
public class TankPlayer extends Tank {
	
	public TankPlayer() {
		initTankPlayer();
	}
	
	private void initTankPlayer(){
	
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
	}
		
	//Реализация кнопочного управления
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
