package filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
* 用于检测用户是否登陆的过滤器，如果未登录，则重定向到指的登录页面
* 配置参数
* sessionKey 需检查的在 Session 中保存的关键字
* redirectURL 如果用户未登录，则重定向到指定的页面，URL不包括 ContextPath
* checkURLList 不做检查的URL列表，以分号分开，并且 URL 中不包括 ContextPath
*/

public class CheckLoginFilter implements Filter {

	protected FilterConfig filterConfig = null;
	private String redirectURL = null;   
    private List<String> checkURLList = new ArrayList<String>();   
    private String sessionKey = null;  
    
	public void destroy() {
		filterConfig = null;
		checkURLList.clear();
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest)request;
		HttpServletResponse httpServletResponse = (HttpServletResponse)response;
		HttpSession session = httpServletRequest.getSession();
		if(sessionKey == null){
			chain.doFilter(request, response);
			return;
		}
		if(session.getAttribute(sessionKey)==null && (!isRequestURIInCheckURLList(httpServletRequest))){
			httpServletRequest.setAttribute("message", "你还未登录");
			httpServletRequest.getRequestDispatcher(redirectURL).forward(httpServletRequest, httpServletResponse);
			return;
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
		this.redirectURL = filterConfig.getInitParameter("redirectURL");
		this.sessionKey = filterConfig.getInitParameter("sessionKey");
		String checkURLListStr = filterConfig.getInitParameter("checkURLList");
		if(checkURLListStr!=null){
			StringTokenizer stringTokenizer = new StringTokenizer(checkURLListStr,";");
			checkURLList.clear();
			while (stringTokenizer.hasMoreTokens()) {
				checkURLList.add(stringTokenizer.nextToken());
			}
		}
	}

	private boolean isRequestURIInCheckURLList(HttpServletRequest request) {
		String uri = request.getServletPath()+(request.getPathInfo()==null?"":request.getPathInfo());
		return checkURLList.contains(uri);
	}
}
