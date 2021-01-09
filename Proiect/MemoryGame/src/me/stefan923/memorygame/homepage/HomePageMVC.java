package me.stefan923.memorygame.homepage;

/**
 * Home page's MVC class
 *
 * @author  Popescu Stefan
 */
public class HomePageMVC {

    /**
     * HomePageMVC's constructor
     */
    public HomePageMVC() {
        HomePageModel model = new HomePageModel();
        HomePageView view = new HomePageView();
        HomePageController controller = new HomePageController(model, view);

        view.setVisible(true);
    }

}
