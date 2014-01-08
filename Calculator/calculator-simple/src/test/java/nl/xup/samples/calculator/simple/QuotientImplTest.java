package nl.xup.samples.calculator.simple;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import nl.xup.samples.calculator.service.Quotient;

/**
 * Test case for QuotientImpl. 
 * 
 * @author misl (Minto van der Sluis)
 */
public class QuotientImplTest {

  // -------------------------------------------------------------------------
  // Test cases
  // -------------------------------------------------------------------------
  
  @Test
  public void testConstructor() {
    Quotient quotient = new QuotientImpl( 5, 3 );

    assertThat( quotient.quotient(), is( 5L ) );
    assertThat( quotient.remainder(), is( 3L ) );
  }
}
