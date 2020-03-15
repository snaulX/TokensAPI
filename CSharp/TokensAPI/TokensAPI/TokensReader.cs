using System;
using System.IO;

namespace TokensAPI
{
    public class TokensReader
    {
        public BinaryReader reader;

        public TokensReader()
        {
            //pass
        }

        public TokensReader(BinaryReader br)
        {
            reader = br;
        }

        public void SetPath(string path) => reader = new BinaryReader(File.Open(path, FileMode.Open));

        public void EndWork()
        {
            reader.Close();
            reader.Dispose();
        }
    }
}
