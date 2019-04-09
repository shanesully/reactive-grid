package com.tweethub.reactivegrid;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.shell.Input;
import org.springframework.shell.Shell;
import org.springframework.shell.jline.InteractiveShellApplicationRunner;
import org.springframework.shell.jline.ScriptShellApplicationRunner;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = {
		InteractiveShellApplicationRunner.SPRING_SHELL_INTERACTIVE_ENABLED + "=false",
		ScriptShellApplicationRunner.SPRING_SHELL_SCRIPT_ENABLED + "=false"
})
public class ReactiveGridApplicationTests {

	@Autowired
	private Shell shell;

	@Test
	public void addTwoNumbers(){
		Object result = shell.evaluate(new Input(){
			@Override
			public String rawText() {
				return "add 1 1";
			}

		});

		assertThat(result).isEqualTo(2);
	}

	@Test
	public void contextLoads() {
	}
}
