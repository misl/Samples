package nl.xup.samples.calculator.remote.rest;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.when;

import javax.ws.rs.WebApplicationException;

import nl.xup.samples.calculator.remote.rest.CalculatorRestService;
import nl.xup.samples.calculator.service.CalculatorService;
import nl.xup.samples.calculator.service.Quotient;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.osgi.framework.ServiceException;

/**
 * Test cases for CalculatorRestService. 
 * 
 * @author misl (Minto van der Sluis)
 */
public class CalculatorRestServiceTest {

  // ------------------------------------------------------------------------
  // Object Attributes
  // ------------------------------------------------------------------------

  private CalculatorRestService restService;

  // ------------------------------------------------------------------------
  // Setup / teardown
  // ------------------------------------------------------------------------

  @Before
  public void createService() {
    restService = new CalculatorRestService();
    restService.setCalculatorService( Mockito.mock( CalculatorService.class ) );
  }

  // -------------------------------------------------------------------------
  // Test cases
  // -------------------------------------------------------------------------

  @Test
  public void testGetter() {
    assertThat( restService.getCalculatorService(), is( notNullValue() ) );
  }
  
  @Test( expected=ServiceException.class )
  public void testGetterNotSet() {
    // Prepare
    restService.setCalculatorService( null );
    
    // Execute
    restService.getCalculatorService();
  }
  
  @Test
  public void testAddition() {
    // Prepare
    when( restService.getCalculatorService().add( anyLong(), anyLong() ) ).thenReturn( 5L );
    
    // Execute
    long sum = restService.add( 5L,  3L );

    // Verify
    assertThat( sum, is( 5L ) );
  }

  @Test( expected=WebApplicationException.class )
  public void testAdditionFailed() {
    // Prepare
    when( restService.getCalculatorService().add( anyLong(), anyLong() ) ).thenThrow( new RuntimeException() );
    
    // Execute
    restService.add( 5L,  3L );
  }

  @Test
  public void testSubtraction() {
    // Prepare
    when( restService.getCalculatorService().subtract( anyLong(), anyLong() ) ).thenReturn( 2L );
    
    // Execute
    long difference = restService.subtract( 5L,  3L );

    // Verify
    assertThat( difference, is( 2L ) );
  }

  @Test( expected=WebApplicationException.class )
  public void testSubtractionFailed() {
    // Prepare
    when( restService.getCalculatorService().subtract( anyLong(), anyLong() ) ).thenThrow( new RuntimeException() );
    
    // Execute
    restService.subtract( 5L,  3L );
  }

  @Test
  public void testMultiplication() {
    // Prepare
    when( restService.getCalculatorService().multiply( anyLong(), anyLong() ) ).thenReturn( 2L );
    
    // Execute
    long product = restService.multiply( 5L,  3L );

    // Verify
    assertThat( product, is( 2L ) );
  }

  @Test( expected=WebApplicationException.class )
  public void testMultiplicationFailed() {
    // Prepare
    when( restService.getCalculatorService().multiply( anyLong(), anyLong() ) ).thenThrow( new RuntimeException() );
    
    // Execute
    restService.multiply( 5L,  3L );
  }

  @Test
  public void testDivision() {
    // Prepare
    when( restService.getCalculatorService().divide( anyLong(), anyLong() ) ).thenReturn( new Quotient() {
      public long quotient() {
        return 1L;
      }

      public long remainder() {
        return 2L;
      }
    } );
    
    // Execute
    Quotient quotient = restService.divide( 5L,  3L );

    // Verify
    assertThat( quotient.quotient(), is( 1L ) );
    assertThat( quotient.remainder(), is( 2L ) );
  }

  @Test( expected=WebApplicationException.class )
  public void testDivisionFailed() {
    // Prepare
    when( restService.getCalculatorService().divide( anyLong(), anyLong() ) ).thenThrow( new RuntimeException() );
    
    // Execute
    restService.divide( 5L,  3L );
  }
}
