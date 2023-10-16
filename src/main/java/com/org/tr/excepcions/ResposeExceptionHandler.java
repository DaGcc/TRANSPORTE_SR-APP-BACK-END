package com.org.tr.excepcions;

import java.time.LocalDateTime;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice //Para que esta clase salte en todos  los controladores que surgieron excepciones
@RestController //Respuestas API REST
public class ResposeExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Metodo controlador del estado HTTP_INTERNAL_SEVER_ERROR
     *
     * @param ex -> de la clase Throwable
     * @param headers -> cabezera de la solicitud
     * @param status -> estado http que origino la excepcion
     * @param request -> detalle de las peticiones
     * @return
     */
    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        System.out.println("1"+ ex.getMessage() + "es:" + status);
        ExceptionResponse exceptionResponse = new ExceptionResponse(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
        return ResponseEntity.status(status).body(exceptionResponse); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Metodo controlador del estado HTTP_BAD_REQUEST
     *
     * @param ex -> de la clase Throwable
     * @param headers -> cabezera de la solicitud
     * @param status -> estado http que origino la excepcion
     * @param request -> detalle de las peticiones
     * @return
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        System.out.println("2"+ ex.getMessage() + "es:" + status);
        ExceptionResponse exceptionResponse = new ExceptionResponse(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
        return ResponseEntity.status(status).body(exceptionResponse); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Metodo controlador del estado HTTP_NOT_FOUND
     *
     * @param ex -> de la clase Throwable
     * @param request -> detalle de las peticiones
     * @return -> retorno
     */
    @ExceptionHandler(ModelNotFoundException.class)
    public final ResponseEntity<ExceptionResponse> ResponseModelNotFoundException(ModelNotFoundException ex, WebRequest request) {
        //TODO: la logica de respuesta para este metodo personalizado

        //se crea la instancia de la clase POJO, y se envian los parametros establecidos en su contructor
        ExceptionResponse exceptionResponse = new ExceptionResponse(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));

        //retorno como respuesta HTTP para el servicio API REST
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponse);
    }

}
