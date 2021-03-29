package com.vastika.uis.controller;

import com.vastika.uis.model.User;
import com.vastika.uis.service.UserService;
import com.vastika.uis.service.UserServiceImpl;

import javax.swing.*;
import java.time.LocalDate;
import java.util.List;

public class UserController {


    public static void main(String[] args) {
        String decision="N";

        UserService userService= new UserServiceImpl();

       do{ String operation = JOptionPane.showInputDialog("Enter operation : save|update|delete|get|list");
        switch(operation){
            case"save":
                User user= getUser("save");
           int saved=     userService.saveUser(user);
               if(saved>=1){
                   JOptionPane.showMessageDialog(null,"user info saved in db");
               }
               else{
                   JOptionPane.showMessageDialog(null,"error in db");
               }
           break;
            case"update":
                User updateduser= getUser("update");
                int updated=     userService.saveUser(updateduser);
                if(updated>=1){
                    JOptionPane.showMessageDialog(null,"user info updated in db");
                }
                else{
                    JOptionPane.showMessageDialog(null,"error in db");
                }
                break;
            case"delete":
                int id =Integer.parseInt(JOptionPane.showInputDialog("Enter id:"));
              int  deleted= userService.deleteUser(id);
                if(deleted>=1){
                    JOptionPane.showMessageDialog(null,"user info deleted in db");
                }
                else{
                    JOptionPane.showMessageDialog(null,"error in db");
                }
                break;
            case"get":
                id =Integer.parseInt(JOptionPane.showInputDialog("Enter id:"));
                 user =userService.getUserById(id);

                printUserInfo(user);


                break;
            case"list":
                List<User> users =userService.getAllUser();
                for (User u:users
                     ) {printUserInfo(u);
                    
                }
                break;


        }
        decision=JOptionPane.showInputDialog("do you want to continue?Enter y|n");

       }
       while(decision.equalsIgnoreCase("y"));
        JOptionPane.showMessageDialog(null ,"Bye Bye");
    }
   public static User getUser(String type){
        User user =new User();
        if (type.equals("update")){
            int id =Integer.parseInt(JOptionPane.showInputDialog("Enter id:"));
        user.setId(id);
        }
        String username=JOptionPane.showInputDialog("Enter username: ");
       String password=JOptionPane.showInputDialog("Enter password : ");
       long mobileNo=Long.parseLong(JOptionPane.showInputDialog("Enter mobile no: "));
       double salary=Double.parseDouble((JOptionPane.showInputDialog("Enter salary:")));
       LocalDate dob=LocalDate.parse(JOptionPane.showInputDialog("Enter date:"));
       boolean active= Boolean.parseBoolean(JOptionPane.showInputDialog("Enter user is active"));

      user.setUsername(username);
      user.setPassword(password);
      user.setSalary(salary);
      user.setMobileNo(mobileNo);
      user.setDob(dob);
      user.setActive(active);



       return user;

   }
   public static  void  printUserInfo(User user){
       System.out.println("++++++++++++++++");
       System.out.println("Id is:"+user.getId());
       System.out.println("User name is:"+user.getUsername());
       System.out.println("User password is:"+user.getPassword());
       System.out.println("mobile no is:"+user.getMobileNo());
       System.out.println("Salary is:"+user.getSalary());
       System.out.println("Dob is:"+user.getDob());
       System.out.println("Stat is :"+user.isActive());
       System.out.println("++++++++++++++++");
   }
}
