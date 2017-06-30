package top.letsgogo.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.letsgogo.filter.StatisticalFilter;

/**
 * @author panteng
 * @description
 * @date 17-6-30.
 */
@Configuration
public class FilterConfig {
    //记录IP
    @Bean
    public FilterRegistrationBean someFilterRegistration() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new StatisticalFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.setOrder(1);
        return filterRegistrationBean;
    }
}
