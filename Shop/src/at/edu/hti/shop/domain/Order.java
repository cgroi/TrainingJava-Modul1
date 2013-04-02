package at.edu.hti.shop.domain;

import java.util.ArrayList;

public class Order {
  
  private ArrayList<OrderLine> alOrderLines = new ArrayList<OrderLine>();
  
  private IFinalPrizeCalc finalPrizeCalc;

	private static final long serialVersionUID = 1L;
	
	public Order() {
	  finalPrizeCalc = new ShippingCostCalc();
	}

	public void add(OrderLine e) {

		if (e == null)
			return;

		alOrderLines.add(e);
	}
	
	public OrderLine getLine(int index) {
	  return alOrderLines.get(index);
	}
	
	private OrderLine removeLine(int index) {
	  return alOrderLines.remove(index);
	}
	
	public int size() {
	  return alOrderLines.size();
	}
	
	public void setLineAmount(int index, int amount) {
	  OrderLine line = getLine(index);
	  if (line == null) {
	    return;
	  }
	  if (amount <= 0) {
	    removeLine(index);
	  } else {
	    line.setAmount(amount);
	  }
	}

	public double calcPrize() {
		double sum = 0;

		for (OrderLine line : alOrderLines) {
			sum += line.getProduct().getPrize()* line.getAmount() ;
		}
		
		sum = finalPrizeCalc.getFinalPrize(sum);
		
		return sum;
	}

	@Override
	public String toString() {
	
		return alOrderLines + " \n => " +calcPrize()+"\n\n";
	}
}
