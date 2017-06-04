package agendamento.model;

public class Response {

	//

	public int getRespId() {
		return respId;
	}

	public void setRespId(int respId) {
		this.respId = respId;
	}

	public String getRespDesc() {
		return respDesc;
	}

	public void setRespDesc(String respDesc) {
		this.respDesc = respDesc;
	}

	public void setOK() {
		this.respId = 0;
		this.respDesc = "OK";
	}

	public void setError(String error) {
		this.respId = -1;
		this.respDesc = error;
	}

	int respId = -1;
	String respDesc = "";

}
