package com.example.mvc.controller.page

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller // 주로 HTML 파일을 내릴 때 사용
class PageController {

    // http://localhost:8080/main
    @GetMapping("/main")
    fun main(): String {
        println("init main")
        return "main.html" // static 하위의 html 파일을 내린다.
    }

    @ResponseBody // RestController 애노테이션 처럼 사용 -> HTML 을 내리지 않는다.
    @GetMapping("/test")
    fun response(): String {
        return "main.html" // "main.html" 텍스트를 내린다.
    }
}