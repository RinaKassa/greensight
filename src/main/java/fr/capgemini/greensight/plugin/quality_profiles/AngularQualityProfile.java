package fr.capgemini.greensight.plugin.quality_profiles;

import fr.capgemini.greensight.plugin.rules.GreensightRuleList;
import fr.capgemini.greensight.plugin.rules.definitions.AngularRulesdefinition;
import fr.capgemini.greensight.plugin.rules.definitions.JavaRulesDefinition;
import org.sonar.api.server.profile.BuiltInQualityProfilesDefinition;
import org.sonar.check.Rule;

/**
 * Declare Greensight Angular Quality profile, contains all angular rules
 */
public class AngularQualityProfile implements BuiltInQualityProfilesDefinition {
    public static final String QUALITY_PROFILE_NAME = "Greensight_angular";

    @Override
    public void define(Context context) {
        // Create an angular quality profile for Greensight
        NewBuiltInQualityProfile profile = context.createBuiltInQualityProfile(QUALITY_PROFILE_NAME,
            AngularRulesdefinition.LANGUAGE);
        profile.setDefault(true);

        // Define list of rules
        GreensightRuleList.getAngularRules()
            .forEach(rule -> profile.activateRule(AngularRulesdefinition.REPOSITORY,
                rule.getAnnotation(Rule.class).key()));

        // Quality profile is done
        profile.done();
    }
}
