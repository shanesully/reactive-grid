package com.tweethub.reactivegrid.commands;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class GitHubSearch {

  @ShellMethod(value="Search GitHub projects", key="search")
  public String search() {
    return "foo";
  }
}
