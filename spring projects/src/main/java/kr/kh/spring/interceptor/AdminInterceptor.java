package kr.kh.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.kh.spring.model.vo.MemberVO;

//관리자만 관리자 페이지에 접근할 수 있게 하기 위해서 제작
public class AdminInterceptor extends HandlerInterceptorAdapter{
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler)
			throws Exception {
		//로그인한 회원 정보를 가져옴
		MemberVO user =(MemberVO)request.getSession().getAttribute("user");
		
		//로그인한 회원이 관리자 이면 가려던 길을 가고
		if(user == null || user.getMe_authority().equals("ADMIN")) {
			response.setContentType("text/html; charset=UTF-8");
			response.getWriter().write("<script>alert(\"관리자만 접근할 수 있습니다.\")<script>");
			response.getWriter().write("<script>location.href=\""+request.getContextPath()
						+"/"+"\"<script>");
			response.flushBuffer();
			return false;
		}
		//아니면 메인 페이지로 이동
		return true;
	}		
}
