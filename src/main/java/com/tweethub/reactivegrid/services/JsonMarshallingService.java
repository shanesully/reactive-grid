package com.tweethub.reactivegrid.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.tweethub.reactivegrid.domain.GitHubSearchResponse;
import java.io.IOException;
import java.util.ArrayList;
import org.springframework.http.ResponseEntity;

public interface JsonMarshallingService {
  public ObjectNode parseGitHubResponseToJson(ResponseEntity<String> rawSearchResults) throws IOException;
  public JsonNode parseGithubProjects(ObjectNode githubFullJson);
  public ArrayList<GitHubSearchResponse> marshallFormattedGithubJson(JsonNode parsedGithubProjects) throws IOException;
}
