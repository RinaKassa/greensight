import java.math.BigInteger;
import java.math.BigDecimal;
import java.util.List;
@SuppressWarnings("all")
class NotUseConstructorForPrimitiveClassRuleCodeExample {
    void myMethod() {
        List list = new ArrayList<>();
        String empty = new String(); // Noncompliant
        String nonempty = new String("Hello world"); // Noncompliant
        Byte myByte = new Byte("1"); // Noncompliant
        Character myCharacter = new Character("a"); // Noncompliant
        Short myShort = new Short(1); // Noncompliant
        Long myLong = new Long(1); // Noncompliant
        Float myFloat = new Float(1.1); // Noncompliant
        Double myDouble = new Double(1.1); // Noncompliant
        Integer integer = new Integer(1); // Noncompliant
        Boolean bool = new Boolean(true); // Noncompliant
        BigInteger bigInteger1 = new BigInteger("3"); // Noncompliant
        BigInteger bigInteger2 = new BigInteger("9223372036854775807"); // Noncompliant
        BigInteger bigInteger3 = new BigInteger("111222333444555666777888999"); // Compliant, greater than Long.MAX_VALUE
        BigDecimal bigDecimal1 = new BigDecimal("3.3"); // Noncompliant
    }
}