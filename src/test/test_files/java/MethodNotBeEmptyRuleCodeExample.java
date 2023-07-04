@SuppressWarnings("all")
class MethodNotBeEmptyRuleCodeExample {
  public void doSomething() {} // Noncompliant

  public void doSomethingElse() {} // Noncompliant

  @Override
  public void doSomethingCompliant() {
    // Do nothing because of X and Y.
  }

  @Override
  public void doSomethingElseCompliant() {
    throw new UnsupportedOperationException();
  }

  abstract void abstractfunc();
}
