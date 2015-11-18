package spring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class MemberDao {
	private JdbcTemplate jdbcTemplate;

	public MemberDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);

	}

	public Member selectByEmail(String email) {
		List<Member> results = jdbcTemplate.query("select * from member where EMAIL= ?", new RowMapper<Member>() {

			@Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {

				Member member = new Member(rs.getString("EMAIL"), rs.getString("PASSWORD"), rs.getString("NAME"),
						rs.getTimestamp("REGDATE"));
				member.setId(rs.getLong("ID"));
				return member;
			}

		}, email);

		return results.isEmpty() ? null : results.get(0);
	}

	public void insert(final Member member) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement("insert into member(EMAIL,PASSWORD,NAME,REGDATE)" + "values(?,?,?,?)",new String[] {"ID"});
				
				
				pstmt.setString(1, member.getEmail());
				pstmt.setString(2, member.getPassword());
				pstmt.setString(3, member.getName());
				pstmt.setTimestamp(4, new Timestamp(member.getRegisterDate().getTime()));
				// TODO Auto-generated method stub
				return pstmt;
			}
		},keyHolder);
		Number keyValue = keyHolder.getKey();
		member.setId(keyValue.longValue());

	}

	public void update1(final Member member) {
		//jdbcTemplate.update("update member set NAME =?, PASSWORD = ? where EMAIL = ?",member.getName(),member.getPassword(),member.getEmail());
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement("update member set PASSWORD =? where EMAIL =?");
						
				pstmt.setString(1, member.getPassword());
						pstmt.setString(2, member.getEmail());
	//					pstmt.setString(3, member.getName());
//						pstmt.setTimestamp(4, new Timestamp(member.getRegisterDate().getTime()));
				// TODO Auto-generated method stub
				return pstmt;
			}
		});

	}
	
	public void update(Member member){
		jdbcTemplate.update("update member set PASSWORD =? where EMAIL =?",member.getPassword(),member.getEmail());
		
	}

	public List<Member> selectAll() {

		List<Member> results = jdbcTemplate.query("select * from member", new RowMapper<Member>() {

			@Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
				Member member = new Member(rs.getString("EMAIL"), rs.getString("PASSWORD"), rs.getString("NAME"),
						rs.getTimestamp("REGDATE"));
				member.setId(rs.getLong("ID"));

				// TODO Auto-generated method stub
				return member;
			}

		});

		return results;

	}
	
	public int count(){

		Integer count  = jdbcTemplate.queryForObject("select count(*) from member", Integer.class);
		return count;
		
		
	}

}
