package agendamento.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tbl_courts database table.
 * 
 */
@Entity
@Table(name="tbl_courts")
@NamedQuery(name="Court.findAll", query="SELECT c FROM Court c")
public class Court implements Serializable {
	private static final long serialVersionUID = 4758142319258112266L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;

	@Column(name="NAME")
	private String name;

	//bi-directional many-to-one association to Booking
	@OneToMany(mappedBy="tblCourt1")
	private List<Booking> tblBookings1;

	//bi-directional many-to-one association to Booking
	@OneToMany(mappedBy="tblCourt2")
	private List<Booking> tblBookings2;

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

	public List<Booking> getTblBookings1() {
		return this.tblBookings1;
	}

	public void setTblBookings1(List<Booking> tblBookings1) {
		this.tblBookings1 = tblBookings1;
	}

	public Booking addTblBookings1(Booking tblBookings1) {
		getTblBookings1().add(tblBookings1);
		tblBookings1.setTblCourt1(this);

		return tblBookings1;
	}

	public Booking removeTblBookings1(Booking tblBookings1) {
		getTblBookings1().remove(tblBookings1);
		tblBookings1.setTblCourt1(null);

		return tblBookings1;
	}

	public List<Booking> getTblBookings2() {
		return this.tblBookings2;
	}

	public void setTblBookings2(List<Booking> tblBookings2) {
		this.tblBookings2 = tblBookings2;
	}

	public Booking addTblBookings2(Booking tblBookings2) {
		getTblBookings2().add(tblBookings2);
		tblBookings2.setTblCourt2(this);

		return tblBookings2;
	}

	public Booking removeTblBookings2(Booking tblBookings2) {
		getTblBookings2().remove(tblBookings2);
		tblBookings2.setTblCourt2(null);

		return tblBookings2;
	}

}