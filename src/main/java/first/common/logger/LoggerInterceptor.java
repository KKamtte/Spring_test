package first.common.logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoggerInterceptor extends HandlerInterceptorAdapter {
	
	protected org.slf4j.Logger log = LoggerFactory.getLogger(LoggerInterceptor.class); //slf4j를 사용해 로그를 출력
	
	//preHandler와 postHandler 메소드가 전처리기와 후처리기에 해당
	//preHandler는 컨트롤러가 호출되기 전에 실행 postHandler는 컨트롤러가 실행되고 난 후 실행
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		if(log.isDebugEnabled()) {
			log.debug("=============START=============\n");
			log.debug(" Request URL \t : " + request.getRequestURI()); //호출된 URL을 나타냄
		}
		return super.preHandle(request, response, handler);
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		if(log.isDebugEnabled()) {
			log.debug("=============END=============\n");
		}
	}
}