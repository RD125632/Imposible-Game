import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Game extends JFrame {

	private static final long serialVersionUID = -267898356374050223L;

	public Game()
	{
		super("2D Graphics Game");
        setSize(1000,700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUndecorated(true);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createMatteBorder(5,5,5,5,Color.black));
        mainPanel.setLayout(null);
        
        mainPanel.add(new Menu(this));
        
        setContentPane(mainPanel);
        
        
       	
	}
	 
}
