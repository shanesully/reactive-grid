package com.tweethub.reactivegrid.services.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.tweethub.reactivegrid.domain.GitHubSearchResponse;
import com.tweethub.reactivegrid.services.AbstractRestClient;
import com.tweethub.reactivegrid.services.GitHubSearchClientService;
import com.tweethub.reactivegrid.services.ReactiveGridService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service("GitHubSearchClientService")
public class GitHubSearchServiceImpl extends AbstractRestClient implements
    GitHubSearchClientService {

  @Autowired
  JsonMarshallingServiceImpl jsonMarshallingService;

  @Autowired
  ReactiveGridService reactiveGridService;

  private static String uri = "https://api.github.com/search/repositories";
  private static String searchQuery = "?q=reactive";

  private static List<GitHubSearchResponse> gitHubResponses = new ArrayList<>();

  @RequestMapping("/repos")
  public ResponseEntity<String> searchReactiveProjects() throws Exception {

    ResponseEntity<String> rawSearchResults = getResults(uri + searchQuery);

    ObjectMapper mapper = new ObjectMapper();
    ObjectNode node = jsonMarshallingService.parseGitHubResponseToJson(rawSearchResults);
    JsonNode parsedGithubProjects = jsonMarshallingService.parseGithubProjects(node);
    ArrayList<GitHubSearchResponse> formattedGithubProjects = jsonMarshallingService.marshallFormattedGithubJson(parsedGithubProjects);

    return new ResponseEntity<>(mapper.writeValueAsString(formattedGithubProjects), HttpStatus.OK);
  }
}
