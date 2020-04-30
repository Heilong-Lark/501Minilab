package view_control;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class MainMenu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		// JLabel with image 
		JLabel pic = new JLabel("");        
        java.awt.Image image = new ImageIcon("view_control/APCompSci.jpeg").getImage();
        pic.setIcon(new ImageIcon(image));
        pic.setBounds(377, 111, 128, 128);
        
        // Content Panel to add Label and Image
        //https://docs.oracle.com/javase/tutorial/uiswing/components/rootpane.html
        Container content = getContentPane();
        content.setBackground(new Color(100,100,255));
        content.add(pic);
        
        // Menu Objects 
        JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
        
		JMenu mnHone = new JMenu("Home");
		menuBar.add(mnHone);
		
		
	}
	
}
