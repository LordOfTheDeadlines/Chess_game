package Chess;

import javafx.scene.paint.Color;

public class Bishop extends Chessman {
    public Bishop(Color c) {
        super(c);
    }

    private void lookDownLeft(int x, int y){
        Ceiling ceil;
        for(int i = 1; i < 8 && x + i <= 7 && y - i >= 0; ++i) {
            ceil = Chessboard.getCeil(x + i, y - i);
            if (!ceil.isFree()) {
                ceil.showSteps(this.getColor());
                break;
            }

            ceil.showSteps(this.getColor());
        }
    }
    private void lookDownRight(int x, int y){
        Ceiling ceil;
        for(int i = 1; i < 8 && x + i <= 7 && y + i <= 7; ++i) {
            ceil = Chessboard.getCeil(x + i, y + i);
            if (!ceil.isFree()) {
                ceil.showSteps(this.getColor());
                break;
            }

            ceil.showSteps(this.getColor());
        }
    }
    private void lookUpLeft(int x, int y){
        Ceiling ceil;
        for(int i = 1; i < 8 && x - i >= 0 && y - i >= 0; ++i) {
            ceil = Chessboard.getCeil(x - i, y - i);
            if (!ceil.isFree()) {
                ceil.showSteps(this.getColor());
                break;
            }

            ceil.showSteps(this.getColor());
        }
    }
    private void lookUpRight(int x, int y){
        Ceiling ceil;
        for(int i = 1; i < 8 && x - i >= 0 && y + i <= 7; ++i) {
            ceil = Chessboard.getCeil(x - i, y + i);
            if (!ceil.isFree()) {
                ceil.showSteps(this.getColor());
                break;
            }
            ceil.showSteps(this.getColor());
        }
    }
    @Override
    void showSteps(int x, int y) {
       lookUpRight(x,y);
       lookUpLeft(x,y);
       lookDownLeft(x,y);
       lookDownRight(x,y);
    }
}
