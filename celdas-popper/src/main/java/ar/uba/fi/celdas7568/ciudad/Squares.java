package ar.uba.fi.celdas7568.ciudad;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.*;
import javax.swing.*;

public class Squares extends JPanel {
	   private static final int PREF_W = 400;
	   private static final int PREF_H = PREF_W;
	   private List<Rectangle> squares = new ArrayList<Rectangle>();
	   private List<Rectangle> squareBorders = new ArrayList<Rectangle>();
	   private List<Color> squareColors = new ArrayList<Color>(); 
	   
	   private JLabel human;

	   public void addSquare(int x, int y, int width, int height, Color c) {
	      Rectangle rect = new Rectangle(x, y, width, height);
	      squares.add(rect);
	      squareBorders.add(new Rectangle(rect));
	      squareColors.add(c);
	   }

	   @Override
	   public Dimension getPreferredSize() {
	      return new Dimension(PREF_W, PREF_H);
	   }

	   @Override
	   protected void paintComponent(Graphics g) {
	      super.paintComponent(g);
	      Graphics2D g2 = (Graphics2D) g;
	      for (int i = 0; i < squares.size(); i++) {    
	    	 Rectangle rect = squares.get(i);
	    	 Color c = squareColors.get(i);
	    	 
	    	 g2.draw(rect);
	    	 g2.setColor(c);
	         g2.fillRect(rect.x, rect.y, rect.width, rect.height);
	      }
	      
	      for (Rectangle rect : squareBorders) {
	    	 g2.setColor(Color.black);
	    	 g2.draw(rect);
	      }      

	   }
	   
	   public void addHuman(int x, int y)
	   {
		    setLayout(null);
			human = new JLabel("");
			human.setIcon(new ImageIcon(JFrame.class.getResource("/ar/uba/fi/celdas7568/ciudad/human.png")));
			human.setBounds( x, y, 30, 30 );
			add(human);
	   }
	   
	   public void modifySquare(int i, Color c){
		   squareColors.set(i, c);
	   }
	   
	   public void modifyHuman(int x, int y)
	   {
			human.setBounds( x, y, 30, 30 );
	   }
}


