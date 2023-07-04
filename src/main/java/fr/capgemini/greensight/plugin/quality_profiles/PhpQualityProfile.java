package fr.capgemini.greensight.plugin.quality_profiles;

import fr.capgemini.greensight.plugin.rules.GreensightRuleList;
import fr.capgemini.greensight.plugin.rules.definitions.PhpRulesDefinition;
import org.sonar.api.server.profile.BuiltInQualityProfilesDefinition;
import org.sonar.check.Rule;

/**
 * Declare Greensight PHP Quality Profile
 */
public final class PhpQualityProfile implements BuiltInQualityProfilesDefinition {
    public static final String QUALITY_PROFILE_NAME = "Greensight";

    @Override
    public void define(Context context) {

        NewBuiltInQualityProfile profile = context.createBuiltInQualityProfile(QUALITY_PROFILE_NAME,
                                                                               PhpRulesDefinition.LANGUAGE);

        profile.setDefault(true);

        GreensightRuleList.getPhpRules()
                .forEach(rule -> profile.activateRule(PhpRulesDefinition.REPOSITORY,
                                                      rule.getAnnotation(Rule.class).key()));

        profile.done();
    }
}
