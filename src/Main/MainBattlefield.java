package Main;

import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

//Класс реализующий игровое поле. 
class MainBattlefield extends JPanel implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Timer timer;
	private Tank tank;
	private TankBot tankBot0, tankBot1, tankBot2, tankBot3;
	
	MainBattlefield(){
		initMainBattlefield();
	}
	
	private void initMainBattlefield(){
	
		addKeyListener(new TAdapter());
		setFocusable(true);
		setBackground(Color.BLACK);
		
		tank = new Tank();
		tankBot0 = new TankBot(16);
		tankBot1 = new TankBot(91);
		tankBot2 = new TankBot(113);
		tankBot3 = new TankBot(273);

		
		timer = new Timer(10, this);
		timer.start();
	}
	
	public void paintComponent (Graphics g){
		super.paintComponent(g);
		
		doDrawing (g);
		Toolkit.getDefaultToolkit().sync();
	}
	
	private void doDrawing (Graphics g){

		Graphics2D g2d = (Graphics2D) g;
		g2d.drawLine(10, 10, 50, 50); //просто так
		
		ArrayList bullets = tank.getBullets(); //Пули существующие на поле.
		for (Object b1 : bullets){
			Bullet b = (Bullet)b1;
			g2d.drawImage(b.getImage(), b.getX(), b.getY(), this);
		} 
		
		g2d.drawImage(tank.getImage(), tank.getX(), tank.getY(), this); //Отрисовка танка
		g2d.drawImage(tankBot0.getImage(), tankBot0.getX(), tankBot0.getY(), this); //Отрисовка танка
		g2d.drawImage(tankBot1.getImage(), tankBot1.getX(), tankBot1.getY(), this); 
		g2d.drawImage(tankBot2.getImage(), tankBot2.getX(), tankBot2.getY(), this); 
		g2d.drawImage(tankBot3.getImage(), tankBot3.getX(), tankBot3.getY(), this); 
		g2d.setColor(Color.CYAN); 
		g2d.drawString(Integer.toString(bullets.size()), 30, 40); //счетчик пуль
	}
	
	
	public void actionPerformed (ActionEvent e){
		updateBullets();
		tank.move();
		tankBot0.move();
		tankBot1.move();
		tankBot2.move();
		tankBot3.move();
		repaint();
	}
	
	//класс для удаления из памяти ненужных пуль и перемещения нужных
	private void updateBullets(){
		ArrayList bullets = tank.getBullets();
		for (int i = 0; i < bullets.size(); i++){
			Bullet b = (Bullet) bullets.get(i);
			if (b.isAlive == true) {b.move();}
			else {bullets.remove(i);}
		} 
	}
	
	private class TAdapter extends KeyAdapter{
		public void keyReleased(KeyEvent e){
			tank.keyReleased(e);
		}
		public void keyPressed(KeyEvent e){
			tank.keyPressed(e);
		}
	}
}
