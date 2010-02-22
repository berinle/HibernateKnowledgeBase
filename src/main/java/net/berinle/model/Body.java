package net.berinle.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="body")
public class Body {

	@Id @GeneratedValue(strategy=GenerationType.AUTO) 
	private Long id;
	
	//@OneToMany(cascade=CascadeType.ALL)
	//@JoinColumn(name="body_id")
	
	@OneToMany(mappedBy="body", cascade=CascadeType.ALL)
	private Set<Hand> hands = new HashSet<Hand>();
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Set<Hand> getHands() {
		return hands;
	}
	public void setHands(Set<Hand> hands) {
		this.hands = hands;
	}
	
	public void addHand(Hand hand){
		hands.add(hand);
		hand.setBody(this);
	}
}
