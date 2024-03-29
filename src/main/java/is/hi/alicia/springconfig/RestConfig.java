
package is.hi.alicia.springconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

import is.hi.alicia.model.*;

@Configuration
public class RestConfig extends RepositoryRestConfigurerAdapter {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
    	config.setBasePath("/api");
        config.exposeIdsFor(Answer.class);
        config.exposeIdsFor(Assignment.class);
        config.exposeIdsFor(Course.class);
        config.exposeIdsFor(User.class);
    }
}