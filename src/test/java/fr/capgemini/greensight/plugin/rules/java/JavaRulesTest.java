package fr.capgemini.greensight.plugin.rules.java;

import fr.capgemini.greensight.plugin.rules.GreensightRuleList;
import fr.capgemini.greensight.plugin.rules.checks.java.TooManyLinesInOneFile;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.sonar.java.checks.verifier.CheckVerifier;
import org.sonar.plugins.java.api.JavaFileScanner;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class JavaRulesTest {
    /**
     * Make use of the new TestFactory in JUnit 5, create a new list with all java rules inside plugin.rules.checks.java
     * and test them with the function {@link JavaRulesTest#TestJavaRule(JavaFileScanner, File)}
     * Java test file name must be "[className]CodeExample.java"
     *
     * @return JUnit TestFactory collection
     */
    @TestFactory
    public List<DynamicTest> checkAllJavaRules() {
        // change if you want to move java test files folder
        String javaTestFolder = "src/test/test_files/java";

        // check if javaTestFolder exist
        assertTrue(Files.isDirectory(Paths.get(javaTestFolder)));

        List<DynamicTest> ret = new ArrayList<>();

        // for each java rule
        GreensightRuleList.getJavaRules().forEach(unknown -> {
            try {
                // gather the object default constructor
                Object obj = unknown.getConstructor().newInstance();

                // check if obj is a specific rule, allow set custom
                // threshold for example.
                if (obj instanceof TooManyLinesInOneFile) {
                    ((TooManyLinesInOneFile) obj).threshold = 10;
                }

                JavaFileScanner javaRule = (JavaFileScanner) obj;
                String className = javaRule.getClass().getSimpleName();

                // create File object that should point to the test file for this rule object
                File fi = new File(Paths.get(javaTestFolder, className + "CodeExample.java").toUri());

                // create dynamicTest and add it to test list
                ret.add(dynamicTest(className, () -> TestJavaRule(javaRule, fi)));
            } catch (Exception err) {
                System.err.println("checkAllJavaRules: " + err);
            }
        });

        return ret;
    }

    /**
     * Test rule against test file
     *
     * @param rule     Java rule
     * @param testFile relative path to test file
     */
    public void TestJavaRule(JavaFileScanner rule, File testFile) {
        // make sure your test file is named "[className]CodeExample.java"
        assertTrue(testFile.exists(), "File not found: " + testFile.getAbsolutePath());

        var checker = CheckVerifier.newVerifier();
        checker.withCheck(rule);
        checker.onFile(testFile.toString());
        checker.verifyIssues();
    }
}
