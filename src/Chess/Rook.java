package Chess;

import javafx.scene.paint.Color;

public class Rook extends Chessman {
    public Rook(Color c) {
        super(c);
    }

    public void lookUp(int x, int y){
        Ceiling ceil;
        for(int i = 1; i <= 7 && x - i >= 0; i++) {
            ceil = Chessboard.getCeil(x - i, y);
            if (!ceil.isFree()) {
                if(ceil.getChMan().getColor()!=this.getColor())
                    ceil.showStepsForEating();
                break;
            }
            ceil.showStepsForMoving();
        }
    }

    public void lookDown(int x, int y){
        Ceiling ceil;
        for(int i = 1; i <=7 && x + i <= 7; i++) {
            ceil = Chessboard.getCeil(x + i, y);
            if (!ceil.isFree()) {
                if(ceil.getChMan().getColor()!=this.getColor())
                    ceil.showStepsForEating();
                break;
            }
            ceil.showStepsForMoving();
        }
    }
    public void lookLeft(int x, int y){
        Ceiling ceil;
        for(int i = 1; i <=7 && y - i >= 0; ++i) {
            ceil = Chessboard.getCeil(x, y - i);
            if (!ceil.isFree()) {
                if(ceil.getChMan().getColor()!=this.getColor())
                    ceil.showStepsForEating();
                break;
            }
            ceil.showStepsForMoving();
        }
    }
    public void lookRight(int x, int y){
        Ceiling ceil;
        for(int i = 1; i <=7 && y + i <= 7; ++i) {
            ceil = Chessboard.getCeil(x, y + i);
            if (!ceil.isFree()) {
                if(ceil.getChMan().getColor()!=this.getColor())
                    ceil.showStepsForEating();
                break;
            }
            ceil.showStepsForMoving();
        }
    }
    @Override
    void showSteps(int x, int y) {
        lookDown(x,y);
        lookUp(x,y);
        lookLeft(x,y);
        lookRight(x,y);
    }
}
