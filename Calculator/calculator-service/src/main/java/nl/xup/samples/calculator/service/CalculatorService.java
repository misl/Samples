package nl.xup.samples.calculator.service;


/**
 * A service that describes the calculator interface. 
 * 
 * @author misl (Minto van der Sluis)
 */
public interface CalculatorService {

  /**
   * Performs the addition of both given addends and returning the sum.
   * The mathematical formula is: addend1 + addent2 = sum
   * 
   * @param addend1 the addend for the formula
   * @param addend2 the other addend for the formula
   * @return the sum of the addition.
   */
  long add( long addend1, long addend2 );
  
  /**
   * Performs the subtraction of the given minuend and subtrahend and
   * returning the difference. The mathematical formula is: 
   * menuend - subtrahend = difference
   *
   * @param menuend the menuend for the formula
   * @param subtrahend the subtrahend for the formula
   * @return the difference of the subtractiong.
   */
  long subtract( long minuend, long subtrahend );
  
  /**
   * Performs the multiplication of the given multiplier and multiplicand
   * and returning the product. The mathematical formula is: 
   * multiplier - multiplicand = product
   *
   * @param menuend the menuend for the formula
   * @param subtrahend the subtrahend for the formula
   * @return the product of the multiplication.
   */
  long multiply( long multiplier, long multiplicand );

  /**
   * Performs the division of the given dividend and divisor
   * and returning the quotient. The mathematical formula is: 
   * dividend : divisor = quotient
   *
   * @param dividend the dividend for the formula
   * @param divisor the divisor for the formula
   * @return the quotient of the division.
   */
  Quotient divide( long dividend, long divisor );
}
