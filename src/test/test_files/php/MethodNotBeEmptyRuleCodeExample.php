@SuppressWarnings("all");
<?php
function printTips($sus) {} //Noncompliant
function funWithBody(){
    $notSus = "hello";
}

class Foo {

    function aMemberFunc() {} //Noncompliant
    function funWithBody2(){
        $notSus2 = "hello";
    }
}
?>