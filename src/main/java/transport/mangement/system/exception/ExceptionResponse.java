package transport.mangement.system.exception;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

@Component
public class ExceptionResponse {
@JsonProperty("HTTP_ERROR")
 private int code;
 @JsonProperty("ERROR_CODE")
 private String errorCode;
 public int getCode() {
  return code;
 }
 public void setCode(int code) {
  this.code = code;
 }

/**
 * @return the errorCode
 */
public String getErrorCode() {
	return errorCode;
}
/**
 * @param errorCode the errorCode to set
 */
public void setErrorCode(String errorCode) {
	this.errorCode = errorCode;
}
}