package com.example.demo.config.filter;

import javax.servlet.*;
import javax.servlet.FilterConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @Author yaKun.shi
 */
public class CustomizeFilter implements Filter {
    private static final String URL_TEST = "/test";
    private static final String URL_INTER = "/test/inter";
    private static final String URLFILTER = "/test";

    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String requestURI = request.getRequestURI();
        if (requestURI.equals(URL_INTER)) {
            System.out.println("filter过滤 /test/inter接口");
            filterChain.doFilter(request, response);
            System.out.println("结束filter过滤 /test/inter接口");
        } else {
            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");
            response.setContentType("application/json;charset=utf-8");
            URL url = new URL("http://localhost:8080/test1/inter");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = connection.getInputStream();
            byte[] buffer = new byte[1024];
            int read = inputStream.read(buffer);
            ServletOutputStream outputStream = response.getOutputStream();
            while (read != -1) {
                outputStream.write(buffer, 0, read);
                read = inputStream.read(buffer);
            }
            String result = new String(buffer);
            System.out.println(result);
            outputStream.close();
            inputStream.close();
            filterChain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
