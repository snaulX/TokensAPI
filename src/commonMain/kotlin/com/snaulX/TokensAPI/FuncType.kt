package com.snaulX.TokensAPI

enum class FuncType(val value: Byte) {
    DEFAULT(0),
    ABSTRACT(1),
    STATIC(2),
    FINAL(3),
    VIRTUAL(4),
    FUNCALIAS(5),
    CONSTRUCTOR(6),
    OPERATOR(7),
    DESTRUCTOR(8),
    OVERRIDE(9)
}