package Main;

import java.awt.EventQueue;
import javax.swing.JFrame;;

//Главный класс, реализует обрамдающее окно и является точкой запуска
public class TanksWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TanksWindow(){
		initUI();
	}

	private void initUI(){
		add (new MainBattlefield());
		
		setSize (640,480);
		setResizable(false);
		
		setTitle("Tanki");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main (String[] args){
		
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				TanksWindow tv = new TanksWindow();
				tv.setVisible(true);}
		});
	}
}
