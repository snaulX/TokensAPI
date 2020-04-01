package com.snaulX.TokensAPI

actual class TokensReader {
    actual val tokens: MutableList<TokenType> = mutableListOf()
    actual val boolValues: MutableList<Boolean> = mutableListOf()
    actual val byteValues: MutableList<Byte> = mutableListOf()
    actual val stringValues: MutableList<String> = mutableListOf()
    actual val securities: MutableList<SecurityDegree> = mutableListOf()
    actual val classTypes: MutableList<ClassType> = mutableListOf()
    actual val funcTypes: MutableList<FuncType> = mutableListOf()
    actual val varTypes: MutableList<VarType> = mutableListOf()
    actual val loops: MutableList<LoopType> = mutableListOf()
    actual val operators: MutableList<OperatorType> = mutableListOf()
    actual val values: MutableList<Any> = mutableListOf()

    actual fun getHeader(): HeaderType {
        TODO("Not yet implemented")
    }

    actual fun getTarget(): String {
        TODO("Not yet implemented")
    }

    actual fun setPath(path: String) {
    }

    actual fun readTokens() {
    }

    actual fun endWork() {
    }
}