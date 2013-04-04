
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

public class AndSpecification<T> extends AbstractSpecification<T> implements ISpecification<T> {
  private ISpecification<T> spec1;
  private ISpecification<T> spec2;

  public AndSpecification(ISpecification<T> s1, ISpecification<T> s2) {
      spec1 = s1;
      spec2 = s2;
  }

  @Override
  public boolean isSatisfiedBy(T candidate) {
      return spec1.isSatisfiedBy(candidate) && spec2.isSatisfiedBy(candidate);
  }
}


//---------------------------- Revision History ----------------------------
//$Log$
//
