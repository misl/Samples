package nl.xup.samples.karaf.wicket;

import org.apache.shiro.web.servlet.ShiroFilter;
import org.ops4j.pax.wicket.api.SuperFilter;
import org.ops4j.pax.wicket.api.WebApplicationFactory;

/**
 * Simple PaxWicket web application factory to create the WicketApplication
 * instance with an Apache Shiro superfilter.
 * 
 * @author Minto van der Sluis (misl)
 */
@SuperFilter(filter=ShiroFilter.class)
public class SampleWebApplicationFactory implements
    WebApplicationFactory<SampleApplication> {

  // -------------------------------------------------------------------------
  // Object attributes
  // -------------------------------------------------------------------------

  private Class<SampleApplication> wicketApplication;

  // -------------------------------------------------------------------------
  // Constructors
  // -------------------------------------------------------------------------

  public SampleWebApplicationFactory() {
  }

  public SampleWebApplicationFactory( Class<SampleApplication> wicketApplication ) {
    this.wicketApplication = wicketApplication;
  }

  // -------------------------------------------------------------------------
  // Implementing WebApplicationFactory
  // -------------------------------------------------------------------------

  /**
   * {@inheritDoc}
   */
  public Class<SampleApplication> getWebApplicationClass() {
    return wicketApplication;
  }
  
  /**
   * {@inheritDoc}
   */
  public void onInstantiation( SampleApplication application ) {
    
  }

  // -------------------------------------------------------------------------
  // Getters / Setters
  // -------------------------------------------------------------------------

  public void setWicketApplication( Class<SampleApplication> wicketApplication ) {
    this.wicketApplication = wicketApplication;
  }
}
