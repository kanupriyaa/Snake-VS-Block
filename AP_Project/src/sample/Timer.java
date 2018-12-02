package sample;
import java.util.concurrent.TimeUnit;
public class Timer implements Runnable
{
    @Override
    public void run()
    {
        Main.time_for_shield=1;
        System.out.printf("I m in");
        try {
            TimeUnit.SECONDS.sleep(5);

        }
        catch (Exception e){}
        Main.time_for_shield=0;
        System.out.println("I am out");

    }
}
