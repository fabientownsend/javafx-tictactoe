package fx;

import tictactoe.Party;

public class ClickEvent {
    private Move move;
    private Party party;
    private Game desktop;

    public ClickEvent(Move move, Party party, Game desktop) {
        this.move = move;
        this.party = party;
        this.desktop = desktop;
    }

    public void updateWindow(int idTile) {
        move.setNewMove(idTile);
        party.play();
        desktop.refreshGameUi();
    }
}
