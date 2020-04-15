package com.training.wipro.onlineassesments.model;

public class AssementsScoreVO {
	private long marksAcquired;
	private long passMarks;
	private long totalMarks;
	/**
	 * @return the marksAcquired
	 */
	public long getMarksAcquired() {
		return marksAcquired;
	}
	/**
	 * @param marksAcquired the marksAcquired to set
	 */
	public void setMarksAcquired(long marksAcquired) {
		this.marksAcquired = marksAcquired;
	}
	/**
	 * @return the passMarks
	 */
	public long getPassMarks() {
		return passMarks;
	}
	/**
	 * @param passMarks the passMarks to set
	 */
	public void setPassMarks(long passMarks) {
		this.passMarks = passMarks;
	}
	/**
	 * @return the totalMarks
	 */
	public long getTotalMarks() {
		return totalMarks;
	}
	/**
	 * @param totalMarks the totalMarks to set
	 */
	public void setTotalMarks(long totalMarks) {
		this.totalMarks = totalMarks;
	}
	@Override
	public String toString() {
		return "AssementsScoreVO [marksAcquired=" + marksAcquired + ", passMarks=" + passMarks + ", totalMarks="
				+ totalMarks + "]";
	}
	
	

}
