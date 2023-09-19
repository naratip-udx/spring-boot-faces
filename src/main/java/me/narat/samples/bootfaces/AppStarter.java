package me.narat.samples.bootfaces;

import java.util.EnumSet;

import org.ocpsoft.rewrite.servlet.RewriteFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import jakarta.faces.webapp.FacesServlet;
import jakarta.servlet.DispatcherType;

@SpringBootApplication
public class AppStarter extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(AppStarter.class, args);
	}

	@Bean
	ServletRegistrationBean<FacesServlet> servletRegistrationBean() {
		var servlet = new FacesServlet();
		return new ServletRegistrationBean<>(servlet, "*.jsf");
	}

	@Bean
	FilterRegistrationBean<RewriteFilter> rewriteFilter() {
		var dispatcherTypes = EnumSet.of(DispatcherType.FORWARD, DispatcherType.REQUEST, DispatcherType.ASYNC,
				DispatcherType.ERROR);

		var rewriteFilter = new FilterRegistrationBean<>(new RewriteFilter());
		rewriteFilter.setDispatcherTypes(dispatcherTypes);
		rewriteFilter.addUrlPatterns("/*");
		return rewriteFilter;
	}
}
