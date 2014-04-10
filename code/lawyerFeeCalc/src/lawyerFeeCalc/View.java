package lawyerFeeCalc;

/*
 * this is a simple app helping a lawyer friend calculate the lawyer fee
 * 
 */


import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.*;	

class View extends JPanel implements IView {

	// the view's main user interface
	private JButton button; 
	private JTextField amount = new JTextField(10);
	
	// the model that this view is showing
	private Model model;
	
	View(Model model_) {
		// create the view UI
		button = new JButton("Submit");
		button.setMaximumSize(new Dimension(100, 50));
		button.setPreferredSize(new Dimension(100, 50));
		// a GridBagLayout with default constraints centres
		// the widget in the window
		
		
		this.setLayout(new GridBagLayout());
		
		this.add(amount, new GridBagConstraints());		
		this.add(button, new GridBagConstraints());
		// set the model 
		model = model_;
		
		// setup the event to go to the "controller"
		// (this anonymous class is essentially the controller)
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int inputAmount;
				try{
					inputAmount = Integer.parseInt(amount.getText());
					}catch (NumberFormatException e1){
						inputAmount = 0;
				}
				model.setAmount(inputAmount);
			}
		});	
	} 

	// IView interface 
	public void updateView() {
		System.out.println("View: updateView");
		//button.setText(Integer.toString(model.getCounterValue()));
	}
} 
