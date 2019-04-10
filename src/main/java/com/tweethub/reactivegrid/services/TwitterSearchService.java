package com.tweethub.reactivegrid.services;

import com.tweethub.reactivegrid.domain.TweetEntity;
import java.util.List;

public interface TwitterSearchService {
  public List<TweetEntity> getTweetsByHashtag(String hashtag) throws Exception;
}
