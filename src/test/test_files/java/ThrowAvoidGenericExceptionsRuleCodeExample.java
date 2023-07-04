@SuppressWarnings("all")
class ThrowAvoidGenericExceptionsRuleCodeExample {
  public void foo(String bar) throws Throwable {  // Noncompliant
    throw new RuntimeException("My Message"); // Noncompliant
  }
  public void fooCompliant(String bar) {
    throw new MyOwnRuntimeException("My Message");
  }
}
@SuppressWarnings("all")
public class MyOwnRuntimeException implements Serializable {
  private static final long serialVersionUID = -3042686055658047285L;
  private transient Object backtrace;
  @serial
  private String detailMessage;
}