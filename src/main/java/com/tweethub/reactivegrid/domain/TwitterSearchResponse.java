package com.tweethub.reactivegrid.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.stereotype.Component;

@Component("twitterResponse")
@JsonIgnoreProperties(ignoreUnknown = true)
public class TwitterSearchResponse {

}
