using System;
using System.Collections.Generic;
using System.Text;

namespace TokensAPI
{
    public enum TokenType : byte
    {
        NEWLN = 0,
        CLASS = 1,
        FUNCTION = 2,
        VAR = 3,
        BLOCK = 4,
        STATEMENT = 5,
        SEQUENCE = 6,
        LITERAL = 7,
        SEPARATOR = 8,
        EXPRESSION_END = 9,
        LOOP = 10,
        LABEL = 11,
        GOTO = 12,
        LOOP_OPERATOR = 13,
        OPERATOR = 14,
        VALUE = 15,
        NULLABLE = 16,
        SWITCH = 17,
        CASE = 18,
        DIRECTIVE = 19,
        NEW = 20,
        ANNOTATION = 21,
        THROW = 22,
        TRY = 23,
        CATCH = 24,
        FINALLY = 25,
        IF = 26,
        ELSE = 27,
        RETURN = 28,
        ACTUAL = 29,
        TYPEOF = 30,
        NAMESPACE = 31,
        IMPORT_LIBRARY = 32,
        USING_NAMESPACE = 33,
        INCLUDE = 34,
        BREAKPOINT = 35,
        CONVERT = 36,
        IMPLEMENTS = 37,
        EXTENDS = 38,
        INSTANCEOF = 39,
        WITH = 40,
        YIELD = 41
    }
}
