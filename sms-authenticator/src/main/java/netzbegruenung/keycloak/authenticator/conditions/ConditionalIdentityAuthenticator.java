package netzbegruenung.keycloak.authenticator.conditions;

import org.jboss.logging.Logger;
import org.keycloak.authentication.AuthenticationFlowContext;
import org.keycloak.authentication.AuthenticationFlowError;
import org.keycloak.authentication.AuthenticationFlowException;
import org.keycloak.authentication.authenticators.conditional.ConditionalAuthenticator;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.RealmModel;
import org.keycloak.models.UserModel;

import java.util.Map;

public class ConditionalIdentityAuthenticator implements ConditionalAuthenticator{

    static final ConditionalIdentityAuthenticator SINGLETON = new ConditionalIdentityAuthenticator();

    private static final Logger logger = Logger.getLogger(ConditionalIdentityAuthenticator.class);

    @Override
    public boolean matchCondition(AuthenticationFlowContext context) {
        if (context == null){
            throw new AuthenticationFlowException("context is null", AuthenticationFlowError.INTERNAL_ERROR);
        }
        boolean isScaEligible = false;

        var authenticatorConfig = context.getAuthenticatorConfig();
        if (authenticatorConfig != null){
            Map<String, String> config = authenticatorConfig.getConfig();
            if (config != null) {
                isScaEligible = Boolean.parseBoolean(config.get(ConditionalIdentityAuthenticatorFactory.IS_SCA_ELIGIBLE));
            }
        }

		logger.trace("ConditionalIdentityAuthenticator result: " + isScaEligible);
		return isScaEligible;
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
