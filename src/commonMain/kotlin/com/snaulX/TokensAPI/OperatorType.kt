package com.snaulX.TokensAPI

enum class OperatorType(val value: Byte) {
    ADD(0),
    SUB(1),
    MUL(3),
    DIV(4),
    MOD(5),
    EQ(6),
    NOTEQ(7),
    NOT(8),
    AND(9),
    OR(10),
    XOR(11),
    GT(12),
    LT(13),
    GTQ(14),
    LTQ(15)
}