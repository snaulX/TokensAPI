package com.snaulX.TokensAPI

enum class ClassType(val tokens_code: Byte) {
    DEFAULT(0),
    SEALED(1),
    ABSTRACT(2),
    STATIC(3)
}