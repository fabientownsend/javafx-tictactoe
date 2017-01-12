package fx;

public class PlayerMove {
    private int move = -1;
    private boolean hasChanged = false;

    public int getLastMove() {
        hasChanged = false;
        return move;
    }

    public void setNewMove(int newMove) {
        if (move != newMove) {
            move = newMove;
            hasChanged = true;
        }
    }

    public boolean hasChanged() {
        return hasChanged;
    }
}