
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

public class Lebensmittel extends Product {

  public Lebensmittel(long id, String name, double prize, double weight, int deliveryDays) {
    super(id, name, prize, weight, deliveryDays);
  }
  
  @Override
  public String toString() {
    return "Lebensmittel [" + super.toString() + "]";
  }

}


//---------------------------- Revision History ----------------------------
//$Log$
//
