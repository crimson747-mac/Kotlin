package com.example.mvc.model.http

import com.example.mvc.annotation.StringFormatDateTime
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.validation.constraints.*

//@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
data class UserRequest(
    @field: NotEmpty
    @field: Size(min = 2, max = 8)
    var name: String? = null,

    @field: PositiveOrZero // 0 < 숫자 검즘 0도 포함
    var age: Int? = null,

    @field: Email // email 양식
    var email: String? = null,

    @field: NotBlank // 공백을 검증
    var address: String? = null,

    @field: Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}\$") // 정규식 검증
    @JsonProperty("phone_number")
    var phoneNumber: String? = null, // phone_number

    @field: StringFormatDateTime(pattern = "yyyy-MM-dd HH:mm:ss", message = "패턴이 올바르지 않습니다.")
    var createdAt: String? = null // yyyy-MM-dd HH:mm:ss
) {
    /*
    // 원하는 애노테이션이 없을 경우 만들어서 사용한다.
    // AssertTrue: Boolean 값을 리턴하는 메서드를 테스트 하기에 적합하다.
    @AssertTrue(message = "생성일자의 패턴은 yyyy-MM-dd HH:mm:ss 입니다") // 메서드는 field 필요 X
    private fun isValidCreateAt(): Boolean { // 정상: ture, 비정상: false
        return try {
            LocalDateTime.parse(this.createdAt,DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
            true
        } catch(e: Exception) {
            false
        }
    }
    */
}