package agendamento.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the tbl_users database table.
 * 
 */
@Entity
@Table(name = "tbl_users")
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
public class User extends Response implements Serializable {
	private static final long serialVersionUID = -3423938356666170723L;

	@EmbeddedId
	private UserPK id;

	@Column(name = "ACTIVE")
	private Boolean active;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "TELEPHONE")
	private String telephone;

	@Column(name = "TYPE")
	private String type;

	public User() {
	}

	public UserPK getId() {
		return this.id;
	}

	public void setId(UserPK id) {
		this.id = id;
	}

	public Boolean getActive() {
		return this.active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

}