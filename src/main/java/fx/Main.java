package fx;

import fx.scenes.menu.MenuUi;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        // GameUi gameUi = new GameUi(builder -> stage.setScene(builder.getResultScene));
        MenuUi menuUi = new MenuUi(builder -> stage.setScene(builder.getGameScene()));
        stage.setScene(menuUi.getMenuScene());
        stage.show();

    }
}
