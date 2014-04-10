package lawyerFeeCalc;

/*
 * this is a simple app helping a lawyer friend calculate the lawyer fee
 * 
 */

import javax.swing.*;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.*;	

public class Main{

	public static void main(String[] args){	
		JFrame frame1 = new JFrame("Lawyer Fee Calculator");
		
		// create Model and initialize it
		Model model = new Model();
		
		// create View, tell it about model (and controller)
		View view = new View(model);
		// tell Model about View. 
		model.addView(view);
		
		// create second view ...
		View2 view2 = new View2(model);
		model.addView(view2);
		
		// create the window
		JPanel p = new JPanel(new GridLayout(2,1));
		frame1.getContentPane().add(p);
		p.add(view);
		p.add(view2);
		
		frame1.setPreferredSize(new Dimension(500,300));
		frame1.pack();
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setVisible(true);
	} 
}
