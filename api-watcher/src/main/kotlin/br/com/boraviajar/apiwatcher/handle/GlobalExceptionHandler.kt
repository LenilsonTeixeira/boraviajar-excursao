package br.com.boraviajar.apiwatcher.handle

import br.com.boraviajar.apiwatcher.handle.model.ErrorMessage
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.time.Instant
import javax.servlet.http.HttpServletRequest

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun handleException(exception: Exception, httpServletRequest: HttpServletRequest): ErrorMessage{
        return ErrorMessage.Builder()
                .message(exception.message)
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .error(HttpStatus.INTERNAL_SERVER_ERROR.name)
                .timestamp(Instant.now().toEpochMilli())
                .path(httpServletRequest.servletPath)
                .build();
    }
}