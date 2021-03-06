package com.snaulX.TokensAPI

enum class PlatformType(val value: Byte) {
    /**
     * Code for all platforms
     */
    Common(0),
    /**
     * Code for TokensBuilder Native
     */
    Native(1),
    /**
     * Code for JTokensBuilder
     */
    Jvm(2),
    /**
     * Code for TokensBuilder.NET
     */
    DotNet(3),
    /**
     * Code for user platform. Name of platform writing in next string in file
     */
    Other(4)
}