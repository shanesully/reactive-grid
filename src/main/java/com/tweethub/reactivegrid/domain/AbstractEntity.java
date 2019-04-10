package com.tweethub.reactivegrid.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public abstract class AbstractEntity {
  private int id;
  private String name;

  @JsonInclude(Include.NON_NULL)
  public String getName(){
    return this.name;
  }
}
