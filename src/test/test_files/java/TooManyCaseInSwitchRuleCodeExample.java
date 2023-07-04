@SuppressWarnings("all")
class TooManyCaseInSwitchRuleCodeExample {
   void myMethod2 () {
  int choix=1;
  switch(choix){ // Noncompliant
       case 1: 
           System.out.println("Bonjour");
           break;
       case 2:
           System.out.println("Hello");
           break;
       case 3:
           System.out.println("Buenos dias");
           break;
       case 4:
           System.out.println("Hello");
           break;
       case 5:
           System.out.println("Buenos dias");
           break;
       case 6:
           System.out.println("Hello");
           break;
       case 7:
           System.out.println("Buenos dias");
           break;
       case 8:
           System.out.println("Hello");
           break;
       case 9:
           System.out.println("Buenos dias");
           break;
       case 10:
           System.out.println("Hello");
           break;
       case 11:
           System.out.println("Buenos dias");
           break;
       case 12:
           System.out.println("Hello");
           break;
       case 13:
           System.out.println("Buenos dias");
           break;
       case 14:
           System.out.println("Hello");
           break;
       case 15:
           System.out.println("Buenos dias");
           break;
       case 16:
           System.out.println("Hello");
           break;
       case 17:
           System.out.println("Buenos dias");
           break;
       case 18:
           System.out.println("Hello");
           break;
       case 19:
           System.out.println("Buenos dias");
           break;
       case 20:
           System.out.println("Hello");
           break;
       case 21:
           System.out.println("Buenos dias");
           break;
       case 22:
           System.out.println("Hello");
           break;
       case 23:
           System.out.println("Buenos dias");
           break;
       case 24:
           System.out.println("Hello");
           break;
       case 25:
           System.out.println("Buenos dias");
           break;
       case 26:
           System.out.println("Hello");
           break;   
       case 27:
           System.out.println("Buenos dias");
           break;
       case 28:
           System.out.println("Hello");
           break;
       case 29:
           System.out.println("Buenos dias");
           break;
       case 30:
           System.out.println("Hello");
           break;
       default:
           System.out.println("Choix incorrect");
           break;
    }
  }

   void myMethod () {
    int day = 4;
    switch (day) {
      case 1:
        System.out.println("Monday");
      break;
      case 2:
        tuesday();
        break;
      case 3:
        System.out.println("Wednesday");
        break;
      case 4:
        thursday();
        break;
      case 5:
        friday();
        break;
      case 6:
        System.out.println("Saturday");
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