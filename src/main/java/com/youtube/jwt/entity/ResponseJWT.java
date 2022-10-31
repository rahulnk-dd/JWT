package com.youtube.jwt.entity;

public class ResponseJWT {

	 private String jwtToken;

	public ResponseJWT(String newGeneratedToken) {
		this.jwtToken=newGeneratedToken;
	}

	public String getJwtToken() {
		return jwtToken;
	}

	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}
	 
	 
}
