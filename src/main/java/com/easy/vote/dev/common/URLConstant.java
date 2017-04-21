package com.easy.vote.dev.common;

public class URLConstant {
	public final static String httpRequestURL = "http://localhost:8080/EasyVoteStatus/services/vote/VoterService?wsdl";
	public final static String REQUEST_ADD_VOTE = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:typ=\"http://www.online.vs/VoterService/types\">"
			+ "<soapenv:Header/>"
			+ "<soapenv:Body>"
			+ "<typ:VoterInfo>"
			+ " <voterId></voterId>"
			+ "<name>Manoj</name>"
			+ "<state>Hyderabad</state>"
			+ " <dist>Guntur</dist>"
			+ " <gender>male</gender>"
			+ "<age>29</age>"
			+ "<voterType>Congress</voterType>"
			+ " <candidatesSign>Hand</candidatesSign>"
			+ "</typ:VoterInfo>"
			+ "</soapenv:Body>" + "</soapenv:Envelope>";
	public final static String REQUEST_GET_VOTER_BYID = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:typ=\"http://www.online.vs/VoterService/types\" > "
			+ "<soapenv:Header/>"
			+ " <soapenv:Body>"
			+ "  <typ:voterId>14339</typ:voterId>"
			+ "</soapenv:Body>"
			+ "</soapenv:Envelope>";
	public final static String REQUEST_GET_ACTIVITY = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:typ=\"http://www.online.vs/VoterService/types\">"
			+ "<soapenv:Header/>"
			+ "<soapenv:Body>"
			+ " <typ:voterType>BJP</typ:voterType>"
			+ "</soapenv:Body>"
			+ "</soapenv:Envelope>";

}
