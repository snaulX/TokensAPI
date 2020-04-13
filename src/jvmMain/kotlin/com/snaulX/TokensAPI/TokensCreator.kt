package com.snaulX.TokensAPI

import java.io.DataOutputStream
import java.io.FileOutputStream

actual class TokensCreator actual constructor() {
    lateinit var output: DataOutputStream

    fun DataOutputStream.writeByte(value: Byte) {
        writeByte(value.toInt())
    }

    /**
     * Set target compilation file
     * @param appName Name of compiling app (file)
     * @param extension Extension of compiling file
     */
    actual fun setOutput(appName: String, extension: String) {
        output = DataOutputStream(FileOutputStream(
                appName + '.' +
                if (extension.isBlank()) "tokens"
                else extension
            )
        )
    }

    /**
     * Set target platform for compilation
     */
    actual fun setTargetPlatform(type: PlatformType) {
        output.writeByte(type.value)
    }

    /**
     * Set type of compilation target (Script, File is class and etc.)
     */
    actual fun setHeader(type: HeaderType) {
        output.writeByte(type.value)
    }

    /**
     * Increment line for correct printing of errors
     */
    actual fun incLine() {
        output.writeByte(0)
    }

    /**
     * Create class
     */
    actual fun createClass(name: String, type: ClassType, securityDegree: SecurityDegree) {
        output.writeByte(1)
        output.writeBytes(name)
        output.writeByte(type.value)
        output.writeByte(securityDegree.value)
    }

    /**
     * Create method (function)
     */
    actual fun createFunction(name: String, typeName: String, type: FuncType, securityDegree: SecurityDegree) {
        output.writeByte(2)
        output.writeBytes(name)
        output.writeBytes(typeName)
        output.writeByte(type.value)
        output.writeByte(securityDegree.value)
    }

    /**
     * Start variables (fields) or properties definition
     */
    actual fun startVarDefinition(type: VarType, securityDegree: SecurityDegree) {
        output.writeByte(3)
        output.writeByte(type.value)
        output.writeByte(securityDegree.value)
    }

    /**
     * If [start] equals true - start new block
     * If [start] equals false - end current block
     */
    actual fun block(start: Boolean) {
        output.writeByte(4)
        output.writeBoolean(start)
    }

    /**
     * If [start] equals true - start new statement
     * If [start] equals false - end current statement
     */
    actual fun statement(start: Boolean) {
        output.writeByte(5)
        output.writeBoolean(start)
    }

    /**
     * If [start] equals true - start new sequence ([)
     * If [start] equals false - end current sequence (])
     */
    actual fun sequence(start: Boolean) {
        output.writeByte(6)
        output.writeBoolean(start)
    }

    /**
     * Call literal
     */
    actual fun callLiteral(literal: String) {
        output.writeByte(7)
        output.writeBytes(literal)
    }

    /**
     * Insert literal (. or -> in C) or expression (,) separator
     */
    actual fun insertSeparator(isLiteral: Boolean) {
        output.writeByte(8)
        output.writeBoolean(isLiteral)
    }

    /**
     * Insert expression (; or \n) end.
     * Need for correct finding syntax errors
     */
    actual fun insertExprEnd() {
        output.writeByte(9)
    }

    /**
     * Insert [type] loop
     */
    actual fun insertLoop(type: LoopType) {
        output.writeByte(10)
        output.writeByte(type.value)
    }

    /**
     * Create label with [name]
     */
    actual fun insertLabel(name: String) {
        output.writeByte(11)
        output.writeBytes(name)
    }

    /**
     * Go to label with [name].
     * Operator goto
     */
    actual fun goToLabel(name: String) {
        output.writeByte(12)
        output.writeBytes(name)
    }

    /**
     * If [_break] equals true - insert operator break
     * If [_break] equals false - insert operator continue
     */
    actual fun insertLoopOperator(_break: Boolean, labelName: String) {
        output.writeByte(13)
        output.writeBoolean(_break)
        output.writeBytes(labelName)
    }

    /**
     * Call [type] operator
     */
    actual fun callOperator(type: OperatorType) {
        output.writeByte(14)
        output.writeByte(type.value)
    }

    /**
     * Call [value]
     */
    actual fun callValue(value: Any?) {
        output.writeByte(15)
        when (value) {
            null -> {
                output.writeByte(0)
            }
            is Int -> {
                output.writeByte(1)
                output.writeInt(value)
            }
            is String -> {
                output.writeByte(2)
                output.writeBytes(value)
            }
            is Byte -> {
                output.writeByte(3)
                output.writeByte(value)
            }
            is Boolean -> {
                output.writeByte(4)
                output.writeBoolean(value)
            }
            is Char -> {
                output.writeByte(5)
                output.writeChar(value.toInt())
            }
            is Float -> {
                output.writeByte(6)
                output.writeFloat(value)
            }
            is Short -> {
                output.writeByte(7)
                output.writeShort(value.toInt())
            }
            is Long -> {
                output.writeByte(8)
                output.writeLong(value)
            }
            is Double -> {
                output.writeByte(9)
                output.writeDouble(value)
            }
        }
    }

    /**
     * Insert nullable (?) operator
     */
    actual fun insertNullable() {
        output.writeByte(16)
    }

    /**
     * Insert switch operator
     */
    actual fun insertSwitch() {
        output.writeByte(17)
    }

    /**
     * Insert case operator.
     * P.S. If you need 'default' operator - use insertCase() and callLiteral("_")
     */
    actual fun insertCase() {
        output.writeByte(18)
    }

    /**
     * Insert directive
     */
    actual fun insertDirective() {
        output.writeByte(19)
    }

    /**
     * Insert operator new
     */
    actual fun insertNew() {
        output.writeByte(20)
    }

    /**
     * Insert start of annotation
     */
    actual fun insertAnnotation() {
        output.writeByte(21)
    }

    /**
     * Insert throw operator
     */
    actual fun throwException() {
        output.writeByte(22)
    }

    /**
     * Start try block
     */
    actual fun insertTry() {
        output.writeByte(23)
    }

    /**
     * Start catch block
     */
    actual fun insertCatch() {
        output.writeByte(24)
    }

    /**
     * Start finally block
     */
    actual fun insertFinally() {
        output.writeByte(25)
    }

    /**
     * Start new if block
     */
    actual fun insertIf() {
        output.writeByte(26)
    }

    /**
     * Start else block.
     * P.S. If you find how make elif - use insertIf() and insertElse()
     */
    actual fun insertElse() {
        output.writeByte(27)
    }

    /**
     * Insert return operator
     */
    actual fun insertReturn(short: Boolean) {
        output.writeByte(28)
        output.writeBoolean(short)
    }

    /**
     * Insert except or actual modifer
     */
    actual fun insertActual(actual: Boolean) {
        output.writeByte(29)
        output.writeBoolean(actual)
    }

    /**
     * Insert typeof operator
     */
    actual fun checkTypeOf(name: String) {
        output.writeByte(30)
        output.writeBytes(name)
    }

    /**
     * Set package or namespace with [name]
     */
    actual fun setPackage(name: String) {
        output.writeByte(31)
        output.writeBytes(name)
    }

    /**
     * Import tokens library with [name]
     */
    actual fun importLibrary(name: String) {
        output.writeByte(32)
        output.writeBytes(name)
    }

    /**
     * Import package or use namespace with [name]
     */
    actual fun importPackage(name: String) {
        output.writeByte(33)
        output.writeBytes(name)
    }

    /**
     * Include VM library with [name]
     */
    actual fun include(name: String) {
        output.writeByte(34)
        output.writeBytes(name)
    }

    /**
     * Insert breakpoint (for debugger)
     */
    actual fun insertBreakpoint() {
        output.writeByte(35)
    }

    /**
     * Implements of next strings
     */
    actual fun implements() {
        output.writeByte(36)
    }

    /**
     * Extends of class
     */
    actual fun extends() {
        output.writeByte(37)
    }

    /**
     * Insert operator is (instanceof in Java)
     */
    actual fun instanceOf(name: String) {
        output.writeByte(38)
        output.writeBytes(name)
    }

    /**
     * Insert operator with
     */
    actual fun insertWith() {
        output.writeByte(39)
    }

    /**
     * Insert operator yield
     */
    actual fun insertYield() {
        output.writeByte(40)
    }

    /**
     * Insert lambda or after case operator
     */
    actual fun insertLambda(lambda: Boolean) {
        output.writeByte(41)
        output.writeBoolean(lambda)
    }

    /**
     * Insert async or await operator
     */
    actual fun insertAsync(await: Boolean) {
        output.writeByte(42)
        output.writeBoolean(await)
    }

    /**
     * Insert parameter type. true - out, false - in
     */
    actual fun parameterType(out: Boolean) {
        output.writeByte(43)
        output.writeBoolean(out)
    }

    /**
     * Insert ref operator
     */
    actual fun insertRef() {
        output.writeByte(44)
    }
}
