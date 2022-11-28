package com.itheima;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class PokerGame {

    //准备牌盒
    //因为我后面其他方法和静态代码块中要用,
    // 所以写成static修饰的成员变量
    //因为往里面添加牌,可以写成集合
    static ArrayList<String> poker = new ArrayList<>();

    //1.准备牌
    //放在成员变量位置(用static修饰)==游戏开始只加载一次
    //相当于只用准备一副牌
    //静态代码块
    static {
        //定义花色和数字的数组
        String[] color = new String[]{"♠", "♥", "♣", "♦"};
        String[] num = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

        //将牌添加到牌盒当中去
        for (String s : color) {
            for (String n : num) {
                poker.add(s + n);
            }
        }
        //添加大小王
        poker.add("大王");
        poker.add("小王");

    }


    public PokerGame() {

        //2.洗牌
        Collections.shuffle(poker);

        //3.发牌
        //应该要定义三个玩家牌盒
        //再定义一个底牌盒
        //定义三个玩家
        String name1 = "二货";
        String name2 = "狙脑阔";
        String name3 = "哈皮";


        ArrayList<String> player1 = new ArrayList<>();
        ArrayList<String> player2 = new ArrayList<>();
        ArrayList<String> player3 = new ArrayList<>();
        ArrayList<String> lord = new ArrayList<>();

        //正式发牌: 遍历牌盒
        //这里最好要用普通方法去遍历: 用i去记录牌
        for (int i = 0; i < poker.size(); i++) {
            //前三张牌当底牌
            if (i < 3) {
                lord.add(poker.get(i));
                //结束本轮循环
                continue;
            }
            //开始发玩家牌
            if (i % 3 == 0) {
                player1.add(poker.get(i));
            } else if (i % 3 == 1) {
                player2.add(poker.get(i));
            } else {
                player3.add(poker.get(i));
            }

        }
        //4.看牌
        lookPoker(player1, name1);
        lookPoker(player2, name2);
        lookPoker(player3, name3);
        lookPoker(lord, "底牌");

    }

    //看牌方法
    //参数: 牌盒 + 牌盒持有者
    public void lookPoker(ArrayList<String> list, String name) {
        System.out.print("name:");
        for (String p : list) {
            System.out.print(p + " ");
        }
        System.out.println("");
    }
}
