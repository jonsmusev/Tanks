package Main;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon ;

//Базовый класс танка. Расширяет класс Thing. 
public class Tank extends Thing{

	ArrayList bullets;
	
	public Tank() {
		initTank();
	}
	
	private void initTank(){
	
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
		
	
	public ArrayList getBullets(){
		return bullets;
	}
	
	//пули добавляем в список, а его обрабатывает уже поле.
	public void shoot() {
		bullets.add(new Bullet(x+5, y+5, direction));
	}
		
}
