package com.easy.votr.dugu.acc.dev.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VOTING_USER_DB")
public class VoterInfoModel {
	@Id
	@Column(name = "VOTER_ID")
	private int voterId;
	@Column(name = "NAME")
	private String name;
	@Column(name = "STATE")
	private String state;
	@Column(name = "DIST")
	private String dist;
	@Column(name = "GENDER")
	private String gender;
	@Column(name = "AGE")
	private int age;
	@Column(name = "TYPE")
	private String voterType;
	@Column(name = "SIGN")
	private String candidatesSign;

	public int getVoterId() {
		return voterId;
	}

	public void setVoterId(int voterId) {
		this.voterId = voterId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDist() {
		return dist;
	}

	public void setDist(String dist) {
		this.dist = dist;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getVoterType() {
		return voterType;
	}

	public void setVoterType(String voterType) {
		this.voterType = voterType;
	}

	public String getCandidatesSign() {
		return candidatesSign;
	}

	public void setCandidatesSign(String candidatesSign) {
		this.candidatesSign = candidatesSign;
	}

}
