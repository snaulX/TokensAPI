using System;
using System.IO;

namespace TokensAPI
{
    public class TokensBuilder
    {
        public BinaryReader reader;

        public TokensBuilder()
        {
            //pass
        }

        public TokensBuilder(BinaryReader br)
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
