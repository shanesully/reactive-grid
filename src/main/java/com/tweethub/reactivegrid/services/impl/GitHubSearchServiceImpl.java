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
  JsonMarshallingServiceImpl jsonMarshallingService;

  private static final String GITHUB_API = "https://api.github.com/search/repositories";
  private static final String SEARCH_QUERY = "?q=reactive";
  private static final String PAGE_NUMBER = "&page=";
  private static final String NO_RESULTS_PER_PAGE = "&per_page=5";

  private ResponseEntity<String> rawResponse;
  private JsonNode jsonResponse;
  private JsonNode jsonGithubProjects;

  public List<GithubProjectEntity> getProjects() throws Exception {
    return getProjects("1");
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
