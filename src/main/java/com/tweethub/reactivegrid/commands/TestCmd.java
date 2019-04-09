package com.tweethub.reactivegrid.commands;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class TestCmd {

  @ShellMethod(value="Testing shell methods", key="add")
  public int add(int a, int b) {
    return a + b;
  }
}
