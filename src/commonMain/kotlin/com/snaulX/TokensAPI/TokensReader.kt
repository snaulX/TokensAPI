package com.snaulX.TokensAPI

expect class TokensReader {
    val tokens: MutableList<TokenType>
    val boolValues: MutableList<Boolean>
    val byteValues: MutableList<Byte>
    val stringValues: MutableList<String>
    val securities: MutableList<SecurityDegree>
    val classTypes: MutableList<ClassType>
    val funcTypes: MutableList<FuncType>
    val varTypes: MutableList<VarType>
    val loops: MutableList<LoopType>
    val operators: MutableList<OperatorType>
    val values: MutableList<Any>

    fun getHeader(): HeaderType
    fun getTarget(): String
    fun setPath(path: String)
    fun readTokens()
    fun endWork()
}