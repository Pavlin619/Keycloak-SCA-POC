// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2024. For more information see LICENSE\n

package netzbegruenung.keycloak.authenticator;

import org.keycloak.Config;
import org.keycloak.authentication.Authenticator;
import org.keycloak.authentication.AuthenticatorFactory;
import org.keycloak.models.AuthenticationExecutionModel;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.KeycloakSessionFactory;
import org.keycloak.provider.ProviderConfigProperty;

import java.util.List;

public class ScaSelectionAuthenticatorFactory implements AuthenticatorFactory {
	public static final String PROVIDER_ID = "sca-selection-authenticator";
	private static final ScaSelectionAuthenticator INSTANCE = new ScaSelectionAuthenticator();

	@Override
	public String getId() {
		return PROVIDER_ID;
	}

	@Override
	public String getDisplayType() {
		return "SCA Selection Screen";
	}

	@Override
	public String getHelpText() {
		return "Authenticator that displays a screen for selecting an SCA method.";
	}

	@Override
	public Authenticator create(KeycloakSession session) {
		return INSTANCE;
	}

	@Override
	public void init(Config.Scope config) {
		// Perform any required initialization
	}

	@Override
	public void postInit(KeycloakSessionFactory factory) {
		// Perform any required post-initialization
	}

	@Override
	public void close() {
		// Perform any cleanup operations
	}

	@Override
	public boolean isConfigurable() {
		return false;  // Set to true if you plan to add configurable properties
	}

	@Override
	public List<ProviderConfigProperty> getConfigProperties() {
		// Return any configuration properties if applicable, empty for now
		return List.of();
	}

	@Override
	public boolean isUserSetupAllowed() {
		return false;
	}

	@Override
	public String getReferenceCategory() {
		return "SCA";
	}

	@Override
	public AuthenticationExecutionModel.Requirement[] getRequirementChoices() {
		return new AuthenticationExecutionModel.Requirement[]{
			AuthenticationExecutionModel.Requirement.REQUIRED,
			AuthenticationExecutionModel.Requirement.ALTERNATIVE,
			AuthenticationExecutionModel.Requirement.CONDITIONAL,
			AuthenticationExecutionModel.Requirement.DISABLED
		};
	}
}
