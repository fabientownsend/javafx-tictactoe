package fx.scenes.game;

import fx.scenes.ClickEvent;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import tictactoe.Marks;

public class BoardConverter {
    private final int TILE_SIZE = 100;
    private ClickEvent clickEvent;

    public BoardConverter(ClickEvent clickEvent) {
        this.clickEvent = clickEvent;
    }

    public Pane makeBoard(Marks[][] board) {
        Pane boardPane = new Pane();
        Group tiles = new Group();
        Group marks = new Group();

        boardPane.setPrefSize(board.length * TILE_SIZE, board.length * TILE_SIZE);
        boardPane.getChildren().addAll(tiles, marks);

        int idTile = 0;
        for (int y  = 0; y < board.length; y++) {
            for (int x = 0; x < board.length; x++) {
                Tile tile = new Tile(x, y, TILE_SIZE, idTile);
                int finalY = y;
                int finalX = x;
                tile.setOnMouseClicked(
                        e -> clickEvent.updatePartyState(getIdTile(board, finalY, finalX)));
                idTile++;
                makeTile(tiles, tile);

                Marks mark = board[x][y];
                if (mark != null) {
                    makeMark(board[x][y], marks, x, y);
                }
            }
        }

        return boardPane;
    }

    private int getIdTile(Marks[][] board, int finalY, int finalX) {
        return finalY  * board.length + finalX;
    }

    private void makeMark(Marks mark, Group marksGroup, int y, int x) {
        MarkFactory markPane = new MarkFactory(x, y, TILE_SIZE, mark);
        marksGroup.getChildren().add(markPane);
    }

    private void makeTile(Group tileGroup, Tile tile) {
        tileGroup.getChildren().add(tile);
    }
}
