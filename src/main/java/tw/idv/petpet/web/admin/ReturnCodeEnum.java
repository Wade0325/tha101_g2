package tw.idv.petpet.web.admin;

public enum ReturnCodeEnum {
	
	LOGIN_SUCCESS("0000", "登入成功"),
	LOGIN_FAIL("E001", "登入失敗"),
	SERVER_ERROR("9999", "登入失敗");
	
	String code;
	String msg;

	private ReturnCodeEnum(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

}
