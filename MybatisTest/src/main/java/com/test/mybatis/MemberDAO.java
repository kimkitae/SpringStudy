package com.test.mybatis;

import java.util.ArrayList;

public interface MemberDAO {

	public ArrayList<Member> getMembers();
	public void insertMember(Member member);
	public void updateMember(Member member);
	public void deleteMember(int num);
	public ArrayList<Member> selectMember(int num);

}
