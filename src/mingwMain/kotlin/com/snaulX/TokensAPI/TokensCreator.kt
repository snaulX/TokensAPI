package com.snaulX.TokensAPI

import kotlinx.cinterop.*
import platform.posix.*

actual class TokensCreator actual constructor() {

    lateinit var file: CPointer<FILE>

    actual fun createClass(
        name: String,
        security: SecurityDegree,
        classType: ClassType
    ) {
    }

    actual fun createMethod(
        name: String,
        returnType: String,
        security: SecurityDegree,
        funcType: FuncType
    ) {
    }

    actual fun createField(
        name: String,
        typeName: String,
        security: SecurityDegree
    ) {
    }

    actual fun createExtensionMethod(
        className: String,
        methodName: String,
        returnType: String,
        security: SecurityDegree
    ) {
    }

    actual fun markDirective(arguments: List<String>) {
    }

    /**
     * Mark annotation with name. Arguments of annotation must be defined in giveArgument()
     * @param name Name of annotation
     */
    actual fun markAnnotation(name: String) {
    }

    /**
     * Create interface with name and security
     * @param name Name of creating interface
     * @param security Security access for this interface
     */
    actual fun createInterface(name: String, security: SecurityDegree) {
    }

    /**
     * Start default block
     * If in context save class - this function create body of this class
     * If in context save enum - body of enum
     * If in context save interface - body of interface
     * If in context save method - body of method
     * And other more...
     */
    actual fun startBlock() {
    }

    /**
     * End block in context
     */
    actual fun endBlock() {
    }

    /**
     * Implement interfaces to class
     * @param interfaces Names of interfaces which must be implement to class
     */
    actual fun implementClass(interfaces: List<String>) {
    }

    /**
     * Override class of other class
     * @param baseClass Name of overriding class
     */
    actual fun overrideClass(baseClass: String) {
    }

    /**
     * Add assembly in .NET, Java Archive or Class File in JVM and static library in LLVM
     */
    actual fun include(libPath: String) {
    }

    /**
     * Link tokens library to this file
     */
    actual fun linkLibrary(libraryPath: String) {
    }

    actual fun markLabel(name: String) {
    }

    /**
     * Import package with this name
     * @param name Name of importing package
     */
    actual fun importPackage(name: String) {
    }

    /**
     * Create package with name for writing next context to this package
     * @param name Name of creating package
     */
    actual fun markPackage(name: String) {
    }

    /**
     * Create enum or enum class in context with name, security
     * @param name Name of creating enum
     * @param security Security access for this enum
     */
    actual fun createEnum(name: String, security: SecurityDegree) {
    }

    /**
     * Create constructor in class of context
     * @param name Name of creating constructor
     * @param security Security access for this constructor
     */
    actual fun createConstructor(name: String, security: SecurityDegree) {
    }

    /**
     * Push variable with name or static class with name to context
     */
    actual fun callLiteral(name: String) {
    }

    /**
     * Set output file for writing tokens to this file
     * @param fileName Name of file which be output
     */
    actual fun setOutput(fileName: String) {
        file = fopen(fileName, "wb") ?: throw Exception("TokensAPI Error. File by name $fileName is not found")
    }

    /**
     * Create typealias with name of type
     * @param name New type name
     */
    actual fun createTypeAlias(name: String) {
    }

    /**
     * Create funcalias with [name]
     * @param name Name of new function
     */
    actual fun createFuncAlias(name: String) {
    }

    /**
     * Mark break operator in this position
     */
    actual fun markBreak() {
    }

    /**
     * Mark goto operator in this position for [name] label
     * @param name Name of label which going to
     */
    actual fun goto(name: String) {
    }

    /**
     * Mark continue operator in this position
     */
    actual fun markContinue() {
    }

    /**
     * Mark breakpoint
     */
    actual fun markBreakpoint() {
    }

    /**
     * Open new statement in context and add to this while statement will not close
     */
    actual fun openStatement() {
    }

    /**
     * Close current statement in context
     */
    actual fun closeStatement() {
    }

    /**
     * Add previous value from context and next
     */
    actual fun add() {
    }

    /**
     * Subtract previous value from context and next
     */
    actual fun subtract() {
    }

    /**
     * Divide previous value from context and next
     */
    actual fun divide() {
    }

    /**
     * Multiply previous value from context and next
     */
    actual fun multiply() {
    }

    /**
     * Compares for equality previous value from context and next
     */
    actual fun equals() {
    }

    /**
     * Compares for not equality previous value from context and next
     */
    actual fun notEquals() {
    }

    /**
     * Create if operator and make new if construction. Next statement will push into this if
     */
    actual fun createIf() {
    }

    /**
     * Create else if operator and continue current if construction. Next statement will push into this if
     */
    actual fun createElseIf() {
    }

    /**
     * Create else operator and close current if construction
     */
    actual fun createElse() {
    }

    /**
     * Create switch operator
     */
    actual fun createSwitch() {
    }

    /**
     * Create case block in current switch operator for checking on next value in context
     */
    actual fun createCase() {
    }

    /**
     * Create default block in current switch operator
     */
    actual fun createDefault() {
    }

    /**
     * Create with operator
     */
    actual fun createWith() {
    }

    /**
     * Create while loop or add statement if it is do-while loop
     */
    actual fun createWhile() {
    }

    /**
     * Create do-while loop and do block
     */
    actual fun createDo() {
    }

    /**
     * Create for loop with three parameters (parameters writing using statements)
     */
    actual fun createFor() {
    }

    /**
     * Create foreach loop
     */
    actual fun createForeach() {
    }

    /**
     * Add in operator
     */
    actual fun addIn() {
    }

    /**
     * Get element in collection by index.
     * In a lot of languages it is operator \[index\]
     */
    actual fun getByIndex(index: Int) {
    }

    /**
     * Compares for greater previous value from context then next
     */
    actual fun greaterThen() {
    }

    /**
     * Compares for less previous value from context then next
     */
    actual fun lessThen() {
    }

    /**
     * Compares for greater or equals previous value from context then next
     */
    actual fun greaterOrEqualsThen() {
    }

    /**
     * Compares for less or equals previous value from context then next
     */
    actual fun lessOrEqualsThen() {
    }

    /**
     * Add operator return and return next value in context
     */
    actual fun addReturn() {
    }

    /**
     * Create new object using operator new
     */
    actual fun createNew() {
    }

    /**
     * Create operator of [type] with [returnType]
     * @param type Type of operator
     * @param returnType Type of returning value
     */
    actual fun createOperator(type: OperatorType, returnType: String) {
    }

    /**
     * Convert next statement to [typeName]
     * @param typeName Name of type for convert to
     */
    actual fun convertTo(typeName: String) {
    }

    /**
     * Add operator is (compare type of last object from context with type by [typeName])
     * @param typeName Name of compareble type
     */
    actual fun addIs(typeName: String) {
    }

    actual var header: HeaderType = HeaderType.Script
    /**
     * Add operator typeof (get type by [typeName])
     * @param typeName Name of getting type
     */
    actual fun checkTypeof(typeName: String) {
    }

    actual fun createStaticField(name: String, typeName: String, security: SecurityDegree) {
    }

    actual fun createFinalField(name: String, typeName: String, security: SecurityDegree) {
    }

    /**
     * Set incrementing line to Tokens code for right printing of errors
     */
    actual fun incLine() {
    }

    actual var platform: PlatformType = PlatformType.Common
    /**
     * Add operator of assign
     */
    actual fun assignValue() {
    }

    /**
     * Return inversion value or just operator not
     */
    actual fun inversion() {
    }

    /**
     * Operator and
     */
    actual fun and() {
    }

    /**
     * Operator or
     */
    actual fun or() {
    }

    /**
     * Operator xor
     */
    actual fun xor() {
    }

    /**
     * Operator of increment
     */
    actual fun increment() {
    }

    /**
     * Operator of decrement
     */
    actual fun decrement() {
    }

    /**
     * Throw exception with next object in context
     */
    actual fun throwException() {
    }

    /**
     * Operator modulo '%'
     */
    actual fun modulo() {
    }

    /**
     * Raises the previous number to the power which expresses the following
     */
    actual fun power() {
    }

    /**
     * Create annotation (attribute in .NET) with [name] and [security]
     * @param name Name of creating annotation
     * @param security Security access for this annotation
     */
    actual fun createAnnotation(name: String, security: SecurityDegree) {
    }

    /**
     * Create collection with [name] and [security]
     * @param name Name of creating collection
     * @param security Security access for this collection
     */
    actual fun createCollection(name: String, security: SecurityDegree) {
    }
}