package nl.xup.samples.calculator.remote.soap;

import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response.Status;

import nl.xup.samples.calculator.service.CalculatorService;

import org.osgi.framework.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Rest interface to access the calculator service. 
 * 
 * @author Minto van der Sluis
 */
public class CalculatorSoapService {

  // -------------------------------------------------------------------------
  // Class attributes
  // -------------------------------------------------------------------------

  private static Logger logger = LoggerFactory.getLogger( CalculatorSoapService.class );

  // -------------------------------------------------------------------------
  // Object attributes
  // -------------------------------------------------------------------------

  private CalculatorService calculatorService;

  // -------------------------------------------------------------------------
  // Interface
  // -------------------------------------------------------------------------

  /**
   * Performs the addition of both given addends and returning the sum.
   * The mathematical formula is: addend1 + addent2 = sum
   * 
   * @param addend1 the addend for the formula
   * @param addend2 the other addend for the formula
   * @return the sum of the addition.
   */
  public long add( @PathParam( "addend1" ) long addend1, @PathParam( "addend2" ) long addend2 ) {
    long answer = 0L;
    try {
      answer = getCalculatorService().add( addend1, addend2 );
    } catch( Exception ex ) {
      logger.error( ex.getMessage(), ex );
      throw new WebApplicationException( ex, Status.INTERNAL_SERVER_ERROR );
    }

    return answer;
  }

  /**
   * Performs the subtraction of the given minuend and subtrahend and
   * returning the difference. The mathematical formula is: 
   * menuend - subtrahend = difference
   *
   * @param menuend the menuend for the formula
   * @param subtrahend the subtrahend for the formula
   * @return the difference of the subtractiong.
   */
  public long subtract( @PathParam( "minuend" ) long minuend, @PathParam( "subtrahend" ) long subtrahend ) {
    long answer = 0L;
    try {
      answer = getCalculatorService().subtract( minuend, subtrahend );
    } catch( Exception ex ) {
      logger.error( ex.getMessage(), ex );
      throw new WebApplicationException( ex, Status.INTERNAL_SERVER_ERROR );
    }

    return answer;
  }

  /**
   * Performs the multiplication of the given multiplier and multiplicand
   * and returning the product. The mathematical formula is: 
   * multiplier - multiplicand = product
   *
   * @param menuend the menuend for the formula
   * @param subtrahend the subtrahend for the formula
   * @return the product of the multiplication.
   */
  public long multiply( long multiplier, long multiplicand ) {
    long answer = 0L;
    try {
      answer = getCalculatorService().multiply( multiplier, multiplicand );
    } catch( Exception ex ) {
      logger.error( ex.getMessage(), ex );
      throw new WebApplicationException( ex, Status.INTERNAL_SERVER_ERROR );
    }

    return answer;
  }

  /**
   * Performs the division of the given dividend and divisor
   * and returning the quotient. The mathematical formula is: 
   * dividend : divisor = quotient
   *
   * @param dividend the dividend for the formula
   * @param divisor the divisor for the formula
   * @return the quotient of the division.
   */
  public String divide( long dividend, long divisor ) {
    String answer = null;
    try {
      answer = getCalculatorService().divide( dividend, divisor ).toString();
    } catch( Exception ex ) {
      logger.error( ex.getMessage(), ex );
      throw new WebApplicationException( ex, Status.INTERNAL_SERVER_ERROR );
    }

    return answer;
  }
  
  // -------------------------------------------------------------------------
  // Getters / Setters
  // -------------------------------------------------------------------------

  public CalculatorService getCalculatorService() {
    if( calculatorService == null ) {
      throw new ServiceException( "Calculator service not available" );
    }
    return calculatorService;
  }

  public void setCalculatorService( CalculatorService service ) {
    this.calculatorService = service;
  }
}