using System;
using System.Runtime.Serialization;

namespace TokensAPI
{
    [Serializable]
    internal class InvalidHeaderException : Exception
    {
        public InvalidHeaderException() : this("Invalid header")
        {
        }

        public InvalidHeaderException(string message) : base(message)
        {
        }

        public InvalidHeaderException(byte header) : this($"Invalid header {header}")
        {
        }

        public InvalidHeaderException(string message, Exception innerException) : base(message, innerException)
        {
        }

        protected InvalidHeaderException(SerializationInfo info, StreamingContext context) : base(info, context)
        {
        }
    }
}