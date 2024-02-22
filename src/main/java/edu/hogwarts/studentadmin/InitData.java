package edu.hogwarts.studentadmin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitData implements CommandLineRunner {
    public void run(){
        System.out.println("INITDATA HEYOO");


    }
}
