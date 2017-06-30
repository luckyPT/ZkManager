package top.letsgogo.filter;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by panteng on 2017/4/8.
 */
public class StatisticalFilter extends OncePerRequestFilter {
    /**
     * 统计记录
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param filterChain
     * @throws ServletException
     * @throws IOException
     */
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        logger.info("访问统计 " + httpServletRequest.getRemoteAddr() + " url = " + httpServletRequest.getRequestURL());
        System.out.println("访问统计 " + httpServletRequest.getRemoteAddr() + " url = " + httpServletRequest.getRequestURL());
        httpServletRequest.setCharacterEncoding("UTF-8");
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
