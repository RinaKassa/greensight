package fr.capgemini.greensight.plugin.rules.php;

import fr.capgemini.greensight.plugin.quality_profiles.PhpQualityProfile;
import fr.capgemini.greensight.plugin.rules.GreensightRuleList;
import fr.capgemini.greensight.plugin.rules.definitions.PhpRulesDefinition;
import org.junit.jupiter.api.Test;
import org.sonar.api.rule.RuleKey;
import org.sonar.api.server.profile.BuiltInQualityProfilesDefinition.BuiltInActiveRule;
import org.sonar.api.server.profile.BuiltInQualityProfilesDefinition.BuiltInQualityProfile;
import org.sonar.api.server.profile.BuiltInQualityProfilesDefinition.Context;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PhpQualityProfileTest {
    @Test
    public void test() {
        PhpQualityProfile phpQualityProfile = new PhpQualityProfile();
        Context context = new Context();
        phpQualityProfile.define(context);
        BuiltInQualityProfile qualityProfile = context.profile("php", PhpQualityProfile.QUALITY_PROFILE_NAME);

        assertEquals("php", qualityProfile.language());
        assertEquals(PhpQualityProfile.QUALITY_PROFILE_NAME, qualityProfile.name());
        assertEquals(GreensightRuleList.getPhpRules().size(), qualityProfile.rules().size());

        assertRuleActive(qualityProfile);
    }

    private void assertRuleActive(BuiltInQualityProfile qualityProfile) {
        RuleKey ruleKey = RuleKey.of(PhpRulesDefinition.REPOSITORY, "GS_01");
        BuiltInActiveRule ruleActive = qualityProfile.rule(ruleKey);
        assertNotNull(ruleActive);
        assertEquals(ruleKey.repository(), ruleActive.repoKey());
    }
}
