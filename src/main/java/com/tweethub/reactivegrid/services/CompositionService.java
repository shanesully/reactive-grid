package com.tweethub.reactivegrid.services;

import com.tweethub.reactivegrid.domain.CompositeProjectEntity;
import java.util.Map;

public interface CompositionService {
  public Map<String, Map<String, CompositeProjectEntity>> getProjectsWithTweets(String page) throws Exception;
}
