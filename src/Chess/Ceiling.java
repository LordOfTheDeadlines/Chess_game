package Chess;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Ceiling extends Group {
    public static final double size = 90;
    private Rectangle background;
    private Color color;
    private Chessman chMan;
    public static Ceiling currentCeil;
    public Position position;
    private static int turnCounter = 0;
    public static ArrayList<Ceiling> possibleSteps = new ArrayList<>();

    public Ceiling(Color color) {
        this.color = color;
        this.background = new Rectangle(size, size, color);
        this.getChildren().add(this.background);

        this.setOnMouseClicked((event) -> {
            if (possibleSteps.contains(this)) {
                Chessman chMan = currentCeil.chMan;
                if(!isCheckmate.test(this)){
                    currentCeil.chMan=null;
                    currentCeil.dropCurrentCeil();
                    turnCounter++;
                    this.setChman(chMan);
                    if(chMan instanceof Pawn)
                        ((Pawn)chMan).isFirstStep=false;
                    this.hideSteps();
                }
                else Chess.Game.win();
            }
            else if (!this.isFree()){
                if(!this.isFree()){
                    if (isWhiteTurn.test(turnCounter) && this.chMan.getColor() == Color.BLACK
                            || !isWhiteTurn.test(turnCounter) && this.chMan.getColor() == Color.WHITE)
                        return;
                    this.setCurrentCeil();
                } else {
                    if(currentCeil!=null)
                      currentCeil.dropCurrentCeil();
                    this.showSteps(this.chMan.getColor());
                }
            }
            }
        );
    }

    private void setCurrentCeil(){
        if(currentCeil!=null)
            currentCeil.dropCurrentCeil();
        currentCeil=this;
        this.getBackground.get().setFill(Color.DARKOLIVEGREEN);
        if(!this.isFree())
            this.chMan.showSteps(this.position.getX(),this.position.getY());
    }

    private void dropCurrentCeil() {
        currentCeil=null;
        this.getBackground.get().setFill(this.color);
        hideSteps();
    }

    public void setChman(Chessman chMan) {
        if (!this.isFree()) {
            this.getChildren().remove(this.chMan);
        }

        this.chMan = chMan;
        this.getChildren().add(chMan);
    }

    public Chessman getChMan(){
        return chMan;
    }

    public boolean isFree() {
        return this.chMan == null;
    }

    private Supplier<Rectangle> getBackground = ()-> this.background;

    private Predicate<Integer> isWhiteTurn= x -> x % 2 == 0;

    private Predicate<Ceiling> isCheckmate = ceiling -> ceiling.chMan instanceof King;

    public void showStepsForMoving() {
       this.getBackground.get().setFill(Color.YELLOW);
       possibleSteps.add(this);
    }

    public void showStepsForEating() {
        this.getBackground.get().setFill(Color.CORAL);
        possibleSteps.add(this);
    }

    public void showSteps(Color color) {
        if (this.isFree())
            this.showStepsForMoving();
        else if (this.chMan.getColor() != color)
            this.showStepsForEating();
    }

    public void hideSteps() {
        possibleSteps.clear();
       for(int i=0;i<8;i++)
           for(int j=0;j<8;j++){
               Ceiling ceiling=Chessboard.board[i][j];
               ceiling.getBackground.get().setFill(ceiling.color);
           }
    }
}
