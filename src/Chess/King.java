package Chess;

import javafx.scene.paint.Color;

public class King extends Chessman {
    public King(Color c) {
        super(c);
    }

    private void checkCeil(Ceiling ceil){
        if (!ceil.isFree()) {
            ceil.showSteps(this.getColor());
        }
        ceil.showSteps(this.getColor());
    }
    @Override
    void showSteps(int x, int y) {
        Ceiling ceil;
        if(x - 1 >= 0) {
            ceil = Chessboard.getCeil(x - 1, y);
            checkCeil(ceil);
        }

        if(x + 1 <= 7) {
            ceil = Chessboard.getCeil(x + 1, y);
            checkCeil(ceil);
        }

        if(y - 1 >= 0) {
            ceil = Chessboard.getCeil(x, y - 1);
            checkCeil(ceil);
        }

        if(y + 1 <= 7) {
            ceil = Chessboard.getCeil(x, y + 1);
            checkCeil(ceil);
        }

        if(x - 1 >= 0 && y - 1 >= 0) {
            ceil = Chessboard.getCeil(x - 1, y - 1);
            checkCeil(ceil);
        }

        if(x + 1 <= 7 && y - 1 >= 0) {
            ceil = Chessboard.getCeil(x + 1, y - 1);
            checkCeil(ceil);
        }

        if(x + 1 <= 7 && y + 1 <= 7) {
            ceil = Chessboard.getCeil(x + 1, y + 1);
            checkCeil(ceil);
        }

        if(x - 1 >= 0 && y + 1 <= 7) {
            ceil = Chessboard.getCeil(x - 1, y + 1);
            checkCeil(ceil);
        }
    }
}
