package com.budget.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;

/**
 * Created by home on 14.11.16.
 */
@Configuration
public class TilesConfig {
    @Bean
    public TilesConfigurer tilesConfigurer() {
        TilesConfigurer configurer = new TilesConfigurer();
        configurer.setDefinitions(new String[] {
                "/WEB-INF/tiles-definitions.xml"
        });
        return configurer;
    }
}
