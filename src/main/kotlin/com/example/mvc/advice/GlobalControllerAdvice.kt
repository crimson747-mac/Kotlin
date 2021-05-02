package com.example.mvc.advice

import com.example.mvc.controller.exception.ExceptionApiController
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.lang.RuntimeException


// RestController 에서 발생하는 Exception 들이 해당 클래스를 통하게 된다. => 글로벌하게 처리하는 방식
// 자동으로 catch 문이 발동하여 서버 내부에서는 에러 없이 동작한다.
// 특정 클래스(컨트롤러)에만 동작하도록 인자를 줄 수도 있다.
// @RestControllerAdvice(basePackageClasses = [ExceptionApiController::class])
class GlobalControllerAdvice {

    @ExceptionHandler(value=[RuntimeException::class])
    fun exception(e: RuntimeException): String {
        return "Server Error"
    }

    @ExceptionHandler(value = [IndexOutOfBoundsException::class])
    fun indexOutOfBoundsException(e: IndexOutOfBoundsException): ResponseEntity<String> {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Index Error")
    }
}