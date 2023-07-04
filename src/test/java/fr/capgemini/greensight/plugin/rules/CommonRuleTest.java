package fr.capgemini.greensight.plugin.rules;

import org.sonar.api.server.rule.RulesDefinition;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CommonRuleTest {
    /**
     * Check if all rules parameters (@RuleProperty) in the provided repository contain a name, description and defaultValue
     *
     * @param repository repository to test
     */
    public static void assertAllRuleParametersHaveDescription(RulesDefinition.Repository repository) {
        for (RulesDefinition.Rule rule : repository.rules()) {
            for (RulesDefinition.Param param : rule.params()) {
                String ruleInfo = String.format("@RuleProperty %s (%s) in repo %s",
                                                rule.key(),
                                                param.name(),
                                                rule.repository().key());
                assertNotNull(param.name());
                assertNotNull(param.description(), String.format("Missing description for %s", ruleInfo));
                assertFalse(param.description().isEmpty() && param.description().isBlank(),
                            String.format("Description must not be empty ot blank for %s", ruleInfo));
                assertNotNull(param.defaultValue(), String.format("Missing default value for %s", ruleInfo));
            }
        }
    }
}
