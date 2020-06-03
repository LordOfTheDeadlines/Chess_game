package Chess;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public abstract class Chessman extends Group {
    private Color color;

    public Chessman(Color color) {
        this.color = color;
        String strColor = "WHITE";
        if (color == Color.BLACK)
            strColor = "BLACK";

        Image img = new Image("/images/" + strColor + "_" + this.getClass().getSimpleName().toUpperCase() + ".png");
        ImageView imgView = new ImageView(img);
        imgView.setFitWidth(Ceiling.size);
        imgView.setFitHeight(Ceiling.size);
        this.getChildren().add(imgView);
    }

    abstract void showSteps(int x, int y);

    public Color getColor() {
        return this.color;
    }
}
