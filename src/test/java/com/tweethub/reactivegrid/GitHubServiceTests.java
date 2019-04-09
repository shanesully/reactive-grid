package com.tweethub.reactivegrid;

import com.tweethub.reactivegrid.services.impl.GitHubSearchServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.shell.jline.InteractiveShellApplicationRunner;
import org.springframework.shell.jline.ScriptShellApplicationRunner;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = {
    InteractiveShellApplicationRunner.SPRING_SHELL_INTERACTIVE_ENABLED + "=false",
    ScriptShellApplicationRunner.SPRING_SHELL_SCRIPT_ENABLED + "=false"
}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GitHubServiceTests {

  private static final ResponseEntity<String> SAMPLE_RESPONSE = new ResponseEntity<String>(
      HttpStatus.OK);

  @LocalServerPort
  private int port;

  @Autowired
  GitHubSearchServiceImpl gitHubSearchService;

  @Test
  public void contextLoads() {
  }

  @Test
  @Before
  public void setup() throws Exception {
  }

  @Test
  public void testGitHubServiceWorking() throws Exception {
    gitHubSearchService.searchReactiveProjects();
  }
}
