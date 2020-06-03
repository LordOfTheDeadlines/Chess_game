package Chess;

import javafx.scene.paint.Color;

public class Knight extends Chessman {
    public Knight(Color c) {
        super(c);
    }

    private void checkCeil(Ceiling ceil){
        if(!ceil.isFree() && ceil.getChMan().getColor()!=this.getColor())
            ceil.showStepsForEating();
        if(ceil.isFree())
            ceil.showStepsForMoving();
    }

    @Override
    void showSteps(int x, int y) {
        Ceiling ceil;
        if (x + 1 < 8 && y + 2 < 8) {
            ceil = Chessboard.getCeil(x + 1, y + 2);
            checkCeil(ceil);
        }

        if (x + 2 < 8 && y + 1 < 8) {
            ceil = Chessboard.getCeil(x + 2, y + 1);
            checkCeil(ceil);
        }

        if (x + 2 < 8 && y - 1 >= 0) {
            ceil = Chessboard.getCeil(x + 2, y - 1);
            checkCeil(ceil);
        }

        if (x + 1 < 8 && y - 2 >= 0) {
            ceil = Chessboard.getCeil(x + 1, y - 2);
            checkCeil(ceil);
        }

        if (x - 1 >= 0 && y - 2 >= 0) {
            ceil = Chessboard.getCeil(x - 1, y - 2);
            checkCeil(ceil);
        }

        if (x - 2 >= 0 && y - 1 >= 0) {
            ceil = Chessboard.getCeil(x - 2, y - 1);
            checkCeil(ceil);
        }

        if (x - 2 >= 0 && y + 1 < 8) {
            ceil = Chessboard.getCeil(x - 2, y + 1);
            checkCeil(ceil);
        }

        if (x - 1 >= 0 && y + 2 < 8) {
            ceil = Chessboard.getCeil(x - 1, y + 2);
            checkCeil(ceil);
        }
    }
}
