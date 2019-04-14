package com.tweethub.reactivegrid.services.impl.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter @Setter
@ConfigurationProperties(prefix = "oauth")
public class Twitter4jConfig {
    @Value("${oauth.consumerKey}") private String consumerKey;
    @Value("${oauth.consumerSecret}") private String consumerSecret;
    @Value("${oauth.accessToken}") private String serverKey;
    @Value("${oauth.accessTokenSecret}") private String serverSecret;
}
