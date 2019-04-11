package com.tweethub.reactivegrid;

import static org.assertj.core.api.Assertions.assertThat;

import com.tweethub.reactivegrid.domain.CompositeProjectEntity;
import com.tweethub.reactivegrid.services.impl.GithubSearchServiceImpl;
import com.tweethub.reactivegrid.services.impl.CompositionServiceImpl;
import com.tweethub.reactivegrid.services.impl.TwitterSearchServiceImpl;
import java.util.Map;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.shell.Shell;
import org.springframework.shell.jline.InteractiveShellApplicationRunner;
import org.springframework.shell.jline.ScriptShellApplicationRunner;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = {
		InteractiveShellApplicationRunner.SPRING_SHELL_INTERACTIVE_ENABLED + "=false",
		ScriptShellApplicationRunner.SPRING_SHELL_SCRIPT_ENABLED + "=false"
})
@PropertySource("classpath:resources/twitter4j.properties ")
public class E2eIntegrationTests {

	@Autowired
	private Shell shell;

	@Autowired
	private GithubSearchServiceImpl githubSearchService;

	@Autowired
	private TwitterSearchServiceImpl twitterSearchService;

	@Autowired
  private CompositionServiceImpl reactiveGridService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testService() throws Exception {
		Map<String, Map<String, CompositeProjectEntity>> compositeProjectEntityList = reactiveGridService.getProjectsWithTweets();

		assertThat(compositeProjectEntityList.size()).isNotEqualTo(0);
	}
}
