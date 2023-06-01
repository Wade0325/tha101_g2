package tw.idv.petpet.web.admin;



import lombok.Data;

@Data
public class BaseResponse {
	
	private String code;
	
	private String msg;
	
	public BaseResponse(ReturnCodeEnum returnCodeEnum) {
		this.setReturnCodeEnum(returnCodeEnum);
	}

	public void setReturnCodeEnum(ReturnCodeEnum returnCodeEnum) {
		this.code = returnCodeEnum.getCode();
		this.msg = returnCodeEnum.getMsg();
	}

}
