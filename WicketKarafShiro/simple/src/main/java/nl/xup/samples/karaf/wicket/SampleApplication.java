/**
 * Copyright OPS4J
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may obtain
 * a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package nl.xup.samples.karaf.wicket;

import nl.xup.samples.karaf.wicket.pages.AccessDeniedPage;
import nl.xup.samples.karaf.wicket.pages.AdminPage;
import nl.xup.samples.karaf.wicket.pages.LoginPage;
import nl.xup.samples.karaf.wicket.pages.PublicPage;
import nl.xup.samples.karaf.wicket.pages.UserPage;

import org.apache.wicket.protocol.http.WebApplication;
import org.wicketstuff.shiro.annotation.AnnotationsShiroAuthorizationStrategy;
import org.wicketstuff.shiro.authz.ShiroUnauthorizedComponentListener;

public class SampleApplication extends WebApplication {
  
  // --------------------------------------------------------------------------
  // Constructors
  // --------------------------------------------------------------------------
  
  public SampleApplication() {
  }

  // --------------------------------------------------------------------------
  // Overrides
  // --------------------------------------------------------------------------

  @Override
  protected void init() {
    super.init();

    // Enable Shiro security
    AnnotationsShiroAuthorizationStrategy authz = new AnnotationsShiroAuthorizationStrategy();
    getSecuritySettings().setAuthorizationStrategy( authz );
    getSecuritySettings().setUnauthorizedComponentInstantiationListener(
        new ShiroUnauthorizedComponentListener( LoginPage.class, AccessDeniedPage.class, authz ) );

    mountPage("account/login", LoginPage.class);
//    mountPage("account/logout", LogoutPage.class);
    mountPage( "public", PublicPage.class );
    mountPage( "admin", AdminPage.class );
    mountPage( "user", UserPage.class );
  }

  @Override
  public Class<PublicPage> getHomePage() {
    return PublicPage.class;
  }

}
