package graduation.project.controller;

import graduation.project.common.result.Result;
import graduation.project.common.exception.XlsxException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.nio.file.AccessDeniedException;


/**
 * @author FTSH
 */
@ControllerAdvice
public class ControllerExceptionHandler {

	private static final Logger log = LoggerFactory.getLogger(ControllerExceptionHandler.class);
	//提示xlsx文件出问题了
	@ResponseBody
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(XlsxException.class)
	public Result handlerMethodArgumentNotValidException(XlsxException e) {
		return Result.error(500,e.getMessage());
	}
	//提示小人，不通过前端传输信息
	@ResponseBody
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Result handlerMethodArgumentNotValidException(MethodArgumentNotValidException e) {
		return Result.error(500,"防君子不防小人啊,发送的参数不符合规定");
	}
}
