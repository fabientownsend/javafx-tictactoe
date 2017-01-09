package fx.scenes;

import fx.PlayerMove;
import tictactoe.Marks;
import tictactoe.players.Player;

public class JavaFxPlayer implements Player {
    private PlayerMove move;
    private final Marks mark;

    public JavaFxPlayer(PlayerMove move, Marks mark) {
        this.move = move;
        this.mark = mark;
    }

    public boolean isReady() {
        return move.hasChanged();
    }

    public int nextMove() {
        return move.getLastMove();
    }

    public Marks getMark() {
        return mark;
    }
}
