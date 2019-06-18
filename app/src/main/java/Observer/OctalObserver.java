package Observer;

import android.util.Log;

public class OctalObserver extends Observer{

    public OctalObserver(Subject subject){
        this.subject = subject;
        this.test = 5;
        this.subject.attach(this);
    }

    public void Gettest() {
        Log.d("OctalObserver","test:" + test);
    }

    @Override
    public void update() {
        System.out.println( "Octal String: "
                + Integer.toOctalString( subject.getState() ) );
    }
}
