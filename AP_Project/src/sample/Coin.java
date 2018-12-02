package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class Coin extends Token
{
    GridPane create_coin()
    {
        identifier= "coin";
        GridPane gridpane_coin = new GridPane();
        gridpane_coin.setLayoutX(rand(10,390));
        gridpane_coin.setLayoutY(10);
        Image image = new Image("coin.jpg");
        ImageView imageView_coin=new ImageView(image);
        imageView_coin.setFitHeight(20);
        imageView_coin.setFitWidth(20);
        gridpane_coin.getChildren().add(imageView_coin);
        return gridpane_coin;
    }

    public int rand(int min, int max) {
        return (int)(Math.random() * max + min);
    }
}
