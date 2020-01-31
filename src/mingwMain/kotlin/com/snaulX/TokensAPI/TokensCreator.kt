package com.snaulX.TokensAPI

import kotlinx.cinterop.*
import platform.posix.*

actual class TokensCreator actual constructor() {

    lateinit var file: CPointer<FILE>

    actual var line: Int
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
        set(value) {}
    actual var position: Int
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
        set(value) {}

    actual fun createClass(
        name: String,
        security: SecurityDegree,
        classType: ClassType,
        data: Boolean
    ) {
    }

    actual fun createMethod(
        name: String,
        returnType: String,
        security: SecurityDegree,
        abstract: Boolean
    ) {
    }

    actual fun createField(
        name: String,
        typeName: String,
        defaultValue: Any?,
        security: SecurityDegree
    ) {
    }

    actual fun createNullableField(
        name: String,
        typeName: String,
        defaultValue: Any,
        security: SecurityDegree
    ) {
    }

    actual fun createExtensionMethod(
        className: String,
        methodName: String,
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
     * Remove class from context and end it
     */
    actual fun endClass() {
    }

    /**
     * Remove method from context and end it
     */
    actual fun endMethod() {
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
     * @param isClass Checking: is it enum or enum class
     */
    actual fun createEnum(name: String, security: SecurityDegree, isClass: Boolean) {
    }

    /**
     * Create constructor in class of context
     * @param name Name of creating constructor
     * @param security Security access for this constructor
     */
    actual fun createConstructor(name: String, security: SecurityDegree) {
    }

    /**
     * Create parameter with name, type and default value
     * @param name Name of creating parameter
     * @param typeName Name of type of parameter
     * @param defaultValue Default value of parameter
     */
    actual fun createParameter(name: String, typeName: String, defaultValue: Any?) {
    }

    /**
     * Create parameter with nullable type
     * (IT`S EXPERIMENTAL)
     */
    actual fun createNullableParameter(name: String, typeName: String, defaultValue: Any) {
    }

    /**
     * Give argument to calling function or annotation
     * @param value Value for give to parameter
     * @param nameOfParameter Name of parameter for give. If this argument is empty - parameter for giving will be next in context
     */
    actual fun giveArgument(value: Any?, nameOfParameter: String) {
    }

    /**
     * Call method with name. Master of method is last object in context
     */
    actual fun callMethod(name: String) {
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
}