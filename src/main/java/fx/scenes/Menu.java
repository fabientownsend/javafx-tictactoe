package fx.scenes;

import fx.Game;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import tictactoe.GameTypes;

public class Menu {
    private TextField boardSizeInput;
    private ComboBox comboBox;
    private Stage stage;
    Text textMenu = new Text();

    public Menu(Stage stage) {
        this.stage = stage;
        stage.setScene(createMenu());
        stage.sizeToScene();
        stage.show();
        textMenu.setId("textMenu");
    }

    private Scene createMenu() {
        this.boardSizeInput = new TextField();

        ObservableList<String> options = FXCollections.observableArrayList();
        for (GameTypes gameType : GameTypes.values()) {
            options.add(gameType.toString());
        }

        this.comboBox = new ComboBox(options);
        comboBox.getSelectionModel().selectFirst();

        Button submit = new Button("Submit");
        submit.setId("submit");
        submit.setOnMouseClicked(e -> submitMenu());

        HBox hb = new HBox();
        hb.getChildren().addAll(textMenu, boardSizeInput, comboBox, submit);
        return new Scene(hb);
    }

    private void submitMenu() {
        if (boardSizeInput.getText().isEmpty()) {
            displayGameScene(3);
        } else if (isValid(boardSizeInput.getText())) {
            int boardSize = Integer.parseInt(boardSizeInput.getText());
            displayGameScene(boardSize);
        } else {
            textMenu.setText("Unexpected value");
        }
    }

    private void displayGameScene(int boardSize) {
        Game game = new Game(boardSize, stringToGameType(comboBox.getValue().toString()));
        stage.setScene(game.getGameUi());
    }

    private boolean isValid(String text) {
        if (text.matches("[0-9]*")) {
            int num = Integer.parseInt(text);

            if (num > 0 && num < 5) {
                return true;
            }
        }
        return false;
    }


    private GameTypes stringToGameType(String type) {
        GameTypes game = GameTypes.HUMAN_VS_COMPUTER;

        for (GameTypes gameType : GameTypes.values()) {
            if (type.equals(gameType.toString())) {
                game = gameType;
            }
        }

        return game;
    }
}
