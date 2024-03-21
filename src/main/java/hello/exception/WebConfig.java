package hello.exception;

import hello.exception.interceptor.LogInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
//    @Bean
//    public FilterRegistrationBean logFilter() {
//        FilterRegistrationBean<Filter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
//        filterFilterRegistrationBean.setFilter(new LogFilter());
//        filterFilterRegistrationBean.setOrder(1);
//        filterFilterRegistrationBean.addUrlPatterns("/*");
//        // Request, error 호출의 경우 logFilter 호출
//        // default: DispatcherType.REQUEST
//        filterFilterRegistrationBean.setDispatcherTypes(DispatcherType.REQUEST, DispatcherType.ERROR);
//        return filterFilterRegistrationBean;
//    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogInterceptor())
                .order(1)
                .addPathPatterns("/**")
                // 인터셉터는 DispatcherType 설정이 없는 대신 excludePathPatterns로 설정
                .excludePathPatterns("/css/**", "/*.ico", "/error"/*, "/error-page/**"*/);
    }
}
