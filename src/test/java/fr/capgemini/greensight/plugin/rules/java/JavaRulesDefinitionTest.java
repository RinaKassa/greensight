package fr.capgemini.greensight.plugin.rules.java;

import fr.capgemini.greensight.plugin.rules.GreensightRuleList;
import fr.capgemini.greensight.plugin.rules.definitions.JavaRulesDefinition;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.sonar.api.rules.RuleType;
import org.sonar.api.server.rule.RulesDefinition;

import static fr.capgemini.greensight.plugin.rules.CommonRuleTest.assertAllRuleParametersHaveDescription;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class JavaRulesDefinitionTest {
    @Test
    public void testRuleDefinition() {
        JavaRulesDefinition rulesDefinition = new JavaRulesDefinition();
        RulesDefinition.Context context = new RulesDefinition.Context();
        rulesDefinition.define(context);
        RulesDefinition.Repository repository = context.repository(JavaRulesDefinition.REPOSITORY);

        assertNotNull(repository);
        assertEquals("Greensight by Capgemini", repository.name());
        assertEquals("java", repository.language());
        assertEquals(GreensightRuleList.getJavaRules().size(), repository.rules().size());

        assertRuleProperties(repository);
        assertAllRuleParametersHaveDescription(repository);
    }

    private void assertRuleProperties(RulesDefinition.Repository repository) {
        RulesDefinition.Rule rule = repository.rule("GS_01");
        assertNotNull(rule);
        assertEquals("Ban SELECT * from your SQL queries", rule.name());// NOSONAR
        assertEquals(RuleType.CODE_SMELL, rule.type());
    }
}
