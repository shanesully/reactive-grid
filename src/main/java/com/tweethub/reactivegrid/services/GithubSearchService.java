package com.tweethub.reactivegrid.services;

import com.tweethub.reactivegrid.domain.GithubProjectEntity;
import java.util.List;

public interface GithubSearchService {
  public List<GithubProjectEntity> getProjects() throws Exception;
}
