package com.example.zdm.calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InfixInToDuffix
{
    // 使用集合定义好优先级
    private static final Map<Character, Integer>basic = new HashMap<>();
    static
    {
        basic.put('-', 1);
        basic.put('+', 1);
        basic.put('×', 2);
        basic.put('÷', 2);
        basic.put('%', 2);
        basic.put('^', 3);
        basic.put('!', 4);
        basic.put('(', 0);//在运算中（）的优先级最高，但是此处因程序中需要 故设置为0
    }

    // 中缀转后缀
    public String toSuffix(StringBuilder infix)
    {
        List<String> queue = new ArrayList<String>();       // 定义队列，用于存储数字以及最后的后缀表达式
        List<Character> stack = new ArrayList<Character>(); // 定义栈，用于存储转换过程的运算符，最后会弹空

        if(infix.charAt(0) == '-' || infix.charAt(0) == '.') // 如果算式开头是个负数或者是小数点，则在前面插入0
        {
            infix.insert(0, '0');
        }

        char[] charArr = infix.substring(0, infix.length()).trim().toCharArray();   // 字符数组，用于拆分数字或符号，trim()用于清空字符串头尾空白符
        String standard = "!^×÷%+-()";   // 判定标准，将表达式中会出现的运算符写出来
        char ch = '&';                  // 在循环中用于保存字符数组的当前循环变量的，这里仅仅是初始化一个值
        int len = 0;                    // 用于记录字符长度 【例如100*2,则记录的len为3 到时候截取字符串的前三位就是数字】
        for(int i = 0; i < charArr.length; i++) // 迭代转换
        {
            ch = charArr[i]; //保存当前迭代变量
            if(Character.isDigit(ch)) // 当前读到的是数字
            {
                len++;
            }
            else if(ch == '.') // 当前读到的是小数点
            {
                len++;
            }
            else if(standard.indexOf(ch) != -1) // 当前读到的是符号并且在判定标准中
            {
                if(len > 0) // 存在长度，则说明符号之前的部分为一个数字
                {
                    queue.add(String.valueOf(Arrays.copyOfRange(charArr, i - len, i))); // 从数组中截取数字转化为整个字符串存储进队列
                    len = 0; // 长度清零
                }
                if(ch == '(') // 读到左括号
                {
                    stack.add(ch); // 左括号直接进栈
                    continue;      // 跳过本次循环找下一位
                }
                if(!stack.isEmpty()) // 栈不空，则判断当前运算符与栈顶运算符优先级
                {
                    int size = stack.size() - 1; // 栈顶，栈最后一个元素的下标
                    boolean flag = false;        // 标志位
                    while(size >= 0 && ch == ')' && stack.get(size) != '(') // 当前为)且栈顶不为(
                    {
                        queue.add(String.valueOf(stack.remove(size))); // 循环弹出栈顶符号直到找到(，ch并未入栈，所以并未插入队列中
                        size--;
                        flag = true; // 设置标志位为true，表明一直在取（）中的元素
                    }
                    if(ch == ')' && stack.get(size) == '(') // 左右括号匹配
                    {
                        flag = true;
                    }
                    while (size >= 0 && !flag && basic.get(stack.get(size)) >= basic.get(ch)) //若取得不是（）内的元素，并且当前栈顶元素的优先级>=当前对比元素 那就出栈插入队列
                    {
                        queue.add(String.valueOf(stack.remove(size)));                    //同样  此处也是remove()方法，既能得到要获取的元素，也能将栈中元素移除掉
                        size--;
                    }
                }
                if(ch != ')') // 当前元素不是)且栈空
                {
                    stack.add(ch); // 符号入栈
                }
                else
                {
                    stack.remove(stack.size() - 1);
                }
            }

            if(i == charArr.length - 1) //如果已经走到了中缀表达式的最后一位
            {
                if(len > 0) //如果len>0  就截取数字
                {
                    queue.add(String.valueOf(Arrays.copyOfRange(charArr, i - len+1, i+1)));
                }
                int size = stack.size() - 1; //size表示栈内最后一个元素下标
                while (size >= 0) //一直将栈内符号全部出栈 并且加入队列中  【最终的后缀表达式是存放在队列中的，而栈内最后会被弹空】
                {
                    queue.add(String.valueOf(stack.remove(size)));
                    size--;
                }
            }
        }

        String a = queue.toString(); // 用toString()函数之后，List转化成用,分隔的数组
        return a.substring(1, a.length()-1);
    }

    // 处理等号运算(后缀表达式的计算)
    public String dealEquation(String equation)
    {
        String [] arr = equation.split(", "); //根据, 拆分后缀表达式字符串
        List<String> list = new ArrayList<String>();

        for(int i = 0; i < arr.length; i++)
        {   //此处就是上面说的运算过程，因为list.remove的缘故导致remove元素后面的下标变化，所以取出最后一个数个最后两个数都是size-2
            int size = list.size(); // 指向找到的第一个符号
            switch (arr[i]) {
                case "+": double a = Double.parseDouble(list.remove(size-2)) + Double.parseDouble(list.remove(size-2)); list.add(String.valueOf(a)); break;
                case "-": double b = Double.parseDouble(list.remove(size-2)) - Double.parseDouble(list.remove(size-2)); list.add(String.valueOf(b)); break;
                case "×": double c = Double.parseDouble(list.remove(size-2)) * Double.parseDouble(list.remove(size-2)); list.add(String.valueOf(c)); break;
                case "÷": double d = Double.parseDouble(list.remove(size-2)) / Double.parseDouble(list.remove(size-2)); list.add(String.valueOf(d)); break;
                case "%": double e = Double.parseDouble(list.remove(size-1)); list.add(String.valueOf(e/100.0)); break; // %运算为百分号运算
                case "^": double f = Math.pow(Double.parseDouble(list.remove(size-2)), Double.parseDouble(list.remove(size-2))); list.add(String.valueOf(f)); break;
                case "!": double g = Double.parseDouble(list.remove(size-1)); list.add(String.valueOf(factorial(g))); break; // 阶乘为独立计算，所以前面只有一个数字
                default: list.add(arr[i]); break; //如果是数字，直接放进list中
            }
        }

        return list.size() == 1 ? list.get(0) : "运算失败" ; // 最后剩下答案
    }

    // 计算阶乘
    private double factorial(double x)
    {
        double ans = 1.0;
        if(x == 0.0 || x == 1.0) return ans;
        else {
            for(int i = 1; i <= x; i++)
            {
                ans = ans * i;
            }
            return ans;
        }
    }
}
