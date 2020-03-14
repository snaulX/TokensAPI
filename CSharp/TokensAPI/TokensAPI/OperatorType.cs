namespace TokensAPI
{
    public enum OperatorType : byte
    {
        ADD = 0,
        SUB = 1,
        MUL = 2,
        DIV = 3,
        MOD = 4,
        EQ = 5,
        NOTEQ = 6,
        NOT = 7,
        AND = 8,
        OR = 9,
        XOR = 10,
        GT = 11,
        LT = 12,
        GTQ = 13,
        LTQ = 14,
        ASSIGN = 15,
        ADDASSIGN = 16,
        SUBASSIGN = 17,
        MULASSIGN = 18,
        DIVASSIGN = 19,
        MODASSIGN = 20,
        CONVERTTO = 21,
        GETBYINDEX = 22,
        INC = 23,
        DEC = 24,
        IN = 25,
        /**
         * Greater or equals
         */
        GORE = 26,
        /**
         * Less or equals
         */
        LORE = 27,
        RANGE = 28,
        POW = 29
    }
}
