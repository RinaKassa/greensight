@SuppressWarnings("all")
class AvoidStatementsNestedRuleCodeExample {
  void myMethod () {
    if (isNestedCompliant1) { 
      /* Compliant */
      if (isNestedCompliant2)
        /* Compliant 2 */
        throw new Exception("Statement but no block tree.");
    }
    if (isNested1) { 
      /* Nested 1 */
      if (isNested2) { 
        /* Nested 2 */
        for(int i = 0; i < 10; i++) { 
          /* Nested 3 */
          switch(0) {                         // Noncompliant
            case 0:
              /* Nested 4 */
              if (isNested4) {                // Noncompliant
                /* Nested 5 */
              }
              break;
            default:
              /* Nested 4 */
              try {                         // Noncompliant
                /* Nested 5 */
                int j = 0;
                int num = 5;
                int total = 0;
                while(j < 10) {              // Noncompliant
                  /* Nested 6 */
                  total = num - j;
                  j++;
                }
              } catch(Exception e) {        // Noncompliant
                /* Nested 5 */
                if (isNested6) {            // Noncompliant
                  /* Nested 6 */
                }
              }
          }
          if (isNested4_2) {                 // Noncompliant
            /* Nested 4 */
            int k = 0;        
            do {                            // Noncompliant
              /* Nested 5 */
              k++;
            } while(k < 10);

            Map<String, Integer> items = new HashMap<>();
            items.put("A", 10);
            items.put("B", 20);

            for (Map.Entry<String, Integer> entry : items.entrySet()) {                // Noncompliant
              /* Nested 5 */
              if (isNested6_2) {                 // Noncompliant
                /* Nested 6 */
              }
            }
          }
        }
      }
    }
  }
}