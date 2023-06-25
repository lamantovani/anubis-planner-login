package br.com.anubis.planner.app;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.web.context.ContextLoaderListener;

import java.util.EnumSet;

public class Application implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext serviletContext) throws ServletException {
        AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
        webApplicationContext.setConfigLocation("br.com.anubis.planner.configuration");

        Dynamic appServlet = serviletContext.addServlet("appServlet", new DispatcherServlet(webApplicationContext));
        appServlet.setLoadOnStartup(1);
        appServlet.addMapping("/app/*");

        serviletContext.addListener(new ContextLoaderListener(webApplicationContext));
//
//        FilterRegistration.Dynamic filter = serviletContext.addFilter("openEntityManagerFilter", buildOpenEntityManagerFiler());
//        filter.addMappingForUrlPatterns(getDispacherType(), false, "/*");

    }

    private OpenEntityManagerInViewFilter buildOpenEntityManagerFiler() {
        OpenEntityManagerInViewFilter openEntityManagerInViewFilter = new OpenEntityManagerInViewFilter();
        openEntityManagerInViewFilter.setEntityManagerFactoryBeanName("entityManagerFactory");
        return openEntityManagerInViewFilter;
    }

    private EnumSet<DispatcherType> getDispacherType(){
        return EnumSet.of(DispatcherType.REQUEST,DispatcherType.FORWARD, DispatcherType.INCLUDE, DispatcherType.ASYNC);
    }
}
