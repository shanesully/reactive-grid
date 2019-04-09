package com.tweethub.reactivegrid.services.impl;

import com.tweethub.reactivegrid.services.AbstractRestClient;
import com.tweethub.reactivegrid.services.TwitterSearchClientService;
import org.springframework.stereotype.Service;

@Service("TwitterSearchClientService")
public class TwitterSearchServiceImpl extends AbstractRestClient
    implements TwitterSearchClientService {

  public String getTweetsForHashtag(String hashtag) {
    return "foo";
  }
}
