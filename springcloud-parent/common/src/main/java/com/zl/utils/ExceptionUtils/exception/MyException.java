package com.zl.utils.ExceptionUtils.exception;


import com.zl.utils.ExceptionUtils.constants.ResultCodeEnum;
import lombok.Data;

@Data
//@ApiModel(value = "自定义全局异常类")
public class MyException extends RuntimeException {
	//@ApiModelProperty(value = "状态码")
	private Integer code;

	/**
	 * 接收状态码和错误消息
	 * @param code
	 * @param message
	 */
	public MyException(Integer code, String message){
		super(message);
		this.code = code;
	}

	public MyException(ResultCodeEnum resultCodeEnum){
		super(resultCodeEnum.getMessage());
		this.code = resultCodeEnum.getCode();
	}

	@Override
	public String toString() {
		return "MyException{" +
				"code=" + code +
				", message=" + this.getMessage() +
				'}';
	}
}
