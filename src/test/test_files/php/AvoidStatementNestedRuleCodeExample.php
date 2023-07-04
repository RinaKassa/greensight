@SuppressWarnings("all")
<?php

function myMethod () {
if (isNestedCompliant1) {
    /* Compliant */
if (isNestedCompliant2){}
    /* Compliant 2 */
}
    if (isNested1) {
        /* Nested 1 */
        if (isNested2) {
            /* Nested 2 */
            for($i = 0; $i < 10; $i++) {
                /* Nested 3 */
                switch(0) {
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
                            $j = 0;
                $num = 5;
                $total = 0;
                while(j < 10) {              // Noncompliant
                    /* Nested 6 */
                    $total = $num - $j;
                    $j++;
                }
              } catch(Exception $e) {        // Noncompliant
                        /* Nested 5 */
                        if (isNested6) {            // Noncompliant
                            /* Nested 6 */
                        }
                    }
                }
                if (isNested4_2) {                 // Noncompliant
                    /* Nested 4 */
                    $k = 0;
            do {                            // Noncompliant
                /* Nested 5 */
                $k++;
            } while($k < 10);

            for ($w=0; $w < 10; $w++) {                // Noncompliant
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
  ?>