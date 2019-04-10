package com.tweethub.reactivegrid.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component("twitterResponse")
@JsonIgnoreProperties(ignoreUnknown = true)
public class TweetEntity extends AbstractEntity {
  private @Getter @Setter String text;
}
