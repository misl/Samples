package nl.xup.samples.karaf.wicket.pages;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;

public class PublicPage extends WebPage {

    private static final long serialVersionUID = 1L;

    public PublicPage() {
      add(new Label("message", "Simple application demonstrating a combination of Wicket, Karaf and Shiro."));
      add(new BookmarkablePageLink<Void>("userLink", UserPage.class));
      add(new BookmarkablePageLink<Void>("adminLink", AdminPage.class));
    }
}
