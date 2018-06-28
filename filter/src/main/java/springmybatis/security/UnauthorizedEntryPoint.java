package springmybatis.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UnauthorizedEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest,
                         HttpServletResponse httpServletResponse,
                         AuthenticationException e)
            throws IOException, ServletException
    {

        if(isAjaxRequest(httpServletRequest)){
            httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED,e.getMessage());
        }else{
            httpServletResponse.sendRedirect("/login.html");
        }
    }

    private boolean isAjaxRequest(HttpServletRequest httpServletRequest)
    {
        String ajaxFlag  = httpServletRequest.getHeader("X-Requested-With");
        return ajaxFlag!=null&&"XMLHttpRequest".equals(ajaxFlag);
    }
}
