package fr.capgemini.greensight.plugin.quality_profiles;

import fr.capgemini.greensight.plugin.rules.GreensightRuleList;
import fr.capgemini.greensight.plugin.rules.definitions.JavaRulesDefinition;
import org.sonar.api.server.profile.BuiltInQualityProfilesDefinition;
import org.sonar.check.Rule;

/**
 * Declare Greensight Java Quality profile, contains all java rules
 */
public final class JavaQualityProfile implements BuiltInQualityProfilesDefinition {
    public static final String QUALITY_PROFILE_NAME = "Greensight";

    @Override
    public void define(Context context) {
        // Create a Java quality profile for Greensight
        NewBuiltInQualityProfile profile = context.createBuiltInQualityProfile(QUALITY_PROFILE_NAME,
                                                                               JavaRulesDefinition.LANGUAGE);
        profile.setDefault(true);

        // Define list of rules
        GreensightRuleList.getJavaRules()
                .forEach(rule -> profile.activateRule(JavaRulesDefinition.REPOSITORY,
                                                         rule.getAnnotation(Rule.class).key()));

        // Quality profile is done
        profile.done();
    }
}
