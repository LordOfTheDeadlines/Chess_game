package Chess;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Game extends Application {
    public static Stage gameStage;
    private static Scene winScene;

    public static void main(String[] args) {
        launch();
    }

    public void start(Stage stage) {
        gameStage = stage;
        Chessboard board = new Chessboard();
        Scene game = new Scene(board, Ceiling.size*8, Ceiling.size*8);
        gameStage.setTitle("Chess Game");
        gameStage.setResizable(false);
        gameStage.setScene(game);
        Label winLabel = new Label("Победа!");
        VBox winBox = new VBox(40);
        winBox.setAlignment(Pos.CENTER);
        Button resetButton = new Button("Начать сначала");
        resetButton.setOnAction(e -> start(stage));
        winBox.getChildren().add(winLabel);
        winBox.getChildren().add(resetButton);
        winScene = new Scene(winBox, Ceiling.size*8, Ceiling.size*8, Color.BLACK);
        gameStage.show();
    }
    public static void win() {
        gameStage.setScene(winScene);
    }
}
