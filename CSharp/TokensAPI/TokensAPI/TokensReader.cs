using System;
using System.IO;
using System.Collections.Generic;

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

        public TokensReader()
        {
            bool_values = new List<bool>();
            string_values = new List<string>();
            tokens = new List<TokenType>();
            byte_values = new List<byte>();
            values = new List<object>();
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
            while (reader.Read() != -1)
            {
                TokenType token = (TokenType) reader.ReadByte();
                tokens.Add(token);
                switch (token)
                {
                    case TokenType.CLASS:
                        string_values.Add(reader.ReadString()); //name of class
                        byte_values.Add(reader.ReadByte()); //class type
                        byte_values.Add(reader.ReadByte()); //security degree
                        break;
                    case TokenType.FUNCTION:
                        string_values.Add(reader.ReadString()); //name of function
                        string_values.Add(reader.ReadString()); //name of return tye of function
                        byte_values.Add(reader.ReadByte()); //type of function
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
