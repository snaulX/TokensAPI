package com.snaulX.TokensAPI

enum class OperatorType(val value: Byte) {
    ADD(0),
    SUB(1),
    MUL(2),
    DIV(3),
    MOD(4),
    EQ(5),
    NOTEQ(6),
    NOT(7),
    AND(8),
    OR(9),
    XOR(10),
    GT(11),
    LT(12),
    GTQ(13),
    LTQ(14)
}