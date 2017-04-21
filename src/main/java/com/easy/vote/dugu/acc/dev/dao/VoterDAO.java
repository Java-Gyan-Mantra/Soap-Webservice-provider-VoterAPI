package com.easy.vote.dugu.acc.dev.dao;

import vs.online.voterservice.ServiceActivityException;
import vs.online.voterservice.types.ActivityResponse;
import vs.online.voterservice.types.User;
import vs.online.voterservice.types.VoterResponse;

import com.easy.votr.dugu.acc.dev.model.VoterInfoModel;

public interface VoterDAO {

	public VoterResponse voteNow(VoterInfoModel model)
			throws ServiceActivityException;

	public User getUser(int id) throws ServiceActivityException;

	public ActivityResponse getActivity(String partyName)
			throws ServiceActivityException;
}
