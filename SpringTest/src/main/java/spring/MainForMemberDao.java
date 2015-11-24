package spring;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.omg.CORBA.Current;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

public class MainForMemberDao {

	private static MemberDao memberDao;

	public static void main(String[] args) {

		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:appCtx.xml");

		memberDao = ctx.getBean("memberDao", MemberDao.class);

		// insertMember();
		innertable();

		ctx.close();

	}

	private static void table() {

		List<String> dd = memberDao.showtt();
		for (String string : dd) {
			System.out.println(string);
		}
	}

	// private static void updateMember(){
	// System.out.println("----updateMember");
	// Member member = memberDao.selectByEmail("daearcdo@gmail.com");
	// String oldPw = member.getPassword();
	// String newPw = Double.toHexString(Math.random());
	// member.changePassword(oldPw, newPw);
	//
	// memberDao.update1(member);
	// System.out.println("��ȣ���� " + oldPw + ">" + newPw);
	//
	// }

	private static void insertMember() {
		System.out.println("----insertMember");
		Macro macro = new Macro("항항", "sueee");
		memberDao.macroInsert(macro);
		System.out.println(macro.getNum() + " ������ �߰�");

	}

	private static void innertable() {

		String service = "ocb";
		String tc = "스크린온";

		List<voltvalues> members = memberDao.seletetable(service, tc);
		System.out.println(service + " / " + tc);
		System.out.println(members.get(0).toString());

	}
}
