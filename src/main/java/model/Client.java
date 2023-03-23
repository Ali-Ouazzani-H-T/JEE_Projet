package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the client database table.
 * 
 */
@Entity
@NamedQuery(name="Client.findAll", query="SELECT c FROM Client c")
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id_client;

	private String nom;

	private String prenom;

	//bi-directional many-to-one association to Information
	@ManyToOne
	@JoinColumn(name="id_information")
	private Information information;

	//bi-directional many-to-one association to Commander
	@OneToMany(mappedBy="client")
	private List<Commander> commanders;

	public Client() {
	}

	public int getId_client() {
		return this.id_client;
	}

	public void setId_client(int id_client) {
		this.id_client = id_client;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Information getInformation() {
		return this.information;
	}

	public void setInformation(Information information) {
		this.information = information;
	}

	public List<Commander> getCommanders() {
		return this.commanders;
	}

	public void setCommanders(List<Commander> commanders) {
		this.commanders = commanders;
	}

	public Commander addCommander(Commander commander) {
		getCommanders().add(commander);
		commander.setClient(this);

		return commander;
	}

	public Commander removeCommander(Commander commander) {
		getCommanders().remove(commander);
		commander.setClient(null);

		return commander;
	}

	
	
	
	}