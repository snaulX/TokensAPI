package com.snaulX.TokensAPI

object EnumConverter {
    fun Byte.toTokenType(): TokenType =
            TokenType.values().firstOrNull { it.value == this }
                ?: throw InvalidCodeException("Invalid token with code $this")

    fun Byte.toClassType(): ClassType =
            ClassType.values().firstOrNull { it.value == this }
                ?: throw InvalidCodeException("Invalid class type with code $this")

    fun Byte.toFuncType(): FuncType =
            FuncType.values().firstOrNull { it.value == this }
                ?: throw InvalidCodeException("Invalid function type with code $this")

    fun Byte.toHeaderType(): HeaderType =
            HeaderType.values().firstOrNull { it.value == this }
                ?: throw InvalidCodeException("Invalid header with code $this")

    fun Byte.toLoopType(): LoopType =
            LoopType.values().firstOrNull { it.value == this }
                    ?: throw InvalidCodeException("Invalid loop with code $this")

    fun Byte.toVarType(): VarType =
            VarType.values().firstOrNull { it.value == this }
                    ?: throw InvalidCodeException("Invalid variable type with code $this")

    fun Byte.toOperatorType(): OperatorType =
            OperatorType.values().firstOrNull { it.value == this }
                    ?: throw InvalidCodeException("Invalid operator type with code $this")

    fun Byte.toSecurityDegree(): SecurityDegree =
            SecurityDegree.values().firstOrNull { it.value == this }
                    ?: throw InvalidCodeException("Invalid security degree with code $this")
}