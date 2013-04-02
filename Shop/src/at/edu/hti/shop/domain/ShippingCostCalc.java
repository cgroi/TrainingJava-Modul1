
/** 
 * Copyright 2013 SSI Schaefer PEEM GmbH. All Rights reserved. 
 * <br /> <br />
 * 
 * $Id$
 * <br /> <br />
 *
 */

package at.edu.hti.shop.domain;


/**
 * This is the class header. The first sentence (ending with "."+SPACE) is important,
 * because it is used summary in the package overview pages.<br />
 * <br />
 *
 *
 * @author  groissenberger
 * @version $Revision$
 */

public class ShippingCostCalc implements IFinalPrizeCalc {

  @Override
  public double getFinalPrize(double prize) {
    double shippingCost = 0;
    if (prize < 10) {
      shippingCost = 5;
    }
    System.out.println("sum is "+prize+", shipping cost "+shippingCost);
    
    return prize+shippingCost;
  }

}


//---------------------------- Revision History ----------------------------
//$Log$
//
