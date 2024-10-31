package netzbegruenung.keycloak.authenticator.conditions;

import org.keycloak.Config;
import org.keycloak.authentication.authenticators.conditional.ConditionalAuthenticator;
import org.keycloak.authentication.authenticators.conditional.ConditionalAuthenticatorFactory;
import org.keycloak.models.AuthenticationExecutionModel;
import org.keycloak.models.KeycloakSessionFactory;
import org.keycloak.provider.ProviderConfigProperty;

import java.util.List;

public class ConditionalIdentityAuthenticatorFactory  implements ConditionalAuthenticatorFactory {

    public static final String IS_SCA_ELIGIBLE = "sca-eligible";
    public static final String PROVIDER_ID = "conditional-identity-authenticator";

    @Override
    public ConditionalAuthenticator getSingleton() {
        return ConditionalIdentityAuthenticator.SINGLETON;
    }

    @Override
    public String getDisplayType() {
        return "Condition - SCA eligible";
    }

    @Override
    public boolean isConfigurable() {
        return true;
    }

    @Override
    public AuthenticationExecutionModel.Requirement[] getRequirementChoices() {
        return REQUIREMENT_CHOICES;
    }

    @Override
    public boolean isUserSetupAllowed() {
        return false;
    }

    @Override
    public String getHelpText() {
        return "Flow is executed only if the user is SCA eligible";
    }

    @Override
    public List<ProviderConfigProperty> getConfigProperties() {
        ProviderConfigProperty providerConfigProperty = new ProviderConfigProperty();
        providerConfigProperty.setType(ProviderConfigProperty.BOOLEAN_TYPE);
        providerConfigProperty.setName(IS_SCA_ELIGIBLE);
        providerConfigProperty.setLabel("Should show SCA");
        providerConfigProperty.setHelpText("Toggle the SCA flow");
        return List.of(providerConfigProperty);
    }

    @Override
    public void init(Config.Scope scope) {

    }

    @Override
    public void postInit(KeycloakSessionFactory keycloakSessionFactory) {

    }

    @Override
    public void close() {

    }

    @Override
    public String getId() {
        return PROVIDER_ID;
    }
}
