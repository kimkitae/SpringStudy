package spring;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

public class MainForMemberDao {

	private static MemberDao memberDao;
	
	public static void main(String[] args) {
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:appCtx.xml");
		
		memberDao = ctx.getBean("memberDao",MemberDao.class);
		
	
//		insertMember();
		table();
		ctx.close();
		
		
		
	}
	
	
	private static void table(){
		
		List<String> dd = memberDao.showtt();
		for (String string : dd) {
			System.out.println(string);
		}
	}
//	private static void updateMember(){
//		System.out.println("----updateMember");
//		Member member = memberDao.selectByEmail("daearcdo@gmail.com");
//		String oldPw = member.getPassword();
//		String newPw = Double.toHexString(Math.random());
//		member.changePassword(oldPw, newPw);
//		
//		memberDao.update1(member);
//		System.out.println("��ȣ���� " + oldPw + ">" + newPw);
//		
//	}
	
//	private static void insertMember(){
//		System.out.println("----insertMember");
//		SimpleDateFormat dateFormat = new SimpleDateFormat("MMddHHmmss");
//		String prefix = dateFormat.format(new Date());
//		Member member = new Member(prefix + "@test.com",prefix,prefix,new Date());
//		memberDao.insert(member);
//		System.out.println(member.getId()+ " ������ �߰�");
//		
//	}
//	
	
}
