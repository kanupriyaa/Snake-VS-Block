package sample;

import java.util.concurrent.TimeUnit;

public class Timer_magnet implements Runnable
{
    @Override
    public void run()
    {
        Main.time_for_magnet=1;
        System.out.printf("I m in");
        try {
            TimeUnit.SECONDS.sleep(5);

        }
        catch (Exception e){}
        Main.time_for_magnet=0;
        System.out.println("I am out");

    }
}

