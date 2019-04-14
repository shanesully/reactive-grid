package com.tweethub.reactivegrid.unit.tests;

import static org.assertj.core.api.Assertions.assertThat;

import com.tweethub.reactivegrid.domain.CompositeProjectEntity;
import com.tweethub.reactivegrid.services.impl.CompositionServiceImpl;
import java.util.Map;
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
public class CompositionServiceTests {

  @Autowired
  private CompositionServiceImpl compositionService;

  private static final String SPECIFIC_PAGE = "2";
  private static final String TOP_LEVEL_KEY = "githubProjects";
  private static final int PROJECT_RESULTS_PER_PAGE = 5;

  private Map<String, Map<String, CompositeProjectEntity>> compositeProjectsMap;

  @Test
  public void contextLoads() { }

  @Test
  public void testGetProjectWithTweetsDefaultPage() throws Exception {
    compositeProjectsMap = compositionService.getProjectsWithTweets();

    assertThat(compositeProjectsMap.get("githubProjects").size()).isEqualTo(PROJECT_RESULTS_PER_PAGE);
  }

  @Test
  public void testGetProjectWithTweetsSpecifyPage() throws Exception {
    compositeProjectsMap = compositionService.getProjectsWithTweets(SPECIFIC_PAGE);
  }
}
