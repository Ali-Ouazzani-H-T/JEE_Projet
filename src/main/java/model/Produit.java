package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the produit database table.
 * 
 */
@Entity
@NamedQuery(name="Produit.findAll", query="SELECT p FROM Produit p")
public class Produit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id_produit;

	@Column(name="nom_produit")
	private String nomProduit;

	private double prix;

	//bi-directional many-to-one association to Commander
	@OneToMany(mappedBy="produit")
	private List<Commander> commanders;

	//bi-directional many-to-one association to Categorie
	@ManyToOne
	@JoinColumn(name="Id_categorie")
	private Categorie categorie;

	public Produit() {
	}

	public int getId_produit() {
		return this.id_produit;
	}

	public void setId_produit(int id_produit) {
		this.id_produit = id_produit;
	}

	public String getNomProduit() {
		return this.nomProduit;
	}

	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}

	public double getPrix() {
		return this.prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public List<Commander> getCommanders() {
		return this.commanders;
	}

	public void setCommanders(List<Commander> commanders) {
		this.commanders = commanders;
	}

	public Commander addCommander(Commander commander) {
		getCommanders().add(commander);
		commander.setProduit(this);

		return commander;
	}

	public Commander removeCommander(Commander commander) {
		getCommanders().remove(commander);
		commander.setProduit(null);

		return commander;
	}

	public Categorie getCategorie() {
		return this.categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
}