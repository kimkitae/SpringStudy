package spring;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainForCPS {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:appCtx.xml");
		
		ChangePasswordService cps = ctx.getBean("ChangePwdSvc",ChangePasswordService.class);
		try{
			cps.changePassword("daearcdo@gmail.com", "1234", "1111");
			System.out.println("��ȣ�� �����Ͽ����ϴ�.");
		}catch(MemberNotFoundException e){
			System.out.println("ȸ�� �����Ͱ� ���� ���� �ʽ��ϴ�.");
		}catch (RuntimeException e2) {
			// TODO: handle exception
			System.out.println("��ȣ�� �ùٸ��� �ʽ��ϴ�.");
		}
				
		ctx.close();
	}

}
