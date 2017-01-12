package fx.scenes;

import fx.PlayerMove;
import fx.scenes.game.GameUi;
import tictactoe.Party;

public class ClickEvent {
    private PlayerMove move;
    private GameUi gameUi;
    private Party party;

    public ClickEvent(PlayerMove move, GameUi gameUi, Party party) {
        this.move = move;
        this.gameUi = gameUi;
        this.party = party;
    }

    public void updatePartyState(int idTile) {
        move.setNewMove(idTile);
        party.play();
        gameUi.update();
    }
}
