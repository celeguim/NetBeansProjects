package agendamento.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

/**
 * The persistent class for the tbl_booking database table.
 * 
 */
@Entity
@Table(name = "tbl_booking")
@NamedQuery(name = "Booking.findAll", query = "SELECT b FROM Booking b")
public class Booking implements Serializable {
	private static final long serialVersionUID = -2139040350098173047L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;

	@Column(name = "COURT_NAME")
	private String courtName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE_FROM")
	private Date dateFrom;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE_TO")
	private Date dateTo;

	@Temporal(TemporalType.DATE)
	@Column(name = "DT_RES_DAY")
	private Date dtResDay;

	@Column(name = "DT_RES_FROM")
	private Time dtResFrom;

	@Column(name = "DT_RES_TO")
	private Time dtResTo;

	@Column(name = "NAME")
	private String name;

	@Column(name = "PLAYER_NAME")
	private String playerName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "TIMESTAMP")
	private Date timestamp;

	// bi-directional many-to-one association to Court
	@ManyToOne
	@JoinColumn(name = "COURT_ID")
	private Court tblCourt1;

	// bi-directional many-to-one association to Player
	@ManyToOne
	@JoinColumn(name = "PLAYER_ID")
	private Player tblPlayer1;

	// bi-directional many-to-one association to Court
	@ManyToOne
	@JoinColumn(name = "TBL_COURTS_ID")
	private Court tblCourt2;

	// bi-directional many-to-one association to Player
	@ManyToOne
	@JoinColumn(name = "TBL_PLAYERS_ID")
	private Player tblPlayer2;

	public Booking() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourtName() {
		return this.courtName;
	}

	public void setCourtName(String courtName) {
		this.courtName = courtName;
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

	public Date getDtResDay() {
		return this.dtResDay;
	}

	public void setDtResDay(Date dtResDay) {
		this.dtResDay = dtResDay;
	}

	public Time getDtResFrom() {
		return this.dtResFrom;
	}

	public void setDtResFrom(Time dtResFrom) {
		this.dtResFrom = dtResFrom;
	}

	public Time getDtResTo() {
		return this.dtResTo;
	}

	public void setDtResTo(Time dtResTo) {
		this.dtResTo = dtResTo;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlayerName() {
		return this.playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public Date getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public Court getTblCourt1() {
		return this.tblCourt1;
	}

	public void setTblCourt1(Court tblCourt1) {
		this.tblCourt1 = tblCourt1;
	}

	public Player getTblPlayer1() {
		return this.tblPlayer1;
	}

	public void setTblPlayer1(Player tblPlayer1) {
		this.tblPlayer1 = tblPlayer1;
	}

	public Court getTblCourt2() {
		return this.tblCourt2;
	}

	public void setTblCourt2(Court tblCourt2) {
		this.tblCourt2 = tblCourt2;
	}

	public Player getTblPlayer2() {
		return this.tblPlayer2;
	}

	public void setTblPlayer2(Player tblPlayer2) {
		this.tblPlayer2 = tblPlayer2;
	}

}