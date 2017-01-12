package fx;

import fx.scenes.menu.MenuUi;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        PartyAdapter partyAdapter = new PartyAdapter();
        MenuUi menuUi = new MenuUi(builder -> stage.setScene(builder.getGameScene()));
        menuUi.setPartyAdapter(partyAdapter);
        stage.setScene(menuUi.getMenuScene());

        stage.show();

        new AnimationTimer() {
            @Override
            public void handle(long now) {
                partyAdapter.play();
            }
        }.start();
    }
}
