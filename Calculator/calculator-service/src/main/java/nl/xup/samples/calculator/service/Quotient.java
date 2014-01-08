package nl.xup.samples.calculator.service;

/**
 * Interface representing the quotient of a division. Giving access
 * to both the actual quotient and a possible remainder of the division. 
 * 
 * @author misl (Minto van der Sluis)
 */
public interface Quotient {

  /**
   * Gives the quotient of a division.
   */
  long quotient();
  
  /**
   * Gives the remainder of a division.
   */
  long remainder();
}
