package com.snaulX.TokensAPI

import com.snaulX.TokensAPI.SecurityDegree.*

expect class TokensCreator() {
    /**
     * Set target compilation file
     * @param appName Name of compiling app (file)
     * @param extension Extension of compiling file
     */
    fun setOutput(appName: String, extension: String = "tokens")
    /**
     * Set target platform for compilation
     */
    fun setTargetPlatform(type: PlatformType = PlatformType.Common)
    /**
     * Set type of compilation target (Script, File is class and etc.)
     */
    fun setHeader(type: HeaderType = HeaderType.Script)
    /**
     * Increment line for correct printing of errors
     */
    fun incLine()
    /**
     * Create class
     */
    fun createClass(name: String, type: ClassType = ClassType.DEFAULT, securityDegree: SecurityDegree = PUBLIC)
    /**
     * Create method (function)
     */
    fun createFunction(name: String, typeName: String = "", type: FuncType = FuncType.DEFAULT, securityDegree: SecurityDegree = PUBLIC)
    /**
     * Start variables (fields) or properties definition
     */
    fun startVarDefinition(type: VarType = VarType.DEFAULT, securityDegree: SecurityDegree = PUBLIC)
    /**
     * If [start] equals true - start new block
     * If [start] equals false - end current block
     */
    fun block(start: Boolean)
    /**
     * If [start] equals true - start new statement
     * If [start] equals false - end current statement
     */
    fun statement(start: Boolean)
    /**
     * If [start] equals true - start new sequence ([)
     * If [start] equals false - end current sequence (])
     */
    fun sequence(start: Boolean)
    /**
     * Call literal
     */
    fun callLiteral(literal: String)
    /**
     * Insert literal (. or -> in C) or expression (,) separator
     */
    fun insertSeparator(isLiteral: Boolean = true)
    /**
     * Insert expression (; or \n) end.
     * Need for correct finding syntax errors
     */
    fun insertExprEnd()
    /**
     * Insert [type] loop
     */
    fun insertLoop(type: LoopType)
    /**
     * Create label with [name]
     */
    fun insertLabel(name: String)
    /**
     * Go to label with [name].
     * Operator goto
     */
    fun goToLabel(name: String)
    /**
     * If [_break] equals true - insert operator break
     * If [_break] equals false - insert operator continue
     */
    fun insertLoopOperator(_break: Boolean, labelName: String = "")
    /**
     * Call [type] operator
     */
    fun callOperator(type: OperatorType)
    /**
     * Call [value]
     */
    fun callValue(value: Any?)
    /**
     * Insert nullable (?) operator
     */
    fun insertNullable()
    /**
     * Insert switch operator
     */
    fun insertSwitch()
    /**
     * Insert case operator.
     * P.S. If you need 'default' operator - use insertCase() and callLiteral("_")
     */
    fun insertCase()
    /**
     * Insert directive
     */
    fun insertDirective()
    /**
     * Insert operator new
     */
    fun insertNew()
    /**
     * Insert start of annotation
     */
    fun insertAnnotation()
    /**
     * Insert throw operator
     */
    fun throwException()
    /**
     * Start try block
     */
    fun insertTry()
    /**
     * Start catch block
     */
    fun insertCatch()
    /**
     * Start finally block
     */
    fun insertFinally()
    /**
     * Start new if block
     */
    fun insertIf()
    /**
     * Start else block.
     * P.S. If you find how make elif - use insertIf() and insertElse()
     */
    fun insertElse()
    /**
     * Insert return operator
     */
    fun insertReturn(short: Boolean = false)
    /**
     * Insert except or actual modifer
     */
    fun insertActual(actual: Boolean = true)
    /**
     * Insert typeof operator
     */
    fun checkTypeOf(name: String)
    /**
     * Set package or namespace with [name]
     */
    fun setPackage(name: String)
    /**
     * Import tokens library with [name]
     */
    fun importLibrary(name: String)
    /**
     * Import package or use namespace with [name]
     */
    fun importPackage(name: String)
    /**
     * Include VM library with [name]
     */
    fun include(name: String)
    /**
     * Insert breakpoint (for debugger)
     */
    fun insertBreakpoint()
    /**
     * Implements of next strings
     */
    fun implements()
    /**
     * Extends of class
     */
    fun extends()
    /**
     * Insert operator is (instanceof in Java)
     */
    fun instanceOf(name: String)
    /**
     * Insert operator with
     */
    fun insertWith()
    /**
     * Insert operator yield
     */
    fun insertYield()
    /**
     * Insert lambda or after case operator
     */
    fun insertLambda(lambda: Boolean = true)
    /**
     * Insert async or await operator
     */
    fun insertAsync(await: Boolean = false)
    /**
     * Insert parameter type. true - out, false - in
     */
    fun parameterType(out: Boolean)
    /**
     * Insert ref operator
     */
    fun insertRef()
}