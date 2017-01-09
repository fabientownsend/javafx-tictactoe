package fx;

import fx.scenes.ui.MenuUi;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        MenuUi menuUi = new MenuUi(stage);
        stage.setScene(menuUi.getMenuScene());
        stage.show();
    }
}
