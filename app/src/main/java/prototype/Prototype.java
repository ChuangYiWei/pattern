package prototype;

public abstract class Prototype implements Cloneable {
//    public Prototype clone() throws CloneNotSupportedException{
//        return (Prototype) super.clone();
//    }

    public Object clone() throws CloneNotSupportedException
    {
        Object clone = null;
        clone = super.clone();
        return clone;
    }

//    public Object clone()
//    {
//        Object clone = null;
//        try
//        {
//            clone = super.clone();
//        }
//        catch (CloneNotSupportedException e)
//        {
//            e.printStackTrace();
//        }
//        return clone;
//    }
}
