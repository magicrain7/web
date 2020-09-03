package common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class FilterOne
 */
@WebFilter(filterName="first")
public class FilterOne implements Filter {

    /**
     * Default constructor. 
     */
    public FilterOne() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("Encoding filter 실행");
		// 서블릿 호출전 처리할 내용(인코딩)
		request.setCharacterEncoding("utf-8");
		// 다음 필터 또는 호출된 서블릿을 실행함.
		chain.doFilter(request, response);
		// 서블릿 실행 후에 처리할 내용(로그)
		System.out.println("처리완료" + ((HttpServletRequest)request).getRequestURI() );
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
