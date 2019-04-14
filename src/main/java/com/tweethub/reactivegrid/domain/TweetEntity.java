package com.tweethub.reactivegrid.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.stereotype.Component;
import lombok.Getter;
import lombok.Setter;

@Component("twitterResponse")
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter @Setter
public class TweetEntity extends AbstractEntity {
  private String text;
}
