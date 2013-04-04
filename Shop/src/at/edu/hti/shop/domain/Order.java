package at.edu.hti.shop.domain;

import java.util.Collection;
import java.util.HashMap;

public class Order {
  
  private HashMap<Long,OrderLine> hmOrderLines = new HashMap<>();
  
  private IFinalPrizeCalc finalPrizeCalc;
	
	public Order() {
	  finalPrizeCalc = new ShippingCostCalc();
	}

	public void add(OrderLine line) {

		if (line == null) {
			return;
		}
		
		Product prod = line.getProduct();
		if (prod == null) {
		  return;
		}
		long prodID = prod.getId();
		
		if (!hmOrderLines.containsKey(prodID)) {
		  //new product, add as new line
		  hmOrderLines.put(prodID, line);
		} else {
		  //line with this product already exists, add qty
		  int qty = line.getAmount();
		  OrderLine existingLine = hmOrderLines.get(prodID);
		  existingLine.setAmount(existingLine.getAmount()+qty);
		}
	}
	
	public OrderLine getLine(long productID) {
	  return hmOrderLines.get(productID);
	}
	
	public Collection<OrderLine> getLines() {
	  return hmOrderLines.values();
	}
	
	public OrderLine removeLine(long productID) {
	  return hmOrderLines.remove(productID);
	}
	
	public OrderLine removeLine(OrderLine orderLine) {
	  return removeLine(orderLine.getProduct().getId());
	}
	
	
	public boolean containsProductType(Class<? extends Product> productType) {
	  for (OrderLine ol : hmOrderLines.values()) {
	    if (ol.getProduct().getClass().equals(productType)) {
	      return true;
	    }
	  }
	  return false;
	}
	
	public int size() {
	  return hmOrderLines.size();
	}
	
	public void setLineAmount(long productID, int amount) {
	  OrderLine line = getLine(productID);
	  if (line == null) {
	    return;
	  }
	  if (amount <= 0) {
	    removeLine(productID);
	  } else {
	    line.setAmount(amount);
	  }
	}
	
	public void setLineAmount(Product product, int amount) {
	  long productID = product.getId();
	  setLineAmount(productID, amount);
	}

	public double calcPrize() {
		double sum = 0;

		for (OrderLine line : hmOrderLines.values()) {
			sum += line.getProduct().getPrize() * line.getAmount();
		}
		
		sum = finalPrizeCalc.getFinalPrize(sum);
		
		return sum;
	}

	@Override
	public String toString() {
	
		return hmOrderLines.values() + " \n => " +calcPrize()+"\n\n";
	}
}
