package agendamento.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the tbl_users database table.
 * 
 */
@Entity
@Table(name = "tbl_users")
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
public class User extends Response implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String email;

	private String password;

	@Lob
	private String respdesc;

	private int respid;

	private String status;

	private String telephone;

	private String type;

	private String username;

	// bi-directional many-to-one association to Player
	@OneToMany(mappedBy = "tblUser")
	private List<Player> tblPlayers;

	public User() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getRespdesc() {
		return this.respdesc;
	}

	public void setRespdesc(String respdesc) {
		this.respdesc = respdesc;
	}

	public int getRespid() {
		return this.respid;
	}

	public void setRespid(int respid) {
		this.respid = respid;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Player> getTblPlayers() {
		return this.tblPlayers;
	}

	public void setTblPlayers(List<Player> tblPlayers) {
		this.tblPlayers = tblPlayers;
	}

	public Player addTblPlayer(Player tblPlayer) {
		getTblPlayers().add(tblPlayer);
		tblPlayer.setTblUser(this);

		return tblPlayer;
	}

	public Player removeTblPlayer(Player tblPlayer) {
		getTblPlayers().remove(tblPlayer);
		tblPlayer.setTblUser(null);

		return tblPlayer;
	}

}