// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2024. For more information see LICENSE\n

package netzbegruenung.keycloak.authenticator;

import org.keycloak.Config;
import org.keycloak.authentication.authenticators.conditional.ConditionalAuthenticator;
import org.keycloak.authentication.authenticators.conditional.ConditionalAuthenticatorFactory;
import org.keycloak.models.AuthenticationExecutionModel;
import org.keycloak.models.KeycloakSessionFactory;
import org.keycloak.provider.ProviderConfigProperty;

import java.util.Collections;
import java.util.List;

public class CustomOtpConditionalAuthenticatorFactory implements ConditionalAuthenticatorFactory {

	public static final String PROVIDER_ID = "custom-otp-condition";
	private static final CustomOtpConditionalAuthenticator INSTANCE = new CustomOtpConditionalAuthenticator();

	@Override
	public ConditionalAuthenticator getSingleton() {
		return INSTANCE;
	}

	@Override
	public String getDisplayType() {
		return "Condition - Custom OTP";
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
		return "Flow is executed only if user selects it";
	}

	@Override
	public List<ProviderConfigProperty> getConfigProperties() {
		return Collections.emptyList();
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