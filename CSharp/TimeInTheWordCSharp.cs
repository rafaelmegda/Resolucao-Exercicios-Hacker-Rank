using System.CodeDom.Compiler;
using System.Collections.Generic;
using System.Collections;
using System.ComponentModel;
using System.Diagnostics.CodeAnalysis;
using System.Globalization;
using System.IO;
using System.Linq;
using System.Reflection;
using System.Runtime.Serialization;
using System.Text.RegularExpressions;
using System.Text;
using System;

class Solution
{

    // Complete the timeInWords function below.
    static string timeInWords(int h, int m)
    {
        h = 13;
        m = 2;
        string horasDescrita = "";
        string[] time =
            {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",             "ten", "eleven", "twelve","thirteen","fourteen","fifteen","sixteen",
        "seventeen","eighteen","nineteen","twenty", "twenty one", "twenty two",                 "twenty three", "twenty four", "twenty five", "twenty six", "twenty seven",                 "twenty eight","twenty nine" };

        if (m == 0)
        {
            horasDescrita = time[h] + " o' clock";
        }
        if (m == 1)
        {
            horasDescrita = time[m] + " minute past " + time[h];
        }
        if (m == 15)
        {
            horasDescrita = "quarter past " + time[h];
        }
        else if (m > 1 && m <= 29)
        {
            horasDescrita = time[m] + " minutes past " + time[h];
        }
        if (m == 30)
        {
            horasDescrita = "half past " + time[h];
        }
        if (m == 45)
        {
            horasDescrita = "quarter to " + time[(h % 12) + 1];
        }        
        else if (m > 30 && m <= 59)
        {
            if(m == 59)
            {
                horasDescrita = time[m] + " minute to" + time[h + 1];
            }
            else
            {
                m = 60 - m;
                horasDescrita = time[m] + " minutes to" + time[h+ 1];
            }               
        }
        return horasDescrita;
    }
    



    static void Main(string[] args)
    {
        //TextWriter textWriter = new StreamWriter(@System.Environment.GetEnvironmentVariable("OUTPUT_PATH"), true);

        int h = Convert.ToInt32(Console.ReadLine());

        int m = Convert.ToInt32(Console.ReadLine());

        string result = timeInWords(h, m);

        //textWriter.WriteLine(result);

        //textWriter.Flush();
        //textWriter.Close();
    }
}
