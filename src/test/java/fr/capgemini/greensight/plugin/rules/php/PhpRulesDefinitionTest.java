package fr.capgemini.greensight.plugin.rules.php;

import fr.capgemini.greensight.plugin.rules.GreensightRuleList;
import fr.capgemini.greensight.plugin.rules.definitions.PhpRulesDefinition;
import org.junit.jupiter.api.Test;
import org.sonar.api.rules.RuleType;
import org.sonar.api.server.rule.RulesDefinition;
import org.sonar.api.server.rule.RulesDefinition.Param;
import org.sonar.api.server.rule.RulesDefinition.Repository;
import org.sonar.api.server.rule.RulesDefinition.Rule;

import static fr.capgemini.greensight.plugin.rules.CommonRuleTest.assertAllRuleParametersHaveDescription;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PhpRulesDefinitionTest {

    @Test
    public void test() {
        PhpRulesDefinition rulesDefinition = new PhpRulesDefinition();
        RulesDefinition.Context context = new RulesDefinition.Context();
        rulesDefinition.define(context);
        Repository repository = context.repository(PhpRulesDefinition.REPOSITORY);

        assertNotNull(repository);
        assertEquals("Greensight by Capgemini", repository.name());
        assertEquals("php", repository.language());
        assertEquals(GreensightRuleList.getPhpRules().size(), repository.rules().size());

        assertRuleProperties(repository);
        assertAllRuleParametersHaveDescription(repository);
    }

    private void assertRuleProperties(Repository repository) {
        Rule rule = repository.rule("GS_01");
        assertNotNull(rule);
        assertEquals("Ban SELECT * from your SQL queries", rule.name());// NOSONAR
        assertEquals(RuleType.CODE_SMELL, rule.type());
    }
}
