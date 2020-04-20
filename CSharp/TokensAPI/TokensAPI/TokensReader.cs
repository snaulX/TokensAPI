using System;
using System.Collections.Generic;
using System.IO;

namespace TokensAPI
{
    public class TokensReader
    {
        public BinaryReader reader;
        public List<bool> bool_values;
        public List<string> string_values;
        public List<TokenType> tokens;
        public List<byte> byte_values;
        public List<object> values;
        public List<SecurityDegree> securities;
        public List<FuncType> function_types;
        public List<VarType> var_types;
        public List<LoopType> loops;
        public List<OperatorType> operators;
        public List<ClassType> class_types;

        public TokensReader()
        {
            bool_values = new List<bool>();
            string_values = new List<string>();
            tokens = new List<TokenType>();
            byte_values = new List<byte>();
            values = new List<object>();
            securities = new List<SecurityDegree>();
            function_types = new List<FuncType>();
            loops = new List<LoopType>();
            operators = new List<OperatorType>();
            class_types = new List<ClassType>();
        }

        public TokensReader(string path) : this()
        {
            SetPath(path);
        }

        public TokensReader(BinaryReader br) : this()
        {
            reader = br;
        }

        public void SetPath(string path) => reader = new BinaryReader(File.Open(path, FileMode.Open));

        /// <summary>
        /// Start of read file and read header and target
        /// ! This method must be call after SetPath or constructor with path
        /// </summary>
        /// <param name="header">Code of header</param>
        /// <param name="target">Name of target platform</param>
        public void GetHeaderAndTarget(out byte header, out string target)
        {
            header = reader.ReadByte();
            byte _target = reader.ReadByte();
            if (_target == 0) target = "COMMON";
            else if (_target == 1) target = "NATIVE";
            else if (_target == 2) target = "JVM";
            else if (_target == 3) target = "DOTNET";
            else if (_target == 4) target = reader.ReadString();
            else throw new InvalidHeaderException(_target);
        }

        public void ReadTokens()
        {
            while (true)
            {
                try
                {
                    TokenType token = (TokenType)reader.ReadByte();
                    tokens.Add(token);
                    if (token == TokenType.CLASS)
                    {
                        string_values.Add(reader.ReadString()); //name of class
                        class_types.Add((ClassType)reader.ReadByte()); //class type
                        securities.Add((SecurityDegree)reader.ReadByte()); //security degree
                    }
                    else if (token == TokenType.FUNCTION)
                    {
                        string_values.Add(reader.ReadString()); //name of function
                        string_values.Add(reader.ReadString()); //name of return tye of function
                        function_types.Add((FuncType)reader.ReadByte()); //type of function
                        securities.Add((SecurityDegree)reader.ReadByte()); //security degree
                    }
                    else if (token == TokenType.VAR)
                    {
                        var_types.Add((VarType)reader.ReadByte());
                        securities.Add((SecurityDegree)reader.ReadByte());
                    }
                    else if (token == TokenType.BLOCK || token == TokenType.STATEMENT || token == TokenType.SEQUENCE
                        || token == TokenType.SEPARATOR || token == TokenType.RETURN || token == TokenType.LAMBDA || token == TokenType.ASYNC
                        || token == TokenType.PARAMETER_TYPE || token == TokenType.GENERIC || token == TokenType.ACTUAL)
                    {
                         bool_values.Add(reader.ReadBoolean());
                    }
                    else if (token == TokenType.LITERAL || token == TokenType.TYPEOF || token == TokenType.NAMESPACE
                        || token == TokenType.IMPORT_LIBRARY || token == TokenType.INCLUDE || token == TokenType.USING_NAMESPACE
                        || token == TokenType.INSTANCEOF || token == TokenType.GOTO || token == TokenType.LABEL)
                    {
                         string_values.Add(reader.ReadString());
                    }
                    else if (token == TokenType.LOOP)
                    {
                        loops.Add((LoopType)reader.ReadByte());
                    }
                    else if (token == TokenType.LOOP_OPERATOR)
                    {
                        bool_values.Add(reader.ReadBoolean());
                        string_values.Add(reader.ReadString());
                    }
                    else if (token == TokenType.OPERATOR)
                    {
                        operators.Add((OperatorType)reader.ReadByte());
                    }
                    else if (token == TokenType.VALUE)
                    {
                        byte valtype = reader.ReadByte();
                        byte_values.Add(valtype);
                        if (valtype == 0) values.Add(null);
                        else if (valtype == 1) values.Add(reader.ReadInt32());
                        else if (valtype == 2) values.Add(reader.ReadString());
                        else if (valtype == 3) values.Add(reader.ReadByte());
                        else if (valtype == 4) values.Add(reader.ReadBoolean());
                        else if (valtype == 5) values.Add(reader.ReadChar());
                        else if (valtype == 6) values.Add(reader.ReadSingle());
                        else if (valtype == 7) values.Add(reader.ReadInt16());
                        else if (valtype == 8) values.Add(reader.ReadInt64());
                        else if (valtype == 9) values.Add(reader.ReadDouble());
                    }
                }
                catch
                {
                    break;
                }
            }
        }

        public void EndWork()
        {
            reader.Close();
            reader.Dispose();
        }
    }
}
