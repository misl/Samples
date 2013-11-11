package nl.xup.samples.karaf.wicket.pages;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.wicketstuff.shiro.ShiroConstraint;
import org.wicketstuff.shiro.annotation.ShiroSecurityConstraint;

@ShiroSecurityConstraint(constraint=ShiroConstraint.HasRole, value="user")
public class UserPage extends WebPage {

    private static final long serialVersionUID = 1L;

    public UserPage() {
        add(new Label("message", "Welcome to the user page."));
    }
}
