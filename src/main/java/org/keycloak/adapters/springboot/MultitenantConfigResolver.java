package org.keycloak.adapters.springboot;

import org.keycloak.adapters.KeycloakConfigResolver;
import org.keycloak.adapters.KeycloakDeployment;
import org.keycloak.adapters.KeycloakDeploymentBuilder;
import org.keycloak.adapters.OIDCHttpFacade;
import org.keycloak.representations.adapters.config.AdapterConfig;

import java.io.InputStream;

public class MultitenantConfigResolver implements KeycloakConfigResolver {
    private KeycloakDeployment keycloakDeployment;

    private static AdapterConfig adapterConfig;

    @Override
    public KeycloakDeployment resolve(OIDCHttpFacade.Request request) {
        if (keycloakDeployment != null) {
            return keycloakDeployment;
        }

        String domain = request.getFirstParam("domain");//request.getQueryParamValue("domain");
        if (null != domain) {
            InputStream is = getClass().getResourceAsStream("/" + domain + "-keycloak.json");
            return KeycloakDeploymentBuilder.build(is);
        } else {
            InputStream is = getClass().getResourceAsStream("/default-keycloak.json");
            return KeycloakDeploymentBuilder.build(is);
        }

    }

    static void setAdapterConfig(AdapterConfig adapterConfig) {
        MultitenantConfigResolver.adapterConfig = adapterConfig;
    }
}



