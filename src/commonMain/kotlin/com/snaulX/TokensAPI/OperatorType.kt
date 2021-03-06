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
    LTQ(14),
    ASSIGN(15),
    ADDASSIGN(16),
    SUBASSIGN(17),
    MULASSIGN(18),
    DIVASSIGN(19),
    MODASSIGN(20),
    CONVERTTO(21),
    INC(22),
    DEC(23),
    IN(24),
    /**
     * Greater or equals
     */
    GORE(25),
    /**
     * Less or equals
     */
    LORE(26),
    RANGE(27),
    POW(28)
}