package com.snaulX.TokensAPI

import com.snaulX.TokensAPI.TokenType.*
import java.io.DataInputStream
import java.io.FileInputStream
import java.io.IOException

actual class TokensReader {
    lateinit var reader: DataInputStream
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
        val value: Byte = reader.readByte()
        for (type: HeaderType in HeaderType.values()) {
            if (type.value == value) return type
        }
        throw InvalidHeaderException("Unknown header with code $value")
    }

    actual fun getTarget(): String = when (reader.readByte()) {
            PlatformType.Common.value -> "COMMON"
            PlatformType.Jvm.value -> "JVM"
            PlatformType.DotNet.value -> "DOTNET"
            PlatformType.Native.value -> "NATIVE"
            else -> reader.readUTF()
        }

    actual fun setPath(path: String) {
        reader = DataInputStream(FileInputStream(path))
    }

    actual fun readTokens() {
        while (true) {
            try {
                val tokenCode: Byte = reader.readByte()
                var token: TokenType = NEWLN
                for (tokenType: TokenType in values()) {
                    if (tokenType.value == tokenCode) {
                        token = tokenType
                        break
                    }
                }
                tokens.add(token)
                when (token) {
                    CLASS -> {
                        stringValues.add(reader.readUTF())
                        //classTypes.add(reader.readByte())
                        //securities.add(reader.readByte())
                    }
                }
            } catch (e: IOException) {
                break
            }
        }
    }

    actual fun endWork() {
        reader.close()
    }
}
