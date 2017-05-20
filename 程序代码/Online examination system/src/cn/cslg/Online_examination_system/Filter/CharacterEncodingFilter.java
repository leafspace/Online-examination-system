package cn.cslg.Online_examination_system.Filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.ServletException;

/**
 * Created by leafspace on 2017/5/20.
 * LastEdit: 2017-5-20
 * Contact me:
 *     Phone: 18852923073
 *     E-mail: 18852923073@163.com
 */

public class CharacterEncodingFilter implements Filter {
	public void destroy() {}

	/**
	 * @param request 
	 * @param response 
	 * @param chain 
	 * @return
     * @function 过滤程序中的不同编码项
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,ServletException {
		request.setCharacterEncoding("utf-8");
		chain.doFilter(request, response);
	}

	public void init(FilterConfig arg0) throws ServletException {}
}