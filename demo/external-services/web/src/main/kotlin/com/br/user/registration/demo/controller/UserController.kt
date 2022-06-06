package com.br.user.registration.demo.controller

import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["v1/user"], produces = [MediaType.APPLICATION_JSON_VALUE])
class UserController {

    @GetMapping
    fun getUser() : ResponseEntity<String> {
        return ResponseEntity.status(HttpStatus.OK).body("Teste")
    }

}