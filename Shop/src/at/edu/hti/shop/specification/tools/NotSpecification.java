
/** 
 * Copyright 2013 SSI Schaefer PEEM GmbH. All Rights reserved. 
 * <br /> <br />
 * 
 * $Id$
 * <br /> <br />
 *
 */

package at.edu.hti.shop.specification.tools;


/**
 * This is the class header. The first sentence (ending with "."+SPACE) is important,
 * because it is used summary in the package overview pages.<br />
 * <br />
 *
 *
 * @author  groissenberger
 * @version $Revision$
 */

public class NotSpecification<T> extends AbstractSpecification<T> implements ISpecification<T> {
  private ISpecification<T> spec;
  
  public NotSpecification(ISpecification<T> x) {
    spec = x;
  }

  public boolean isSatisfiedBy(T candidate) {
      return !spec.isSatisfiedBy(candidate);
  }
}


//---------------------------- Revision History ----------------------------
//$Log$
//
