package fr.capgemini.greensight.plugin.rules;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests for {@link GreensightRuleList}
 */
public class GreensightRuleListTest {

    // number of Java check
    public static final int JavaCheckCount = 24;

    // number of PHP check
    public static final int PhpCheckCount = 10;

    // number of Python check
    public static final int PythonCheckCount = 3;

    /**
     * Ensure the correct number of Checks are detected for each language
     * If you added/removed a check, please update the values above this comment
     */
    @Test
    public void testGreensightRuleList() {
        assertEquals(JavaCheckCount, GreensightRuleList.getJavaRules().size(), "Invalid number of Java checks");
        assertEquals(PhpCheckCount, GreensightRuleList.getPhpRules().size(), "Invalid number of PHP checks");
        assertEquals(PythonCheckCount, GreensightRuleList.getPythonRules().size(), "Invalid number of Python checks");
    }
}
