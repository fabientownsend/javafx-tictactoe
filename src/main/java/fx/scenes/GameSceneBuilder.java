package fx.scenes;

import fx.PartyAdapter;
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
    private Board board;
    private PlayerMove move;
    private PartyAdapter partyAdapter;

    public GameSceneBuilder(int boardSize, GameTypes gameType, PartyAdapter partyAdapter) {
        this.move = new PlayerMove();
        this.board = new Board(boardSize);
        this.partyAdapter = partyAdapter;

        this.party = createParty(move, board, gameType);
        this.gameUi = new GameUi(party, board, move);

        partyAdapter.setParty(party);
        partyAdapter.setGameUi(gameUi);
    }

    private Party createParty(PlayerMove move, Board board, GameTypes gameTypes) {
        PlayerFactory playerFactory = new PlayerFactory(move, board);
        Player[] players = playerFactory.getPlayers(gameTypes);
        Party party = new Party(board, players[0], players[1]);
        return party;
    }

    public Scene getGameScene() {
        partyAdapter.start();
        return gameUi.getScene();
    }
}
