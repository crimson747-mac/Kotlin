package com.example.mvc.controller.delete

import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

@RestController
@RequestMapping("/api")
@Validated
class DeleteApiController {
    // 1. path variable
    // 2. request param

    @DeleteMapping(path = ["/delete-mapping"])
    fun deleteMapping(
        @RequestParam(value = "name") _name: String,

        @NotNull(message = "age 값이 누락되었습니다.")
        @Min(value = 20, message = "age 는 20보다 커야 합니다.")
        @RequestParam(name = "age") _age: Int
    ): String {
        println(_name)
        println(_age)

        return "name: $_name, age: $_age"
    }

    @RequestMapping(method = [RequestMethod.DELETE], path = ["/delete-mapping/name/{name}/age/{age}"])
    fun deleteMappingPath(
        @NotNull(message = "name 값이 누락되었습니다.")
        @Size(min = 2, max = 5, message = "name 의 길이는 2 ~ 5")
        @PathVariable(value = "name") _name: String,

        @NotNull(message = "age 값이 누락되었습니다.")
        @Min(value = 20, message = "age 는 20보다 커야 합니다.")
        @PathVariable(name = "age") _age: Int,
    ): String {
        println(_name)
        println(_age)

        return "name: $_name, age: $_age"
    }
}