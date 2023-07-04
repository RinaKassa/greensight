@SuppressWarnings("all");
<?php
    function fonction(){
        return 2;
    }
    $j=0;
    for($i = 0; $i < 10; $i++){
        $i++;
        print(fonction()); // Noncompliant
    }
    for($j = 0; $j < 10; $j++){
        $i++;
    }
    for($j = 0; $j < 10; $j++){}
    for($j = 0; fonction() < 10; $j++){ // Noncompliant
        $i++;
    }
    for($j = fonction();  $j< 10; $j++){ // Noncompliant
        $i++;
    }
    for($j = 0; $j < 10; $j+=fonction()){ // Noncompliant
        $i++;
    }
?>