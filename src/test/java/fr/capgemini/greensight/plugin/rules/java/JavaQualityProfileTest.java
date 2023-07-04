package fr.capgemini.greensight.plugin.rules.java;

import fr.capgemini.greensight.plugin.quality_profiles.JavaQualityProfile;
import fr.capgemini.greensight.plugin.rules.GreensightRuleList;
import fr.capgemini.greensight.plugin.rules.definitions.JavaRulesDefinition;
import org.junit.jupiter.api.Test;
import org.sonar.api.rule.RuleKey;
import org.sonar.api.server.profile.BuiltInQualityProfilesDefinition;
import org.sonar.api.server.profile.BuiltInQualityProfilesDefinition.BuiltInActiveRule;
import org.sonar.api.server.profile.BuiltInQualityProfilesDefinition.BuiltInQualityProfile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class JavaQualityProfileTest {
    @Test
    public void test() {
        JavaQualityProfile javaQualityProfile = new JavaQualityProfile();
        BuiltInQualityProfilesDefinition.Context context = new BuiltInQualityProfilesDefinition.Context();
        javaQualityProfile.define(context);
        BuiltInQualityProfilesDefinition.BuiltInQualityProfile qualityProfile = context.profile("java",
                                                                                                JavaQualityProfile.QUALITY_PROFILE_NAME);

        assertEquals("java", qualityProfile.language());
        assertEquals(JavaQualityProfile.QUALITY_PROFILE_NAME, qualityProfile.name());
        assertEquals(GreensightRuleList.getJavaRules().size(), qualityProfile.rules().size());

        assertRuleActive(qualityProfile);
    }

    private void assertRuleActive(BuiltInQualityProfile qualityProfile) {
        RuleKey ruleKey = RuleKey.of(JavaRulesDefinition.REPOSITORY, "GS_01");
        BuiltInActiveRule ruleActive = qualityProfile.rule(ruleKey);
        assertNotNull(ruleActive);
        assertEquals(ruleKey.repository(), ruleActive.repoKey());
    }
}
