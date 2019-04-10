package com.tweethub.reactivegrid.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.Map;
import org.springframework.stereotype.Component;
import lombok.Getter;
import lombok.Setter;

@Component("compositeProjectEntity")
@Getter @Setter
public class CompositeProjectEntity extends AbstractEntity {
  private String description;
  private String htmlUrl;
  private Map<String, TweetEntity> tweets;

  @JsonInclude(Include.NON_NULL)
  public Map<String, TweetEntity> getTweets() {
    return tweets;
  }
}
