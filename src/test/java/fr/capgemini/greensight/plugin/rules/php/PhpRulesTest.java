package fr.capgemini.greensight.plugin.rules.php;

import fr.capgemini.greensight.plugin.rules.GreensightRuleList;
import fr.capgemini.greensight.plugin.rules.checks.php.TooManyLinesInOneFile;
import fr.capgemini.greensight.plugin.rules.java.JavaRulesTest;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.sonar.plugins.php.api.tests.PHPCheckVerifier;
import org.sonar.plugins.php.api.visitors.PHPCheck;

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
public class PhpRulesTest {
    @TestFactory
    public List<DynamicTest> checkAllPhpRules() {
        String phpTestFolder = "src/test/test_files/php";

        assertTrue(Files.isDirectory(Paths.get(phpTestFolder)));

        List<DynamicTest> ret = new ArrayList<>();

        GreensightRuleList.getPhpRules().forEach(unknown -> {
            try {
                // gather the object default constructor
                Object obj = unknown.getConstructor().newInstance();

                // check if obj is a specific rule, allow set custom
                // threshold for example.
                if (obj instanceof TooManyLinesInOneFile) {
                    ((TooManyLinesInOneFile) obj).maxNumberOfLineThreshold = 10;
                }

                PHPCheck phpRule = (PHPCheck) obj;
                String className = phpRule.getClass().getSimpleName();

                File fi = new File(Paths.get(phpTestFolder, className + "CodeExample.php").toUri());
                ret.add(dynamicTest(className, () -> TestPhpRule(phpRule, fi)));
            } catch (Exception err) {
                System.err.println("checkAllPhpRules: " + err);
            }
        });

        return ret;
    }

    /**
     * Test PHP rule against specified test file
     *
     * @param rule     rule to test
     * @param testFile test php file
     */
    public void TestPhpRule(PHPCheck rule, File testFile) {
        // make sure your test file is named "[className]CodeExample.php"
        assertTrue(testFile.exists(), "File not found: " + testFile.getAbsolutePath());
        PHPCheckVerifier.verify(rule, testFile);
    }
}
