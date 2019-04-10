package com.tweethub.reactivegrid.domain;

import lombok.Getter;
import lombok.Setter;

public abstract class AbstractEntity {
  @Getter @Setter private int id;
  @Getter @Setter private String name;
}
