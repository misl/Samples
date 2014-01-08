package nl.xup.samples.calculator.simple;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import nl.xup.samples.calculator.service.CalculatorService;
import nl.xup.samples.calculator.service.Quotient;

/**
 * Test cases for CalculatorServiceImpl. 
 * 
 * @author misl (Minto van der Sluis)
 */
public class CalculatorServiceImplTest {

  // ------------------------------------------------------------------------
  // Object Attributes
  // ------------------------------------------------------------------------

  private CalculatorService service;

  // ------------------------------------------------------------------------
  // Setup / teardown
  // ------------------------------------------------------------------------

  @Before
  public void createService() {
    service = new CalculatorServiceImpl();
  }

  // -------------------------------------------------------------------------
  // Test cases
  // -------------------------------------------------------------------------
  
  @Test
  public void testAddition() {
    long sum = service.add( 5L,  3L );

    assertThat( sum, is( 8L ) );
  }

  @Test
  public void testSubtraction() {
    long difference = service.subtract( 5L,  3L );

    assertThat( difference, is( 2L ) );
  }

  @Test
  public void testMultiplication() {
    long product = service.multiply( 5L,  3L );

    assertThat( product, is( 15L ) );
  }

  @Test
  public void testDivision() {
    Quotient quotient = service.divide( 5L,  3L );

    assertThat( quotient.quotient(), is( 1L ) );
    assertThat( quotient.remainder(), is( 2L ) );
  }
}
