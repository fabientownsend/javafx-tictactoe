package fx.scenes.menu;

import fx.scenes.GameSceneBuilder;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import tictactoe.GameTypes;

import java.util.function.Consumer;

public class MenuUi {
    private Consumer<GameSceneBuilder> callback;

    public MenuUi(Consumer<GameSceneBuilder> callback) {
        this.callback = callback;
    }

    public Scene getMenuScene() {
        return new Scene(createMenu());
    }

    private HBox createMenu() {
        TextField boardSizeInput = new TextField();
        Text errorMessage = createErrorMessageText();
        ComboBox gameTypesList = createListGameTypes();

        Button gameSettingSubmission = createSubmissionButton(
                boardSizeInput, errorMessage, gameTypesList);

        return  new HBox(errorMessage, boardSizeInput, gameTypesList, gameSettingSubmission);
    }

    private Text createErrorMessageText() {
        Text errorMessage = new Text();
        errorMessage.setId("textMenu");
        return errorMessage;
    }

    private Button createSubmissionButton(
            TextField boardSizeInput,
            Text errorMessage,
            ComboBox gameTypesList) {
        Button submit = new Button("Submit");
        submit.setId("submit");
        submit.setOnMouseClicked(e -> submitSettings(boardSizeInput, errorMessage, gameTypesList));
        return submit;
    }

    private ComboBox createListGameTypes() {
        ObservableList<String> options = FXCollections.observableArrayList();
        for (GameTypes gameType : GameTypes.values()) {
            options.add(gameType.toString());
        }

        ComboBox gameTypesComboBox = new ComboBox(options);
        gameTypesComboBox.getSelectionModel().selectFirst();
        return gameTypesComboBox;
    }

    private void submitSettings(TextField boardSizeInput, Text errorMessage, ComboBox gameTypesList) {
        if (boardSizeInput.getText().isEmpty()) {
            displayGameScene(3, gameTypesList);
        } else if (isValid(boardSizeInput.getText())) {
            int boardSize = Integer.parseInt(boardSizeInput.getText());
            displayGameScene(boardSize, gameTypesList);
        } else {
            errorMessage.setText("Unexpected value");
        }
    }

    private void displayGameScene(int boardSize, ComboBox gameTypesComboBox) {
        GameSceneBuilder gameSceneBuilder = new GameSceneBuilder(
                boardSize, getGameTypeSelected(gameTypesComboBox));
        gameSceneBuilder.play();

        callback.accept(gameSceneBuilder);
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

    private GameTypes getGameTypeSelected(ComboBox gameTypesComboBox) {
        String gameTypeSelected = gameTypesComboBox.getValue().toString();
        GameTypes game = GameTypes.HUMAN_VS_COMPUTER;

        for (GameTypes gameType : GameTypes.values()) {
            if (gameTypeSelected.equals(gameType.toString())) {
                game = gameType;
            }
        }

        return game;
    }
}
