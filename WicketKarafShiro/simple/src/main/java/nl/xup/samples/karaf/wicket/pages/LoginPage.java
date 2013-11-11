package nl.xup.samples.karaf.wicket.pages;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.wicketstuff.shiro.component.LoginPanel;

public class LoginPage extends WebPage {

  private static final long serialVersionUID = 1L;

  public LoginPage() {
    super();
    add( new LoginPanel( "login", true ) );
  }

  public LoginPage( PageParameters pageParameters ) {
    super();
    add( new LoginPanel( "login", true ) );
  }
}
