package me.narat.samples.bootfaces;

import java.util.EnumSet;

import javax.faces.webapp.FacesServlet;
import javax.servlet.DispatcherType;
import javax.servlet.ServletContextListener;

import org.apache.myfaces.webapp.StartupServletContextListener;
import org.ocpsoft.rewrite.servlet.RewriteFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServletConfig {

	@Bean
	ServletRegistrationBean<FacesServlet> servletRegistration() {
		return new ServletRegistrationBean<>(new FacesServlet(), "*.jsf");
	}

	@Bean
	FilterRegistrationBean<RewriteFilter> rewriteFilter() {
		var dispatcherTypes = EnumSet.of(DispatcherType.FORWARD, DispatcherType.REQUEST, DispatcherType.ASYNC,
				DispatcherType.ERROR);

		var rwFilter = new FilterRegistrationBean<>(new RewriteFilter());
		rwFilter.setDispatcherTypes(dispatcherTypes);
		rwFilter.addUrlPatterns("/*");
		return rwFilter;
	}

	@Bean
	ServletListenerRegistrationBean<ServletContextListener> facesStartupServletContextListener() {
		ServletListenerRegistrationBean<ServletContextListener> bean = new ServletListenerRegistrationBean<>();
		bean.setListener(new StartupServletContextListener());
		return bean;
	}
}
