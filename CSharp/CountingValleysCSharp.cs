// Solution Hacker Rank Counting valleys: Access https://www.hackerrank.com/challenges/counting-valleys/problem

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

class Solution {

    // Complete the countingValleys function below.
    static int countingValleys(int n, string s) {
        int vales = 0;
        int nivel = 0;
        int posicao = 0;

        for(int a = 0; a < n; a++){

            if(s[a] == 'D'){
                nivel --;
            }
            if(s[a] == 'U'){
                nivel ++;
            }
            if(s[a] == 'D' && nivel == -1){
                posicao = a + 1;
            }
            if(s[a] == 'U' && posicao != 0 && nivel == 0){
                vales++;
            }
        }

        return vales;
    }

    static void Main(string[] args) {
        TextWriter textWriter = new StreamWriter(@System.Environment.GetEnvironmentVariable("OUTPUT_PATH"), true);

        int n = Convert.ToInt32(Console.ReadLine());

        string s = Console.ReadLine();

        int result = countingValleys(n, s);

        textWriter.WriteLine(result);

        textWriter.Flush();
        textWriter.Close();
    }
}
