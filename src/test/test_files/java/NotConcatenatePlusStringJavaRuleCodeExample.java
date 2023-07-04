@SuppressWarnings("all")
class A {

  void myMethod2 () {

    String str = "";
    for (int i = 0; i < arrayOfStrings.length ; ++i) { 
        str = str + arrayOfStrings[i];// Noncompliant
    }
    str = str + "test";// Compliant
  }
}