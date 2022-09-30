package com.todd.ex.stream;

import java.util.stream.Stream;

public class AccountStreams {

	public static void main(String[] args) {
		Account[] actsArray = {
				new Account(1,"Checking",100),
				new Account(2,"Checking",200),
				new Account(3,"Savings",300),
				new Account(4,"Checking",400)
		};
		
		//find account having a balance greater than 150 and type "Checking"
		for(Account act: actsArray) {
			if(act.getAccountBalance() > 150) {
				if(act.getAccountType().equals("Checking")) {
					System.out.println("Act : "+act.getAccountNumber()+"; bal : "+act.getAccountBalance());
				}
			}				
		}
		
		System.out.println("Using Streams-----------------------------------------------------------");
		Stream<Account> acctsStream = Stream.of(
				new Account(1,"Checking",100),
				new Account(2,"Checking",200),
				new Account(3,"Savings",300),
				new Account(4,"Checking",400)
				);
		acctsStream
			.filter(a -> a.getAccountBalance() > 150)
			.filter(a -> a.getAccountType().equals("Checking"))
			.forEach(System.out::println);

	}

}
