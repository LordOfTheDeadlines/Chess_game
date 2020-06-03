package Chess;

import javafx.scene.paint.Color;

public class Pawn extends Chessman {
    public boolean isFirstStep = true;

    public Pawn(Color c) {
        super(c);
    }

    @Override
    void showSteps(int x, int y) {
        Ceiling singleStep;
        Ceiling doubleStep;
        if (this.getColor() == Color.WHITE) {
            singleStep = Chessboard.getCeil(x-1,y);
            if (singleStep.isFree()) {
                singleStep.showStepsForMoving();
            }
            if (this.isFirstStep) {
                doubleStep = Chessboard.getCeil(x-2,y);
                if (doubleStep.isFree()) {
                    doubleStep.showStepsForMoving();
                }
            }
            if(y-1>=0){
                doubleStep = Chessboard.getCeil(x - 1, y - 1);
                if(!doubleStep.isFree() && doubleStep.getChMan().getColor()==Color.BLACK)
                    doubleStep.showStepsForEating();
            }
            if(y+1<=7){
                singleStep = Chessboard.getCeil(x - 1, y + 1);
                if(!singleStep.isFree() && singleStep.getChMan().getColor()==Color.BLACK)
                    singleStep.showStepsForEating();
            }

        }
        else {
            singleStep = Chessboard.getCeil(x+1,y);
            if (singleStep.isFree()) {
                singleStep.showStepsForMoving();
            }

            if (this.isFirstStep) {
                doubleStep = Chessboard.getCeil(x+2, y);
                if (doubleStep.isFree()) {
                    doubleStep.showStepsForMoving();
                }
            }
            if(y+1<=7){
                doubleStep = Chessboard.getCeil(x + 1, y + 1);
                if(!doubleStep.isFree() && doubleStep.getChMan().getColor()==Color.WHITE)
                    doubleStep.showStepsForEating();
            }
            if(y-1>=0){
                singleStep = Chessboard.getCeil(x + 1, y - 1);
                if(!singleStep.isFree() && singleStep.getChMan().getColor()==Color.WHITE)
                    singleStep.showStepsForEating();
            }
        }
    }
}


