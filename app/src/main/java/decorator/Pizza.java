package decorator;

// Abstract Pizza class (All classes extend
// from this)
public abstract class Pizza
{
    // it is an abstract pizza
    String description = "Unkknown Pizza";

    public String getDescription()
    {
        return description;
    }

    public abstract int getCost();
}
