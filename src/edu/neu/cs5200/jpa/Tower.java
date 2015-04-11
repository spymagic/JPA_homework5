package edu.neu.cs5200.jpa;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Tower
 *
 */
@Entity

public class Tower implements Serializable {

	@Id
	private int id;
	private String name;
	private double height;
	private int sides;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="siteId")
	private Site site;
	
	@OneToMany(mappedBy="tower")
	private List<Equipment> equipment;
	
	private static final long serialVersionUID = 1L;

	public Tower() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public double getHeight() {
		return this.height;
	}

	public void setHeight(double height) {
		this.height = height;
	}   
	public int getSides() {
		return this.sides;
	}

	public void setSides(int sides) {
		this.sides = sides;
	}
	public Site getSite() {
		return site;
	}
	public void setSite(Site site) {
		this.site = site;
	}
	public List<Equipment> getEquipment() {
		return equipment;
	}
	public void setEquipment(List<Equipment> equipment) {
		this.equipment = equipment;
	}   

   
}
