package exposed.assignment.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class FileAccessConfigurer implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/external-files/**")
                .addResourceLocations("file:external-files/")
                .setCachePeriod(3600);
    }
}
