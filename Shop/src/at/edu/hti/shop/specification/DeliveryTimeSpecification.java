
/** 
 * Copyright 2013 SSI Schaefer PEEM GmbH. All Rights reserved. 
 * <br /> <br />
 * 
 * $Id$
 * <br /> <br />
 *
 */

package at.edu.hti.shop.specification;

import at.edu.hti.shop.domain.OrderLine;
import at.edu.hti.shop.domain.Product;
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

public class DeliveryTimeSpecification<T extends OrderLine> extends AbstractSpecification<T> implements ISpecification<T> {
  
  private int deliveryDays;
  
  public DeliveryTimeSpecification(int deliveryDays) {
    this.deliveryDays = deliveryDays;
    System.out.println("maximum delivery days: "+deliveryDays);
  }

  @Override
  public boolean isSatisfiedBy(T candidate) {
    OrderLine ol = (OrderLine)candidate;
    System.out.println(ol.getProduct().getName()+" -> "+ol.getProduct().getDeliveryDays()+" Tage");
    if (ol.getProduct().getDeliveryDays() > deliveryDays) {
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
