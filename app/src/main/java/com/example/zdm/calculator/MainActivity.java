package com.example.zdm.calculator;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    Button btn_0;
    Button btn_1;
    Button btn_2;
    Button btn_3;
    Button btn_4;
    Button btn_5;
    Button btn_6;
    Button btn_7;
    Button btn_8;
    Button btn_9;
    Button btn_add;         // +
    Button btn_subtract;    // -
    Button btn_multiply;    // ×
    Button btn_divide;      // ÷
    Button btn_mod;         // %
    Button btn_point;       // 小数点
    Button btn_equal;       // =
    Button btn_clear;       // 清除
    Button btn_del;         // 删除
    Button btn_status;      // 正负状态
    Button btn_leftbracket; // (
    Button btn_rightbracket;// )
    Button btn_power;       // 乘方
    Button btn_factorial;   // 阶乘
    Button btn_ans;         // 上一次的答案
    private TextView textInput;   // 输入框
    private TextView textOutput;  // 输出框
    private StringBuilder pending = new StringBuilder(); // 输入框的StringBuilder
    private String answer;  // 答案

    // 初始化计算器
    private void initView()
    {
        // 找到对应的按钮id
        btn_0 = (Button) findViewById(R.id.zero);
        btn_1 = (Button) findViewById(R.id.one);
        btn_2 = (Button) findViewById(R.id.two);
        btn_3 = (Button) findViewById(R.id.three);
        btn_4 = (Button) findViewById(R.id.four);
        btn_5 = (Button) findViewById(R.id.five);
        btn_6 = (Button) findViewById(R.id.six);
        btn_7 = (Button) findViewById(R.id.seven);
        btn_8 = (Button) findViewById(R.id.eight);
        btn_9 = (Button) findViewById(R.id.nine);
        btn_add = (Button) findViewById(R.id.add);
        btn_subtract = (Button) findViewById(R.id.subtract);
        btn_multiply = (Button) findViewById(R.id.multiply);
        btn_divide = (Button) findViewById(R.id.divide);
        btn_mod = (Button) findViewById(R.id.mod);
        btn_point = (Button) findViewById(R.id.point);
        btn_equal = (Button) findViewById(R.id.equal);
        btn_clear = (Button) findViewById(R.id.AC);
        btn_del = (Button) findViewById(R.id.DEL);
        btn_status = (Button) findViewById(R.id.status);
        btn_leftbracket = (Button) findViewById(R.id.leftbracket);
        btn_rightbracket = (Button) findViewById(R.id.rightbracket);
        btn_power = (Button) findViewById(R.id.power);
        btn_factorial = (Button) findViewById(R.id.factorial);
        btn_ans = (Button) findViewById(R.id.ANS);

        textInput = (TextView) findViewById(R.id.textInput);
        textOutput = (TextView) findViewById(R.id.textOutput);

        // 设置点击监听器
        btn_0.setOnClickListener(this);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);
        btn_add.setOnClickListener(this);
        btn_subtract.setOnClickListener(this);
        btn_multiply.setOnClickListener(this);
        btn_divide.setOnClickListener(this);
        btn_mod.setOnClickListener(this);
        btn_point.setOnClickListener(this);
        btn_equal.setOnClickListener(this);
        btn_clear.setOnClickListener(this);
        btn_del.setOnClickListener(this);
        btn_status.setOnClickListener(this);
        btn_leftbracket.setOnClickListener(this);
        btn_rightbracket.setOnClickListener(this);
        btn_power.setOnClickListener(this);
        btn_factorial.setOnClickListener(this);
        btn_ans.setOnClickListener(this);

        answer = "0.0"; // 初始化答案
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 创建活动时初始化界面
        initView();
    }

    @Override
    public void onClick(View v)
    {
        int last = 0;
        if(pending.length() != 0)
        {
            // codePointAt()方法返回的是码点的十进制值
            last = pending.codePointAt(pending.length() - 1);
        }

        switch(v.getId())
        {
            case R.id.zero:
            {
                judge3();
                pending = pending.append("0");
                textInput.setText(pending);
                break;
            }
            case R.id.one:
            {
                judge3();
                pending = pending.append("1");
                textInput.setText(pending);
                break;
            }
            case R.id.two:
            {
                judge3();
                pending = pending.append("2");
                textInput.setText(pending);
                break;
            }
            case R.id.three:
            {
                judge3();
                pending = pending.append("3");
                textInput.setText(pending);
                break;
            }
            case R.id.four:
            {
                judge3();
                pending = pending.append("4");
                textInput.setText(pending);
                break;
            }
            case R.id.five:
            {
                judge3();
                pending = pending.append("5");
                textInput.setText(pending);
                break;
            }
            case R.id.six:
            {
                judge3();
                pending = pending.append("6");
                textInput.setText(pending);
                break;
            }
            case R.id.seven:
            {
                judge3();
                pending = pending.append("7");
                textInput.setText(pending);
                break;
            }
            case R.id.eight:
            {
                judge3();
                pending = pending.append("8");
                textInput.setText(pending);
                break;
            }
            case R.id.nine:
            {
                judge3();
                pending = pending.append("9");
                textInput.setText(pending);
                break;
            }
            case R.id.add:
            {
                pending = pending.append("+");
                textInput.setText(pending);
                break;
            }
            case R.id.subtract:
            {
                pending = pending.append("-");
                textInput.setText(pending);
                break;
            }
            case R.id.multiply:
            {
                pending = pending.append("×");
                textInput.setText(pending);
                break;
            }
            case R.id.divide:
            {
                pending = pending.append("÷");
                textInput.setText(pending);
                break;
            }
            case R.id.mod:
            {
                pending = pending.append("%");
                textInput.setText(pending);
                break;
            }
            case R.id.point:
            {
                judge3();
                if (judge1())
                {
                    pending = pending.append(".");
                    textInput.setText(pending);
                }
                break;
            }
            case R.id.equal:
            {
                if ((pending.length() > 1))
                {
                    InfixInToDuffix inf = new InfixInToDuffix();
                    try {
                        String a = inf.toSuffix(pending);
                        answer = inf.dealEquation(a);
                    } catch (Exception ex) {
                        answer = "出错";
                    }
                    textOutput.setText(answer);
                    pending = pending.delete(0, pending.length());
                    if (Character.isDigit(answer.charAt(0)))
                    {
                        pending = pending.append(answer);
                    }
                }
                break;
            }
            case R.id.AC:
            {
                pending = pending.delete(0, pending.length());
                textInput.setText(pending);
                textOutput.setText("");
                break;
            }
            case R.id.DEL:
            {
                if (pending.length() != 0)
                {
                    pending = pending.delete(pending.length() - 1, pending.length()); // 删掉最后一个
                    textInput.setText(pending);
                }
                break;
            }
            case R.id.status:
            {
                if(textOutput.getText().length() != 0)
                {
                    String ans = textOutput.getText().toString();
                    double temp = Double.parseDouble(ans);
                    double trans = 0.0 - temp;
                    String newPending = String.valueOf(trans);
                    pending = pending.delete(0, pending.length());
                    pending.append(newPending);
                    textInput.setText(pending);
                    textOutput.setText("");
                }
                break;
            }
            case R.id.leftbracket:
            {
                if((last != '(') || (last <='0' && last >= '9'))
                {
                    pending = pending.append("(");
                    textInput.setText(pending);
                }
                break;
            }
            case R.id.rightbracket:
            {
                if((last >= '0' && last <= '9'|| last == ')' || last == '!' || last == '%')&&judge2()==1)
                {
                    pending = pending.append(")");
                    textInput.setText(pending);
                }
                break;
            }
            case R.id.power:
            {
                pending = pending.append("^");
                textInput.setText(pending);
                break;
            }
            case R.id.factorial:
            {
                pending = pending.append("!");
                textInput.setText(pending);
                break;
            }
            case R.id.ANS:
            {
                //pending = pending.delete(0, pending.length());
                pending.append(answer);
                textInput.setText(pending);
                break;
            }
            default:
            {
                break;
            }
        }
    }

    // 判断小数点，防止输入多个小数点
    private boolean judge1()
    {
        String a = "!^+-×÷%.";           // 计算器可输入的所有符号
        int[] b = new int[a.length()]; // 存储索引
        int max; // 最后一个符号的下标
        for (int i = 0; i < a.length(); i++) // 遍历一遍所有符号，找出所有符号出现的最后的一次索引
        {
            String c = "" + a.charAt(i);
            b[i] = pending.lastIndexOf(c);
        }
        Arrays.sort(b); // 升序排列
        if (b[a.length() - 1] == -1)
        {
            max = 0;
        } else {
            max = b[a.length() - 1];
        }
        if (pending.indexOf(".", max) == -1) { // 从max位置往后查找"."出现的下标，没有则返回-1
            return true;
        } else {
            return false;
        }
    }

    // 判断左右括号匹配
    private int judge2()
    {
        int a=0,b=0;
        for(int i = 0; i < pending.length(); i++){ // 遍历等式，计算左右括号的个数
            if(pending.charAt(i)=='(' ) {
                a++;
            }
            if(pending.charAt(i)==')' ) {
                b++;
            }
        }
        if(a == b)
            return 0;
        if(a > b) // 左括号大于右括号，此时可以继续输入右括号
            return 1;
        return 2;
    }

    // 如果已经计算过一次答案，那下一次输入数字的时候重新开始输入算式
    private void judge3()
    {
        if(textOutput.getText() != "")
        {
            textOutput.setText("");
            pending = pending.delete(0, pending.length());
        }
    }
}
