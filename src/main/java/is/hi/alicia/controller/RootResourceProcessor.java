package is.hi.alicia.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.webmvc.RepositoryLinksResource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;

public class RootResourceProcessor implements ResourceProcessor<RepositoryLinksResource> {

@Bean
@Override
public RepositoryLinksResource process(RepositoryLinksResource resource) {
    resource.add(ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(RestController.class).addAnswer(null,null)).withRel("addAnswer"));
    return resource;
    }
}