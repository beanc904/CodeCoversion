package com.beanc;

import javax.swing.*;
import java.awt.*;

public class About extends JDialog {
    public About(JFrame frame) {
        super(frame, "关于", true);
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());

        //内容为窗口引用
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        JLabel label = new JLabel("使用文档："+
                "by @beanc904");

        GridBagConstraints constraints1 = new GridBagConstraints();
        constraints1.gridx = 0;
        constraints1.gridy = 1;
        JLabel label1 = new JLabel("使用前，请先点按清除！");

        GridBagConstraints constraints2 = new GridBagConstraints();
        constraints2.gridx = 0;
        constraints2.gridy = 2;
        JLabel label2 = new JLabel("使用时，请将八位二进制原码等输入进文本框内，点按回车。");

        GridBagConstraints constraints3 = new GridBagConstraints();
        constraints3.gridx = 0;
        constraints3.gridy = 3;
        JLabel label3 = new JLabel("v0.0.1" );

        container.add(label, constraints);
        container.add(label1, constraints1);
        container.add(label2, constraints2);
        container.add(label3, constraints3);

        setSize(400, 300);
        setLocationRelativeTo(null);
    }
}
