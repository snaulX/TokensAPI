using System;
using System.IO;

namespace TokensAPI
{
    public class TokensReader
    {
        public BinaryReader reader;

        public TokensReader(string path)
        {
            SetPath(path);
        }

        public TokensReader(BinaryReader br)
        {
            reader = br;
        }

        public void SetPath(string path) => reader = new BinaryReader(File.Open(path, FileMode.Open));

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

        public void EndWork()
        {
            reader.Close();
            reader.Dispose();
        }
    }
}
