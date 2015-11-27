package spring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

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
	
	
	public List<Macro> macroselete() {

		List<Macro> results = jdbcTemplate.query("select * from macro ORDER BY num DESC", new RowMapper<Macro>() {

			@Override
			public Macro mapRow(ResultSet rs, int rowNum) throws SQLException {
				Macro macro = new Macro(rs.getString("stats"), rs.getString("result"), rs.getTimestamp("time"));
				macro.setNum(rs.getInt("num"));

				// TODO Auto-generated method stub
				return macro;
			}

		});
		return results;
	}
	
	
	

	public Member selectByEmail(String service) {
		List<Member> results = jdbcTemplate.query("select * from exceltest where service= ?", new RowMapper<Member>() {

			@Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {

				Member member = new Member(rs.getString("service"), rs.getString("name"), rs.getFloat("result"),
						rs.getTimestamp("time"));
				member.setNum(rs.getInt("num"));
				return member;
			}

		}, service);

		return results.isEmpty() ? null : results.get(0);
	}

	public void macroInsert(final Macro macro) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement("insert into macro(stats,result)" + "values(?,?)",new String[] {"num"});
				
				
				//pstmt.setInt(1, macro.getNum());
				pstmt.setString(1, macro.getStats());
				pstmt.setString(2, macro.getResult());
				
				//pstmt.setTimestamp(4, new Timestamp(macro.getTime().getTime()));
				// TODO Auto-generated method stub
				return pstmt;
			}
		},keyHolder);
		Number keyValue = keyHolder.getKey();
		macro.setNum(keyValue.intValue());

	}

//	public void update1(final Member member) {
//		//jdbcTemplate.update("update member set NAME =?, PASSWORD = ? where EMAIL = ?",member.getName(),member.getPassword(),member.getEmail());
//		jdbcTemplate.update(new PreparedStatementCreator() {
//			
//			@Override
//			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
//				PreparedStatement pstmt = con.prepareStatement("update member set PASSWORD =? where EMAIL =?");
//						
//				pstmt.setString(1, member.getPassword());
//						pstmt.setString(2, member.getEmail());
//	//					pstmt.setString(3, member.getName());
////						pstmt.setTimestamp(4, new Timestamp(member.getRegisterDate().getTime()));
//				// TODO Auto-generated method stub
//				return pstmt;
//			}
//		});
//
//	}
//	

	public List<Member> selectAll(String tables) {

		List<Member> results = jdbcTemplate.query("select * from "+tables, new RowMapper<Member>() {

			@Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
				Member member = new Member(rs.getString("service"), rs.getString("name"), rs.getFloat("result"),
						rs.getTimestamp("time"));
				member.setNum(rs.getInt("num"));

				// TODO Auto-generated method stub
				return member;
			}

		});
		return results;
	}
	
	
	public List<voltvalues> voltvalue(String tables) {

		List<voltvalues> results = jdbcTemplate.query("select * from "+tables, new RowMapper<voltvalues>() {

			@Override
			public voltvalues mapRow(ResultSet rs, int rowNum) throws SQLException {
				voltvalues member = new voltvalues(rs.getString("service"), rs.getString("device"), rs.getString("tc"),rs.getInt("round"),rs.getString("logcat"),rs.getString("dump"),rs.getString("average"));
				member.setNum(rs.getInt("num"));

				
				
				// TODO Auto-generated method stub
				return member;
			}

		});
		return results;
	}
	
	
		public List<Member> showtable() {

			List<Member> results = jdbcTemplate.query("SHOW TABLE", new RowMapper<Member>() {

				@Override
				public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
					Member member = new Member(rs.getString("service"), rs.getString("name"), rs.getFloat("result"),
							rs.getTimestamp("time"));
					member.setNum(rs.getInt("num"));

					// TODO Auto-generated method stub
					return member;
				}

			});

		return results;

	}

	
	

	
	public List<String> showtt(){
		
		List<String> table = jdbcTemplate.queryForList("SHOW TABLES", String.class);
		
		return table;
		
		
	}
	
	public List<voltvalues> seletetable(String service, String tc) {
			
//		List<voltvalues> results = jdbcTemplate.query("select * from voltvalues INNER JOIN " + service + " on voltvalues.tc = " + service + ".name and voltvalues.service = " + service +".service where "+service+".name = "+"'"+tc+"'" , new RowMapper<voltvalues>() {
			List<voltvalues> results = jdbcTemplate.query("select * from voltvalues where service= "+"'"+service+"'" + "AND tc = "+"'"+tc+"'" , new RowMapper<voltvalues>() {
			@Override
			public voltvalues mapRow(ResultSet rs, int rowNum) throws SQLException {
				voltvalues member = new voltvalues(rs.getString("service"), rs.getString("device"), rs.getString("tc"),rs.getInt("round"),rs.getString("logcat"),rs.getString("dump"),rs.getString("average"));
				member.setNum(rs.getInt("num"));
				// TODO Auto-generated method stub
				return member;
			}

		});
		return results;
	}

}
