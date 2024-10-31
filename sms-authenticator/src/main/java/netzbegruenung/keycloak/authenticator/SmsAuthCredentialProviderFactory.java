/*
 * Copyright 2016 Red Hat, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * @author Bill Burke
 * @author Netzbegruenung e.V.
 * @author verdigado eG
 */

package netzbegruenung.keycloak.authenticator;

import org.keycloak.credential.CredentialProvider;
import org.keycloak.credential.CredentialProviderFactory;
import org.keycloak.models.KeycloakSession;

import netzbegruenung.keycloak.authenticator.credentials.SmsAuthCredentialModel;

public class SmsAuthCredentialProviderFactory implements CredentialProviderFactory<SmsAuthCredentialProvider> {

    public static final String PROVIDER_ID = "mobile-number";

    @Override
    public String getId() {
        return PROVIDER_ID;
    }

    @Override
    public CredentialProvider<SmsAuthCredentialModel> create(KeycloakSession session) {
        return new SmsAuthCredentialProvider(session);
    }
}
