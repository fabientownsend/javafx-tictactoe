package fx.scenes.game;

import fx.PlayerMove;
import fx.scenes.ClickEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import tictactoe.Board;
import tictactoe.Party;

public class GameUi {
    private Party party;
    private Board board;
    private Button reset;
    private Label label;
    private BorderPane boarderPane;
    private BoardConverter boardConverter;

    public GameUi(Party party, Board board, PlayerMove move) {
        this.party = party;
        this.board = board;
        ClickEvent clickEvent = new ClickEvent(move, this, party);
        this.boardConverter = new BoardConverter(clickEvent);
    }

    public Scene getScene() {
        createResetButton();
        createTextDisplayer();
        this.boarderPane = new BorderPane();
        update();
        return new Scene(boarderPane);
    }

    private void createTextDisplayer() {
        label = new Label();
        label.setText("Welcome to Tic-Tac-Toe");
        label.setId("my_label");
    }

    private void createResetButton() {
        reset = new Button("Replay");
        reset.setId("reset");
        reset.setOnMouseClicked(e -> resetParty());
    }

    private void resetParty() {
        party.reset();
        update();
    }

    public void update() {
        boarderPane.setTop(updateMessage());
        boarderPane.setCenter(convertBoard());
        boarderPane.setBottom(resetButton());
    }

    private Pane convertBoard() {
        return boardConverter.makeBoard(board.getContent());
    }

    private Button resetButton() {
        if (party.isTie() || party.currentPlayerWon()) {
            reset.setVisible(true);
        } else {
            reset.setVisible(false);
        }

        return reset;
    }

    private Label updateMessage() {
        if (party.isTie()) {
            label.setText("It's a tie");
        } else if (party.currentPlayerWon()) {
            label.setText(party.getCurrentPlayerMark() + " win the party");
        } else {
            label.setText(party.getCurrentPlayerMark() + " turn");
        }

        return label;
    }
}
