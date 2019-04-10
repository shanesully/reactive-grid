package com.tweethub.reactivegrid.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;
import lombok.Getter;
import lombok.Setter;

@Component("githubResponse")
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter @Setter
public class GithubProjectEntity extends AbstractEntity {
  private  String description;
  private String htmlUrl;

  @JsonProperty("html_url")
  public String getHtmlUrl() {
    return htmlUrl;
  }

}
