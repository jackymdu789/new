package com.waleed.tcs.training;

class Participant{
	private Integer participantId;
	private String  participantName;
	private String  participantSkills ;
	
	public Participant() {

	}
	
	@Override
	public String toString() {
		return "Participant [participantId=" + participantId + ", particpantName=" + participantName
				+ ", participantSkills=" + participantSkills + "]";
	}

	public Participant(Integer participantId, String participantName, String participantSkills) {

		this.participantId = participantId;
		this.participantName = participantName;
		this.participantSkills = participantSkills;
	}
	public Participant(String participantName, String participantSkills) {
		this.participantName = participantName;
		this.participantSkills = participantSkills;
	}
	public Integer getParticipantId() {
		return participantId;
	}
	public void setParticipantId(Integer participantId) {
		this.participantId = participantId;
	}
	public String getParticipantName() {
		return participantName;
	}
	public void setParticipantName(String participantName) {
		this.participantName = participantName;
	}
	public String getParticipantSkills() {
		return participantSkills;
	}
	public void setParticipantSkills(String participantSkills) {
		this.participantSkills = participantSkills;
	}
}
