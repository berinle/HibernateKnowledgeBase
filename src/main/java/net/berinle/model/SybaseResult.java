package net.berinle.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
public class SybaseResult {

	//call proc pqbGetRoundPwb
	
	@Id private Long bipId;
	private String bipType;
	private Long bidUnits;
	private String bipName;
	private Integer itemTotal;
	private Long bidderId;
	private String bidderType;
	private String bidderName;
	private Integer roundNum;
	private Long bidAmt;
	private String bipDesc;
	
	public Long getBipId() {
		return bipId;
	}
	public void setBipId(Long bipId) {
		this.bipId = bipId;
	}
	public String getBipType() {
		return bipType;
	}
	public void setBipType(String bipType) {
		this.bipType = bipType;
	}
	public Long getBidUnits() {
		return bidUnits;
	}
	public void setBidUnits(Long bidUnits) {
		this.bidUnits = bidUnits;
	}
	public String getBipName() {
		return bipName;
	}
	public void setBipName(String bipName) {
		this.bipName = bipName;
	}
	public Integer getItemTotal() {
		return itemTotal;
	}
	public void setItemTotal(Integer itemTotal) {
		this.itemTotal = itemTotal;
	}
	public Long getBidderId() {
		return bidderId;
	}
	public void setBidderId(Long bidderId) {
		this.bidderId = bidderId;
	}
	public String getBidderType() {
		return bidderType;
	}
	public void setBidderType(String bidderType) {
		this.bidderType = bidderType;
	}
	public String getBidderName() {
		return bidderName;
	}
	public void setBidderName(String bidderName) {
		this.bidderName = bidderName;
	}
	public Integer getRoundNum() {
		return roundNum;
	}
	public void setRoundNum(Integer roundNum) {
		this.roundNum = roundNum;
	}
	public Long getBidAmt() {
		return bidAmt;
	}
	public void setBidAmt(Long bidAmt) {
		this.bidAmt = bidAmt;
	}
	public String getBipDesc() {
		return bipDesc;
	}
	public void setBipDesc(String bipDesc) {
		this.bipDesc = bipDesc;
	}
	
	public String toString(){
		return ToStringBuilder.reflectionToString(this);
	}
	
}
