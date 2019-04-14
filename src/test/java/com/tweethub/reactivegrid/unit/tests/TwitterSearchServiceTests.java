package com.tweethub.reactivegrid.unit.tests;

import static org.assertj.core.api.Assertions.assertThat;

import com.tweethub.reactivegrid.domain.TweetEntity;
import com.tweethub.reactivegrid.services.impl.TwitterSearchServiceImpl;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.shell.jline.InteractiveShellApplicationRunner;
import org.springframework.shell.jline.ScriptShellApplicationRunner;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = {
    InteractiveShellApplicationRunner.SPRING_SHELL_INTERACTIVE_ENABLED + "=false",
    ScriptShellApplicationRunner.SPRING_SHELL_SCRIPT_ENABLED + "=false"
})
public class TwitterSearchServiceTests {

  @Autowired
  private TwitterSearchServiceImpl twitterSearchService;

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

    assertThat(tweets.size()).isNotZero();
    assertThat(tweets.get(0).getId()).isNotNull();
    assertThat(tweets.get(0).getText()).isNotNull();
  }
}