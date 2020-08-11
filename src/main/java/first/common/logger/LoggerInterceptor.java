package first.common.logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoggerInterceptor extends HandlerInterceptorAdapter {
	
	protected org.slf4j.Logger log = LoggerFactory.getLogger(LoggerInterceptor.class); //slf4j�� ����� �α׸� ���
	
	//preHandler�� postHandler �޼ҵ尡 ��ó����� ��ó���⿡ �ش�
	//preHandler�� ��Ʈ�ѷ��� ȣ��Ǳ� ���� ���� postHandler�� ��Ʈ�ѷ��� ����ǰ� �� �� ����
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		if(log.isDebugEnabled()) {
			log.debug("=============START=============\n");
			log.debug(" Request URL \t : " + request.getRequestURI()); //ȣ��� URL�� ��Ÿ��
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