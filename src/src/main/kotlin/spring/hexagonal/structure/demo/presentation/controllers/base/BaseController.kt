package spring.hexagonal.structure.demo.presentation.controllers.base

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import java.lang.Exception

open class BaseController {

    fun Ok(`object`: Any?): ResponseEntity<*>? {
        return ResponseEntity(`object`, HttpStatus.CREATED)
    }

    fun BadRequest(ex: Exception): ResponseEntity<*>? {
        return ResponseEntity(ex.message, HttpStatus.BAD_REQUEST)
    }
}