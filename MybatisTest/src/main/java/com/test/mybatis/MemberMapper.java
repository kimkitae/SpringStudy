package com.test.mybatis;

import java.util.ArrayList;

import com.test.mybatis.Member;

public interface MemberMapper {
	ArrayList<Member> getMembers();
	void insertMember(Member member);
	void updateMember(Member member);
	void deleteMember(int num);
	ArrayList<Member> selectMember(int num);
}
