
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

public interface ISpecification<T> {
  
  boolean isSatisfiedBy(T candidate);
  
  public ISpecification<T> And(ISpecification<T> s2);
  
  public ISpecification<T> Or(ISpecification<T> s2);
  
  public ISpecification<T> Not();

}


//---------------------------- Revision History ----------------------------
//$Log$
//
