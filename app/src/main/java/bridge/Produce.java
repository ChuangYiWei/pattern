package bridge;

import android.util.Log;

// Concrete implementation 1 for bridge pattern
public class Produce implements Workshop {
//    public Produce()
//    {
//        Log.w("Produce","Produce constructor called");
//    }
    @Override
    public void work()
    {
        System.out.print("Produced");
    }
}
