package sample;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.control.Label;

public class Ball extends Token
{
    GridPane create_ball()
    {
        Circle ball = circle();
        ball.setLayoutX(rand(10,390));
        ball.setLayoutY(10);
        ball.setFill(Color.YELLOW);
        gridpane.getChildren().add(ball);
        Label number=new Label();
        number.setText(Integer.toString(rand(1,5)));
        gridpane.getChildren().add(number);

        return gridpane;
    }

    public int rand(int min, int max) {
        return (int)(Math.random() * max + min);
    }

    public Circle circle() {
        Circle circle = new Circle();
        circle.setLayoutX(200);
        circle.setLayoutY(400);
        circle.setRadius(10);
        circle.setFill(Color.YELLOW);
        return circle;
    }
}
