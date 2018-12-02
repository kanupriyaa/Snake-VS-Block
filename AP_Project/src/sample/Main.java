package sample;

import com.sun.glass.ui.Window;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main extends Application {
    public static int time_for_magnet=0;
    public static int time_for_shield=0;
    public int stop=0;
    AnimationTimer timer;
    Pane root = new Pane();
    List drop = new ArrayList();//all blocks
    List drop2 = new ArrayList();//walls
    List drop3  = new ArrayList();//balls
    List allTokens = new ArrayList();
    double mouseX;
    Snake S;
    double speed;
    double falling;
    int flag=0;
    Label coins;
    Label score;
    public Stage window;
    public static void main(String[] args) {
        launch();

    }
//    public void start(Stage window) throws Exception{
//        Parent root = FXMLLoader.load(getClass().getResource("Homepage.fxml"));
//        window.setTitle("Game");
//        window.setScene(new Scene(root, 391, 491));
//        window.show();
//
//    }
    @Override
    public void start(Stage window) throws Exception {

        speed = 100;
        falling = 2000;

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(falling), event -> {

//            speed += falling / 3000;
            drop.add(block());
            drop2.add(wall());

            Token token1 = new Coin();
            Token token2 = new Shield();
            Token token3 = new Destroy_block();
            Token token4 = new Magnet();
            Token token5 = new Ball();

            allTokens.add(((Coin) token1).create_coin());
            allTokens.add(((Shield) token2).create_Shield());
            allTokens.add(((Destroy_block) token3).create_destroy());
            allTokens.add(((Magnet) token4).create_magnet());
            allTokens.add(((Ball) token5).create_ball());
            for (int i = 0; i < allTokens.size()-11; i++) {
                allTokens.remove(0);

            }
//            for (int i = 1; i < 5; i++) {
//                ((GridPane)allTokens.get(allTokens.size()-i)).setLayoutX(rand(10,390));
//            }
//            System.out.println(allTokens.size());

            drop3.add(allTokens.get(allTokens.size()-rand(1,5)));
//            System.out.println(drop2.size());
            root.getChildren().add((Node)drop2.get(drop2.size() -1));
            root.getChildren().add((Node)drop3.get(drop3.size() -1));
            root.getChildren().add((Node)drop.get(drop.size() -1));
        }));

        timeline.setCycleCount(10000000);
        timeline.play();



        timer = new AnimationTimer() {

            @Override
            public void handle(long arg0) {
                gameUpdate(timeline);

            }

        };
        timer.start();
        S=new Snake();

        coins=new Label("0");
        coins.setLayoutX(450);
        coins.setLayoutY(0);
        coins.setPrefSize(50,50);
        coins.setTextFill(Color.BLACK);

        score=new Label("0");
        score.setLayoutX(10);
        coins.setLayoutY(10);
        coins.setPrefSize(50,50);
        coins.setTextFill(Color.BLACK);

        root.getChildren().addAll(S.getSnake(),coins,score);
        Scene scene = new Scene(root, 500, 800);
        scene.setFill(Color.WHITE);

        scene.setOnMouseMoved(e -> {
            mouseX = e.getX();
        });

        window.setScene(scene);
        window.show();


    }

    public Circle circle() {
        Circle circle = new Circle();
        circle.setLayoutX(200);
        circle.setLayoutY(400);
        circle.setRadius(10);
        circle.setFill(Color.YELLOW);
        return circle;
    }


    public VBox block() {
        ArrayList tem = new ArrayList();
        int num = rand(1,4);
        if (flag%3==0){
            num = 4;
        }
        flag++;
        //wall=wall();
        for (int a = 0; a<num;a++) {
            Rectangle R1 = new Rectangle();
            StackPane S1 = new StackPane();
            R1.setHeight(100);
            R1.setWidth(100);
            R1.setFill(Rang());
            Text t = new Text(Integer.toString(rand(1, 5)));
            S1.setMaxSize(100,100);
            S1.setMinSize(100,100);
            S1.getChildren().addAll(R1, t);
            tem.add(S1);
        }
        for (int a=0; a<5-num;a++){
            Region r = new Region();
            r.setMinSize(100,100);
            r.setMaxSize(100,100);
            tem.add(r);
        }
        HBox H1 = new HBox();
        Collections.shuffle(tem);
        for (int a = 0; a<5;a++){
            if(tem.get(a).getClass()==StackPane.class){
                H1.getChildren().add((StackPane)tem.get(a));
            }
            else if (tem.get(a).getClass()==Region.class){
                H1.getChildren().add((Region)tem.get(a));
            }
        }

        VBox V1=new VBox(H1);
        V1.setLayoutX(0);
        V1.setLayoutY(-100);

        return V1;

    }

    public Rectangle wall()
    {
        Rectangle wall=new Rectangle();
        wall.setHeight(200);
        wall.setWidth(8);
        wall.setLayoutY(-400);
        wall.setLayoutX(rand(0,4)*100);
        wall.setFill(Color.BLACK);
        return wall;
    }

    public Color Rang() {
        int x=rand(0,10);
        if(x==1)
            return Color.RED;
        else if(x==2)
            return Color.YELLOW;
        else if(x==3)
            return Color.PURPLE;
        else if(x==4)
            return (Color.ORANGE);
        else if(x==5)
            return (Color.RED);
        else if(x==6)
            return (Color.LIGHTBLUE);
        else if(x==7)
            return (Color.LIMEGREEN);
        else if(x==8)
            return (Color.MAGENTA);
        else if(x==9)
            return (Color.MAROON);
        else if(x==0)
            return (Color.AQUAMARINE);
        return Color.ORANGE;
    }

    public int rand(int min, int max) {
        return (int)(Math.random() * max + min);
    }
    public void Block_count(int less, Text text){
        for (int i = 0; i < less; i++) {
            text.setText(String.valueOf(Integer.parseInt(text.getText())-1));
//            System.out.println(text.getText());
            try {
                Thread.sleep(200);
            }
            catch (Exception e){

            }
        }
    }

    public void gameUpdate(Timeline timeline){

        // updating every block
        for(int i = 0; i < drop.size(); i++) {
//          System.out.println(drop.size());
            ((VBox) drop.get(i)).setLayoutY(((VBox) drop.get(i)).getLayoutY() +   speed / 150 );
//          System.out.println((((Circle) drop3.get(i)).getLayoutY()));
            //if get dropped into snake
            VBox temp = ((VBox) drop.get(i));
            HBox hb=(HBox)temp.getChildren().get(0);
            //System.out.println(temp.getLayoutY());
            if (temp.getLayoutY()>289.0 && temp.getLayoutY()<291){
                Double tcirx=S.getSnake().getLayoutX()/100;
                int cirx = (int)Math.ceil(tcirx)-1;
//                System.out.println(hb.getChildren().get(cirx).getClass());
                if (hb.getChildren().get(cirx).getClass()==StackPane.class){
                    timeline.pause();
                    int blocktext = Integer.parseInt(((Text)(((StackPane)(hb.getChildren().get(cirx))).getChildren().get(1))).getText());
                    Block_count(blocktext,((Text)((StackPane)(hb.getChildren().get(cirx))).getChildren().get(1)));
                    timeline.play();
                    hb.getChildren().remove(cirx);
                    Region r = new Region();
                    r.setMaxSize(100,100);
                    r.setMinSize(100,100);
                    hb.getChildren().add(cirx,r);
                    if (time_for_shield!=1) {
                        if (S.getSnake().getChildren().size() <= blocktext) {
                            root.getChildren().remove(S.getSnake());
                            try {
                                Label game_over = new Label("GAME OVER");
                                game_over.setLayoutX(200);
                                game_over.setLayoutY(200);
                                game_over.setPrefSize(500, 500);
                                game_over.setTextFill(Color.BLACK);
                                score.setText(Integer.toString(Integer.parseInt(score.getText())+S.getSnake().getChildren().size()));

                                root.getChildren().addAll(game_over);
                                //Thread.sleep(43567890);
                            } catch (Exception E) {
                                System.out.println("error");
                            }
                        } else {
                            for (int j = 0; j < blocktext; j++) {
                                S.getSnake().getChildren().remove(0);
                            }
                            score.setText(Integer.toString(Integer.parseInt(score.getText())+(blocktext)));
                        }
                    }
                }
            }
//            if((((VBox) drop.get(i)).getLayoutX() > Snake.getLayoutX() && ((VBox) drop.get(i)).getLayoutX() < Snake.getLayoutX() + 70) &&
//                    ((VBox) drop.get(i)).getLayoutY() >= 550	) {
//                System.out.println(((VBox)(drop.get(i))).getLayoutX());
//                System.out.println( Snake.getLayoutX());
//                root.getChildren().remove(((VBox) drop.get(i)));
//                drop.remove(i);
//            }
            //if missed remove
            else if(((VBox) drop.get(i)).getLayoutY() >= 800) {
                root.getChildren().remove(((VBox) drop.get(i)));
                drop.remove(i);
            }
        }

        //updating every wall
        int flag1=0;
        for (int i = 0; i < drop2.size(); i++) {
            Rectangle wall = ((Rectangle) drop2.get(i));
            ((Rectangle) drop2.get(i)).setLayoutY(((Rectangle) drop2.get(i)).getLayoutY() +   speed / 150 );
//            System.out.println(i+" "+((Rectangle)(drop2.get(i))).getLayoutY());
            if (((Rectangle)(drop2.get(i))).getLayoutY()>200 && ((Rectangle)(drop2.get(i))).getLayoutY()<400+S.getSnake().getChildren().size()*20){
                if ( S.getSnake().getLayoutX()-wall.getLayoutX()>-30 && S.getSnake().getLayoutX()-wall.getLayoutX()<10){
                    flag1=1;
                }

//                if (Math.abs(((Rectangle)(drop2.get(i))).getLayoutX()-Snake.getLayoutX()))
            }
        }
        //updating every ball
        for (int i = 0; i < drop3.size(); i++) {
//            System.out.println(((GridPane) drop3.get(i)).getChildren().get(0));
            ((GridPane) drop3.get(i)).setLayoutY(((GridPane) drop3.get(i)).getLayoutY() +   speed / 150 );
            GridPane temp=(GridPane) drop3.get(i);
            if (time_for_magnet==1){
                if (temp.getLayoutY()>400.0 && temp.getLayoutY()<402.0){

                }
            }
            if (temp.getLayoutY()>400.0 && temp.getLayoutY()<402.0 && (Math.abs(temp.getLayoutX()-S.getSnake().getLayoutX()))<25.0){
//                System.out.println("Difference- "+String.valueOf(Math.abs(temp.getLayoutX()-Snake.getLayoutX())));
                root.getChildren().remove((GridPane)drop3.get(i));
                if(drop3.get(i).equals(allTokens.get(allTokens.size()-1)))
                {
                   int snake_len=Integer.parseInt(((Label)((GridPane)drop3.get(i)).getChildren().get(1)).getText());
                   //System.out.println(snake_len);
                   for( int j=0;j<snake_len;j++)
                    {
                        S.getSnake().getChildren().add(circle());
                        System.out.println(j);
                    }


                }
                else if(drop3.get(i).equals(allTokens.get(allTokens.size()-2)))
                {
                    System.out.println("Magnet");
                    Timer_magnet time1 = new Timer_magnet();
                    Thread t =new Thread(time1);
                    t.start();
                    if(time_for_magnet == 1)
                    {

                    }

                }

                else if(drop3.get(i).equals(allTokens.get(allTokens.size()-3)))
                {
                    //System.out.println("Destroy block");

                    for(int j=0;j<root.getChildren().size();j++)
                    {
                        if(root.getChildren().get(j).getClass()==VBox.class)
                        {
                            if (root.getChildren().get(j)!=S.getSnake()) {
                                root.getChildren().remove(j);
                            }
                        }
                    }
                    drop.clear();
                }
                else if(drop3.get(i).equals(allTokens.get(allTokens.size()-4)))
                {
                    System.out.println("Shield");
                    Timer time = new Timer();
                    Thread t =new Thread(time);
                    t.start();

                }
                else if(drop3.get(i).equals(allTokens.get(allTokens.size()-5)))
                {
                 //   System.out.println("Coin");
                    coins.setText(Integer.toString(Integer.parseInt(coins.getText())+1));


                }
                System.out.println(drop3.size());
                drop3.remove(i);

            }
        }
        //removing every last wall
        if (drop2.size()>0){
            if (((Rectangle)drop2.get(0)).getLayoutY()>=800){
                root.getChildren().remove((Rectangle) drop2.get(0));
                drop2.remove(0);
            }
        }
        //removing every lst ball
        if (drop3.size()>0){
            if (((GridPane)drop3.get(0)).getLayoutY()>=780){
                root.getChildren().remove(drop3.get(0));
                drop3.remove(0);
            }
        }
        if (flag1==0) {
            if (mouseX-S.getSnake().getLayoutX()>0.5){
                S.moveRight();
            }
            else if (mouseX-S.getSnake().getLayoutX()<-0.5){
                S.moveLeft();
            }
            else {
                S.getSnake().setLayoutX(mouseX);
            }

        }
    }

}
