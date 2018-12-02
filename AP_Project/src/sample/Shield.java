package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class Shield extends Token
{
    GridPane create_Shield()
    {
        identifier= "Shield";
        Image image = new Image("shield.jpg");
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(25);
        imageView.setFitWidth(25);
        gridpane.getChildren().add(imageView);
        return gridpane;
    }
}

