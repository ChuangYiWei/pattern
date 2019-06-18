package Observer;

import android.util.Log;

public class HexaObserver extends Observer{

    public HexaObserver(Subject subject){
        this.subject = subject;
        this.test = 4;
        this.subject.attach(this);
    }
    public void Gettest() {
        Log.d("OctalObserver","test:" + test);
    }
    @Override
    public void update() {
        System.out.println( "Hex String: "
                + Integer.toHexString( subject.getState() ).toUpperCase() );
    }
}
