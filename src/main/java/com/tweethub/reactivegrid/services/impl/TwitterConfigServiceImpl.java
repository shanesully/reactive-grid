package com.tweethub.reactivegrid.services.impl;

import com.tweethub.reactivegrid.services.TwitterConfigService;
import org.springframework.stereotype.Service;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

@Service("twitterConfigService")
public class TwitterConfigServiceImpl implements TwitterConfigService {
  private static ConfigurationBuilder configurationBuilder;
  private static TwitterFactory twitterFactory;
  private static Twitter twitter;

  TwitterConfigServiceImpl() {
    configurationBuilder = new ConfigurationBuilder();
    setupTwitterConfig();
  }

  private void setupTwitterConfig() {
    configurationBuilder.setDebugEnabled(true)
        .setOAuthConsumerKey("*****")
        .setOAuthConsumerSecret("*****")
        .setOAuthAccessToken("*****")
        .setOAuthAccessTokenSecret("*****");

    twitterFactory = new TwitterFactory(configurationBuilder.build());
    twitter = twitterFactory.getInstance();
  }

  public Twitter getTwitterInstance() {
    return twitter;
  }
}
