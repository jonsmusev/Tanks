package Main;

import java.awt.Image;

//Базовый класс всех предметов, существующих на доске. 
public class Thing {

	//Переменные задающие направление
	final int NORTH = 1;
	final int EAST = 2;
	final int SOUTH = 3;
	final int WEST = 4;
	int direction;
	Image image;
	Image image_NORTH, image_WEST, image_SOUTH, image_EAST;
	
	//переменные задающие координаты и смещение
	public int x,y,dx,dy;
	
	//переменные задающие существует ли объект и движется ли он
	boolean isAlive, isMoving;
	
	//пустой инициализатор
	public Thing() {initThing();}
	private void initThing(){}
	
	//возврат координат
	public int getX() { return x; }
	public int getY() {	return y; }
	
	//возврат изображения
	public Image getImage() { return image; }
	
	//уничтожение объекта
	public void explode(){}

}
