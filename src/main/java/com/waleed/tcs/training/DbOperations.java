package com.waleed.tcs.training;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

//jdbcTemplate

//maven : spring-jdbc

@Component("dbOperate")
public class DbOperations {
	
	private JdbcTemplate jdbcTemplate;
	
	private DataSource dataSource;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
		System.out.println("Connected to DB");
	}
	
	Integer getNumberOfParticipants() {
	
return jdbcTemplate.queryForObject(
		"select count(*) from participant_details",
		Integer.class);
	}
	
	String getParticipantNameById(Integer id) {
	
return jdbcTemplate.queryForObject(
		"select participantName from participant_details where participantId = ?",
		String.class,
		id)	;
	}
	
//	Get all details of a participant by id
	Participant getAllDetailsOfParticipantById(Integer id) {
String query = "select * from participant_details where participantId = ?";

return jdbcTemplate.queryForObject(query, new ParticipantMapper(), id);

	}
	
//	Get All participants with all their details
	List<Participant> getAllParticipants() {
return jdbcTemplate.query("select * from participant_details", new ParticipantMapper());		
	}
	
	
	class ParticipantMapper implements RowMapper<Participant>{

		@Override
		public Participant mapRow(ResultSet rs, int rowNum) throws SQLException {
			
		Participant participant = new Participant();
		
//		Map the fileds of Participant with columns of table
		participant.setParticipantId(rs.getInt("participantId"));
		participant.setParticipantName(rs.getString("participantName"));
		participant.setParticipantSkills(rs.getString("participantSkills"));
		
			return participant;
		}

	
	}
	
	void registerNewParticipant(Participant participant) {
	String insertQuery = "insert into participant_details(participantName, participantSkills) values(?,?)";
	
	jdbcTemplate.update(insertQuery, participant.getParticipantName(), participant.getParticipantSkills());
	}
	
//	void updateNewParticipant(Participant participant) {
//		String insertQuery = "update into participant_details(participantName, participantSkills) values(?,?)";
//		
//		jdbcTemplate.update(insertQuery, participant.getParticipantName(), participant.getParticipantSkills());
//		}
	
	
	
	
	
}
