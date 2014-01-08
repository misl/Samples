package nl.xup.samples.calculator.simple;

import nl.xup.samples.calculator.service.Quotient;

/**
 * Simple implementation of the Quotient interface. 
 * 
 * @author misl (Minto van der Sluis)
 */
public class QuotientImpl implements Quotient {

  // -------------------------------------------------------------------------
  // Object Attributes
  // -------------------------------------------------------------------------
  
  private long quotient = 0L;
  private long remainder = 0L;

  // -------------------------------------------------------------------------
  // Constructors
  // -------------------------------------------------------------------------
  
  /**
   * Creates a new instance with the given quotient and remainder values.
   * 
   * @param quotient 
   * @param remainder
   */
  public QuotientImpl( long quotient, long remainder ) {
    this.quotient = quotient;
    this.remainder = remainder;
  }
  
  // -------------------------------------------------------------------------
  // Implementing Quotient
  // -------------------------------------------------------------------------

  /**
   * Gives the quotient of a division.
   */
  public long quotient() {
    return quotient;
  }
  
  /**
   * Gives the remainder of a division.
   */
  public long remainder() {
    return remainder;
  }

  // -------------------------------------------------------------------------
  // Overrides
  // -------------------------------------------------------------------------
  
  @Override
  public String toString() {
    return "" + quotient + " R " + remainder;
  }
}
