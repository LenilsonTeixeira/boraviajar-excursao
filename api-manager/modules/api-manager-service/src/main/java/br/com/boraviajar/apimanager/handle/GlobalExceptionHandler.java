package br.com.boraviajar.apimanager.handle;

import br.com.boraviajar.apimanager.exception.BaseException;
import br.com.boraviajar.apimanager.handle.model.ErrorResponse;
import br.com.boraviajar.apimanager.handle.model.FieldResponse;
import br.com.boraviajar.apimanager.util.FieldTranslator;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import javax.validation.Path;
import java.time.Instant;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final String INVALID_MESSAGE = "Atributos inválidos";
    private static final String INVALID_FIELD_PATTERN = "%s inválido";
    private static final String INVALID_BODY = "Body inválido";
    private static final String INVALID_CONTENT_TYPE = "Content-Type inválido";
    private static final String INCOMPATIBLE_TYPE = "Tipos incompatíveis";
    private static final String MISSING_HEADER = "Header obrigatório não informado";
    private static final String MISSING_PARAM = "Parâmetro obrigatório não informado";
    private static final String FILE_TOO_LARGE = "Arquivo muito grande";

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleBaseException(final BaseException exception, final HttpServletRequest request) {

        final ErrorResponse error = ErrorResponse
                .builder()
                .status(exception.getStatus().value())
                .error(exception.getStatus().name())
                .message(exception.getMessage())
                .timestamp(Instant.now().toEpochMilli())
                .path(request.getServletPath())
                .build();

        return ResponseEntity
                .status(error.getStatus())
                .body(error);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleException(final Exception exception, final HttpServletRequest request) {

        return ErrorResponse
                .builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .error(HttpStatus.INTERNAL_SERVER_ERROR.name())
                .message(exception.getMessage())
                .timestamp(Instant.now().toEpochMilli())
                .path(request.getServletPath())
                .build();
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ErrorResponse handleHttpMessageNotReadableException(final HttpMessageNotReadableException exception, final HttpServletRequest request) {

        return ErrorResponse
                .builder()
                .message(INVALID_BODY)
                .status(HttpStatus.UNPROCESSABLE_ENTITY.value())
                .error(exception.getMessage())
                .timestamp(Instant.now().toEpochMilli())
                .path(request.getServletPath())
                .build();
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ErrorResponse handleHttpMediaTypeNotSupportedException(final HttpMediaTypeNotSupportedException exception, final HttpServletRequest request) {

        return ErrorResponse
                .builder()
                .message(INVALID_CONTENT_TYPE)
                .status(HttpStatus.UNPROCESSABLE_ENTITY.value())
                .error(exception.getMessage())
                .timestamp(Instant.now().toEpochMilli())
                .path(request.getServletPath())
                .build();
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ErrorResponse handleMultipartException(final MultipartException exception, final HttpServletRequest request) {

        return ErrorResponse
                .builder()
                .message(INVALID_BODY)
                .status(HttpStatus.UNPROCESSABLE_ENTITY.value())
                .error(exception.getMessage())
                .path(request.getServletPath())
                .build();
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleArgumentNotValidException(final MethodArgumentNotValidException exception, final HttpServletRequest request) {

        final ErrorResponse errorResponse = buildResponse(HttpStatus.BAD_REQUEST, request.getServletPath(), exception);

        exception.getBindingResult().getFieldErrors().forEach(error -> {

            final FieldResponse field = FieldResponse
                    .builder()
                    .message(error.getDefaultMessage())
                    .field(FieldTranslator.translate(error.getField()))
                    .value(String.valueOf(error.getRejectedValue()))
                    .build();

            errorResponse.addField(field);
        });

        return errorResponse;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleConstraintViolationException(final ConstraintViolationException exception, final HttpServletRequest request) {

        final ErrorResponse errorResponse = buildResponse(HttpStatus.BAD_REQUEST, request.getServletPath(), exception);

        exception.getConstraintViolations().forEach(error -> {

            String fieldName = null;

            for (Path.Node node : error.getPropertyPath()) {
                fieldName = node.getName();
            }

            final FieldResponse field = FieldResponse
                    .builder()
                    .message(error.getMessage())
                    .field(FieldTranslator.translate(fieldName))
                    .value(String.valueOf(error.getInvalidValue()))
                    .build();

            errorResponse.addField(field);

        });

        return errorResponse;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleMissingServletRequestParameterException(final MissingServletRequestParameterException exception, final HttpServletRequest request) {

        final ErrorResponse errorResponse = buildResponse(HttpStatus.BAD_REQUEST, request.getServletPath(), exception);

        final FieldResponse field = FieldResponse
                .builder()
                .message(MISSING_PARAM)
                .field(FieldTranslator.translate(exception.getParameterName()))
                .build();

        errorResponse.addField(field);

        return errorResponse;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleMissingServletRequestPartException(final MissingServletRequestPartException exception, final HttpServletRequest request) {

        final ErrorResponse errorResponse = buildResponse(HttpStatus.BAD_REQUEST, request.getServletPath(), exception);

        final FieldResponse field = FieldResponse
                .builder()
                .message(String.format(INVALID_FIELD_PATTERN, StringUtils.capitalize(exception.getRequestPartName())))
                .field(FieldTranslator.translate(exception.getRequestPartName()))
                .build();

        errorResponse.addField(field);

        return errorResponse;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleTypeMismatchException(final TypeMismatchException exception, final HttpServletRequest request) {

        final ErrorResponse errorResponse = buildResponse(HttpStatus.BAD_REQUEST, request.getServletPath(), exception);

        final FieldResponse field = FieldResponse
                .builder()
                .message(INCOMPATIBLE_TYPE)
                .field(FieldTranslator.translate(String.valueOf(getFieldName(exception))))
                .value(String.valueOf(exception.getValue()))
                .build();

        errorResponse.addField(field);

        return errorResponse;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleBindException(final BindException exception, final HttpServletRequest request) {

        final ErrorResponse errorResponse = buildResponse(HttpStatus.BAD_REQUEST, request.getServletPath(), exception);

        exception.getBindingResult().getFieldErrors().forEach(error -> {

            final FieldResponse field = FieldResponse
                    .builder()
                    .message(error.getDefaultMessage())
                    .field(FieldTranslator.translate(error.getField()))
                    .value(String.valueOf(error.getRejectedValue()))
                    .build();

            errorResponse.addField(field);
        });

        return errorResponse;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleMissingRequestHeaderException(final MissingRequestHeaderException exception, final HttpServletRequest request) {

        final ErrorResponse errorResponse = buildResponse(HttpStatus.BAD_REQUEST, request.getServletPath(), exception);

        final FieldResponse field = FieldResponse
                .builder()
                .message(MISSING_HEADER)
                .field(FieldTranslator.translate(exception.getHeaderName()))
                .build();

        errorResponse.addField(field);

        return errorResponse;
    }

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ErrorResponse handleMaxSizeException(final MaxUploadSizeExceededException exception, final HttpServletRequest request) {

        return ErrorResponse
                .builder()
                .message(FILE_TOO_LARGE)
                .status(HttpStatus.EXPECTATION_FAILED.value())
                .error(exception.getMessage())
                .path(request.getServletPath())
                .build();
    }

    private ErrorResponse buildResponse(final HttpStatus httpStatus, final String path, final Exception e) {

        return ErrorResponse
                .builder()
                .message(INVALID_MESSAGE)
                .timestamp(Instant.now().toEpochMilli())
                .status(httpStatus.value())
                .error(e.getMessage())
                .path(path)
                .build();
    }

    private String getFieldName(final TypeMismatchException exception) {

        try {
            return String.valueOf(FieldUtils.readField(exception, "name", true));
        } catch (Exception e) {
            return exception.getPropertyName();
        }
    }
}
