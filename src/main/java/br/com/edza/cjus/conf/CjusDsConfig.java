package br.com.edza.cjus.conf;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(
        entityManagerFactoryRef = "cjusEntityManagerFactory",
        transactionManagerRef = "cjusTransactionManager",
        basePackages = "br.com.edza.cjus.repository"
)
@EnableTransactionManagement
public class CjusDsConfig {

	  @Primary
	    @Bean(name = "cjusEntityManagerFactory")
	    public LocalContainerEntityManagerFactoryBean gatewaypagtoEntityManagerFactory(final EntityManagerFactoryBuilder builder,
	                                                                            final @Qualifier("cjus") DataSource dataSource) {
	        return builder
	                .dataSource(dataSource)
	                .packages("br.com.edza.cjus.model")
	                .persistenceUnit("cjus")
	                .build();
	    }

    @Bean(name = "cjusTransactionManager")
    public PlatformTransactionManager cjusTransactionManager(@Qualifier("cjusEntityManagerFactory") EntityManagerFactory cjusEntityManagerFactory) {
        return new JpaTransactionManager(cjusEntityManagerFactory);
    }
}