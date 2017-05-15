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
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String email;

	private String name;

	private String password;

	private String telephone;

	// bi-directional many-to-one association to Booking
	@OneToMany(mappedBy = "tblPlayer")
	private List<Booking> tblBookings;

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

}