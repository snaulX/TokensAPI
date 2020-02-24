package com.snaulX.TokensAPI

enum class ClassType(val tokens_code: Byte) {
    DEFAULT(0),
    FINAL(1),
    ABSTRACT(2),
    STATIC(3),
    DATA(4),
    ENUM(5)
}