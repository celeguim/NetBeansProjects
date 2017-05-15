package agendamento.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the tbl_courts database table.
 * 
 */
@Entity
@Table(name = "tbl_courts")
@NamedQuery(name = "Court.findAll", query = "SELECT c FROM Court c")
public class Court implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private Boolean available;
	private String name;
	int respId;
	String respDesc;

	public String getRespDesc() {
		return respDesc;
	}

	public void setRespDesc(String respDesc) {
		this.respDesc = respDesc;
	}

	public int getRespId() {
		return respId;
	}

	public void setRespId(int id) {
		this.respId = id;
	}

	// bi-directional many-to-one association to Booking
	@OneToMany(mappedBy = "tblCourt")
	private List<Booking> tblBookings;

	public Court() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Boolean getAvailable() {
		return this.available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Booking> getTblBookings() {
		return this.tblBookings;
	}

	public void setTblBookings(List<Booking> tblBookings) {
		this.tblBookings = tblBookings;
	}

	public Booking addTblBooking(Booking tblBooking) {
		getTblBookings().add(tblBooking);
		tblBooking.setTblCourt(this);

		return tblBooking;
	}

	public Booking removeTblBooking(Booking tblBooking) {
		getTblBookings().remove(tblBooking);
		tblBooking.setTblCourt(null);

		return tblBooking;
	}

	public void setOK() {
		this.respDesc = "OK";
		this.respId = 0;
	}

	public void setError(String error) {
		this.respDesc = error;
		this.respId = -1;
	}

}