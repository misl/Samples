package nl.xup.samples.calculator.command;

import nl.xup.samples.calculator.service.CalculatorService;

import org.apache.karaf.shell.commands.Argument;
import org.apache.karaf.shell.commands.Command;
import org.apache.karaf.shell.console.OsgiCommandSupport;
import org.osgi.framework.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Special karaf shell command to do calculations in the shell.
 * 
 * @author Minto van der Sluis (misl)
 */
@Command( scope = "calculator", name = "calc", description = "Extremely simple calculator." )
public class CalculatorCommand extends OsgiCommandSupport {

  // -------------------------------------------------------------------------
  // Class attributes
  // -------------------------------------------------------------------------

  private static Logger logger = LoggerFactory.getLogger( CalculatorCommand.class );

  // -------------------------------------------------------------------------
  // Object attributes
  // -------------------------------------------------------------------------

  private CalculatorService calculatorService;

  // -------------------------------------------------------------------------
  // Command Arguments
  // -------------------------------------------------------------------------

  @Argument( index = 0, name = "operand1", description = "The first operand.", required = true, multiValued = false )
  private Long operand1;

  @Argument( index = 1, name = "operator", description = "The operator.", required = true, multiValued = false )
  private String operator;

  @Argument( index = 2, name = "operand2", description = "The second operand.", required = true, multiValued = false )
  private Long operand2;

  // -------------------------------------------------------------------------
  // NamedQueryCommand overrides
  // -------------------------------------------------------------------------

  @Override
  protected Object doExecute() throws Exception {
    try {
      if ( "+".equals( operator ) ) {
        return getCalculatorService().add( operand1, operand2 );
      } else if ( "-".equals( operator ) ) {
        return getCalculatorService().subtract( operand1, operand2 );
      } else if ( "*".equals( operator ) ) {
        return getCalculatorService().multiply( operand1, operand2 );
      } else if ( ":".equals( operator ) ) {
        return getCalculatorService().divide( operand1, operand2 );
      } else {
        throw new IllegalArgumentException( "Unknown operator!" );        
      }
    } catch( Exception ex ) {
      session.getConsole().println( ex.getMessage() );
      logger.warn( ex.getMessage(), ex );
    }
    
    return null;
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
