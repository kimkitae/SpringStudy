package spring;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainForCPS {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:appCtx.xml");
		
		ChangePasswordService cps = ctx.getBean("ChangePwdSvc",ChangePasswordService.class);
		try{
			cps.changePassword("daearcdo@gmail.com", "1234", "1111");
			System.out.println("암호를 변경하였습니다.");
		}catch(MemberNotFoundException e){
			System.out.println("회원 데이터가 존재 하지 않습니다.");
		}catch (RuntimeException e2) {
			// TODO: handle exception
			System.out.println("암호가 올바르지 않습니다.");
		}
				
		ctx.close();
	}

}
