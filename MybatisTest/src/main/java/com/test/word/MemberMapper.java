package com.test.word;

import java.util.ArrayList;

import com.test.word.Member;

public interface MemberMapper {
	ArrayList<Member> getMembers();
	void insertMember(Member member);
	void updateMember(Member member);
	void deleteMember(int num);
void dropTable();
	ArrayList<Member> selectMember(int num);
}
