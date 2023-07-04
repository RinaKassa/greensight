@SuppressWarnings("all")
class AvoidTernaryOperatorExample {
    void myMethod () {
        int i = 0;
        String output = i > 10 ? "Yes" : "No"; // Noncompliant
        String test = (i > 10 ? "Yes" : "No"); // Noncompliant
        String test2 = i > 10 ? "10" : i > 5 ? "5" : "0"; // Noncompliant
        String test3 = i > 10 ? "10" : (i > 5 ? "5" : "0"); // Noncompliant
    }
}