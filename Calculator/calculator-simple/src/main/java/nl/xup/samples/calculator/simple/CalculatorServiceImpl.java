package nl.xup.samples.calculator.simple;

import nl.xup.samples.calculator.service.CalculatorService;
import nl.xup.samples.calculator.service.Quotient;

/**
 * A service that describes the calculator interface.
 * 
 * @author misl (Minto van der Sluis)
 */
public class CalculatorServiceImpl implements CalculatorService {

  // -------------------------------------------------------------------------
  // Implementing CalculatorService
  // -------------------------------------------------------------------------

  /**
   * {@inheritDoc}
   */
  public long add( long addend1, long addend2 ) {
    return addend1 + addend2;
  }

  /**
   * {@inheritDoc}
   */
  public long subtract( long minuend, long subtrahend ) {
    return minuend - subtrahend;
  }

  /**
   * {@inheritDoc}
   */
  public long multiply( long multiplier, long multiplicand ) {
    return multiplier * multiplicand;
  }

  /**
   * {@inheritDoc}
   */
  public Quotient divide( long dividend, long divisor ) {
    long quotient = dividend / divisor;
    long remainder = dividend % divisor;
    
    return new QuotientImpl( quotient, remainder );
  }
}
