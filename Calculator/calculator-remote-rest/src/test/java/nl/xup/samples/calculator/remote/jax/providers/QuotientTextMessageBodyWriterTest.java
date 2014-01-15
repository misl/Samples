package nl.xup.samples.calculator.remote.jax.providers;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.ws.rs.core.MediaType;

import nl.xup.samples.calculator.service.Quotient;
import nl.xup.samples.calculator.simple.QuotientImpl;

import org.junit.Test;

/**
 * Test cases for QuotientTextMessageBodyWriter. 
 * 
 * @author misl (Minto van der Sluis)
 */
public class QuotientTextMessageBodyWriterTest {

  // -------------------------------------------------------------------------
  // Test cases
  // -------------------------------------------------------------------------

  @Test
  public void testIsWriteable() {
    QuotientTextMessageBodyWriter quotientWriter = new QuotientTextMessageBodyWriter();
    
    assertThat( quotientWriter.isWriteable( String.class, null, null, MediaType.TEXT_XML_TYPE ), is( false ) );
    assertThat( quotientWriter.isWriteable( String.class, null, null, MediaType.TEXT_PLAIN_TYPE ), is( false ) );
    assertThat( quotientWriter.isWriteable( Quotient.class, null, null, MediaType.TEXT_XML_TYPE ), is( false ) );
    assertThat( quotientWriter.isWriteable( Quotient.class, null, null, MediaType.TEXT_PLAIN_TYPE ), is( true ) );
  }
  
  @Test
  public void testGetSize() {
    QuotientTextMessageBodyWriter quotientWriter = new QuotientTextMessageBodyWriter();
    
    assertThat( quotientWriter.getSize( new QuotientImpl( 1L, 1L ), Quotient.class, null, null, MediaType.TEXT_XML_TYPE ), is( -1L ) );
  }

  @Test
  public void testWriteTo() throws IOException {
    // Prepare
    QuotientTextMessageBodyWriter quotientWriter = new QuotientTextMessageBodyWriter();
    Quotient quotient = new QuotientImpl( 1L, 2L );
    ByteArrayOutputStream stream = new ByteArrayOutputStream();
    
    // Execute
    quotientWriter.writeTo( quotient, null, null, null, null, null, stream );
    
    assertThat( stream.toString(), is( "1 R 2" ) );
  }
}
