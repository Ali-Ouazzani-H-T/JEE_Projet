package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the commander database table.
 * 
 */
@Embeddable
public class CommanderPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_produit", insertable=false, updatable=false)
	private int idProduit;

	@Column(name="id_client", insertable=false, updatable=false)
	private int idClient;

	public CommanderPK() {
	}
	public int getIdProduit() {
		return this.idProduit;
	}
	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}
	public int getIdClient() {
		return this.idClient;
	}
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CommanderPK)) {
			return false;
		}
		CommanderPK castOther = (CommanderPK)other;
		return 
			(this.idProduit == castOther.idProduit)
			&& (this.idClient == castOther.idClient);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idProduit;
		hash = hash * prime + this.idClient;
		
		return hash;
	}
}