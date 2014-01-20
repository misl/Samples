package nl.xup.samples.calculator.remote.soap;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.when;

import javax.ws.rs.WebApplicationException;

import nl.xup.samples.calculator.service.CalculatorService;
import nl.xup.samples.calculator.simple.QuotientImpl;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.osgi.framework.ServiceException;

/**
 * Test cases for CalculatorRestService. 
 * 
 * @author misl (Minto van der Sluis)
 */
public class CalculatorSoapServiceTest {

  // ------------------------------------------------------------------------
  // Object Attributes
  // ------------------------------------------------------------------------

  private CalculatorSoapService soapService;

  // ------------------------------------------------------------------------
  // Setup / teardown
  // ------------------------------------------------------------------------

  @Before
  public void createService() {
    soapService = new CalculatorSoapService();
    soapService.setCalculatorService( Mockito.mock( CalculatorService.class ) );
  }

  // -------------------------------------------------------------------------
  // Test cases
  // -------------------------------------------------------------------------

  @Test
  public void testGetter() {
    assertThat( soapService.getCalculatorService(), is( notNullValue() ) );
  }
  
  @Test( expected=ServiceException.class )
  public void testGetterNotSet() {
    // Prepare
    soapService.setCalculatorService( null );
    
    // Execute
    soapService.getCalculatorService();
  }
  
  @Test
  public void testAddition() {
    // Prepare
    when( soapService.getCalculatorService().add( anyLong(), anyLong() ) ).thenReturn( 5L );
    
    // Execute
    long sum = soapService.add( 5L,  3L );

    // Verify
    assertThat( sum, is( 5L ) );
  }

  @Test( expected=WebApplicationException.class )
  public void testAdditionFailed() {
    // Prepare
    when( soapService.getCalculatorService().add( anyLong(), anyLong() ) ).thenThrow( new RuntimeException() );
    
    // Execute
    soapService.add( 5L,  3L );
  }

  @Test
  public void testSubtraction() {
    // Prepare
    when( soapService.getCalculatorService().subtract( anyLong(), anyLong() ) ).thenReturn( 2L );
    
    // Execute
    long difference = soapService.subtract( 5L,  3L );

    // Verify
    assertThat( difference, is( 2L ) );
  }

  @Test( expected=WebApplicationException.class )
  public void testSubtractionFailed() {
    // Prepare
    when( soapService.getCalculatorService().subtract( anyLong(), anyLong() ) ).thenThrow( new RuntimeException() );
    
    // Execute
    soapService.subtract( 5L,  3L );
  }

  @Test
  public void testMultiplication() {
    // Prepare
    when( soapService.getCalculatorService().multiply( anyLong(), anyLong() ) ).thenReturn( 2L );
    
    // Execute
    long product = soapService.multiply( 5L,  3L );

    // Verify
    assertThat( product, is( 2L ) );
  }

  @Test( expected=WebApplicationException.class )
  public void testMultiplicationFailed() {
    // Prepare
    when( soapService.getCalculatorService().multiply( anyLong(), anyLong() ) ).thenThrow( new RuntimeException() );
    
    // Execute
    soapService.multiply( 5L,  3L );
  }

  @Test
  public void testDivision() {
    // Prepare
    when( soapService.getCalculatorService().divide( anyLong(), anyLong() ) ).thenReturn( new QuotientImpl( 1L, 2L ) );
    
    // Execute
    String quotient = soapService.divide( 5L,  3L );

    // Verify
    assertThat( quotient, is( equalTo( "1 R 2" ) ) );
  }

  @Test( expected=WebApplicationException.class )
  public void testDivisionFailed() {
    // Prepare
    when( soapService.getCalculatorService().divide( anyLong(), anyLong() ) ).thenThrow( new RuntimeException() );
    
    // Execute
    soapService.divide( 5L,  3L );
  }
}
