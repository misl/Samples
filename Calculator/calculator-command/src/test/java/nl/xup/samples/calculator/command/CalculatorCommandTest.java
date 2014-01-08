package nl.xup.samples.calculator.command;

import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import nl.xup.samples.calculator.service.CalculatorService;
import nl.xup.samples.calculator.service.Quotient;
import nl.xup.samples.calculator.simple.CalculatorServiceImpl;

import org.apache.felix.service.command.CommandSession;
import org.apache.karaf.shell.commands.basic.DefaultActionPreparator;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Test case for CalculatorCommand
 * 
 * @author Minto van der Sluis (misl)
 */
public class CalculatorCommandTest {

  // ------------------------------------------------------------------------
  // Class Attributes
  // ------------------------------------------------------------------------

  private CommandSession session;
  private CalculatorCommand command;
  private CalculatorService service;

  // ------------------------------------------------------------------------
  // Setup / teardown
  // ------------------------------------------------------------------------

  @Before
  public void setup() {
    session = Mockito.mock( CommandSession.class );
    Mockito.when( session.getConsole() ).thenReturn( System.out );

    service = new CalculatorServiceImpl();

    command = new CalculatorCommand();
    command.setCalculatorService( service );
  }

  // ------------------------------------------------------------------------
  // Test cases
  // ------------------------------------------------------------------------

  @Test
  public void testAddition() throws Exception {
    prepareCommand( command, Arrays.<Object> asList( 5, "+", 3 ) );

    Object obj = command.execute( session );

    assertThat( obj, is( instanceOf( Long.class ) ) );
    assertThat( Long.class.cast(obj), is( 8L ) );
  }

  @Test
  public void testSubtraction() throws Exception {
    prepareCommand( command, Arrays.<Object> asList( 5, "-", 3 ) );

    Object obj = command.execute( session );

    assertThat( obj, is( instanceOf( Long.class ) ) );
    assertThat( Long.class.cast(obj), is( 2L ) );
  }

  @Test
  public void testMultiplication() throws Exception {
    prepareCommand( command, Arrays.<Object> asList( 5, "*", 3 ) );

    Object obj = command.execute( session );

    assertThat( obj, is( instanceOf( Long.class ) ) );
    assertThat( Long.class.cast(obj), is( 15L ) );
  }

  @Test
  public void testDivision() throws Exception {
    prepareCommand( command, Arrays.<Object> asList( 5, ":", 3 ) );

    Object obj = command.execute( session );

    assertThat( obj, is( instanceOf( Quotient.class ) ) );
    assertThat( obj.toString(), is( "1 R 2" ) );
  }

  @Test
  public void testUnkownOperation() throws Exception {
    prepareCommand( command, Arrays.<Object> asList( 5, "!", 3 ) );

    Object obj = command.execute( session );

    assertThat( obj, is( nullValue() ) );
  }

  // ------------------------------------------------------------------------
  // Helper methods
  // ------------------------------------------------------------------------

  protected void prepareCommand( CalculatorCommand command, List<Object> params )
      throws Exception {
    DefaultActionPreparator preparator = new DefaultActionPreparator();
    preparator.prepare( command, session, params );
  }
}