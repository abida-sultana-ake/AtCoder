import java.io.IOException;
import static java.lang.Math.*;

public class Main
{
    static class Scan
    {
        final private int BUF_SIZE = 1 << 16;
        private int cur_size = 0;
        private int pointer = 0;
        private java.io.DataInputStream in;
        private byte buffer[] = new byte[BUF_SIZE];

        Scan(java.io.InputStream input)
        {
            in = new java.io.DataInputStream(input);
        }

        // fills the buffer with characters
        private void fill() throws java.io.IOException
        {
            cur_size = in.read(buffer, 0, BUF_SIZE);
            if (cur_size == -1) buffer[0] = 0;
            pointer = 0;
        }

        private byte read() throws java.io.IOException
        {
            if (pointer == cur_size) fill();
            return buffer[pointer++];
        }

        int readInt() throws java.io.IOException
        {
            int res = 0;
            byte c;
            while ((c = read()) <= ' ');
            boolean negate = c == '-';
            if (negate) c = read();
            while (c >= '0' && c <= '9')
            {
                res = res * 10 + c - '0';
                c = read();
            }
            return negate ? -res : res;
        }

        long readLong() throws java.io.IOException
        {
            long res = 0;
            byte c;
            while ((c = read()) <= ' ') ;
            boolean negate = c == '-';
            if (negate) c = read();
            while (c >= '0' && c <= '9') {
                res = res * 10 + c - '0';
                c = read();
            }
            return negate ? -res : res;
        }

        double readDouble() throws java.io.IOException
        {
            byte c;
            while ((c = read()) <= ' ');
            boolean negate = c == '-';
            if (negate)
                c = read();
            int power = 0;
            long res = 0;
            boolean dot_flag = false;
            for (;(c >= '0' && c <= '9') || c == '.'; c = read())
            {
                if (dot_flag)
                    power++;
                if (c == '.')
                    dot_flag = true;
                else
                    res = res * 10 + c - '0';
            }
            double ret = res / Math.pow(10, power);
            return negate ? -ret : ret;
        }

        // skip defines whether ' ', '\n', '\r' must be skipped in readChar method
        char readChar(boolean skip) throws java.io.IOException
        {
            if (skip)
            {
                byte c;
                while ((c = read()) == ' ' || c == '\n' || c == '\r');
                return (char) c;
            }
            return (char) read();
        }

        // skip defines whether current string must be skipped in readString and readText methods

        /* If exact length is known, in terms of efficiency
         it is better to specify it while using readText, readString and readWord methods */

        String readWord() throws java.io.IOException
        {
            byte c;
            while ((c = read()) == '\n' || c == ' ' || c == '\r');
            StringBuilder s = new StringBuilder();
            s.append((char)c);
            for (;(c = read()) != '\n' && c != ' ' && c != '\r' && c != 0; s.append((char)c));
            return s.toString();
        }

        String readWord(int LEN) throws java.io.IOException
        {
            byte[] s = new byte[LEN];
            byte c;
            while ((c = read()) == '\n' || c == ' ' || c == '\r');
            s[0] = c;
            for (int i = 1; (c = read()) != ' ' && c != '\n' && c != '\r' && c != 0; s[i++] = c);
            return new String(s);
        }

        String readString(boolean skip, int LEN) throws java.io.IOException
        {
            byte[] s = new byte[LEN];
            byte c;
            if (skip)
                while ((c = read()) != '\n');
            for (int i = 0; (c = read()) != '\n' && c != '\r' && c != 0; s[i++] = c);
            read();
            return new String(s);
        }

        String readString(boolean skip) throws java.io.IOException
        {
            StringBuilder s = new StringBuilder("");
            byte c;
            if (skip)
                while ((c = read()) != '\n');
            for (;(c = read()) != '\n' && c != '\r' && c != 0; s.append((char)c));
            read();
            return s.toString();
        }

        String readText(boolean skip, int LEN) throws java.io.IOException
        {
            byte[] s = new byte[LEN];
            byte c;
            if (skip)
                while ((c = read()) != '\n');
            for (int i = 0; (c = read()) != 0; s[i++] = c);
            return new String(s);
        }

        String readText(boolean skip) throws java.io.IOException
        {
            StringBuilder s = new StringBuilder("");
            byte c;
            if (skip)
                while ((c = read()) != '\n');
            for (;(c = read()) != 0; s.append((char)c));
            return s.toString();
        }
    }

    static class Segment
    {
        int st, fin;

        Segment(int s, int f)
        {
            st = s;
            fin = f;
        }
    }

    public static void main(String args[]) throws IOException
    {
        Scan in = new Scan(System.in);
        int a = in.readInt(), b = in.readInt(), c = in.readInt(), d = in.readInt();
        int res = 0;
        for (int i = Math.max(a, c) + 1; i <= Math.min(b, d); i++)
        {
            res++;
        }
        System.out.println(res);
    }
}