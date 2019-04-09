package com.tweethub.reactivegrid.services.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.tweethub.reactivegrid.domain.GitHubSearchResponse;
import com.tweethub.reactivegrid.services.JsonMarshallingService;
import java.io.IOException;
import java.util.ArrayList;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service("jsonMarshallingService")
public class JsonMarshallingServiceImpl implements JsonMarshallingService {

  private ObjectMapper mapper = new ObjectMapper();

  public ObjectNode parseGitHubResponseToJson(ResponseEntity<String> rawSearchResults) throws IOException {
    return (ObjectNode)mapper.readTree(rawSearchResults.getBody());
  }

  public JsonNode parseGithubProjects(ObjectNode githubFullJson) {
    return githubFullJson.get("items");
  }

  public ArrayList<GitHubSearchResponse> marshallFormattedGithubJson(JsonNode parsedGithubProjects)
      throws IOException {
    return mapper.readValue(parsedGithubProjects.traverse(), new TypeReference<ArrayList<GitHubSearchResponse>>(){});
  }
}
