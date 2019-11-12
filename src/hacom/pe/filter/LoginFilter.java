package hacom.pe.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import hacom.pe.util.SistConstants;

//public class LoginFilter implements Filter {
//
//	final static Logger log = LogManager.getLogger(LoginFilter.class.getName());
//	private String homePage = "/index.jsf";
//	private String loginPage = "/login.jsf";
//	private String timeoutPage = "/login.jsf?timeout=out";
//
//	/**
//	 *
//	 * @param filterConfig
//	 * @throws ServletException
//	 */
//	public void init(FilterConfig filterConfig) throws ServletException {
//	}
//
//	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
//			throws IOException, ServletException {
//		if ((request instanceof HttpServletRequest) && (response instanceof HttpServletResponse)) {
//
//			HttpServletRequest httpServletRequest = (HttpServletRequest) request;
//			HttpServletResponse httpServletResponse = (HttpServletResponse) response;
//
//			String requestPath = httpServletRequest.getRequestURI();
//
//			if (!(requestPath.endsWith(".js.jsf") || 
//					requestPath.endsWith(".css.jsf") || 
//					requestPath.endsWith(".ttf.jsf") || 
//					requestPath.endsWith(".gif.jsf") || 
//					requestPath.endsWith(".png.jsf") || 
//					requestPath.endsWith(".woff2.jsf"))) {
//
//				log.debug("Accediendo a: " + requestPath);
//				boolean loginVal = requestPath.endsWith("login.jsf");
//				if (!loginVal) {
//					if (isSessionControlRequiredForThisResource(httpServletRequest)) {
//						if (isSessionInvalid(httpServletRequest)) {
//							String timeoutUrl = httpServletRequest.getContextPath() + getTimeoutPage();
//							log.debug("-->> Session finalizada TimeOut");
//							if (isAjax(httpServletRequest)) {
//								httpServletResponse.setContentType("text/xml");
//								httpServletResponse.getWriter().append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>")
//										.printf("<partial-response><redirect url=\"%s\"></redirect></partial-response>",
//												timeoutUrl);
//								// httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//								// httpServletResponse.setHeader("Location",
//								// httpServletResponse.encodeRedirectURL(timeoutUrl.toString()));
//								// httpServletResponse.flushBuffer();
//							} else {
//								httpServletResponse.sendRedirect(timeoutUrl);
//							}
//							return;
//						} else {
//							log.debug("Verificando dentro de session si esta logeado o salir");
//							HttpSession session = (HttpSession) httpServletRequest.getSession();
//							String varSession = (String) session.getAttribute(SistConstants.SESSION_INFO);
//							if (varSession == null) {
//								log.debug("-->> Saliendo porque no esta autentificado");
//								String url = httpServletRequest.getContextPath() + getLoginPage();
//
//								if (isAjax(httpServletRequest)) {
//									httpServletResponse.setContentType("text/xml");
//									httpServletResponse.getWriter().append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>")
//											.printf("<partial-response><redirect url=\"%s\"></redirect></partial-response>",
//													url);
//									// httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//									// httpServletResponse.setHeader("Location",
//									// httpServletResponse.encodeRedirectURL(timeoutUrl.toString()));
//									// httpServletResponse.flushBuffer();
//								} else {
//									httpServletResponse.sendRedirect(url);
//								}
//
//								return;
//							} else {
//								log.debug("Logeado <<--");
//							}
//						}
//					}
//				}
//			}
//
//		}
//		try {
//
//			filterChain.doFilter(request, response);
//		} catch (Exception e) {
//			e.printStackTrace();
//			log.error("Error LoginFilter:", e.getMessage());
//			log.error("Remote Host:", ((HttpServletRequest) request).getRemoteHost());
//
//			String homeUrl = ((HttpServletRequest) request).getContextPath() + getHomePage();
//			((HttpServletResponse) response).setContentType("text/xml");
//			((HttpServletResponse) response).getWriter().append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>")
//					.printf("<partial-response><redirect url=\"%s\"></redirect></partial-response>", homeUrl);
//			return;
//			// ((HttpServletResponse)
//			// response).sendRedirect(((HttpServletRequest)
//			// request).getContextPath() + getTimeoutPage());
//			// FacesContext.getCurrentInstance().getExternalContext().redirect(((HttpServletRequest)
//			// request).getContextPath() + getTimeoutPage());
//		}
//
//	}
//
//	private boolean isAjax(HttpServletRequest request) {
//		return "XMLHttpRequest".equals(request.getHeader("X-Requested-With"));
//	}
//
//	private boolean isSessionControlRequiredForThisResource(HttpServletRequest httpServletRequest) {
//		String requestPath = httpServletRequest.getRequestURI();
//		boolean controlRequired = !StringUtils.contains(requestPath, getTimeoutPage());
//		/*
//		 * log.info("- IsSessionControlRequiredForThisResource:" +
//		 * controlRequired); log.info("-----> requestPath:" + requestPath);
//		 * log.info("-----> getTimeoutPage:" + getTimeoutPage());
//		 * log.info("-----> controlRequired:" + controlRequired);
//		 */
//		return controlRequired;
//	}
//
//	private boolean isSessionInvalid(HttpServletRequest httpServletRequest) {
//		boolean sessionInValid = (httpServletRequest.getRequestedSessionId() != null)
//				&& !httpServletRequest.isRequestedSessionIdValid();
//		/*
//		 * log.info("- IsSessionInvalid:"+sessionInValid);
//		 * log.info("-----> getRequestedSessionId:"+httpServletRequest.
//		 * getRequestedSessionId());
//		 * log.info("-----> isRequestedSessionIdValid:"+httpServletRequest.
//		 * isRequestedSessionIdValid());
//		 * log.info("-----> sessionInValid:"+sessionInValid);
//		 */
//		return sessionInValid;
//	}
//
//	public void destroy() {
//	}
//
//	public String getTimeoutPage() {
//		return timeoutPage;
//	}
//
//	public void setTimeoutPage(String timeoutPage) {
//		this.timeoutPage = timeoutPage;
//	}
//
//	public String getLoginPage() {
//		return loginPage;
//	}
//
//	public void setLoginPage(String loginPage) {
//		this.loginPage = loginPage;
//	}
//
//	public String getHomePage() {
//		return homePage;
//	}
//
//	public void setHomePage(String homePage) {
//		this.homePage = homePage;
//	}
//}