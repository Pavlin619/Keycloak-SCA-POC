// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2024. For more information see LICENSE\n

package netzbegruenung.keycloak.authenticator;

import jakarta.ws.rs.core.Response;
import org.keycloak.authentication.AuthenticationFlowContext;
import org.keycloak.authentication.Authenticator;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.RealmModel;
import org.keycloak.models.UserModel;

public class ScaSelectionAuthenticator implements Authenticator {
	public static final String SCA_CHOICE = "sca_choice";

	@Override
	public void authenticate(AuthenticationFlowContext context) {
		// Render SCA options form
		Response response = context.form()
			.createForm("select-sca.ftl");

		context.challenge(response);
	}

	@Override
	public void action(AuthenticationFlowContext context) {
		String chosenOption = context.getHttpRequest().getDecodedFormParameters().getFirst(SCA_CHOICE);

		if (chosenOption == null) {
			// If no choice, show error message
			Response response = context.form()
				.setError("Please choose an SCA method.")
				.createForm("select-sca.ftl");
			context.challenge(response);
			return;
		}

		// Save choice to the session for later use
		context.getAuthenticationSession().setAuthNote(SCA_CHOICE, chosenOption);

		// Mark authentication as successful and proceed
		context.success();
	}

	@Override
	public void close() {
		// No action required on close
	}

	@Override
	public boolean requiresUser() {
		return true;
	}

	@Override
	public void setRequiredActions(KeycloakSession session, RealmModel realm, UserModel user) {
		// No additional actions required
	}

	@Override
	public boolean configuredFor(KeycloakSession session, RealmModel realm, UserModel user) {
		return true;
	}
}
