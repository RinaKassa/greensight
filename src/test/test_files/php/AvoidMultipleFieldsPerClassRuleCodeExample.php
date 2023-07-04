@SuppressWarnings("all")
<?php

class LotsOfFields { // Noncompliant
    public $field1;
    public $field2;
    private $field3;
    protected $field4;
    public $field5;
    public $field6;
    public $field7;
    public $field8;
    public $field9;
    public $field10;
    public $field11;
    public $field12;
    public $field13;
    public $field14;
}
class RespectingThreshold { /* Compliant */
    public $field1;
    private $field2;
}
?>
