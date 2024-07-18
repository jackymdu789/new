package com.waleed.tcs.training;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        
        DbOperations ref = context.getBean("dbOperate", DbOperations.class);
        
        Integer numberOfRegisteredParticipants = ref.getNumberOfParticipants();
        
//        System.out.println("Number of registered participants : " + numberOfRegisteredParticipants);
        
//        System.out.println("Enter id");
        
//        System.out.println(ref.getAllDetailsOfParticipantById(new Scanner(System.in).nextInt()));
        
        
//        System.out.println("Name : " + ref.getParticipantNameById(new Scanner(System.in).nextInt()));
        
System.out.println("Registered participants :");

//List<Participant> participants = ref.getAllParticipants();

//for(Participant participant : ref.getAllParticipants()) {
//	System.out.println(participant);
//}

ref.getAllParticipants().forEach(System.out::println);


//Scanner scan = new Scanner(System.in);
//
//System.out.println("Please enter the particpant name and skills");
//
//ref.registerNewParticipant(new Participant(scan.nextLine(), scan.nextLine()));
//
//System.out.println("New Participant registered!!!");


        
        
        
        
        
        
    }
}
