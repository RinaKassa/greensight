package fr.capgemini.greensight.plugin.rules.python;

import fr.capgemini.greensight.plugin.quality_profiles.PythonQualityProfile;
import fr.capgemini.greensight.plugin.rules.GreensightRuleList;
import fr.capgemini.greensight.plugin.rules.definitions.PythonRulesDefinition;
import org.junit.jupiter.api.Test;
import org.sonar.api.rule.RuleKey;
import org.sonar.api.server.profile.BuiltInQualityProfilesDefinition.BuiltInActiveRule;
import org.sonar.api.server.profile.BuiltInQualityProfilesDefinition.BuiltInQualityProfile;
import org.sonar.api.server.profile.BuiltInQualityProfilesDefinition.Context;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PythonQualityProfileTest {
    @Test
    public void test() {
        PythonQualityProfile pythonQualityProfile = new PythonQualityProfile();
        Context context = new Context();
        pythonQualityProfile.define(context);
        BuiltInQualityProfile qualityProfile = context.profile("py", PythonQualityProfile.QUALITY_PROFILE_NAME);

        assertEquals("py", qualityProfile.language());
        assertEquals(PythonQualityProfile.QUALITY_PROFILE_NAME, qualityProfile.name());
        assertEquals(GreensightRuleList.getPythonRules().size(), qualityProfile.rules().size());

        assertRuleActive(qualityProfile);
    }

    private void assertRuleActive(BuiltInQualityProfile qualityProfile) {
        RuleKey ruleKey = RuleKey.of(PythonRulesDefinition.REPOSITORY, "GS_01");
        BuiltInActiveRule ruleActive = qualityProfile.rule(ruleKey);
        assertNotNull(ruleActive);
        assertEquals(ruleKey.repository(), ruleActive.repoKey());
    }
}
