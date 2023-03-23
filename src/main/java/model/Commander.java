package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the commander database table.
 * 
 */
@Entity
@NamedQuery(name="Commander.findAll", query="SELECT c FROM Commander c")
public class Commander implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CommanderPK id;

	@Temporal(TemporalType.DATE)
	private Date dateCommande;

	private int qnt;

	//bi-directional many-to-one association to Produit
	@ManyToOne
	@JoinColumn(name="id_produit")
	private Produit produit;

	//bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name="id_client")
	private Client client;

	public Commander() {
	}

	public CommanderPK getId() {
		return this.id;
	}

	public void setId(CommanderPK id) {
		this.id = id;
	}

	public Date getDateCommande() {
		return this.dateCommande;
	}

	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}

	public int getQnt() {
		return this.qnt;
	}

	public void setQnt(int qnt) {
		this.qnt = qnt;
	}

	public Produit getProduit() {
		return this.produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}