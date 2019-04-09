package com.tweethub.reactivegrid.commands;

import com.tweethub.reactivegrid.services.impl.GitHubSearchServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class GitHubSearch {

  @Autowired
  GitHubSearchServiceImpl gitHubSearchService;

  @ShellMethod(value="Search GitHub projects", key="search")
  public String search() throws Exception {
    return gitHubSearchService.searchReactiveProjects().getBody();
  }
}
