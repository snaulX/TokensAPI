package com.snaulX.TokensAPI

actual class TokensCreator actual constructor() {
    actual fun createClass(name: String, security: SecurityDegree, sealed: Boolean) {
    }

    actual fun createMethod(
        name: String,
        security: SecurityDegree,
        abstract: Boolean
    ) {
    }

    actual fun createField(name: String, security: SecurityDegree) {
    }

    actual fun createExtensionMethod(
        className: String,
        methodName: String,
        security: SecurityDegree,
        abstract: Boolean
    ) {
    }

    actual fun markDirective(arguments: List<String>) {
    }

    actual fun markAnnotation(context: String) {
    }
}