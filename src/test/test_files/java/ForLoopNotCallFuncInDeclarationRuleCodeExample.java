@SuppressWarnings("all")
class ForLoopNotCallFuncInDeclarationRuleCodeExample {
  void myMethod() {
    for (int i = myFuncInit(); i < myFuncExp(); myFuncUpdate(i)) {} // Noncompliant
    for (int j = myFuncInit(); j < 5; j++) {} // Noncompliant 
    for (String s = "abc"; s.length() > 0; s = s.substring(1)) {} // Noncompliant 
    for (int j = 0; j < 5; myFuncUpdate(j)) {} // Noncompliant 
    for (int i = myFuncInit(); i < 5; myFuncUpdate(i)) {} // Noncompliant
    for (int i = 0; i < myFuncExp(); myFuncUpdate(i)) {} // Noncompliant 
    for (int j = 0; j > 5; j--) {} 
    for (int i = 0; i < 5; ++i) {} 
  }
  int myFuncInit() {return 0;}
  int myFuncExp() {return 5;}
  int myFuncUpdate(int i) {return i++;}
}