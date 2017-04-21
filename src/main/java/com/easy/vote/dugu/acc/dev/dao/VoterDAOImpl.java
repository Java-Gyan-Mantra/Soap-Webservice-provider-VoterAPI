package com.easy.vote.dugu.acc.dev.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vs.online.voterservice.ServiceActivityException;
import vs.online.voterservice.types.ActivityResponse;
import vs.online.voterservice.types.User;
import vs.online.voterservice.types.VoterInfo;
import vs.online.voterservice.types.VoterResponse;

import com.easy.vote.dev.common.Utility;
import com.easy.votr.dugu.acc.dev.model.VoterInfoModel;

@Repository
public class VoterDAOImpl implements VoterDAO {

	@Autowired(required = true)
	private SessionFactory factory;

	@Override
	public VoterResponse voteNow(VoterInfoModel model)
			throws ServiceActivityException {
		VoterResponse response = null;
		if (model != null) {
			getSession().save(model);
			response = new VoterResponse();
			response.setVoterId(model.getVoterId());
			response.setResponse("Voting successfull");
		} else {
			throw new ServiceActivityException("Voting Closed.");
		}
		return response;
	}

	private Session getSession() {
		Session session = null;
		if (factory.getCurrentSession() == null) {
			session = factory.openSession();
		} else {
			session = factory.getCurrentSession();
		}
		return session;
	}

	@Override
	public User getUser(int id) throws ServiceActivityException {
		User user = null;
		VoterInfoModel model = null;
		VoterInfo voterInfo = new VoterInfo();
		model = (VoterInfoModel) getSession()
				.createCriteria(VoterInfoModel.class)
				.add(Restrictions.eq("voterId", id)).uniqueResult();
		if (model != null) {
			user = new User();
			voterInfo = Utility.PojoToVoConvert(model);
			user.setVoterInfo(voterInfo);
		} else {
			throw new ServiceActivityException(id + ": user not found");
		}
		return user;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ActivityResponse getActivity(String partyName)
			throws ServiceActivityException {
		int count = 0;
		VoterInfo voterInfo = null;
		ActivityResponse response = new ActivityResponse();
		List<VoterInfoModel> voterInfoModels = null;

		voterInfoModels = getSession().createCriteria(VoterInfoModel.class)
				.add(Restrictions.eq("voterType", partyName)).list();
		if (!voterInfoModels.isEmpty() || voterInfoModels.size() >= 1) {
			count = voterInfoModels.size();
			for (VoterInfoModel model : voterInfoModels) {
				voterInfo = Utility.PojoToVoConvert(model);
				response.setVoteCount(count);
				response.getVoterInfo().add(voterInfo);
			}
		} else {
			throw new ServiceActivityException("No Activity Found");

		}
		return response;
	}
}
