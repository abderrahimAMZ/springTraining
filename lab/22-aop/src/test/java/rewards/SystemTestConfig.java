package rewards;

import javax.sql.DataSource;

import config.AspectsConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

import config.RewardsConfig;


/** 
 * TODO-05: Make this configuration include the aspect configuration. 
 * Save all your work, run the LoggingAspectTests.  It should pass, 
 * and you should see one line of LoggingAspect output in the console.	 
 */
@Configuration
@Import({AspectsConfig.class, RewardsConfig.class})
@ComponentScan("rewards.internal.aspects")
public class SystemTestConfig {

	
	/**
	 * Creates an in-memory "rewards" database populated 
	 * with test data for fast testing
	 */
	@Bean
	public DataSource dataSource(){
		return
			(new EmbeddedDatabaseBuilder())
			.addScript("classpath:rewards/testdb/schema.sql")
			.addScript("classpath:rewards/testdb/data.sql")
			.build();
	}	
	
}
