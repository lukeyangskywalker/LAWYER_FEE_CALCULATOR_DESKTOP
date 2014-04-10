package lawyerFeeCalc;

/*
 * this is a simple app helping a lawyer friend calculate the lawyer fee
 * 
 */

import java.util.ArrayList;


// View interface
interface IView {
	public void updateView();
}

public class Model {
	// the data in the model, just a counter
	private int myAmount;

	private String minCalc = "";
	private String maxCalc = "";

	public Boolean detail = false;
	
	int min;
	int max;

	// all views of this model
	private ArrayList<IView> views = new ArrayList<IView>();

	// set the view observer
	public void addView(IView view) {
		views.add(view);
		// update the view to current state of the model
		notifyObservers();
	}
	
	// set the detail
	public void detailButton(){
		if (detail)
			detail = false;
		else
			detail = true;
		notifyObservers();
	}
	
	public boolean getDetailStat(){
		return detail;
	}
	
	public int getAmount() {
		return myAmount;
	}

	private int calcMin() {
		int retV = 0;
		int orgV = myAmount;
		String retStr;

		// 1w
		if (orgV <= 10000) {
			retStr = "2500";
			minCalc = retStr;
			return 2500;
		} else {
			retStr = "2500";
			retV += 2500;
			orgV = orgV - 10000;
		}

		// 10w
		if (orgV <= 100000) {
			retV += orgV * 0.04;
			retStr += " + " + (orgV * 0.04);
			minCalc = retStr;
			return retV;
		} else {
			retV += 100000 * 0.04;
			retStr += " + " + (100000 * 0.04);
			orgV = orgV - 100000;
		}

		// 50w
		if (orgV <= 500000) {
			retV += orgV * 0.03;
			retStr += " + " + (orgV * 0.03);
			minCalc = retStr;
			return retV;
		} else {
			retV += 500000 * 0.03;
			retStr += " + " + (500000 * 0.03);
			orgV = orgV - 500000;
		}

		// 100w
		if (orgV <= 1000000) {
			retV += orgV * 0.025;
			retStr += " + " + (orgV * 0.025);
			minCalc = retStr;
			return retV;
		} else {
			retV += 1000000 * 0.025;
			retStr += " + " + (1000000 * 0.025);
			orgV = orgV - 1000000;
		}

		// 500w
		if (orgV <= 5000000) {
			retV += orgV * 0.02;
			retStr += " + " + (orgV * 0.02);
			minCalc = retStr;
			return retV;
		} else {
			retV += 5000000 * 0.02;
			retStr += " + " + (5000000 * 0.02);
			orgV = orgV - 5000000;
		}

		// 1000w
		if (orgV <= 10000000) {
			retV += orgV * 0.015;
			retStr += " + " + (orgV * 0.015);
			minCalc = retStr;
			return retV;
		} else {
			retV += 10000000 * 0.015;
			retStr += " + " + (10000000 * 0.015);
			orgV = orgV - 10000000;
		}

		// 1y
		if (orgV <= 100000000) {
			retV += orgV * 0.007;
			retStr += " + " + (orgV * 0.007);
			minCalc = retStr;
			return retV;
		} else {
			retV += 100000000 * 0.007;
			retStr += " + " + (100000000 * 0.007);
			orgV = orgV - 100000000;
		}

		// >1y
		retV += orgV * 0.005;
		retStr += " + " + (orgV * 0.005);

		return retV;
	}

	// TODO clean up!
	// the following code is hard coded to the max.. 
	// well think of it as hackathon style coding
	
	private int calcMax() {
		int retV = 0;
		int orgV = myAmount;
		String retStr;

		// 1w
		if (orgV <= 10000) {
			retStr = "2500";
			maxCalc = retStr;
			return 2500;
		} else {
			retStr = "2500";
			retV += 2500;
			orgV = orgV - 10000;
		}

		// 10w
		if (orgV <= 100000) {
			retV += orgV * 0.07;
			retStr += " + " + (orgV * 0.07);
			maxCalc = retStr;
			return retV;
		} else {
			retV += 100000 * 0.07;
			retStr += " + " + (100000 * 0.07);
			orgV = orgV - 100000;
		}

		// 50w
		if (orgV <= 500000) {
			retV += orgV * 0.06;
			retStr += " + " + (orgV * 0.06);
			maxCalc = retStr;
			return retV;
		} else {
			retV += 500000 * 0.06;
			retStr += " + " + (500000 * 0.06);
			orgV = orgV - 500000;
		}

		// 100w
		if (orgV <= 1000000) {
			retV += orgV * 0.05;
			retStr += " + " + (orgV * 0.05);
			maxCalc = retStr;
			return retV;
		} else {
			retV += 1000000 * 0.05;
			retStr += " + " + (1000000 * 0.05);
			orgV = orgV - 1000000;
		}

		// 500w
		if (orgV <= 5000000) {
			retV += orgV * 0.04;
			retStr += " + " + (orgV * 0.04);
			maxCalc = retStr;
			return retV;
		} else {
			retV += 5000000 * 0.04;
			retStr += " + " + (5000000 * 0.04);
			orgV = orgV - 5000000;
		}

		// 1000w
		if (orgV <= 10000000) {
			retV += orgV * 0.03;
			retStr += " + " + (orgV * 0.03);
			maxCalc = retStr;
			return retV;
		} else {
			retV += 10000000 * 0.03;
			retStr += " + " + (10000000 * 0.03);
			orgV = orgV - 10000000;
		}

		// 1y
		if (orgV <= 100000000) {
			retV += orgV * 0.02;
			retStr += " + " + (orgV * 0.02);
			maxCalc = retStr;
			return retV;
		} else {
			retV += 100000000 * 0.02;
			retStr += " + " + (100000000 * 0.02);
			orgV = orgV - 100000000;
		}

		// >1y
		retV += orgV * 0.005;
		retStr += " + " + (orgV * 0.005);

		return retV;
	}

	public int getMin() {
		min = calcMin();
		return min;
	}

	public int getMax() {
		max = calcMax();
		return max;
	}

	public String getMinCalc() {
		return minCalc;
	}
	public String getMaxCalc() {
		return maxCalc;
	}
	
	public void setAmount(int amount) {
		this.myAmount = amount;
		System.out.println("Model: calculating amount: " + myAmount);
		notifyObservers();
	}

	// notify the IView observer
	private void notifyObservers() {
		for (IView view : this.views) {
			System.out.println("Model: notify View");
			view.updateView();
		}
	}

	public void preProcess(char[][] matrix) {
		// TODO Auto-generated method stub
		
	}
}
