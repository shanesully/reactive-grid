package com.tweethub.reactivegrid.commands.impl;

import com.tweethub.reactivegrid.commands.AbstractShellCmd;
import com.tweethub.reactivegrid.commands.GithubSearchCmd;
import com.tweethub.reactivegrid.services.impl.CompositionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class GithubSearchCmdImpl extends AbstractShellCmd implements GithubSearchCmd {

  @Autowired
  CompositionServiceImpl reactiveGridService;

  @ShellMethod(value="Search GitHub projects", key="search_tweets")
  public String search() throws Exception {
    return objectMapper.writeValueAsString(reactiveGridService.getProjectsWithTweets());
  }
}
