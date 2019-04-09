package com.tweethub.reactivegrid;

import com.tweethub.reactivegrid.services.impl.TwitterSearchServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.shell.Shell;
import org.springframework.shell.jline.InteractiveShellApplicationRunner;
import org.springframework.shell.jline.ScriptShellApplicationRunner;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = {
		InteractiveShellApplicationRunner.SPRING_SHELL_INTERACTIVE_ENABLED + "=false",
		ScriptShellApplicationRunner.SPRING_SHELL_SCRIPT_ENABLED + "=false"
})
public class ReactiveGridApplicationTests {

	@Autowired
	private Shell shell;

	@Autowired
	TwitterSearchServiceImpl twitterSearchService;

	@Test
	public void contextLoads() {
	}
}
