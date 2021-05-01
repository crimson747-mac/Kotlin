package com.example.mvc.controller.get

import com.example.mvc.model.http.UserRequest
import org.springframework.web.bind.annotation.*

@RestController         // REST API Controller 동작
@RequestMapping("/api") // http://localhost:8080/api
class GetApiController {
    @GetMapping(path=["/hello", "/hello-again"]) // GET http://localhost:8080/api/hello
    fun hello():String {
        return "hello kotlin"
    }

    @RequestMapping(method = [RequestMethod.GET], path=["/request-mapping"]) // 엣날 발식
    fun requestMapping(): String {
        return "request-mapping"
    }

    @GetMapping("/get-mapping/path-variable/{name}/{age}") // GET http://localhost:8080/api/get-mapping/path-variable/
    fun pathVariable(@PathVariable name: String, @PathVariable age: Int): String {
        println("name: $name, age: $age")
        return "$name is $age years old"
    }

    @GetMapping("/get-mapping/path-variable2/{name}/{age}") // GET http://localhost:8080/api/get-mapping/path-variable/
    fun pathVariable2(@PathVariable(value = "name") _name: String, @PathVariable(name="age") _age: Int): String {
        val name = "zeros"
        println("name: $_name, age: $_age")
        return "$_name is $_age years old"
    }

    // http://localhost:8080/api/page?key=value&key2=value2
    @GetMapping("/get-mapping/query-param") // ?name=zeros&age=20
    fun queryParam(
        @RequestParam(name = "name") name: String,
        @RequestParam(value = "age") age: Int
    ):String {
        println("$name, $age")
        return "$name, $age"
    }

    // name, age, address, email
    // phone-number - X
    @GetMapping("/get-mapping/query-param/object")
    fun queryParamObject(userRequest: UserRequest): UserRequest {
        println(userRequest)
        return userRequest
    }

    // name, age, address, email
    // phone-number - O
    @GetMapping("/get-mapping/query-param/map")
    fun queryParamMap(
        @RequestParam map: Map<String, Any>
    ): Map<String, Any> {
        println(map)
        return map
    }
}