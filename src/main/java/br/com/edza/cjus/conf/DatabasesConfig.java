package br.com.edza.cjus.conf;
import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DatabasesConfig {

	@Primary
    @Bean(name="cjus")
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource gatwaypagtoDataSource() {
      DataSource build = DataSourceBuilder.create().build();
	return build;
    }
}
