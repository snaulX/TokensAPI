package com.snaulX.TokensAPI

import kotlinx.cinterop.*
import platform.posix.*

actual class TokensCreator actual constructor() {
    /**
     * Set target compilation file
     * @param appName Name of compiling app (file)
     * @param extension Extension of compiling file
     */
    actual fun setOutput(appName: String, extension: String) {
    }

    /**
     * Set target platform for compilation
     */
    actual fun setTargetPlatform(type: PlatformType) {
    }

    /**
     * Set type of compilation target (Script, File is class and etc.)
     */
    actual fun setHeader(type: HeaderType) {
    }

    /**
     * Increment line for correct printing of errors
     */
    actual fun incLine() {
    }

    /**
     * Create class
     */
    actual fun createClass(name: String, type: ClassType, securityDegree: SecurityDegree) {
    }

    /**
     * Create method (function)
     */
    actual fun createFunction(name: String, typeName: String, type: FuncType) {
    }

    /**
     * Start variables (fields) or properties definition
     */
    actual fun startVarDefinition(type: VarType, securityDegree: SecurityDegree) {
    }

    /**
     * If [start] equals true - start new block
     * If [start] equals false - end current block
     */
    actual fun block(start: Boolean) {
    }

    /**
     * If [start] equals true - start new statement
     * If [start] equals false - end current statement
     */
    actual fun statement(start: Boolean) {
    }

    /**
     * If [start] equals true - start new sequence ([)
     * If [start] equals false - end current sequence (])
     */
    actual fun sequence(start: Boolean) {
    }

    /**
     * Call literal
     */
    actual fun callLiteral(literal: String) {
    }

    /**
     * Insert literal (. or -> in C) or expression (,) separator
     */
    actual fun insertSeparator(isLiteral: Boolean) {
    }

    /**
     * Insert expression (; or \n) end.
     * Need for correct finding syntax errors
     */
    actual fun insertExprEnd() {
    }

    /**
     * Insert [type] loop
     */
    actual fun insertLoop(type: LoopType) {
    }

    /**
     * Create label with [name]
     */
    actual fun insertLabel(name: String) {
    }

    /**
     * Go to label with [name].
     * Operator goto
     */
    actual fun goToLabel(name: String) {
    }

    /**
     * If [_break] equals true - insert operator break
     * If [_break] equals false - insert operator continue
     */
    actual fun insertLoopOperator(_break: Boolean, labelName: String) {
    }

    /**
     * Call [type] operator
     */
    actual fun callOperator(type: OperatorType) {
    }

    /**
     * Call [value]
     */
    actual fun callValue(value: Any?) {
    }

    /**
     * Insert nullable (?) operator
     */
    actual fun insertNullable() {
    }

    /**
     * Insert switch operator
     */
    actual fun insertSwitch() {
    }

    /**
     * Insert case operator.
     * P.S. If you need 'default' operator - use insertCase() and callLiteral("_")
     */
    actual fun insertCase() {
    }

    /**
     * Insert directive
     */
    actual fun insertDirective(arguments: List<String>) {
    }

    /**
     * Insert operator new
     */
    actual fun insertNew() {
    }

    /**
     * Insert start of annotation
     */
    actual fun insertAnnotation() {
    }

    /**
     * Insert throw operator
     */
    actual fun throwException() {
    }

    /**
     * Start try block
     */
    actual fun insertTry() {
    }

    /**
     * Start catch block
     */
    actual fun insertCatch() {
    }

    /**
     * Start finally block
     */
    actual fun insertFinally() {
    }

    /**
     * Start new if block
     */
    actual fun insertIf() {
    }

    /**
     * Start else block.
     * P.S. If you find how make elif - use insertIf() and insertElse()
     */
    actual fun insertElse() {
    }

    /**
     * Insert return operator
     */
    actual fun insertReturn() {
    }

    /**
     * Insert except or actual modifer
     */
    actual fun insertActual(actual: Boolean) {
    }

    /**
     * Insert typeof operator
     */
    actual fun checkTypeOf(name: String) {
    }

    /**
     * Set package or namespace with [name]
     */
    actual fun setPackage(name: String) {
    }

    /**
     * Import tokens library with [name]
     */
    actual fun importLibrary(name: String) {
    }

    /**
     * Import package or use namespace with [name]
     */
    actual fun importPackage(name: String) {
    }

    /**
     * Include VM library with [name]
     */
    actual fun include(name: String) {
    }

    /**
     * Insert breakpoint (for debugger)
     */
    actual fun insertBreakpoint() {
    }

    /**
     * Convert to type with [name]
     */
    actual fun convertTo(name: String) {
    }

    /**
     * Implements of [interfaces]
     */
    actual fun implements(interfaces: List<String>) {
    }

    /**
     * Extends of class by [name]
     */
    actual fun extends(name: String) {
    }
}