package com.easy.vote.dev.common;

import com.easy.votr.dugu.acc.dev.model.VoterInfoModel;

import vs.online.voterservice.types.VoterInfo;

public class Utility {

	public static VoterInfo PojoToVoConvert(VoterInfoModel model) {
		VoterInfo voterInfo = new VoterInfo();
		voterInfo.setVoterId(model.getVoterId());
		voterInfo.setName(model.getName());
		voterInfo.setAge(model.getAge());
		voterInfo.setCandidatesSign(model.getCandidatesSign());
		voterInfo.setDist(model.getDist());
		voterInfo.setState(model.getState());
		voterInfo.setGender(model.getGender());
		voterInfo.setVoterType(model.getVoterType());
		return voterInfo;
	}
}
