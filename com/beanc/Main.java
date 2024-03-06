package com.beanc;

import com.beanc.exchange.OriginalTo;
import com.beanc.exchange.ToOriginal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    public Main() {
        Container c = getContentPane();

        JPanel panel = new JPanel(new GridBagLayout());

        JLabel[] labels = new JLabel[4];
        labels[0] = new JLabel("原码");
        labels[1] = new JLabel("反码");
        labels[2] = new JLabel("补码");
        labels[3] = new JLabel("偏移码");

        JTextField[] textFields = new JTextField[4];
        textFields[0] = new JTextField("输入完成后点击回车");
        textFields[0].setColumns(20);
        textFields[1] = new JTextField("输入完成后点击回车");
        textFields[1].setColumns(20);
        textFields[2] = new JTextField("输入完成后点击回车");
        textFields[2].setColumns(20);
        textFields[3] = new JTextField("输入完成后点击回车");
        textFields[3].setColumns(20);
        //原码
        textFields[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String OriginalCode = textFields[0].getText();//原码

                String ComplementCode = OriginalTo.OTC(OriginalCode);//反码
                String TwosComplementCode = OriginalTo.OTT(OriginalCode);//补码
                String OffsetCode = OriginalTo.OTS(OriginalCode);//偏移码

                textFields[1].setText(ComplementCode);
                textFields[2].setText(TwosComplementCode);
                textFields[3].setText(OffsetCode);
            }
        });

        //反码
        textFields[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ComplementCode = textFields[1].getText();//反码

                String OriginalCode = ToOriginal.CTO(ComplementCode);//原码
                String TwosComplementCode = OriginalTo.OTT(OriginalCode);//补码
                String OffsetCode = OriginalTo.OTS(OriginalCode);//偏移码

                textFields[0].setText(OriginalCode);
                textFields[2].setText(TwosComplementCode);
                textFields[3].setText(OffsetCode);
            }
        });

        //补码
        textFields[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String TwosComplementCode = textFields[2].getText();//补码

                String OriginalCode = ToOriginal.TTO(TwosComplementCode);//原码
                String ComplementCode = OriginalTo.OTC(OriginalCode);//反码
                String OffsetCode = OriginalTo.OTS(OriginalCode);//偏移码

                textFields[0].setText(OriginalCode);
                textFields[1].setText(ComplementCode);
                textFields[3].setText(OffsetCode);
            }
        });

        //偏移码
        textFields[3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String OffsetCode = textFields[3].getText();//偏移码

                String OriginalCode = ToOriginal.STO(OffsetCode);//原码
                String ComplementCode = OriginalTo.OTC(OriginalCode);//反码
                String TwosComplementCode = OriginalTo.OTT(OriginalCode);//补码

                textFields[0].setText(OriginalCode);
                textFields[1].setText(ComplementCode);
                textFields[2].setText(TwosComplementCode);
            }
        });

        JButton button = new JButton("关于");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                About about = new About(Main.this);
                about.setVisible(true);
            }
        });

        JButton button1 = new JButton("清除");
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFields[0].setText("");
                textFields[1].setText("");
                textFields[2].setText("");
                textFields[3].setText("");
            }
        });


        GridBagConstraints[] constraints = new GridBagConstraints[10];

        constraints[0] = new GridBagConstraints();
        constraints[0].gridx = 0;
        constraints[0].gridy = 0;

        constraints[1] = new GridBagConstraints();
        constraints[1].gridx = 0;
        constraints[1].gridy = 1;

        constraints[2] = new GridBagConstraints();
        constraints[2].gridx = 0;
        constraints[2].gridy = 2;

        constraints[3] = new GridBagConstraints();
        constraints[3].gridx = 0;
        constraints[3].gridy = 3;

        constraints[4] = new GridBagConstraints();
        constraints[4].gridx = 1;
        constraints[4].gridy = 0;

        constraints[5] = new GridBagConstraints();
        constraints[5].gridx = 1;
        constraints[5].gridy = 1;

        constraints[6] = new GridBagConstraints();
        constraints[6].gridx = 1;
        constraints[6].gridy = 2;

        constraints[7] = new GridBagConstraints();
        constraints[7].gridx = 1;
        constraints[7].gridy = 3;

        constraints[8] = new GridBagConstraints();
        constraints[8].gridx = 1;
        constraints[8].gridy = 4;

        constraints[9] = new GridBagConstraints();
        constraints[9].gridx = 0;
        constraints[9].gridy = 4;

        panel.add(labels[0], constraints[0]);
        panel.add(labels[1], constraints[1]);
        panel.add(labels[2], constraints[2]);
        panel.add(labels[3], constraints[3]);
        panel.add(textFields[0], constraints[4]);
        panel.add(textFields[1], constraints[5]);
        panel.add(textFields[2], constraints[6]);
        panel.add(textFields[3], constraints[7]);
        panel.add(button, constraints[8]);
        panel.add(button1, constraints[9]);

        c.add(panel);
        setSize(450, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.setTitle("八位二进制数制转换");
        main.setVisible(true);
    }
}
