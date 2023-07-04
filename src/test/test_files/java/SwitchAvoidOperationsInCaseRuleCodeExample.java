@SuppressWarnings("all")
class SwitchAvoidOperationsInCaseRuleCodeExample {
  void myMethod () {
    int day = 4;
    switch (day) {
      case 1: // Noncompliant
        System.out.println("Monday");
        System.out.println("Lundi");
        System.out.println("Lunes");
        System.out.println("Måndag");
      break;
      case 2:
        tuesday();
        break;
      case 3: // Noncompliant
        System.out.println("Wednesday");
        System.out.println("Mercredi");
        System.out.println("Miércoles");
        System.out.println("Onsdag");
        break;
      case 4:
        thursday();
        break;
      case 5:
        friday();
        break;
      case 6: // Noncompliant
        System.out.println("Saturday");
        System.out.println("Samedi");
        System.out.println("Sábado");
        System.out.println("Lördag");
        break;
      default:
        sunday();
        break;
    }
  }
  
  
  void tuesday() {
    System.out.println("Tuesday");
    System.out.println("Mardi");
    System.out.println("Martes");
    System.out.println("Tisdag");
  }
  
  void thursday() {
    System.out.println("Thursday");
    System.out.println("Jeudi");
    System.out.println("Jueves");
    System.out.println("Torsdag");
  }
  
  void friday() {
    System.out.println("Friday");
    System.out.println("Vendredi");
    System.out.println("Viernes");
    System.out.println("Fredag");
  }
  
  void sunday() {
    System.out.println("Sunday");
    System.out.println("Dimanche");
    System.out.println("Domingo");
    System.out.println("Söndag");
  }
}