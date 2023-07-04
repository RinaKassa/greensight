@SuppressWarnings("all")
class VarNotAssignValueUnnecessarilyRuleCodeExample {
  int myMethod() {
    int hours = 24;
    return hours; // Noncompliant
  } 

  int myMethodGood() {
    return 24;
  }
}