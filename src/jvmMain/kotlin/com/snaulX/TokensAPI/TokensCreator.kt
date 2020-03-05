package com.snaulX.TokensAPI

import java.io.*

actual class TokensCreator actual constructor() {

    fun DataOutputStream.writeByte(value: Byte) {
        writeByte(value.toInt())
    }

    lateinit var output: DataOutputStream

    actual fun setOutput(fileName: String) {
        output = DataOutputStream(FileOutputStream(fileName))
        output.writeByte(header.value)
        output.writeByte(platform.value)
    }

    actual fun createClass(
        name: String,
        security: SecurityDegree,
        classType: ClassType
    ) {
        output.writeByte(0)
        output.writeUTF(name)
        output.writeByte(security.value)
        output.writeByte(classType.tokens_code)
    }

    actual fun createMethod(
        name: String,
        returnType: String,
        security: SecurityDegree,
        funcType: FuncType
    ) {
        output.writeByte(1)
        output.writeUTF(name)
        output.writeUTF(returnType)
        output.writeByte(security.value)
        output.writeByte(funcType.value)
    }

    actual fun createField(
        name: String,
        typeName: String,
        security: SecurityDegree
    ) {
        output.writeByte(2)
        output.writeUTF(name)
        output.writeUTF(typeName)
        output.writeByte(security.value)
        output.writeByte(0) //field is default type
    }

    actual fun createExtensionMethod(
        className: String,
        methodName: String,
        returnType: String,
        security: SecurityDegree
    ) {
        output.writeByte(3)
        output.writeUTF(className)
        output.writeUTF(methodName)
        output.writeUTF(returnType)
        output.writeByte(security.value)
    }

    actual fun markDirective(arguments: List<String>) {
        output.writeByte(4)
        output.writeInt(arguments.size)
        for (arg: String in arguments) {
            output.writeUTF(arg)
        }
    }

    /**
     * Mark annotation with name. Arguments of annotation must be defined in giveArgument()
     * @param name Name of annotation
     */
    actual fun markAnnotation(name: String) {
        output.writeByte(5)
        output.writeUTF(name)
    }

    /**
     * Create interface with name and security
     * @param name Name of creating interface
     * @param security Security access for this interface
     */
    actual fun createInterface(name: String, security: SecurityDegree) {
        output.writeByte(6)
        output.writeUTF(name)
        output.writeByte(security.value)
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
        output.writeByte(7)
    }

    /**
     * End block in context
     */
    actual fun endBlock() {
        output.writeByte(8)
    }

    /**
     * Implement interfaces to class
     * @param interfaces Names of interfaces which must be implement to class
     */
    actual fun implementClass(interfaces: List<String>) {
        output.writeByte(9)
        output.writeInt(interfaces.size)
        for (iface: String in interfaces) output.writeUTF(iface)
    }

    /**
     * Override class of other class
     * @param baseClass Name of overriding class
     */
    actual fun overrideClass(baseClass: String) {
        output.writeByte(10)
        output.writeUTF(baseClass)
    }

    /**
     * Add assembly in .NET, Java Archive or Class File in JVM and static library in LLVM
     */
    actual fun include(libPath: String) {
        output.writeByte(11)
        output.writeUTF(libPath)
    }

    /**
     * Link tokens library to this file
     */
    actual fun linkLibrary(libraryPath: String) {
        output.writeByte(12)
        output.writeUTF(libraryPath)
    }

    actual fun markLabel(name: String) {
        output.writeByte(13)
        output.writeUTF(name)
    }

    /**
     * Import package with this name
     * @param name Name of importing package
     */
    actual fun importPackage(name: String) {
        output.writeByte(14)
        output.writeUTF(name)
    }

    /**
     * Create package with name for writing next context to this package
     * @param name Name of creating package
     */
    actual fun markPackage(name: String) {
        output.writeByte(15)
        output.writeUTF(name)
    }

    /**
     * Create enum or enum class in context with name, security
     * @param name Name of creating enum
     * @param security Security access for this enum
     */
    actual fun createEnum(name: String, security: SecurityDegree) {
        output.writeByte(16)
        output.writeUTF(name)
        output.writeByte(security.value)
    }

    /**
     * Create constructor in class of context
     * @param name Name of creating constructor
     * @param security Security access for this constructor
     */
    actual fun createConstructor(name: String, security: SecurityDegree) {
        output.writeByte(17)
        output.writeByte(security.value)
    }

    fun loadValue(value: Any?) {
        if (value == null) {
            output.write(value)
        }
        else if (value is Char) {
            output.writeChar(value.toInt())
        }
        else if (value is Boolean) {
            output.writeBoolean(value)
        }
        else if (value is Byte) {
            output.writeByte(value)
        }
        else if (value is Short) {
            output.writeShort(value.toInt())
        }
        else if (value is Int) {
            output.writeInt(value)
        }
        else if (value is Float) {
            output.writeFloat(value)
        }
        else if (value is Long) {
            output.writeLong(value)
        }
        else if (value is String) {
            output.writeUTF(value)
        }
    }

    /**
     * Push variable with name or static class with name to context
     */
    actual fun callLiteral(name: String) {
        output.writeByte(21)
        output.writeUTF(name)
    }

    /**
     * Create typealias with name of type
     * @param name New type name
     */
    actual fun createTypeAlias(name: String) {
        output.writeByte(22)
        output.writeUTF(name)
    }

    /**
     * Create funcalias with [name]
     * @param name Name of new function
     */
    actual fun createFuncAlias(name: String) {
        output.writeByte(23)
        output.writeUTF(name)
    }

    /**
     * Mark break operator in this position
     */
    actual fun markBreak() {
        output.writeByte(24)
    }

    /**
     * Mark goto operator in this position for [name] label
     * @param name Name of label which going to
     */
    actual fun goto(name: String) {
        output.writeByte(26)
        output.writeUTF(name)
    }

    /**
     * Mark continue operator in this position
     */
    actual fun markContinue() {
        output.writeByte(25)
    }

    /**
     * Mark breakpoint
     */
    actual fun markBreakpoint() {
        output.writeByte(27)
    }

    /**
     * Open new statement in context and add to this while statement will not close
     */
    actual fun openStatement() {
        output.writeByte(28)
    }

    /**
     * Close current statement in context
     */
    actual fun closeStatement() {
        output.writeByte(29)
    }

    /**
     * Add previous value from context and next
     */
    actual fun add() {
        output.writeByte(30)
    }

    /**
     * Subtract previous value from context and next
     */
    actual fun subtract() {
        output.writeByte(31)
    }

    /**
     * Divide previous value from context and next
     */
    actual fun divide() {
        output.writeByte(32)
    }

    /**
     * Multiply previous value from context and next
     */
    actual fun multiply() {
        output.writeByte(33)
    }

    /**
     * Compares for equality previous value from context and next
     */
    actual fun equals() {
        output.writeByte(34)
    }

    /**
     * Compares for not equality previous value from context and next
     */
    actual fun notEquals() {
        output.writeByte(35)
    }

    /**
     * Create if operator and make new if construction. Next statement will push into this if
     */
    actual fun createIf() {
        output.writeByte(40)
    }

    /**
     * Create else if operator and continue current if construction. Next statement will push into this if
     */
    actual fun createElseIf() {
        output.writeByte(41)
    }

    /**
     * Create else operator and close current if construction
     */
    actual fun createElse() {
        output.writeByte(42)
    }

    /**
     * Create switch operator
     */
    actual fun createSwitch() {
        output.writeByte(43)
    }

    /**
     * Create case block in current switch operator for checking on next value in context
     */
    actual fun createCase() {
        output.writeByte(44)
    }

    /**
     * Create default block in current switch operator
     */
    actual fun createDefault() {
        output.writeByte(45)
    }

    /**
     * Create with operator
     */
    actual fun createWith() {
        output.writeByte(46)
    }

    /**
     * Create while loop or add statement if it is do-while loop
     */
    actual fun createWhile() {
        output.writeByte(47)
    }

    /**
     * Create do-while loop and do block
     */
    actual fun createDo() {
        output.writeByte(48)
    }

    /**
     * Create for loop with three parameters (parameters writing using statements)
     */
    actual fun createFor() {
        output.writeByte(49)
    }

    /**
     * Create foreach loop
     */
    actual fun createForeach() {
        output.writeByte(50)
    }

    /**
     * Add in operator
     */
    actual fun addIn() {
        output.writeByte(51)
    }

    /**
     * Get element in collection by index.
     * In a lot of languages it is operator \[index\]
     */
    actual fun getByIndex(index: Int) {
        output.writeByte(52)
        output.writeInt(index)
    }

    /**
     * Compares for greater previous value from context then next
     */
    actual fun greaterThen() {
        output.writeByte(36)
    }

    /**
     * Compares for less previous value from context then next
     */
    actual fun lessThen() {
        output.writeByte(37)
    }

    /**
     * Compares for greater or equals previous value from context then next
     */
    actual fun greaterOrEqualsThen() {
        output.writeByte(38)
    }

    /**
     * Compares for less or equals previous value from context then next
     */
    actual fun lessOrEqualsThen() {
        output.writeByte(39)
    }

    /**
     * Add operator return and return next value in context
     */
    actual fun addReturn() {
        output.writeByte(53)
    }

    /**
     * Create new object using operator new
     */
    actual fun createNew() {
        output.writeByte(54)
    }

    /**
     * Create operator of [type] with [returnType]
     * @param type Type of operator
     * @param returnType Type of returning value
     */
    actual fun createOperator(type: OperatorType, returnType: String) {
        output.writeByte(55)
        output.writeByte(type.value)
        output.writeUTF(returnType)
    }

    /**
     * Convert next statement to [typeName]
     * @param typeName Name of type for convert to
     */
    actual fun convertTo(typeName: String) {
        output.writeByte(56)
        output.writeUTF(typeName)
    }

    /**
     * Add operator is (compare type of last object from context with type by [typeName])
     * @param typeName Name of compareble type
     */
    actual fun addIs(typeName: String) {
        output.writeByte(57)
        output.writeUTF(typeName)
    }

    actual var header: HeaderType = HeaderType.Script
    /**
     * Add operator typeof (get type by [typeName])
     * @param typeName Name of getting type
     */
    actual fun checkTypeof(typeName: String) {
        output.writeByte(58)
        output.writeUTF(typeName)
    }

    actual fun createStaticField(name: String, typeName: String, security: SecurityDegree) {
        output.writeByte(2)
        output.writeUTF(name)
        output.writeUTF(typeName)
        output.writeByte(security.value)
        output.writeByte(1) //field is static type
    }

    actual fun createFinalField(name: String, typeName: String, security: SecurityDegree) {
        output.writeByte(2)
        output.writeUTF(name)
        output.writeUTF(typeName)
        output.writeByte(security.value)
        output.writeByte(2) //field is final type
    }

    /**
     * Set incrementing line to Tokens code for right printing of errors
     */
    actual fun incLine() {
        output.writeByte(59)
    }

    actual var platform: PlatformType = PlatformType.Common

    /**
     * Add operator of assign
     */
    actual fun assignValue() {
        output.writeByte(19)
    }

    /**
     * Return inversion value or just operator not
     */
    actual fun inversion() {
        output.writeByte(60)
    }

    /**
     * Operator and
     */
    actual fun and() {
        output.writeByte(61)
    }

    /**
     * Operator or
     */
    actual fun or() {
        output.writeByte(62)
    }

    /**
     * Operator xor
     */
    actual fun xor() {
        output.writeByte(63)
    }

    /**
     * Operator of increment
     */
    actual fun increment() {
        output.writeByte(64)
    }

    /**
     * Operator of decrement
     */
    actual fun decrement() {
        output.writeByte(65)
    }

    /**
     * Throw exception with next object in context
     */
    actual fun throwException() {
        output.writeByte(66)
    }

    /**
     * Operator modulo '%'
     */
    actual fun modulo() {
        output.writeByte(67)
    }

    /**
     * Raises the previous number to the power which expresses the following
     */
    actual fun power() {
        output.writeByte(68)
    }

    /**
     * Create annotation (attribute in .NET) with [name] and [security]
     * @param name Name of creating annotation
     * @param security Security access for this annotation
     */
    actual fun createAnnotation(name: String, security: SecurityDegree) {
        output.writeByte(18)
        output.writeUTF(name)
        output.writeByte(security.value)
    }

    /**
     * Create collection with [name] and [security]
     * @param name Name of creating collection
     * @param security Security access for this collection
     */
    actual fun createCollection(name: String, security: SecurityDegree) {
        output.writeByte(20)
        output.writeUTF(name)
        output.writeByte(security.value)
    }
}
