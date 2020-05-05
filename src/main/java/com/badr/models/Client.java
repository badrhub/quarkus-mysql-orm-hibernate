package com.badr.models;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Cacheable
public class Client {
    
    @Id @GeneratedValue(strategy =GenerationType.IDENTITY )
    private Integer code;
    private String nom;
    private String tel;

	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Client(Integer code, String nom, String tel) {
		this.code = code;
		this.nom = nom;
		this.tel = tel;
	}
	public Client() {
	}
    
    

    
}