package fx;

import fx.scenes.game.GameUi;
import tictactoe.Party;

public class PartyAdapter {
    private boolean isStarted = false;
    private Party party;
    private GameUi gameUi;

    public void play() {
        if (isStarted && party.isCurrentPlayerReady()) {
            party.play();
            gameUi.update();
        }
    }

    public void setParty(Party party) {
        this.party = party;
    }

    public void start() {
        isStarted = true;
    }

    public void setGameUi(GameUi gameUi) {
        this.gameUi = gameUi;
    }
}
