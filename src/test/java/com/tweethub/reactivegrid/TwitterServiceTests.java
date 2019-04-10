package com.tweethub.reactivegrid;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;

import com.tweethub.reactivegrid.domain.TweetEntity;
import com.tweethub.reactivegrid.services.impl.TwitterSearchServiceImpl;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.shell.jline.InteractiveShellApplicationRunner;
import org.springframework.shell.jline.ScriptShellApplicationRunner;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = {
    InteractiveShellApplicationRunner.SPRING_SHELL_INTERACTIVE_ENABLED + "=false",
    ScriptShellApplicationRunner.SPRING_SHELL_SCRIPT_ENABLED + "=false"
}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TwitterServiceTests {

  @LocalServerPort
  private int port;

  @MockBean
  TwitterSearchServiceImpl twitterSearchService;

  List<TweetEntity> sampleTweets = new ArrayList<>();

  @Test
  public void contextLoads() {
  }

  @Test
  @Before
  public void setup() {
  }

  @Test
  public void testTwitterServiceWorking() throws Exception {
    List<TweetEntity> tweets = twitterSearchService.getTweetsByHashtag("reactive");

    assertThat(tweets.size()).isEqualTo(15);
  }
}