package sample;

import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Snake {
    int length;
    VBox snake;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public VBox getSnake() {
        return snake;
    }

    public void setSnake(VBox snake) {
        this.snake = snake;
    }

    Snake(){
        snake=new VBox();
        snake.getChildren().addAll(circle(),circle(),circle(),circle());
        snake.setLayoutY(400);
        length=4;
    }
    Circle circle(){
        Circle circle = new Circle();
        circle.setLayoutX(200);
        circle.setLayoutY(400);
        circle.setRadius(10);
        circle.setFill(Color.YELLOW);
        return circle;
    }
    void moveLeft(){
        getSnake().setLayoutX(getSnake().getLayoutX()-0.5);
    }
    void moveRight(){
        getSnake().setLayoutX(getSnake().getLayoutX()+0.5);
    }
    void tryEating(){

    }
    


}
