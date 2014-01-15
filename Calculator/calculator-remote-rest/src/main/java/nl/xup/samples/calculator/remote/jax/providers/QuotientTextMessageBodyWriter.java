package nl.xup.samples.calculator.remote.jax.providers;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

import nl.xup.samples.calculator.service.Quotient;

/**
 * Jax-rs Provider for writing graphs to output streams.
 * 
 * @author Minto van der Sluis
 */
@Provider
@Produces( { MediaType.TEXT_PLAIN } )
public class QuotientTextMessageBodyWriter implements MessageBodyWriter<Quotient> {

  // -------------------------------------------------------------------------
  // Implementing MessageBodyWriter
  // -------------------------------------------------------------------------

  public boolean isWriteable( Class<?> type, Type genericType, Annotation[] annotations,
      MediaType mediaType ) {
    return Quotient.class.isAssignableFrom( type ) && MediaType.TEXT_PLAIN_TYPE.equals( mediaType );
  }

  public long getSize( Quotient t, Class<?> type, Type genericType, Annotation[] annotations,
      MediaType mediaType ) {
    return -1;
  }

  public void writeTo( Quotient quotient, Class<?> type, Type genericType, Annotation[] annotations,
      MediaType mediaType, MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream )
      throws IOException {
    entityStream.write( quotient.toString().getBytes( "UTF-8" ) );
  }
}
