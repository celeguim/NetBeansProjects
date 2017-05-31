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
public class Court extends Response implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	@Lob
	private String respdesc;

	private int respid;

	private String status;

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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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

}