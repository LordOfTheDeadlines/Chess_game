package Chess;

import javafx.scene.Group;
import javafx.scene.paint.Color;

public class Chessboard extends Group {
    public static Ceiling[][] board = new Ceiling[8][8];

    public Chessboard() {
        for(int x = 0; x < 8; x++) {
            for(int y = 0; y < 8; y++) {
                Color color = chooseColor(x,y);
                Ceiling ceiling = new Ceiling(color);
                ceiling.setTranslateX(y * Ceiling.size);
                ceiling.setTranslateY(x * Ceiling.size);
                ceiling.position=new Position(x,y);
                this.getChildren().add(ceiling);
                Chessman ch = chooseChessman(x,y);
                if(ch!=null) ceiling.setChman(ch);
                board[x][y]=ceiling;
            }
        }
    }

    private Chessman chooseChessman(int x, int y){
        if (x == 1)
            return new Pawn(Color.BLACK);

        if (x == 6)
            return new Pawn(Color.WHITE);

        if (x == 0) {
            if (y == 0 || y == 7)
                return new Rook(Color.BLACK);
            if (y == 1 || y == 6)
                return new Knight(Color.BLACK);
            if (y == 2 || y == 5)
                return new Bishop(Color.BLACK);
            if (y == 3)
                return new Queen(Color.BLACK);
            if (y == 4)
                return new King(Color.BLACK);
        }
        if (x == 7) {
            if (y == 0 || y == 7)
                return new Rook(Color.WHITE);
            if (y == 1 || y == 6)
                return new Knight(Color.WHITE);
            if (y == 2 || y == 5)
                return new Bishop(Color.WHITE);
            if (y == 3)
                return new Queen(Color.WHITE);
            if (y == 4)
                return new King(Color.WHITE);
        }
        return null;
    }
    private Color chooseColor(int x, int y){
        if ((x + y) % 2 == 0)
            return Color.WHITE;
        else return Color.BLACK;
    }

    public static Ceiling getCeil(int x, int y) {
        return board[x][y];
    }
}
