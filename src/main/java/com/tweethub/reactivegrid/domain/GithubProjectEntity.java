package com.tweethub.reactivegrid.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

@Component("githubResponse")
@JsonIgnoreProperties(ignoreUnknown = true)
public class GithubProjectEntity extends AbstractEntity {
  private String description;
  private String htmlUrl;

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @JsonProperty("html_url")
  public String getHtmlUrl() {
    return htmlUrl;
  }

  public void setHtmlUrl(String htmlUrl) {
    this.htmlUrl = htmlUrl;
  }
}
