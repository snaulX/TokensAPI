package com.snaulX.TokensAPI

expect class TokensCreator() {
    var line: Int
    var position: Int
    var header: HeaderType
    /**
     * Mark target platform of the file
     * @param platform Target platform
     */
    fun markPlatform(platform: PlatformType)
    fun createClass(name: String, security: SecurityDegree = SecurityDegree.PUBLIC, classType: ClassType = ClassType.DEFAULT)
    fun createMethod(name: String, returnType: String, security: SecurityDegree = SecurityDegree.PUBLIC, funcType: FuncType = FuncType.DEFAULT)
    fun createField(name: String, typeName: String, security: SecurityDegree = SecurityDegree.PUBLIC)
    fun createStaticField(name: String, typeName: String, security: SecurityDegree = SecurityDegree.PUBLIC)
    fun createFinalField(name: String, typeName: String, security: SecurityDegree = SecurityDegree.PUBLIC)
    fun createExtensionMethod(className: String, methodName: String, returnType: String, security: SecurityDegree = SecurityDegree.PUBLIC)
    fun markDirective(arguments: List<String>)
    /**
     * Mark annotation with [name]. Arguments of annotation must be defined in [giveArgument]
     * @param name Name of annotation
     */
    fun markAnnotation(name: String)
    /**
     * Create interface with [name] and [security]
     * @param name Name of creating interface
     * @param security Security access for this interface
     */
    fun createInterface(name: String, security: SecurityDegree = SecurityDegree.PUBLIC)

    /**
     * Start default block
     * If in context save class - this function create body of this class
     * If in context save enum - body of enum
     * If in context save interface - body of interface
     * If in context save method - body of method
     * And other more...
     */
    fun startBlock()
    /**
     * End block in context
     */
    fun endBlock()
    /**
     * Implement interfaces to class
     * @param interfaces Names of interfaces which must be implement to class
     */
    fun implementClass(interfaces: List<String>)
    /**
     * Override class of other class
     * @param baseClass Name of overriding class
     */
    fun overrideClass(baseClass: String)
    /**
     * Add assembly in .NET, Java Archive or Class File in JVM and static library in LLVM
     * @param libPath Path to adding library
     */
    fun include(libPath: String)
    /**
     * Link tokens library to this file
     * @param libraryPath Path to linking tokens library
     */
    fun linkLibrary(libraryPath: String)

    /**
     * Mark label with [name] in this position
     * @param name Name of marking label
     */
    fun markLabel(name: String)
    /**
     * Import package with [name]
     * @param name Name of importing package
     */
    fun importPackage(name: String)
    /**
     * Create package with [name] for writing next context to this package
     * @param name Name of creating package
     */
    fun markPackage(name: String)
    /**
     * Create enum or enum class in context with name, security
     * @param name Name of creating enum
     * @param security Security access for this enum
     */
    fun createEnum(name: String, security: SecurityDegree = SecurityDegree.PUBLIC)
    /**
     * Create constructor in class of context
     * @param name Name of creating constructor
     * @param security Security access for this constructor
     */
    fun createConstructor(name: String, security: SecurityDegree = SecurityDegree.PUBLIC)
    /**
     * Create parameter with name, type and default value
     * @param name Name of creating parameter
     * @param typeName Name of type of parameter
     */
    fun createParameter(name: String, typeName: String)
    /**
     * Give argument to calling function or annotation
     * @param value Value for give to parameter
     * @param nameOfParameter Name of parameter for give. If this argument is empty - parameter for giving will be next in context
     */
    fun giveArgument(value: Any?, nameOfParameter: String = "")
    /**
     * Call method with [name]. Master of method is last object in context
     */
    fun callMethod(name: String)
    /**
     * Push variable with [name] or static class with [name] to context
     */
    fun callLiteral(name: String)

    /**
     * Set output file for writing tokens to this file and write to this file [header]
     * @param fileName Name of file which be output
     */
    fun setOutput(fileName: String)

    /**
     * Create typealias with [name] of type by [oldTypeName]
     * @param name New type name
     * @param oldTypeName Name of alias type
     */
    fun createTypeAlias(name: String, oldTypeName: String)

    /**
     * Create funcalias with [name] of function with [oldFuncName]
     * @param name Name of new function
     * @param oldFuncName Name of alias function
     */
    fun createFuncAlias(name: String, oldFuncName: String)
    /**
     * Mark break operator in this position
     */
    fun markBreak()
    /**
     * Mark goto operator in this position for [name] label
     * @param name Name of label which going to
     */
    fun goto(name: String)

    /**
     * Mark continue operator in this position
     */
    fun markContinue()

    /**
     * Mark breakpoint
     */
    fun markBreakpoint()

    /**
     * Open new statement in context and add to this while statement will not close
     */
    fun openStatement()

    /**
     * Close current statement in context
     */
    fun closeStatement()

    /**
     * Add previous value from context and next
     */
    fun add()

    /**
     * Subtract previous value from context and next
     */
    fun subtract()

    /**
     * Divide previous value from context and next
     */
    fun divide()

    /**
     * Multiply previous value from context and next
     */
    fun multiply()

    /**
     * Compares for equality previous value from context and next
     */
    fun equals()

    /**
     * Compares for not equality previous value from context and next
     */
    fun notEquals()

    /**
     * Compares for greater previous value from context then next
     */
    fun greaterThen()

    /**
     * Compares for less previous value from context then next
     */
    fun lessThen()

    /**
     * Compares for greater or equals previous value from context then next
     */
    fun greaterOrEqualsThen()

    /**
     * Compares for less or equals previous value from context then next
     */
    fun lessOrEqualsThen()

    /**
     * Create if operator and make new if construction. Next statement will push into this if
     */
    fun createIf()

    /**
     * Create else if operator and continue current if construction. Next statement will push into this if
     */
    fun createElseIf()

    /**
     * Create else operator and close current if construction
     */
    fun createElse()

    /**
     * Create switch operator and push to this variable with [name]
     * @param name Name of switching variable
     */
    fun createSwitch(name: String)

    /**
     * Create case block in current switch operator for checking on [value]
     * @param value Checking value
     */
    fun createCase(value: Any?)

    /**
     * Create default block in current switch operator
     */
    fun createDefault()

    /**
     * Create with operator for variable with [name]
     * @param name Name of variable for use in with operator
     */
    fun createWith(name: String)

    /**
     * Create while loop or add statement if it is do-while loop
     */
    fun createWhile()

    /**
     * Create do-while loop and do block
     */
    fun createDo()

    /**
     * Create for loop with three parameters (parameters writing using statements)
     */
    fun createFor()

    /**
     * Create foreach loop
     */
    fun createForeach()

    /**
     * Add in operator
     */
    fun addIn()

    /**
     * Get element in collection by index.
     * In a lot of languages it is operator \[index\]
     */
    fun getByIndex(index: Int)

    /**
     * Add operator return and return [value]
     * @param value Returning value
     */
    fun addReturn(value: Any?)

    /**
     * Create new object using operator new and constructor [name].
     * If we now type of this constructor - write name of this type in the [typeName]
     * @param name Name of using constructor
     * @param typeName Name of type with this constructor. If we don`t know type - write empty string
     */
    fun createNew(name: String, typeName: String = "")

    /**
     * Create operator of [type] with [returnType]
     * @param type Type of operator
     * @param returnType Type of returning value
     */
    fun createOperator(type: OperatorType, returnType: String)

    /**
     * Convert next statement to [typeName]
     * @param typeName Name of type for convert to
     */
    fun convertTo(typeName: String)

    /**
     * Add operator is (compare type of last object from context with type by [typeName])
     * @param typeName Name of compareble type
     */
    fun addIs(typeName: String)

    /**
     * Add operator typeof (get type by [typeName])
     * @param typeName Name of getting type
     */
    fun checkTypeof(typeName: String)
}