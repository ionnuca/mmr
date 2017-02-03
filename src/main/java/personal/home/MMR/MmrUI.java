package personal.home.MMR;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import personal.home.MMR.DAO.UserDao;
import personal.home.MMR.entities.User;

/**
 * This UI is the application entry point. A UI may either represent a browser
 * window (or tab) or some part of a html page where a Vaadin application is
 * embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is
 * intended to be overridden to add component to the user interface and
 * initialize non-component functionality.
 */
@Theme("mmrtheme")
@Widgetset("personal.home.MMR.MyAppWidgetset")
// @CDIUI("")
// @Title("Prosto title")
public class MmrUI extends UI {

	// @Inject
	// private CDIViewProvider viewProvider;

	// @Inject
	// private UserDao userDao;

	@Override
	protected void init(VaadinRequest vaadinRequest) {
		final VerticalLayout layout = new VerticalLayout();

		final TextField name = new TextField();
		name.setCaption("Type your name here:");

		Button button = new Button("Do not Click Me");
		button.addClickListener(e -> {

			UserDao dao = new UserDao();
			User vasea = new User();
			vasea.setUserName("Vasea12");
			vasea.setPassword("vasea12");
			dao.insertUser(vasea);
		});

		layout.addComponents(name, button);
		layout.setMargin(true);
		layout.setSpacing(true);

		setContent(layout);
	}

	@WebServlet(urlPatterns = "/*", name = "MmrUIServlet", asyncSupported = true)
	@VaadinServletConfiguration(ui = MmrUI.class, productionMode = false)
	public static class MmrUIServlet extends VaadinServlet {
	}
}
