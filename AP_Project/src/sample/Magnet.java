package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class Magnet extends Token
{
    GridPane create_magnet()
    {
        identifier= "magnet";
        Image image = new Image("magnet.jpeg");
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(25);
        imageView.setFitWidth(25);
        gridpane.getChildren().add(imageView);
        return gridpane;
    }
}
