package net.berinle.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="V_ITEM")
public class Item {
	@Id @Column(name="item_id") private Integer itemId;
	private String uda_1;
	private String uda_2;
	private String uda_3;
	private String uda_4;
	private String uda_5;
	private String uda_6;
	private String uda_7;
	private String uda_8;
	private String uda_9;
	private String uda_10;
	
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public String getUda_1() {
		return uda_1;
	}
	public void setUda_1(String uda_1) {
		this.uda_1 = uda_1;
	}
	public String getUda_2() {
		return uda_2;
	}
	public void setUda_2(String uda_2) {
		this.uda_2 = uda_2;
	}
	public String getUda_3() {
		return uda_3;
	}
	public void setUda_3(String uda_3) {
		this.uda_3 = uda_3;
	}
	public String getUda_4() {
		return uda_4;
	}
	public void setUda_4(String uda_4) {
		this.uda_4 = uda_4;
	}
	public String getUda_5() {
		return uda_5;
	}
	public void setUda_5(String uda_5) {
		this.uda_5 = uda_5;
	}
	public String getUda_6() {
		return uda_6;
	}
	public void setUda_6(String uda_6) {
		this.uda_6 = uda_6;
	}
	public String getUda_7() {
		return uda_7;
	}
	public void setUda_7(String uda_7) {
		this.uda_7 = uda_7;
	}
	public String getUda_8() {
		return uda_8;
	}
	public void setUda_8(String uda_8) {
		this.uda_8 = uda_8;
	}
	public String getUda_9() {
		return uda_9;
	}
	public void setUda_9(String uda_9) {
		this.uda_9 = uda_9;
	}
	public String getUda_10() {
		return uda_10;
	}
	public void setUda_10(String uda_10) {
		this.uda_10 = uda_10;
	}
}
