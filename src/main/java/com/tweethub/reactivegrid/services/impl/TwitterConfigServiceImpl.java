package com.tweethub.reactivegrid.services.impl;

import com.tweethub.reactivegrid.services.TwitterConfigService;
import com.tweethub.reactivegrid.services.impl.config.Twitter4jConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

@Service("twitterConfigService")
public class TwitterConfigServiceImpl implements TwitterConfigService {
  private static ConfigurationBuilder configurationBuilder;
  private static TwitterFactory twitterFactory;
  private static Twitter twitter;

  private final Twitter4jConfig twitter4jConfig;

  @Autowired
  TwitterConfigServiceImpl(Twitter4jConfig twitter4jConfig) {
    this.twitter4jConfig = twitter4jConfig;
    configurationBuilder = new ConfigurationBuilder();
    setupTwitterConfig();
  }

  private void setupTwitterConfig() {
    configurationBuilder.setDebugEnabled(true)
        .setOAuthConsumerKey(twitter4jConfig.getConsumerKey())
        .setOAuthConsumerSecret(twitter4jConfig.getConsumerSecret())
        .setOAuthAccessToken(twitter4jConfig.getServerKey())
        .setOAuthAccessTokenSecret(twitter4jConfig.getServerSecret());

    twitterFactory = new TwitterFactory(configurationBuilder.build());
    twitter = twitterFactory.getInstance();
  }

  public Twitter getTwitterInstance() {
    return twitter;
  }
}
