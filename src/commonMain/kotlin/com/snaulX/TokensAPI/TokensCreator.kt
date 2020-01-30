package com.snaulX.TokensAPI

expect class TokensCreator() {
    fun createClass(name: String, security: SecurityDegree = SecurityDegree.PUBLIC, sealed: Boolean = false)
    fun createMethod(name: String, security: SecurityDegree = SecurityDegree.PUBLIC, abstract: Boolean = false)
    fun createField(name: String, security: SecurityDegree = SecurityDegree.PUBLIC)
    fun createExtensionMethod(className: String, methodName: String, security: SecurityDegree = SecurityDegree.PUBLIC, abstract: Boolean = false)
    fun markDirective(arguments: List<String>)
    fun markAnnotation(context: String)
}