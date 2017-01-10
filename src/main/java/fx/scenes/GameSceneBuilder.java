package fx.scenes;

import fx.PlayerFactory;
import fx.PlayerMove;
import fx.scenes.game.GameUi;
import javafx.scene.Scene;
import tictactoe.Board;
import tictactoe.GameTypes;
import tictactoe.Party;
import tictactoe.players.Player;

public class GameSceneBuilder {
    private GameUi gameUi;
    private Party party;

    public GameSceneBuilder(int boardSize, GameTypes gameType) {
        PlayerMove move = new PlayerMove();
        Board board = new Board(boardSize);
        this.party = createParty(move, board, gameType);
        this.gameUi = new GameUi(party, board, move);
    }

    public void play() {
        party.play();
    }

    private Party createParty(PlayerMove move, Board board, GameTypes gameTypes) {
        PlayerFactory playerFactory = new PlayerFactory(move, board);
        Player[] players = playerFactory.getPlayers(gameTypes);
        Party party = new Party(board, players[0], players[1]);
        return party;
    }

    public Scene getGameScene() {
        return gameUi.getScene();
    }
}
