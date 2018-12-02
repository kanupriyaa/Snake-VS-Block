package sample;

import javafx.scene.layout.GridPane;

public abstract class Token

{
    GridPane gridpane;
    String identifier = "null";

    public GridPane getGridpane() {
        return gridpane;
    }

    public void setGridpane(GridPane gridpane) {
        this.gridpane = gridpane;
    }

    Token()
    {
        gridpane= new GridPane();
        gridpane.setLayoutX(rand(10, 390));
        gridpane.setLayoutY(10);
    }

    public int rand(int min, int max) {
        return (int)(Math.random() * max + min);
    }
}
