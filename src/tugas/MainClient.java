/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tugas;

import java.util.Scanner;

/**
 *
 * @author M. Reza Irvanda
 */
public class MainClient {
    public static void main (String args[]){
        if(args.length < 2){
            System.out.println("Args : <cluster_address> <keyspace>");
            return;
        }
        
        TwitterLike twitter = new TwitterLike(args[0], args[1]); //cluster_address, keyspace
        String username,password;
        Scanner scan = new Scanner(System.in);
        System.out.println("Pilih:\n1.Login\n2.Register");
        int pilihan = scan.nextInt();
        if(pilihan==1){
            System.out.print("Login as: ");
            username = scan.nextLine();
            System.out.print("Password: ");
            password = scan.nextLine();
            while(!twitter.login(username,password)){
                System.out.println("Username dan Password tidak cocok");
                System.out.print("Login as: ");
                username = scan.nextLine();
                System.out.print("Password: ");
                password = scan.nextLine();
            }
        }
        else{
            //register, wrong code assumed as register
            System.out.print("Register as: ");
            username = scan.nextLine();
            System.out.print("Password: ");
            password = scan.nextLine();
            while(!twitter.register(username,password)){
                System.out.println("Username sudah ada");
                System.out.print("Register as: ");
                username = scan.nextLine();
                System.out.print("Password: ");
                password = scan.nextLine();
            }
        }
        
        //main loop
        while(true){
            System.out.println("Pilih aksi:\n1. Follow a Friend \n2. Post a Tweet \n3. See Tweets From a User \n4. See Timeline\n5. Logout");
            pilihan = scan.nextInt();
            if(pilihan<1 || pilihan >5{
                System.out.println("Kode aksi salah.");
            }
            else if(pilihan<4){
                System.out.println("Masukkan paramater : ");
                String parameter = scan.nextLine();
                switch(pilihan){
                    case 1:
                        if(twitter.followFriend(username, parameter))
                            System.out.println("Anda berhasil follow `"+parameter+"`");
                        break;
                    case 2:
                        if(twitter.postTweet(username, parameter))
                            System.out.println("Tweet anda berhasil di-post.");
                        break;
                    case 3:
                    	System.out.println("TWEETS FROM `"+parameter+"` :");
                        System.out.println(twitter.getTweetsFromUser(parameter));
                        break;
                }
            }
            else if(pilihan==4){
                System.out.println(twitter.getTimelineFromUser(username));
            }
            else{
            	// case 5
            	twitter.logout();
            }
        }
    }
}
