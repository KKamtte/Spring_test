package first.sample.controller;

import java.util.Map;
import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Controller
public class SampleController {
	
	//org.slf4j.Logger log = Logger.getLogger(this.getClass()); 
	
	@RequestMapping(value="/sample/openSampleList.do")
	
	public ModelAndView openSampleList(Map<String,Object> commandMap) throws Exception {
		ModelAndView mv = new ModelAndView("");
		//log.debug("인터셉터 테스트");
		
		return mv;
	}
}
