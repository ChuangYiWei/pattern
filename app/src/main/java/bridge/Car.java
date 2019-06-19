package bridge;

import android.util.Log;

// Refine abstraction 1 in bridge pattern
public class Car extends Vehicle {
    public Car(Workshop workShop1, Workshop workShop2)
    {
        super(workShop1, workShop2);
        Log.w("Car","super call finish");
    }

    @Override
    public void manufacture()
    {
        System.out.print("Car ");
        workShop1.work();
        workShop2.work();
    }
}
