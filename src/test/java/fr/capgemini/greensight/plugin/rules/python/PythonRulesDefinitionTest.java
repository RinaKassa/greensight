package fr.capgemini.greensight.plugin.rules.python;

import fr.capgemini.greensight.plugin.rules.GreensightRuleList;
import fr.capgemini.greensight.plugin.rules.definitions.PythonRulesDefinition;
import org.junit.Test;
import org.sonar.api.server.rule.RulesDefinition;

import static fr.capgemini.greensight.plugin.rules.CommonRuleTest.assertAllRuleParametersHaveDescription;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PythonRulesDefinitionTest {

    @Test
    public void test() {
        PythonRulesDefinition rulesDefinition = new PythonRulesDefinition();
        RulesDefinition.Context context = new RulesDefinition.Context();
        rulesDefinition.define(context);
        RulesDefinition.Repository repository = context.repository(PythonRulesDefinition.REPOSITORY);

        assertNotNull(repository);
        assertEquals("Greensight by Capgemini", repository.name());
        assertEquals("py", repository.language());
        assertEquals(GreensightRuleList.getPythonRules().size(), repository.rules().size());

        assertAllRuleParametersHaveDescription(repository);
    }

}
