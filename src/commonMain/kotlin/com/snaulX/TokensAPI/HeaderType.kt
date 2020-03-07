package com.snaulX.TokensAPI

enum class HeaderType (val value: Byte) {
    Script(0),
    /**
     * File is body of class.
     * Can will using directives: implements, extends, name
     * Can will writing in file constructors
     */
    Class(1),
    Library(2),
    /**
     * Compile to executable console program
     */
    Console(3),
    /**
     * Compile to executable program without console
     */
    GUI(4),
    TokensLibrary(5),
    /**
     * Script for building project.
     * The compilation of the project is carried out due to the interpretation of build script.
     */
    BuildScript(6)
}