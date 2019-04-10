package com.tweethub.reactivegrid.services.impl;

import com.tweethub.reactivegrid.domain.TweetEntity;
import com.tweethub.reactivegrid.services.AbstractRestClient;
import com.tweethub.reactivegrid.services.TwitterSearchService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import twitter4j.Query;
import twitter4j.QueryResult;

@Service("TwitterSearchService")
public class TwitterSearchServiceImpl extends AbstractRestClient
    implements TwitterSearchService {

  private static final String ENGLISH_ONLY = "lang:en";
  private static final String EXCLUDE_RETWEETS = "exclude:retweets";
  private static final String EXCLUDE_REPLIES = "exclude:replies";
  private static final int COUNT = 10;
  private static final String SEPARATOR = " ";
  private static final String ENCODED_HASHTAG = "%23";

  @Autowired
  JsonMarshallingServiceImpl jsonMarshallingService;

  @Autowired
  TwitterConfigServiceImpl twitterConfigService;

  TwitterSearchServiceImpl() {
  }

  public List<TweetEntity> getTweetsByHashtag(String hashtag) throws Exception {

    QueryResult result = getTwitterSearchResultForQuery(hashtag);

    return jsonMarshallingService.convertTwitterSearchResponseToList(result);
  }

  private Query buildTwitterQuery(String query) {
    return new Query(query).count(COUNT);
  }

  private QueryResult getTwitterSearchResultForQuery(String query) throws Exception {
    return twitterConfigService
        .getTwitterInstance()
        .search(
            buildTwitterQuery(
                buildTwitterAPISearchOptions()
                    + ENCODED_HASHTAG + query
            )
        );
  }

  private String buildTwitterAPISearchOptions() {
    return ENGLISH_ONLY + SEPARATOR +
        EXCLUDE_REPLIES + SEPARATOR +
        EXCLUDE_RETWEETS + SEPARATOR;
  }
}
