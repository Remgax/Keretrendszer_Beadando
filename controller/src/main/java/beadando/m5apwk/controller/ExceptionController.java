package beadando.m5apwk.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import beadando.m5apwk.exceptions.DiakNemTalalhato;

@ControllerAdvice
public class ExceptionController {

//    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
//    @ResponseBody
//    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
//    public String methodNotAlloed(HttpRequestMethodNotSupportedException e) {
//        return "This method is not allowed "+e.getMethod()+", use one of these"+e.getSupportedHttpMethods();
//    }
//
//    @ExceptionHandler(HttpMessageNotReadableException.class)
//    @ResponseBody
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public String badRequest(HttpMessageNotReadableException e) throws Throwable{
//        Throwable c = e.getCause().getCause();
//        return c.getClass().getSimpleName()+": "+c.getMessage();
//    }
//
//    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
//    @ResponseBody
//    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
//    public String unsupported(HttpMediaTypeNotSupportedException e) {
//        return "Use one of the followings: "+e.getSupportedMediaTypes();
//    }
//
//    @ExceptionHandler(DiakNemTalalhato.class)
//    @ResponseBody
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public String unknowDiakId(DiakNemTalalhato e) {
//        return "Diak not found with id: "+e.getMessage();
//    }
}