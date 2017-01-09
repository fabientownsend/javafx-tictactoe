package fx;

import fx.scenes.GameUi;
import javafx.scene.Scene;
import tictactoe.Board;
import tictactoe.GameTypes;
import tictactoe.Party;
import tictactoe.players.Player;

public class Game {
    private GameUi gameUi;

    public Game(int boardSize, GameTypes gameType) {
        Move move = new Move();
        Board board = new Board(boardSize);
        Party party = createParty(move, board, gameType);
        ClickEvent clickEvent = new ClickEvent(move, party, this);
        this.gameUi = new GameUi(party, board, clickEvent);
    }

    private Party createParty(Move move, Board board, GameTypes gameTypes) {
        PlayerFactory playerFactory = new PlayerFactory(move, board);
        Player[] players = playerFactory.getPlayers(gameTypes);
        Party party = new Party(board, players[0], players[1]);
        party.play();
        return party;
    }

    public Scene getGameUi() {
        return gameUi.getScene();
    }

    public void refreshGameUi() {
        gameUi.refresh();
    }
}
