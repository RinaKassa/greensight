@SuppressWarnings("all")
class LotsOfFields { // Noncompliant
    public int field1;
    public String field2;
    private boolean field3;
    protected char field4;
    public double field5;
    public Field field6;
    public Field field7;
    public Field field8;
    public Field field9;
    public Field field10;
    public Field field11;
    public Field field12;
    public Field field13;
    public Field field14;
}
@SuppressWarnings("all")
class RespectingThreshold { /* Compliant */
    public int field1;
    private String field2;
}