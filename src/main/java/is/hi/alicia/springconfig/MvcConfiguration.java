package is.hi.alicia.springconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import de.neuland.jade4j.JadeConfiguration;
import de.neuland.jade4j.spring.template.SpringTemplateLoader;
import de.neuland.jade4j.spring.view.JadeViewResolver;

@Configuration
public class MvcConfiguration extends WebMvcConfigurerAdapter {

	@Bean
	public SpringTemplateLoader templateLoader() {
		SpringTemplateLoader templateLoader = new SpringTemplateLoader();
		templateLoader.setBasePath("/WEB-INF/views/");
		templateLoader.setEncoding("UTF-8");
		templateLoader.setSuffix(".jade");
		return templateLoader;
	}

	@Bean
	public JadeConfiguration jadeConfiguration() {
		JadeConfiguration configuration = new JadeConfiguration();
		configuration.setCaching(false);
		configuration.setTemplateLoader(templateLoader());
		return configuration;
	}

	@Bean
	public ViewResolver viewResolver() {
		JadeViewResolver viewResolver = new JadeViewResolver();
		viewResolver.setConfiguration(jadeConfiguration());
		return viewResolver;
	}
}