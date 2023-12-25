package JYH;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.Arrays;
import java.util.Comparator;

public class MyFrame2 {
    int o=0;
    int g=0;
    int r=0;
    int y=0;
    int z[]=new int[1];
    int sum=13;
    public MyFrame2() {
        poke a=new poke();
        a.makepoke();
        a.daluanpoke();
        a.chouqupoke1();
        JFrame f = new JFrame("卡牌游戏");
        Toolkit tk = Toolkit.getDefaultToolkit();
        int w = (int) tk.getScreenSize().getWidth();
        int h = (int) tk.getScreenSize().getHeight();
        Container cp = f.getContentPane();//获取f窗口//其实就是把窗口f丢到窗体cp中
        cp.setLayout(null);
        ImageIcon bj = new ImageIcon("img/dd.jpg");
        JLabel jl = new JLabel(bj);
        jl.setBounds(0, 0, w, h);//设置位置大小（距离左边界，距离上边界，宽，高）
        cp.add(jl);
        JLayeredPane jp=f.getLayeredPane();
        JButton []wj = new JButton[13];//玩家的牌
        JButton []dnwj = new JButton[13];//电脑玩家的牌
        for (int i = 0; i < 13; i++) {			//
            ImageIcon pkImg = new ImageIcon("img/"+a.c[i]);
            wj[i] = new JButton(pkImg);
            wj[i].setBounds(300+80*i, 580, 147, 210);//实现每张牌间距一样
            jp.add(wj[i],new Integer(i));
        }
        a.chouqupoke2();
        for (int i = 0; i < 13; i++) {
            ImageIcon pkImg = new ImageIcon("img/rr.jpg");
            Image temp22 = pkImg.getImage().getScaledInstance(147, 210, pkImg.getImage().SCALE_DEFAULT); //调整图片和按钮大小自适应
            pkImg=new ImageIcon(temp22);
            dnwj[i] = new JButton(pkImg);
            dnwj[i].setBounds(60+80*i, 10, 147, 210);
            jp.add(dnwj[i],new Integer(i));
        }
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon pkImg8 = new ImageIcon("img/pp.jpg");
        JButton p1 = new JButton("",pkImg8);
        JButton p2 = new JButton("",pkImg8);
        p1.setBounds(500, 285, 147, 210);//设置大小位置
        p2.setBounds(800, 285, 147, 210);//设置大小位置
        ImageIcon pkImg2 = new ImageIcon("img/rr.jpg");
        Image temp21 = pkImg2.getImage().getScaledInstance(p1.getWidth(),
                p1.getHeight(), pkImg2.getImage().SCALE_DEFAULT);
        pkImg2 = new ImageIcon(temp21);
        p1.setIcon(pkImg2);
        p2.setIcon(pkImg2);
        p1.setBorderPainted(false);
        p2.setBorderPainted(false);
        JButton p6= new JButton("头像");
        JButton p7 = new JButton("头像");
        ImageIcon pkImg6 = new ImageIcon("img/cc.jpg");//给玩家设置头像图片
        ImageIcon pkImg7 = new ImageIcon("img/aa.jpg");//给电脑玩家设置头像图片
        p6.setBounds(50, 550, 150, 150);
        p7.setBounds(1300, 35, 150, 150);
        Image temp2 = pkImg6.getImage().getScaledInstance(p6.getWidth(), p6.getHeight(), pkImg6.getImage().SCALE_DEFAULT);
        pkImg6 = new ImageIcon(temp2);
        p6.setIcon(pkImg6);
        Image temp3 = pkImg7.getImage().getScaledInstance(p7.getWidth(), p7.getHeight(), pkImg7.getImage().SCALE_DEFAULT);
        pkImg7 = new ImageIcon(temp3);
        p7.setIcon(pkImg7);
        JLabel p8 = new JLabel("姓名：姜云鹤");
        JLabel p9 = new JLabel("学号：2214100238 ");
        JLabel p10= new JLabel("电脑玩家");
        p10.setBounds(1305, 150, 150, 100);
        p8.setBounds(50, 680, 150, 100);
        p9.setBounds(50, 720, 150, 100);
        p8.setFont(new Font("宋体",Font.BOLD,20));//”宋体”：代表字体 Font.BOLD:代表加粗字体 “20”：代表字体大小
        p9.setFont(new Font("宋体",Font.BOLD,16));
        p10.setFont(new Font("宋体",Font.BOLD,20));
        p8.setForeground(Color.CYAN);
        p9.setForeground(Color.CYAN);
        p10.setForeground(Color.CYAN);
        for (o=0; o < 13; o++) {
            wj[o].addActionListener(new ActionListener(){
                int u=o;
                public void actionPerformed(ActionEvent e) {
                    if(y%2==0) {wj[u].setBounds(300+80*u, 550, 147, 210);r=u;y++;}
                    else {wj[u].setBounds(300+80*u, 580, 147, 210);wj[r].setBounds(300+80*r, 580, 147, 210);r=u;y++;}
                }
            });
        }
        JButton p3 = new JButton("");
        p3.setBorderPainted(false);
        p3.setBounds(690, 370, 60, 60);
        ImageIcon icon = new ImageIcon("img/uu.jpg");
        Image temp1 = icon.getImage().getScaledInstance(p3.getWidth(),  p3.getHeight(), icon.getImage().SCALE_DEFAULT);
        icon = new ImageIcon(temp1);
        p3.setIcon(icon);
        p3.setHorizontalTextPosition(SwingConstants.CENTER);
        JButton p5 = new JButton("出牌");
        p5.setBounds(1000, 500, 60, 30);
        ImageIcon icon11 = new ImageIcon("img/kk.jpg");
        p5.setFont(new Font("宋体",Font.BOLD,12));
        p5.setIcon(icon11);
        p5.setHorizontalTextPosition(SwingConstants.CENTER);
        JButton p11 = new JButton("出牌");
        p11.setBounds(1000, 220, 60, 30);
        p11.setFont(new Font("宋体",Font.BOLD,12));
        p11.setIcon(icon11);
        p11.setHorizontalTextPosition(SwingConstants.CENTER);
        p11.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int nearestIndex = a.findNearestCard(a.c[r]);
                if (nearestIndex != -1) {
                    ImageIcon pkImg2 = new ImageIcon("img/" + a.d[nearestIndex]);
                    p2.setIcon(pkImg2);
                    a.d[nearestIndex] = null;
                    dnwj[nearestIndex].setVisible(false);
                    if (a.isAllCardsPlayed()) {
                        JOptionPane.showMessageDialog(f, "电脑已经没有牌可以出了！");
                    }
                }
            }
        });
        JLabel p12 = new JLabel(" ");
        p12.setBounds(705, 420, 60, 60);//位置大小
        p12.setFont(new Font("宋体",Font.BOLD,15));//改变字体
        p12.setForeground(Color.cyan);//字体颜色
        JLabel p4 = new JLabel(" ");
        p4.setFont(new Font("宋体",Font.BOLD,38));
        p4.setBounds(80, 450, 150, 150);
        p4.setForeground(Color.cyan);
        p3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                for(int t=0;t<100;t++) {
                    int m=1+(int)(Math.random()*2);
                    if(m==1) {
                        p12.setText(" ");
                        a.bidaxiao(a.c, a.d,1,g,r,z);
                        if(z[0]==1)p4.setText(" "); if(z[0]==0)p4.setText(" ");
                    }
                    if(m==2) {
                        p12.setText(" ");
                        a.bidaxiao(a.c, a.d, 2,g,r,z);
                        if(z[0]==1)p4.setText(" ");
                        if(z[0]==0)p4.setText(" ");
                    }}
            }});
        p5.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                ImageIcon pkImg10 = new ImageIcon("img/"+a.c[r]);
                p1.setIcon(pkImg10);
               for (int i = 0; i < 13; i++) {
                   wj[i].setBounds(300+80*i, 580, 147, 210);
                }}});
        jp.add(p1);//放玩家出的牌的按钮
        jp.add(p2);//放电脑玩家出的牌的按钮
        jp.add(p3);//骰子
        jp.add(p4);//显示输赢的标签
        jp.add(p5);//“vs”出牌按钮
        jp.add(p6);//玩家的头像
        jp.add(p7);//电脑玩家的头像
        jp.add(p8);//姓名的标签
        jp.add(p9);//学号的标签
        jp.add(p10);//电脑玩家名字的标签
        jp.add(p11);//出牌按钮
        jp.add(p12);//比大小标签
    }
    public class poke {
        String[] a=new String[52];
        String[] b=new String[52];
        String[] c=new String[13];
        String[] d=new String[13];
        public boolean isAllCardsPlayed() {
            for (String card : d) {
                if (card != null) {
                    return false;
                }
            }
            return true;
        }
        int findNearestCard(String playerCard) {
            int playerCardValue = getCardValue(playerCard);
            int minDifference = Integer.MAX_VALUE;
            int nearestCardIndex = -1;
            for (int i = 0; i < d.length; i++) {
                if (d[i] == null) continue;
                int computerCardValue = getCardValue(d[i]);
                int difference = Math.abs(computerCardValue - playerCardValue);
                if (difference < minDifference) {
                    minDifference = difference;
                    nearestCardIndex = i;
                } else if (difference == minDifference && compareSuit(d[nearestCardIndex], d[i]) > 0) {
                    nearestCardIndex = i;
                }
            }
            return nearestCardIndex;
        }
        int getCardValue(String card) {
            int dotIndex = card.indexOf(".jpg");
            if (dotIndex == -1) {
                throw new IllegalArgumentException("Invalid card format: " + card);
            }
            String value = card.replaceAll("[^0-9]", "");
            if (value.isEmpty()) {
                if (card.contains("J")) return 11;
                else if (card.contains("Q")) return 12;
                else if (card.contains("K")) return 13;
                else if (card.contains("A")) return 1;

                throw new IllegalArgumentException("Invalid card value: " + card);
            } else {
                return Integer.parseInt(value);
            }
        }
        int compareSuit(String card1, String card2) {
            if (card1 == null || card2 == null || card1.length() < ".jpg".length() || card2.length() < ".jpg".length()) {
                throw new IllegalArgumentException("Card strings are not valid.");
            }

            String suit1 = card1.substring(0, card1.indexOf(".jpg"));
            String suit2 = card2.substring(0, card2.indexOf(".jpg"));

            suit1 = suit1.replaceAll("[0-9]", "");
            suit2 = suit2.replaceAll("[0-9]", "");

            String order = "meihongfanghei";
            return order.indexOf(suit1) - order.indexOf(suit2);
        }
        void makepoke(){
            String[] card={"fang","mei","hong","hei"};
            int cnt=0;
            for(int j=3;j<=13;j++)
                for(int i=0;i<4;i++)
                {
                    a[cnt]=card[i]+j+".jpg"+" ";
                    cnt++;
                }
            for(int j=1;j<=2;j++)
                for(int i=0;i<4;i++)
                {
                    a[cnt]=card[i]+j+".jpg"+" ";
                    cnt++;
                }
        }
        void daluanpoke()
        {
            System.arraycopy(a,0,b,0,52);
            String x;
            for(int i=1;i<=152;i++)
            {
                int m=(int)(Math.random()*52);
                int n=(int)(Math.random()*52);
                x=b[m];
                b[m]=b[n];
                b[n]=x;
            }
        }
        void chouqupoke1() {
            System.arraycopy(b, 0, c, 0, 13);
            Arrays.sort(c, new Comparator<String>() {
                public int compare(String o1, String o2) {
                    return getCardValue(o1) - getCardValue(o2);
                }
            });
        }
        void chouqupoke2() {
            System.arraycopy(b, 13, d, 0, 13);
            Arrays.sort(d, new Comparator<String>() {
                public int compare(String o1, String o2) {
                    int valueCompare = getCardValue(o1) - getCardValue(o2);
                    if (valueCompare == 0) {
                        return compareSuit(o1, o2);
                    }
                    return valueCompare;
                }
            });
        }
        void bidaxiao(String[] c,String[] d,int q,int g,int r,int []z) {
            int u=0,y=0;
            for(int i=0;i<52;i++) 	 {
                if(c[r]==a[i])u=i;
            }
            for(int i=0;i<52;i++) 	 {
                if(d[g]==a[i])y=i;
            }
        }}
    public static void main(String[] args) {
        MyFrame2 mf = new MyFrame2();
    }
}