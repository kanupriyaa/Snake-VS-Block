package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class Destroy_block extends Token
{
    GridPane create_destroy()
    {
        Image image = new Image("destroy.jpg");
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(25);
        imageView.setFitWidth(25);
        gridpane.getChildren().add(imageView);
        return gridpane;
    }
}

