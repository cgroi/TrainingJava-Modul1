
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

public class ProductTypeSpecification<T extends OrderLine> extends AbstractSpecification<T> implements ISpecification<T> {
  
  private Class<? extends Product> productType;

  public ProductTypeSpecification(Class<? extends Product> productType) {
    this.productType = productType;
    System.out.println("productType: "+this.productType.getSimpleName());
  }
  
  @Override
  public boolean isSatisfiedBy(T candidate) {
    OrderLine ol = (OrderLine)candidate;
    Product prod = ol.getProduct();
    System.out.println(ol.getProduct().getName()+" -> "+prod.getClass().getSimpleName());
      
    if (productType.equals(prod.getClass())) {
      return true;
    } else {
      System.out.println("möööp");
      return false;
    }
  }

}


//---------------------------- Revision History ----------------------------
//$Log$
//
