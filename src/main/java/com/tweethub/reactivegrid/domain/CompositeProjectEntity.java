package com.tweethub.reactivegrid.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component("compositeProjectEntity")
public class CompositeProjectEntity extends AbstractEntity {
  private String description;
  private String htmlUrl;

  @JsonInclude(Include.NON_NULL)
  Map<String, TweetEntity> tweets;

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getHtmlUrl() {
    return htmlUrl;
  }

  public void setHtmlUrl(String htmlUrl) {
    this.htmlUrl = htmlUrl;
  }

  public Map<String, TweetEntity> getTweets() {
    return tweets;
  }

  public void setTweets(
      Map<String, TweetEntity> tweets) {
    this.tweets = tweets;
  }
}
