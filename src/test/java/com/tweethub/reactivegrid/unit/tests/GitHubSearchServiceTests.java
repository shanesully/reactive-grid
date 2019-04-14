package com.tweethub.reactivegrid.unit.tests;

import static org.assertj.core.api.Assertions.assertThat;

import com.tweethub.reactivegrid.domain.GithubProjectEntity;
import com.tweethub.reactivegrid.services.impl.GithubSearchServiceImpl;
import java.util.ArrayList;
import java.util.List;
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
public class GitHubSearchServiceTests {

  private List<GithubProjectEntity> getProjectsResponse;

  @Autowired
  private GithubSearchServiceImpl githubSearchService;

  @Test
  public void contextLoads() { }

  @Test
  public void testGetProjectsReturnsProjectList() throws Exception {
    getProjectsResponse = githubSearchService.getProjects();

    assertThat(getProjectsResponse).isNotEmpty();
    assertThat(getProjectsResponse.get(0).getDescription()).isNotEmpty();
  }

  @Test
  public void testGetProjectsSpecifyPage() throws Exception {
    getProjectsResponse = new ArrayList<>();
    getProjectsResponse = githubSearchService.getProjects("2");

    assertThat(getProjectsResponse).isNotEmpty();
    assertThat(getProjectsResponse.get(0).getDescription()).isNotEmpty();
  }
}
