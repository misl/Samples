package nl.xup.samples.karaf.wicket;

import javax.servlet.Filter;
import javax.servlet.ServletContext;

import org.apache.shiro.web.env.DefaultWebEnvironment;
import org.apache.shiro.web.env.EnvironmentLoader;
import org.apache.shiro.web.filter.mgt.FilterChainResolver;
import org.apache.shiro.web.mgt.WebSecurityManager;
import org.apache.shiro.web.servlet.AbstractShiroFilter;
import org.ops4j.pax.wicket.api.ConfigurableFilterConfig;
import org.ops4j.pax.wicket.api.FilterFactory;

public class SampleFilterFactory implements FilterFactory {

  private WebSecurityManager webSecurityManager;

  // --------------------------------------------------------------------------
  // Constructors
  // --------------------------------------------------------------------------

  public SampleFilterFactory() {
  }
  
  // --------------------------------------------------------------------------
  // Implementing FilterFactory
  // --------------------------------------------------------------------------

  public Filter createFilter( ConfigurableFilterConfig filterConfig ) {
    // Ensure shiro environment is part of the servlet context.
    ensureShiroEnvironmentInServletContext( filterConfig );

    return new InnerShiroFilter( getWebSecurityManager(), null );
  }

  // --------------------------------------------------------------------------
  // Getters / Setters
  // --------------------------------------------------------------------------

  public WebSecurityManager getWebSecurityManager() {
    if( webSecurityManager == null ) {
      throw new IllegalStateException( "Propety securityManager needs to be set." );
    }
    return webSecurityManager;
  }

  public void setWebSecurityManager( WebSecurityManager securityManager ) {
    this.webSecurityManager = securityManager;
  }

  // --------------------------------------------------------------------------
  // Private methods
  // --------------------------------------------------------------------------

  private void ensureShiroEnvironmentInServletContext( ConfigurableFilterConfig filterConfig ) {
    ServletContext context = filterConfig.getServletContext();

    // Add the shiro environment to the servlet context if not added before.
    if ( context.getAttribute( EnvironmentLoader.ENVIRONMENT_ATTRIBUTE_KEY ) == null ) {
      DefaultWebEnvironment environment = new DefaultWebEnvironment();
      environment.setSecurityManager(getWebSecurityManager());
      filterConfig.getServletContext().setAttribute(EnvironmentLoader.ENVIRONMENT_ATTRIBUTE_KEY, environment);
    }
  }
  
  // --------------------------------------------------------------------------
  // Inner classes
  // --------------------------------------------------------------------------

  /**
   * Ordinarily the {@code AbstractShiroFilter} must be subclassed to additionally perform configuration
   * and initialization behavior.  
   */
  private static final class InnerShiroFilter extends AbstractShiroFilter {

      protected InnerShiroFilter(WebSecurityManager webSecurityManager, FilterChainResolver resolver) {
          super();
          if (webSecurityManager == null) {
              throw new IllegalArgumentException("WebSecurityManager property cannot be null.");
          }
          setSecurityManager(webSecurityManager);
          if (resolver != null) {
              setFilterChainResolver(resolver);
          }
      }
  }
}
