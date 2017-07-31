package nl.sourcelabs.solutions.kotlinworkshop.resource

import nl.sourcelabs.solutions.kotlinworkshop.domain.ServiceError
import org.slf4j.LoggerFactory
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.http.ResponseEntity
import org.springframework.web.HttpRequestMethodNotSupportedException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException

@RestController
@ControllerAdvice
class ErrorResource {

    companion object {
        val logger = LoggerFactory.getLogger(ErrorResource::class.java)!!
    }

    @ExceptionHandler(EmptyResultDataAccessException::class)
    fun handle404(exception: Exception): ResponseEntity<ServiceError> {
        logger.error("Entity not found", exception)
        return ResponseEntity.status(404).body(ServiceError(status = 404, reason = "Entity referred to in operation was not found."))
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException::class)
    fun handle400Param(exception: Exception): ResponseEntity<ServiceError> {
        logger.error("Method argument mismatch (bad request)", exception)
        return ResponseEntity.status(400).body(ServiceError(status = 400, reason = "Bad request, check the parameter and payload types."))
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException::class)
    fun handle400Method(exception: Exception): ResponseEntity<ServiceError> {
        logger.error("Method argument mismatch (bad request)", exception)
        return ResponseEntity.status(400).body(ServiceError(status = 400, reason = "Bad request, specified method not allowed for the given URI."))
    }

    @ExceptionHandler(Exception::class)
    fun handle500(exception: Exception): ResponseEntity<ServiceError> {
        logger.error("Unhandled error", exception)
        return ResponseEntity.status(500).body(ServiceError(status = 500, reason = "Application error. Please notify us if the problem persists."))
    }
}