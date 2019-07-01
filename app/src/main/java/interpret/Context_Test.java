package interpret;

// 存放要解譯的語句
public class Context_Test {

    private String mContext;
    public Context_Test(String str)
    {
        mContext = str;
    }

    public String getContext()
    {
        return mContext;
    }
}