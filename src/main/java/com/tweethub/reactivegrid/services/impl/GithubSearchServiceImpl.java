package com.tweethub.reactivegrid.services.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.tweethub.reactivegrid.domain.GithubProjectEntity;
import com.tweethub.reactivegrid.services.AbstractRestClient;
import com.tweethub.reactivegrid.services.GithubSearchService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service("GithubSearchService")
public class GithubSearchServiceImpl extends AbstractRestClient implements
    GithubSearchService {

  @Autowired
  private JsonMarshallingServiceImpl jsonMarshallingService;

  private final String GITHUB_API = "https://api.github.com/search/repositories";
  private final String SEARCH_QUERY = "?q=reactive";
  private final String PAGE_NUMBER = "&page=";
  private final String NO_RESULTS_PER_PAGE = "&per_page=5";
  private final String DEFAULT_PAGE = "1";

  private ResponseEntity<String> rawResponse;
  private JsonNode jsonResponse;
  private JsonNode jsonGithubProjects;

  public List<GithubProjectEntity> getProjects() throws Exception {
    return getProjects(DEFAULT_PAGE);
  }

  public List<GithubProjectEntity> getProjects(String pageNo) throws Exception {
    rawResponse = getResults(
        GITHUB_API +
            SEARCH_QUERY +
            PAGE_NUMBER + pageNo +
            NO_RESULTS_PER_PAGE
    );

    jsonResponse = jsonMarshallingService.parseHttpResponseToJson(rawResponse);
    jsonGithubProjects = jsonMarshallingService.parseGitHubProjectsFromJson(jsonResponse);

    return jsonMarshallingService.returnGitHubProjectsList(jsonGithubProjects);
  }
}
