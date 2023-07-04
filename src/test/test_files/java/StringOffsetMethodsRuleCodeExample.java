@SuppressWarnings("all")
class StringOffsetMethodsRuleCodeExample {
    String str = "Hello, my name is Eliott";

    void foo(){
        str.substring(3).indexOf("Eliott"); // Noncompliant

        str.substring(3).lastIndexOf("hey"); // Noncompliant
        str.substring(3).startsWith("H"); // Noncompliant
    }

    void fooPlus(){
        str.indexOf("m"); // compliant
    }
}