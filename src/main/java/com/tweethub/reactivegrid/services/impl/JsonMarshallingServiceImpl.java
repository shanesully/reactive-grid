package com.tweethub.reactivegrid.services.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.tweethub.reactivegrid.domain.GithubProjectEntity;
import com.tweethub.reactivegrid.domain.TweetEntity;
import com.tweethub.reactivegrid.services.JsonMarshallingService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import twitter4j.QueryResult;

@Service("jsonMarshallingService")
public class JsonMarshallingServiceImpl implements JsonMarshallingService {

  private static final int OFFSET = 1;

  private ObjectMapper mapper = new ObjectMapper();

  public JsonNode parseHttpResponseToJson(ResponseEntity<String> httpResponse) throws IOException {
    return (ObjectNode)mapper.readTree(httpResponse.getBody());
  }

  public JsonNode parseGitHubProjectsFromJson(JsonNode parsedGithubProjects) {
    return parsedGithubProjects.get("items");
  }

  public List<TweetEntity> convertTwitterSearchResponseToList(QueryResult twitterSearchResponse) throws IOException {
    JsonNode jsonNode = mapper.valueToTree(twitterSearchResponse.getTweets());

    return mapper.readValue(jsonNode.traverse(), new TypeReference<ArrayList<TweetEntity>>(){});
  }

  public List<GithubProjectEntity> returnGitHubProjectsList(JsonNode json) throws Exception {
    return mapper.readValue(json.traverse(), new TypeReference<ArrayList<GithubProjectEntity>>(){});
  }

  public <T> Map<String, T> convertListToSequencedMap(List<T> list) {
    Map<String, T> orderedMap = new LinkedHashMap<>();

    for(T entity: list) {
      orderedMap.put(
          String.valueOf(list.indexOf(entity) + OFFSET),
          entity
      );
    }

    return orderedMap;
  }
}
