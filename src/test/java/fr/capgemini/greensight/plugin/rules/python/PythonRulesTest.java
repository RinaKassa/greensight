package fr.capgemini.greensight.plugin.rules.python;

import fr.capgemini.greensight.plugin.rules.GreensightRuleList;
import fr.capgemini.greensight.plugin.rules.java.JavaRulesTest;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.sonar.plugins.java.api.JavaFileScanner;
import org.sonar.plugins.python.api.PythonCheck;
import org.sonar.python.checks.utils.PythonCheckVerifier;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

/**
 * Same logic as {@link JavaRulesTest}
 */
public class PythonRulesTest {

    @TestFactory
    public List<DynamicTest> checkAllPythonRules() {
        // change if you want to move java test files folder
        String pythonTestFolder = "src/test/test_files/python";

        // check if javaTestFolder exist
        assertTrue(Files.isDirectory(Paths.get(pythonTestFolder)));

        List<DynamicTest> ret = new ArrayList<>();

        GreensightRuleList.getPythonRules().forEach(unknown -> {
            try {
                PythonCheck pythonRule = (PythonCheck) unknown.getConstructor().newInstance();
                String className = pythonRule.getClass().getSimpleName();
                File fi = new File(Paths.get(pythonTestFolder, className + "CodeExample.py").toUri());
                ret.add(dynamicTest(className, () -> testPythonRule(pythonRule, fi)));
            } catch (Exception err) {
                System.err.println("checkAllPythonRules: " + err);
            }
        });

        return ret;
    }

    /**
     * Test rule against test file
     *
     * @param rule     Python rule
     * @param testFile relative path to test file
     */
    public void testPythonRule(PythonCheck rule, File testFile) {
        // make sure your test file is named "[className]CodeExample.java"
        assertTrue(testFile.exists(), "File not found: " + testFile.getAbsolutePath());

        PythonCheckVerifier.verify(testFile.getAbsolutePath(), rule);
    }
}
