package springmybatis.errorpage;


import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

@Configuration
public class Errorconfig implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> {

    @Override
    public void customize(ConfigurableServletWebServerFactory factory)
    {
        ErrorPage errorPage400 = new ErrorPage(HttpStatus.BAD_REQUEST, "/error.html");
        ErrorPage errorPage404 = new ErrorPage(HttpStatus.NOT_FOUND, "/error.html");
        ErrorPage errorPage500 = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error.html");
        factory.addErrorPages(errorPage400,errorPage404,errorPage500);
    }
}
