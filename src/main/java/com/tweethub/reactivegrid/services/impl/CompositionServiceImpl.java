package com.tweethub.reactivegrid.services.impl;

import com.tweethub.reactivegrid.domain.CompositeProjectEntity;
import com.tweethub.reactivegrid.domain.GithubProjectEntity;
import com.tweethub.reactivegrid.domain.TweetEntity;
import com.tweethub.reactivegrid.services.CompositionService;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("reactiveGridService")
public class CompositionServiceImpl implements CompositionService {

  @Autowired
  private GithubSearchServiceImpl githubSearchService;

  @Autowired
  private TwitterSearchServiceImpl twitterSearchService;

  @Autowired
  private JsonMarshallingServiceImpl jsonMarshallingService;

  private static final String DEFAULT_PAGE = "1";

  private Map<String, TweetEntity> tweetMap;
  private List<TweetEntity> tweetsForProject;
  private List<CompositeProjectEntity> finalProjectList;
  private List<GithubProjectEntity> githubProjects;
  private Map<String, CompositeProjectEntity> finalProjectsMap;
  private CompositeProjectEntity compositeProjectEntity;

  CompositionServiceImpl() {
    tweetMap = new LinkedHashMap<>();
    tweetsForProject = new ArrayList<>();
    finalProjectList = new ArrayList<>();
    githubProjects = new ArrayList<>();
    finalProjectsMap = new LinkedHashMap<>();
  }

  public Map<String, Map<String, CompositeProjectEntity>> getProjectsWithTweets() throws Exception {
    return getProjectsWithTweets(DEFAULT_PAGE);
  }

  public Map<String, Map<String, CompositeProjectEntity>> getProjectsWithTweets(String page) throws Exception {
    flushValues();

    githubProjects = githubSearchService.getProjects(page);

    for(GithubProjectEntity project: githubProjects) {
        tweetsForProject = twitterSearchService.getTweetsByHashtag(project.getName());

        tweetMap = jsonMarshallingService.convertListToSequencedMap(tweetsForProject);

        compositeProjectEntity = new CompositeProjectEntity();
        compositeProjectEntity.setId(project.getId());
        compositeProjectEntity.setDescription(project.getDescription());
        compositeProjectEntity.setHtmlUrl(project.getHtmlUrl());
        compositeProjectEntity.setName(project.getName());

        if(tweetMap.size() > 0)
          compositeProjectEntity.setTweets(tweetMap);

        finalProjectList.add(compositeProjectEntity);
    }

    finalProjectsMap = jsonMarshallingService.convertListToSequencedMap(finalProjectList);

    return addTopLevelKeyToProjectsMap(finalProjectsMap, "githubProjects");
  }

  private Map<String, Map<String, CompositeProjectEntity>> addTopLevelKeyToProjectsMap(
      Map<String, CompositeProjectEntity> finalProjectsMap, String keyName) {
    Map<String, Map<String, CompositeProjectEntity>> finalMapNoReally = new LinkedHashMap<>();
    finalMapNoReally.put(keyName, finalProjectsMap);

    return finalMapNoReally;
  }

  private void flushValues() {
    finalProjectList = new ArrayList<>();
    githubProjects = new ArrayList<>();
    finalProjectsMap = new LinkedHashMap<>();
  }
}
