package agendamento.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * The persistent class for the tbl_booking database table.
 * 
 */
@Entity
@Table(name = "tbl_booking")
@NamedQuery(name = "Booking.findAll", query = "SELECT b FROM Booking b")
public class Booking extends Response implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7351592532912345283L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE_FROM")
	private Date dateFrom;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE_TO")
	private Date dateTo;

	private String name;

	@Lob
	private String respdesc;

	private int respid;

	private String status;

	@Temporal(TemporalType.TIMESTAMP)
	private Date timestamp;

	// bi-directional many-to-one association to Court
	@ManyToOne
	@JoinColumn(name = "TBL_COURTS_ID")
	private Court tblCourt;

	// bi-directional many-to-one association to Player
	@ManyToOne
	@JoinColumn(name = "TBL_PLAYERS_ID")
	private Player tblPlayer;

	public Booking() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateFrom() {
		return this.dateFrom;
	}

	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}

	public Date getDateTo() {
		return this.dateTo;
	}

	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
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

	public Date getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public Court getTblCourt() {
		return this.tblCourt;
	}

	public void setTblCourt(Court tblCourt) {
		this.tblCourt = tblCourt;
	}

	public Player getTblPlayer() {
		return this.tblPlayer;
	}

	public void setTblPlayer(Player tblPlayer) {
		this.tblPlayer = tblPlayer;
	}

}