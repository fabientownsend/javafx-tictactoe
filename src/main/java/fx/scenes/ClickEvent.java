package fx.scenes;

import fx.PlayerMove;
import fx.scenes.ui.GameUi;
import tictactoe.Party;

public class ClickEvent {
    private PlayerMove move;
    private Party party;
    private GameUi gameUi;

    public ClickEvent(PlayerMove move, Party party, GameUi gameUi) {
        this.move = move;
        this.party = party;
        this.gameUi = gameUi;
    }

    public void updatePartyState(int idTile) {
        move.setNewMove(idTile);
        party.play();
        gameUi.refresh();
    }
}
