package lawyerFeeCalc;

/*
 * this is a simple app helping a lawyer friend calculate the lawyer fee
 * 
 */

import javax.swing.*;

import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.event.*;
import java.util.*;

class View2 extends JPanel implements IView {

	// the model that this view is showing
	private Model model;

	private JLabel output = new JLabel();
	private JLabel output2 = new JLabel();
	private JLabel output3 = new JLabel();
	private JButton button;
	
	View2(Model model_) {
		// create UI
		setBackground(Color.WHITE);
		setLayout(new FlowLayout(FlowLayout.LEFT));

		button = new JButton("Detail");
		
		// set the model
		model = model_;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(output);
		this.add(output2);
		this.add(output3);
		this.add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.detailButton();
			}
		});	
/*
		// setup the event to go to the "controller"
		// (this anonymous class is essentially the controller)
		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				model.incrementCounter();
			}
		}
		
				);
	*/
	}

	// IView interface
	public void updateView() {
		System.out.println("View2: updateView");
		// just displays an 'X' for each counter value
		int x = model.getAmount();
		if (x == 0) {
			output.setText("Please enter an amount then press Submit");
		} else {
			int min = model.getMin();
			int max= model.getMax();
			String outputLine1;
			String outputLine2;
			String outputLine3;
			if (model.getDetailStat()){
				outputLine1 = "Amount: " + model.getAmount();
				outputLine2 = "Minimum fee: "+model.getMinCalc()+" = "+ min;
				outputLine3 = "Maximum fee: "+model.getMaxCalc()+" = "+ max;
			}
			else{
				outputLine1 = "Amount: " + model.getAmount();
				outputLine2 = "Minimum fee: "+ min;
				outputLine3 = "Maximum fee: "+ max;
			}
			
			output.setText(outputLine1);
			output2.setText(outputLine2);
			output3.setText(outputLine3);
			
		}
	}
}
