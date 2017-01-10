package fx.scenes.board;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Tile extends Rectangle {

    public Tile(int x, int y, int width, int idTile) {
        setWidth(width);
        setHeight(width);
        relocate(x * width, y * width);
        setFill(Color.WHITE);
        setId("id_tile_" + idTile);

        setStroke(Color.BLACK);
        setStrokeWidth(5);
    }
}

