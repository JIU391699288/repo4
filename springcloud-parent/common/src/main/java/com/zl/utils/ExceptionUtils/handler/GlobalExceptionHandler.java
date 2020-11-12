package com.zl.utils.ExceptionUtils.handler;


import com.zl.utils.ExceptionUtils.constants.ResultCodeEnum;
import com.zl.utils.ExceptionUtils.exception.MyException;
import com.zl.utils.ExceptionUtils.util.ExceptionUtil;
import com.zl.utils.ExceptionUtils.vo.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
	//全局异常处理
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public R error(Exception e){
		//e.printStackTrace();//输出异常堆栈信息
		log.error(e.getMessage());
		return R.error();
	}

	//特定异常处理
	@ExceptionHandler(ArithmeticException.class)
	@ResponseBody
	public R error(ArithmeticException e){
		//e.printStackTrace();//输出异常堆栈信息
		//log.error(e.getMessage());
		log.info("错误信息----------------------------");
		log.error(e.getMessage());
		return R.setResult(ResultCodeEnum.MY_ERROR);
	}

	//自定义异常处理
	@ExceptionHandler(MyException.class)
	@ResponseBody
	public R error(MyException e){
		//e.printStackTrace();//输出异常堆栈信息
		//log.error(e.getMessage());
		log.error(ExceptionUtil.getMessage(e));
		return R.error().message(e.getMessage()).code(e.getCode());
	}
}
