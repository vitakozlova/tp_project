package bsu.fpmi.tp.util.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.ReflectionSaltSource;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Vlad Abramov
 * @since 18.11.2014
 */
@Configuration
public class JavaAppConfig {

    @Bean(name = "passwordEncoder")
    public PasswordEncoder getPasswordEncoder() {
        return new ShaPasswordEncoder(256);
    }

    @Bean(name = "saltSource")
    public ReflectionSaltSource getSaltSource() {
        ReflectionSaltSource saltSource = new ReflectionSaltSource();
        saltSource.setUserPropertyToUse("username");
        return saltSource;
    }

    @Bean(name = "viewResolver")
    public ContentNegotiatingViewResolver getViewResolver() {
        ContentNegotiatingViewResolver viewResolver = new ContentNegotiatingViewResolver();

        Map<String, String> mediaTypes = new HashMap<String, String>();
        mediaTypes.put("html", "text/html");
        mediaTypes.put("json", "application/json");
        viewResolver.setMediaTypes(mediaTypes);

        UrlBasedViewResolver urlBasedViewResolver = new UrlBasedViewResolver();
        urlBasedViewResolver.setViewClass(JstlView.class);
        urlBasedViewResolver.setPrefix("/WEB-INF/pages/");
        urlBasedViewResolver.setSuffix(".jsp");
        viewResolver.setViewResolvers(Arrays.<ViewResolver>asList(urlBasedViewResolver));

        MappingJacksonJsonView jsonView = new MappingJacksonJsonView();
        jsonView.setPrefixJson(true);
        viewResolver.setDefaultViews(Arrays.<View>asList(jsonView));

        return viewResolver;
    }
}
