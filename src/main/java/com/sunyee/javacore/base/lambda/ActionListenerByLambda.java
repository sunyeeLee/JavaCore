package com.sunyee.javacore.base.lambda;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by lishunyi on 2019/9/23
 */
public class ActionListenerByLambda {

    public static void main(String[] args) {
        JButton show = new JButton();

        //old way by anonymous inner class
        show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Event handling without lambda expression is boring");
            }
        });

        //new way by lambda expression
        show.addActionListener((e) ->{
            System.out.println("Lambda expression code!!!");
        });

    }
}
