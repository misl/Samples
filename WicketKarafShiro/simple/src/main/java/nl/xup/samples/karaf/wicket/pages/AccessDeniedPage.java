package nl.xup.samples.karaf.wicket.pages;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.FeedbackPanel;

public class AccessDeniedPage extends WebPage {

  private static final long serialVersionUID = 1L;

  public AccessDeniedPage() {
    add( new FeedbackPanel( "feedback" ) );
    add( new BookmarkablePageLink<Void>( "loginLink", LoginPage.class ) );
  }
}
