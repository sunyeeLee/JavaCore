package com.sunyee.javacore.base.serializable;


import java.io.*;
import java.util.Date;

/**
 * Created by lishunyi on 2020/4/23
 */
public class SerializableDemo {

    public static void main(String[] args) {
        // initial the object
        User user = new User();
        user.setName("lishunyi");
        user.setAge(23);
        user.setBirthday(new Date());
        user.setGender("male");
        System.out.println(user);

        //write obj to file
        ObjectOutputStream oos = null;

        try{
            oos = new ObjectOutputStream(new FileOutputStream("userFile"));
            oos.writeObject(user);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //read obj from file
        File file = new File("userFile");
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(file));
            User newUser = (User) ois.readObject();
            System.out.println(newUser);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
