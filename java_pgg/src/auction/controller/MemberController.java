package auction.controller;

import java.util.Scanner;

import auction.model.vo.MemberVO;
import auction.service.MemberService;
import auction.service.MemberServiceImp;



public class MemberController {
	private MemberService memberService = new MemberServiceImp();
	private Scanner scan;
	
	public MemberController(Scanner scan) {
		this.scan = scan;
	}

	public MemberVO login() {
		//아이디 입력
		System.out.print("아이디 : ");
		String id = scan.next();

		//비번 입력
		System.out.print("비번 : ");
		String pw = scan.next();
		
		//서비스에게 아이디, 비번을 주면서 일치하는 회원 정보를 가져오라고 시킴
		MemberVO user = memberService.login(id, pw);
		
		//가져온 회원 정보를 반환
		return user;
	}

	public boolean signup() {
		//아이디 입력
		System.out.print("아이디 : ");
		String id = scan.next();
		//비번 입력
		System.out.print("비번 : ");
		String pw = scan.next();
		//이름 입력
		System.out.print("이름 : ");
		String name = scan.next();
		System.out.print("주소 : ");
		String address = scan.next();
		System.out.print("전화번호 : ");
		String contact = scan.next();
		return memberService.signup(id, pw, name , address, contact);
	}
}
