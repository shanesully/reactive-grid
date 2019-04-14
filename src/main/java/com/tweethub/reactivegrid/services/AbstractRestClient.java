package com.tweethub.reactivegrid.services;

import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public abstract class AbstractRestClient {

  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

  public ResponseEntity<String> getResults(String uri) {
    ResponseEntity<String> rawSearchResults
        = restTemplate().getForEntity(uri, String.class);

    return rawSearchResults;
  }
}
