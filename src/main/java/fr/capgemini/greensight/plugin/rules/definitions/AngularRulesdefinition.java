package fr.capgemini.greensight.plugin.rules.definitions;

import fr.capgemini.greensight.plugin.rules.GreensightRuleList;
import fr.capgemini.greensight.plugin.rules.GreensightRulesDefinition;
import org.sonar.api.server.rule.RulesDefinitionAnnotationLoader;
import org.sonar.plugins.java.api.CheckRegistrar;
import org.sonar.plugins.php.api.visitors.PHPCustomRuleRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Provide the "checks" (implementations of rules) classes that are going be executed during
 * source code analysis.
 * This class is a batch extension by implementing the {@link org.sonar.plugins.java.api.CheckRegistrar} interface.
 */
public class AngularRulesdefinition {
    private static final String RESOURCE_BASE_PATH = "/org/sonar/l10n/javascript/rules/squid";
    public static final String REPOSITORY = "angular-greensight";
    public static final String LANGUAGE = "javascript";
}
