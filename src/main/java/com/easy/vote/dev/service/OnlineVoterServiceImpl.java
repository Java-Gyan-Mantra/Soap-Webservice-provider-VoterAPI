package com.easy.vote.dev.service;

import java.util.Random;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.Transactional;

import vs.online.voterservice.OnlineVoterService;
import vs.online.voterservice.ServiceActivityException;
import vs.online.voterservice.types.ActivityResponse;
import vs.online.voterservice.types.ServiceFaultType;
import vs.online.voterservice.types.User;
import vs.online.voterservice.types.VoterInfo;
import vs.online.voterservice.types.VoterResponse;

import com.easy.vote.dev.common.Constants;
import com.easy.vote.dugu.acc.dev.dao.VoterDAO;
import com.easy.votr.dugu.acc.dev.model.VoterInfoModel;

@WebService(serviceName = "VoterService", portName = "VoterServiceSOAP", targetNamespace = "http://www.online.vs/VoterService/", endpointInterface = "vs.online.voterservice.OnlineVoterService")
@PropertySource(value = { "classpath:application.properties" })
@Transactional
public class OnlineVoterServiceImpl implements OnlineVoterService {
	@Autowired
	private VoterDAO dao;
	@Autowired
	private Environment environment;
	ServiceFaultType serviceFaultType = null;

	@Override
	public User getVoteDetailsByVoterId(String input) {
		User user = null;
		try {
			user = dao.getUser(Integer.valueOf(input));
		} catch (Exception e) {
			ServiceFaultType serviceFaultType = new ServiceFaultType();
			int code = Integer.valueOf(environment
					.getProperty(Constants.ERROR_CODE));
			serviceFaultType.setErrorCode(code);
			serviceFaultType.setErrorMessage(e.getMessage());
			serviceFaultType.setErrorDescription(environment
					.getProperty(Constants.DESC_GET_USER));
		}
		return user;
	}

	@Override
	public ActivityResponse getVoteActivity(String input) {
		ActivityResponse activityResponse = null;
		try {
			activityResponse = dao.getActivity(input);
		} catch (Exception e) {
			serviceFaultType = new ServiceFaultType();
			int code = Integer.valueOf(environment
					.getProperty(Constants.ERROR_CODE));
			serviceFaultType.setErrorCode(code);
			serviceFaultType.setErrorMessage(e.getMessage());
			serviceFaultType.setErrorDescription(environment
					.getProperty(Constants.DESC_GET_ACTIVITY));
		}
		return activityResponse;
	}

	@Override
	public VoterResponse addVote(VoterInfo input)
			throws ServiceActivityException {
		VoterResponse response = null;
		try {
			VoterInfoModel model = new VoterInfoModel();
			model.setVoterId(new Random().nextInt(54628));
			model.setName(input.getName());
			model.setGender(input.getGender());
			model.setDist(input.getDist());
			model.setState(input.getState());
			model.setAge(input.getAge());
			model.setCandidatesSign(input.getCandidatesSign());
			model.setVoterType(input.getVoterType());
			response = dao.voteNow(model);
		} catch (Exception e) {
			serviceFaultType = new ServiceFaultType();
			int code = Integer.valueOf(environment
					.getProperty(Constants.ERROR_CODE));
			serviceFaultType.setErrorCode(code);
			serviceFaultType.setErrorMessage(e.getMessage());
			serviceFaultType.setErrorDescription(environment
					.getProperty(Constants.DESC_ADD_VOTE));

		}
		return response;

	}

}
