package fr.capgemini.greensight.plugin.quality_profiles;

import fr.capgemini.greensight.plugin.rules.GreensightRuleList;
import fr.capgemini.greensight.plugin.rules.definitions.PythonRulesDefinition;
import org.sonar.api.server.profile.BuiltInQualityProfilesDefinition;
import org.sonar.check.Rule;

/**
 * Declare Greensight Python Quality Profile
 */
public class PythonQualityProfile implements BuiltInQualityProfilesDefinition {

    public static final String QUALITY_PROFILE_NAME = "Greensight";

    @Override
    public void define(Context context) {
        // Create a Python quality profile for Greensight

        NewBuiltInQualityProfile profile = context.createBuiltInQualityProfile(QUALITY_PROFILE_NAME,
                                                                               PythonRulesDefinition.LANGUAGE);

        profile.setDefault(true);

        GreensightRuleList.getPythonRules()
                .forEach(rule -> profile.activateRule(PythonRulesDefinition.REPOSITORY,
                                                      rule.getAnnotation(Rule.class).key()));

        profile.done();
    }
}
