@SuppressWarnings("all")
class UseParseToConvertStringRuleExample {
    void myMethod () {

        String myNum = "12.2";

        float f = (new Float(myNum)).floatValue(); // Noncompliant
        double d = (new Double(myNum)).doubleValue(); // Noncompliant
        int i = (new Integer(myNum)).intValue(); // Noncompliant
        byte b = (new Byte(myNum)).byteValue(); // Noncompliant
        short s = (new Short(myNum)).shortValue(); // Noncompliant
        long l = (new Long(myNum)).longValue(); // Noncompliant

        String myNum2 = "12.2";

        float f2 = Float.parseFloat(myNum2); // compliant
    }
}