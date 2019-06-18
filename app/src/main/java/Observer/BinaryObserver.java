package Observer;

import android.util.Log;

public class BinaryObserver extends Observer{

    public BinaryObserver(Subject subject){
        this.subject = subject;
        this.test = 3;
        this.subject.attach(this);
    }
    public void Gettest() {
        Log.d("OctalObserver","test:" + test);
    }
    @Override
    public void update() {
        System.out.println( "Binary String: "
                + Integer.toBinaryString( subject.getState() ) );
    }
}
