package tw.idv.petpet.core.pojo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties({ "hibernateLazyInitializer" })
public class Core implements Serializable {
	private static final long serialVersionUID = 1457755989409740329L;
	private boolean successful;
	private String message;
	private boolean login;

	public Core() {
	}

	public Core(boolean successful, String message, boolean login) {
		this.successful = successful;
		this.message = message;
		this.login = login;
	}
}
