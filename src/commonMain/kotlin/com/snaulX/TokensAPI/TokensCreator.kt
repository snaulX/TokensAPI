package com.snaulX.TokensAPI

expect class TokensCreator() {
    var line: Int
    var position: Int
    fun createClass(name: String, security: SecurityDegree = SecurityDegree.PUBLIC, classType: ClassType = ClassType.DEFAULT, data: Boolean = false)
    fun createMethod(name: String, returnType: String, security: SecurityDegree = SecurityDegree.PUBLIC, abstract: Boolean = false)
    fun createField(name: String, typeName: String, defaultValue: Any? = null, security: SecurityDegree = SecurityDegree.PUBLIC)
    fun createNullableField(name: String, typeName: String, defaultValue: Any, security: SecurityDegree = SecurityDegree.PUBLIC)
    fun createExtensionMethod(className: String, methodName: String, security: SecurityDegree = SecurityDegree.PUBLIC)
    fun markDirective(arguments: List<String>)
    /**
     * Mark annotation with name. Arguments of annotation must be defined in giveArgument()
     * @param name Name of annotation
     */
    fun markAnnotation(name: String)
    /**
     * Create interface with name and security
     * @param name Name of creating interface
     * @param security Security access for this interface
     */
    fun createInterface(name: String, security: SecurityDegree = SecurityDegree.PUBLIC)
    /**
     * Remove class from context and end it
     */
    fun endClass()
    /**
     * Remove method from context and end it
     */
    fun endMethod()
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
     */
    fun include(libPath: String)
    /**
     * Link tokens library to this file
     */
    fun linkLibrary(libraryPath: String)
    fun markLabel(name: String)
    /**
     * Import package with this name
     * @param name Name of importing package
     */
    fun importPackage(name: String)
    /**
     * Create package with name for writing next context to this package
     * @param name Name of creating package
     */
    fun markPackage(name: String)
    /**
     * Create enum or enum class in context with name, security
     * @param name Name of creating enum
     * @param security Security access for this enum
     * @param isClass Checking: is it enum or enum class
     */
    fun createEnum(name: String, security: SecurityDegree = SecurityDegree.PUBLIC, isClass: Boolean = false)
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
     * @param defaultValue Default value of parameter
     */
    fun createParameter(name: String, typeName: String, defaultValue: Any? = null)
    /**
     * Create parameter with nullable type
     * (IT`S EXPERIMENTAL)
     */
    fun createNullableParameter(name: String, typeName: String, defaultValue: Any)
    /**
     * Give argument to calling function or annotation
     * @param value Value for give to parameter
     * @param nameOfParameter Name of parameter for give. If this argument is empty - parameter for giving will be next in context
     */
    fun giveArgument(value: Any?, nameOfParameter: String = "")
    /**
     * Call method with name. Master of method is last object in context
     */
    fun callMethod(name: String)
    /**
     * Push variable with name or static class with name to context
     */
    fun callLiteral(name: String)

    /**
     * Set output file for writing tokens to this file
     * @param fileName Name of file which be output
     */
    fun setOutput(fileName: String)
}