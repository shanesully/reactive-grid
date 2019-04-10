package com.tweethub.reactivegrid.commands.impl;

import com.tweethub.reactivegrid.commands.AbstractShellCmd;
import com.tweethub.reactivegrid.commands.ProjectSearchCmd;
import com.tweethub.reactivegrid.services.impl.CompositionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class ProjectSearchCmdImpl extends AbstractShellCmd implements ProjectSearchCmd {

  private static final String DEFAULT_PAGE = "1";

  @Autowired
  CompositionServiceImpl reactiveGridService;

  @ShellMethod(value="Search for Reactive Github projects with Tweets", key="search_reactive_projects")
  public String search(@ShellOption(defaultValue = DEFAULT_PAGE) String page) throws Exception {
    return objectMapper.writeValueAsString(reactiveGridService.getProjectsWithTweets(page));
  }
}
