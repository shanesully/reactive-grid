package com.tweethub.reactivegrid.commands;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class TwitterSearch {

  @ShellMethod(value="Search Tweet by Hashtag", key="tweets")
  public String searchTweets(String hashtag) {
    return "foo";
  }
}