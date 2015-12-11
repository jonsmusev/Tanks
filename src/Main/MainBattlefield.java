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


class MainBattlefield extends JPanel implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Timer timer;
	private Tank tank;
	
	MainBattlefield(){
		initMainBattlefield();
	}
	
	private void initMainBattlefield(){
	
		addKeyListener(new TAdapter());
		setFocusable(true);
		setBackground(Color.BLACK);
		
		tank = new Tank();
		
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
		g2d.drawLine(10, 10, 50, 50);
		
		ArrayList bullets = tank.getBullets();
		for (Object b1 : bullets){
			Bullet b = (Bullet)b1;
			g2d.drawImage(b.getImage(), b.getX(), b.getY(), this);
		} 
		
		g2d.drawImage(tank.getImage(), tank.getX(), tank.getY(), this);
		g2d.setColor(Color.CYAN);
		g2d.drawString(Integer.toString(bullets.size()), 30, 40);
	}
	
	
	public void actionPerformed (ActionEvent e){
		updateBullets();
		tank.move();
		repaint();
	}
	
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
