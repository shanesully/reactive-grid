package com.tweethub.reactivegrid.commands.impl;

import com.tweethub.reactivegrid.commands.AbstractShellCmd;
import com.tweethub.reactivegrid.commands.TwitterSearchCmd;
import com.tweethub.reactivegrid.services.impl.TwitterSearchServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class TwitterSearchCmdImpl extends AbstractShellCmd implements TwitterSearchCmd {

  @Autowired
  TwitterSearchServiceImpl twitterSearchService;

  @ShellMethod(value="Search TweetEntity by Hashtag", key="get_tweets_for_project")
  public String searchTweetsForProject(String projectName) throws Exception {
    return objectMapper.writeValueAsString(
        jsonMarshallingService.convertListToSequencedMap(
          twitterSearchService.getTweetsByHashtag(projectName)
        )
    );
  }
}