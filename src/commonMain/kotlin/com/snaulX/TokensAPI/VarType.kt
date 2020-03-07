package com.snaulX.TokensAPI

enum class VarType(val value: Byte) {
    DEFAULT(0),
    ABSTRACT(1),
    STATIC(2),
    FINAL(3),
    VIRTUAL(4),
    OVERRIDE(5),
    CONST(6)
}