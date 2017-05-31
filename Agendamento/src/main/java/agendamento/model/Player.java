package agendamento.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the tbl_players database table.
 * 
 */
@Entity
@Table(name = "tbl_players")
@NamedQuery(name = "Player.findAll", query = "SELECT p FROM Player p")
public class Player extends Response implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7575324428984904699L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String email;

	private String name;

	private String password;

	@Lob
	private String respdesc;

	private int respid;

	private String status;

	private String telephone;

	// bi-directional many-to-one association to Booking
	@OneToMany(mappedBy = "tblPlayer")
	private List<Booking> tblBookings;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "TBL_USERS_USERNAME")
	private User tblUser;

	public Player() {
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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

	public List<Booking> getTblBookings() {
		return this.tblBookings;
	}

	public void setTblBookings(List<Booking> tblBookings) {
		this.tblBookings = tblBookings;
	}

	public Booking addTblBooking(Booking tblBooking) {
		getTblBookings().add(tblBooking);
		tblBooking.setTblPlayer(this);

		return tblBooking;
	}

	public Booking removeTblBooking(Booking tblBooking) {
		getTblBookings().remove(tblBooking);
		tblBooking.setTblPlayer(null);

		return tblBooking;
	}

	public User getTblUser() {
		return this.tblUser;
	}

	public void setTblUser(User tblUser) {
		this.tblUser = tblUser;
	}

}