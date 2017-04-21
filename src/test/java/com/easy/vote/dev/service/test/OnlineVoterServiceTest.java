package com.easy.vote.dev.service.test;

import java.io.IOException;

import com.easy.vote.dev.common.URLConstant;

public class OnlineVoterServiceTest {
	public static void main(String[] args) {
		String responseString;
		try {
			responseString = TestUtil.testVoterService(
					URLConstant.httpRequestURL,
					URLConstant.REQUEST_GET_VOTER_BYID);
			System.out.println("Response String : " + responseString);
		} catch (IOException e) {
			System.out.println(e.getMessage() + " : "
					+ "Gateway Service Failed..");
		}
	}

}
