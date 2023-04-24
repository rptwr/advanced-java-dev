package examples.h1;

// 010 Step 08 - Exploring Java Spring XML Configuration

import java.util.Arrays;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import game.GameRunner;

public class XmlConfigurationContextLauncherApplication {
	
	public static void main(String[] args) {

		try (var context = 
				new ClassPathXmlApplicationContext("contextConfiguration.xml")) {
			
			Arrays.stream(context.getBeanDefinitionNames())
				.forEach(System.out::println);
			
			System.out.println(context.getBean("name"));
			
			System.out.println(context.getBean("age"));
			
			context.getBean(GameRunner.class).run();

		}
	}
}


// create a new XML file
// whatever we are doing in java cofiguration all of that we can do that in XML configration