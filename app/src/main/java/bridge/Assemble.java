package bridge;

import android.util.Log;

// Concrete implementation 2 for bridge pattern
public class Assemble implements Workshop {
//    public Assemble()
//    {
//        Log.w("Assemble","Assemble constructor called");
//    }
    @Override
    public void work()
    {
        System.out.print(" And");
        System.out.println(" Assembled.");
    }
}
