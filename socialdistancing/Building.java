package socialdistancing;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


/* 
	Building extends JPanel so that we can override the paint method. The paint method is necessary to use the simple
	drawing tools of the library! 
	Simulator implements an ActionListener which adds the method actionPerformed. This method is invoked by the 
	animation timer every timerValue(16ms).
*/
public class Building extends JPanel implements ActionListener{
	// serial suppresses warning
	private static final long serialVersionUID = 1L;
	
	//simulation control objects/values
	JFrame frame;
	Control control;
	Timer timer; //Event control	
	int time = 0; //Track time as the simulation runs
	
	ArrayList<Wall> walls = new ArrayList<Wall>();
	int[][] coords = {{550, 0}, {200, 0}, {550, 400}, {200, 400}, {620, 160}, {-25, 160}, {620, 400}, {-25, 400}};
	
	//activation of Simulator separated from Constructor 
	public void activate() {
		//Timer for animation
		//Argument 1: timerValue is a period in milliseconds to fire event
		//Argument 2:t any class that "implements ActionListener"
		timer = new Timer(control.timerValue, this); //timer constructor
		timer.restart(); //restart or start
		
		// frame becomes visible
		frame.setVisible(true);		
	}
	
	/* This invoked by Timer per period in milliseconds in timerValue  */
	@Override
	public void actionPerformed(ActionEvent e) {
		//Triggers paint call through polymorphism
		repaint();	
	}
	
	
	/* constructor will setup our main Graphic User Interface - a simple Frame! */	
	public Building(Control ctl, String title) {
		makeWalls();
		// used for Control callback
		this.control = ctl;
		
		//Setup the GUI
		frame = new JFrame(title);
		frame.setSize(ctl.frameX,ctl.frameY); //set the size
		
		//add this so that hitting the x button will actually end the program
		//the program will continue to run behind the scenes and you might end up with 10+ of them
		//without realizing it
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//make it visible
		frame.setVisible(true);
		frame.add(this); //add this class (JPanel) to the JFrame
	}
	
	public void paintWalls(Graphics g) {

		for (Wall wall : walls) {
			g.drawImage(wall.getImage(), wall.getX(), wall.getY(), this);
		}
		
		//text color
		g.setColor(Color.BLUE);
		g.setFont(new Font("Roboto", Font.BOLD, 20));
		
		g.drawString("Daiso", 610, 50);
		g.drawString("Pokemon Center", 5, 50);
		g.drawString("99 Ranch Market", 5, 440);
		g.drawString("Leader Zin's House", 590, 440);
		
	}


	/* paint method for drawing the simulation and animation */
	@Override
	public void paint(Graphics g) {
		
		//tracking total time manually with the time variable
		time += control.timerValue;
		
		//events
		super.paintComponent(g); // a necessary call to the parent paint method, required for proper screen refreshing
		paintWalls(g);
		control.paintPersons(g); // repaint all objects in simulation
		
	} 
	
	public void makeWalls() {
		walls.add(new Wall(coords[0][0], coords[0][1], "SocialDistancingImages/wall2.png", true));
		walls.add(new Wall(coords[4][0], coords[4][1], "SocialDistancingImages/wall1.png", false));

		walls.add(new Wall(coords[1][0], coords[1][1], "SocialDistancingImages/wall2.png", true));
		walls.add(new Wall(coords[5][0], coords[5][1], "SocialDistancingImages/wall1.png", false));
		
		walls.add(new Wall(coords[2][0], coords[2][1], "SocialDistancingImages/wall2.png", true));
		walls.add(new Wall(coords[6][0], coords[6][1], "SocialDistancingImages/wall1.png", false));
		
		walls.add(new Wall(coords[3][0], coords[3][1], "SocialDistancingImages/wall2.png", true));
		walls.add(new Wall(coords[7][0], coords[7][1], "SocialDistancingImages/wall1.png", false));
	}
	
}