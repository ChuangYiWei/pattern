package interpret;

// 解譯第一個字母是小寫的語句的解譯器
public class ExpressionImplA implements Expression
{
    @Override
    public int interpret(String expression)
    {
        String str = expression.substring(1, expression.length());
        return Integer.valueOf(str) * 2;
    }
}
