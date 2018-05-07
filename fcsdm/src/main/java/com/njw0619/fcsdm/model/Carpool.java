package com.njw0619.fcsdm.model;

import java.util.Date;

public class Carpool {
	private int seq;
	private int matchSeq;
	private int memberId;
	private Date created;
	private Date updated;
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public int getMatchSeq() {
		return matchSeq;
	}
	public void setMatchSeq(int matchSeq) {
		this.matchSeq = matchSeq;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getUpdated() {
		return updated;
	}
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
}
