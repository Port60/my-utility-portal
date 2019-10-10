package com.myutility;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

  private static final String[] CLASSPATH_RESOURCE_LOCATIONS =
      {"classpath:/static/app/src/", "classpath:/templates/app/"};

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/**").addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS)
        .resourceChain(true).addResolver(new PathResourceResolver());
    // registry.addResourceHandler("/node_modules/**")
    // .addResourceLocations("classpath:/templates/app/").resourceChain(true)
    // .addResolver(new PathResourceResolver());
    //
    // registry.addResourceHandler("/js/**").addResourceLocations("classpath:/templates/app/src/")
    // .resourceChain(true).addResolver(new PathResourceResolver());
    // registry.addResourceHandler("/img/**").addResourceLocations("classpath:/templates/app/src/")
    // .resourceChain(true).addResolver(new PathResourceResolver());
    // registry.addResourceHandler("/icons/**").addResourceLocations("classpath:/templates/app/src/")
    // .resourceChain(true).addResolver(new PathResourceResolver());
    // registry.addResourceHandler("/vendors/**").addResourceLocations("classpath:/templates/app/src/")
    // .resourceChain(true).addResolver(new PathResourceResolver());

  }
}
