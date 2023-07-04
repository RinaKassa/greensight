@SuppressWarnings("all")
class VarNotIncrementOrDecrementUnusedRuleCodeExample {
  int myMethod() {
    int i = 0;
    int j = 0;

    i = i++; // Noncompliant



    return j++; // Noncompliant
  }
  void myMethodGood(){ // compliant
    for (int k = 0; k < 10; k++) {

    }
  }
}