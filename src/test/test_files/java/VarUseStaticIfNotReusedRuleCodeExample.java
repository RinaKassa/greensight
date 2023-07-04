@SuppressWarnings("all")
class VarUseStaticIfNotReusedRuleCodeExample {
    private final int counter0 = 0; // Noncompliant
    public final String letterA = "A"; // Noncompliant
    private static final int counter1 = 1;
    public static final String letterB = "B";
    
    myMethod(final int counter) {
        return counter;
    }
}