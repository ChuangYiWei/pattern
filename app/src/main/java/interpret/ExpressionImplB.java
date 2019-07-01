package interpret;

public class ExpressionImplB implements Expression
{
    @Override
    public int interpret(String expression)
    {
        String str = expression.substring(1, expression.length());
        return Integer.valueOf(str) / 2;
    }
}
