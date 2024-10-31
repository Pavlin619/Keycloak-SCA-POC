// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2024. For more information see LICENSE\n

package netzbegruenung.keycloak.authenticator;

import org.jboss.logging.Logger;
import org.keycloak.authentication.AuthenticationFlowContext;
import org.keycloak.authentication.AuthenticationFlowError;
import org.keycloak.authentication.AuthenticationFlowException;
import org.keycloak.authentication.authenticators.conditional.ConditionalAuthenticator;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.RealmModel;
import org.keycloak.models.UserModel;

public class CustomOtpConditionalAuthenticator implements ConditionalAuthenticator {

	private static final Logger logger = Logger.getLogger(ConditionalIdentityAuthenticator.class);

	@Override
	public boolean matchCondition(AuthenticationFlowContext context) {
		if (context == null) {
			throw new AuthenticationFlowException("context is null", AuthenticationFlowError.INTERNAL_ERROR);
		}

		String chosenScaMethod = context.getAuthenticationSession().getAuthNote(ScaSelectionAuthenticator.SCA_CHOICE);
		if (chosenScaMethod != null && chosenScaMethod.equals("custom_otp")) {  // replace "expected-sca-method" with the actual method this authenticator handles
			logger.trace("ConditionalIdentityAuthenticator matched condition with choice: " + chosenScaMethod);
			return true;
		}

		return false;
	}

	@Override
	public void action(AuthenticationFlowContext authenticationFlowContext) {
		//Not used
	}

	@Override
	public boolean requiresUser() {
		return true;
	}

	@Override
	public void setRequiredActions(KeycloakSession keycloakSession, RealmModel realmModel, UserModel userModel) {
		//Not used
	}

	@Override
	public void close() {
		//Does nothing
	}
}
