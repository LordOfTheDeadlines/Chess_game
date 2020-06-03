package Chess;

import javafx.scene.paint.Color;

public class Queen extends Chessman {
    public Queen(Color c) {
        super(c);
    }

    @Override
    void showSteps(int x, int y) {
        lookDown(x,y);
        lookLeft(x,y);
        lookRight(x,y);
        lookUp(x,y);
        lookDownLeft(x,y);
        lookDownRight(x,y);
        lookUpLeft(x,y);
        lookUpRight(x,y);
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
}
