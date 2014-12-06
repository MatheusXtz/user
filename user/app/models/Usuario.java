package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import play.db.ebean.Model;

@Entity
public class Usuario extends Model {
    @Id
    @GeneratedValue
	private Long idUser;
    
    private String nome;
    
    public static Model.Finder<Long, Usuario> find = new Model.Finder<Long, Usuario>(
			Long.class, Usuario.class);

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
	
}
