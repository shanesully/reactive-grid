package com.tweethub.reactivegrid.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.stereotype.Component;

@Component("twitterResponse")
@JsonIgnoreProperties(ignoreUnknown = true)
public class TweetEntity extends AbstractEntity {
  String text;

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }
}
