import java.awt.Color;
import java.awt.Cursor;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;


public class Menu extends JPanel {

	private static final long serialVersionUID = -6139169395192395063L;
	private Game frame;
	protected int xMouse;
	protected int yMouse;
	
	public Menu(Game gameFrame)
	{
		super();
		frame = gameFrame;
		
        setLayout(null);
        setBounds(5,645,990,50);
        setCursor(new Cursor(Cursor.HAND_CURSOR)); 
 
        addMouseMotionListener(new MouseMotionAdapter() 
        {
            public void mouseDragged(MouseEvent evt) 
            {
                int x = evt.getXOnScreen();
                int y = evt.getYOnScreen();
                
                frame.setLocation(x - xMouse,y - (yMouse + 645));
            }
        });
        
        addMouseListener(new MouseAdapter() 
        {
            public void mousePressed(MouseEvent evt) 
            {
              xMouse = evt.getX();
              yMouse = evt.getY();
            }
        });
               
        
        JButton close = menubutton("Exit");
        close.setBounds(750,0,40,40);
        add(close);     	        
}
	
	@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        Color color1 = new Color(4,8,64);
        Color color2 = new Color(50,76,156);
        
        int w = getWidth();
        int h = getHeight();
        
        GradientPaint gp = new GradientPaint(0, 0, color1, 0, h, color2);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, w, h);
    }
	
	
	
	public JButton menubutton(String name)
    {
        final Icon normal = new ImageIcon("Images/" + name + ".png");
        final Icon pushed = new ImageIcon("Images/" + name + "Pushed.png");
        
        final JButton button = new JButton();
        button.setName(name);
        button.setIcon(normal);
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        button.addMouseListener(new MouseAdapter() 
        {
            @Override
			public void mouseEntered(MouseEvent evt) {
               button.setIcon(pushed);
            }

            @Override
			public void mouseExited(MouseEvent evt) {
                button.setIcon(normal);
            }
        });
        
        button.addActionListener(new ActionListener()
        {
            @Override
			public void actionPerformed(ActionEvent event)
            {
                switch(((JComponent) event.getSource()).getName())
                {
                  case "Exit":
                    System.exit(0);
                }
            }
        });
       
        return button;
    }
}
