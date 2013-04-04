
/** 
 * Copyright 2013 SSI Schaefer PEEM GmbH. All Rights reserved. 
 * <br /> <br />
 * 
 * $Id$
 * <br /> <br />
 *
 */

package at.edu.hti.shop.specification;

import at.edu.hti.shop.domain.Order;
import at.edu.hti.shop.domain.OrderLine;
import at.edu.hti.shop.specification.tools.AbstractSpecification;
import at.edu.hti.shop.specification.tools.ISpecification;


/**
 * This is the class header. The first sentence (ending with "."+SPACE) is important,
 * because it is used summary in the package overview pages.<br />
 * <br />
 *
 *
 * @author  groissenberger
 * @version $Revision$
 */

public class MaxWeightSpecification<T extends Order> extends AbstractSpecification<T> implements ISpecification<T> {
  
  double maxWeight;
  
  public MaxWeightSpecification(double maxWeight) {
    this.maxWeight = maxWeight;
    System.out.println("maximum order weight: "+maxWeight);
  }

  @Override
  public boolean isSatisfiedBy(T candidate) {
    Order order = (Order)candidate;
    double orderWeight = 0;
    for (OrderLine ol : order.getLines()) {
      orderWeight += ol.getAmount() * ol.getProduct().getWeight();
    }
    System.out.println("order has "+orderWeight+"kg");
    if (orderWeight > maxWeight) {
      System.out.println("möööp");
      return false;
    } else {
      return true;
    }
  }

}


//---------------------------- Revision History ----------------------------
//$Log$
//
