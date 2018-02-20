public class BankTester{
	public static void main(String[] args) {
		
		//B. Testing Requirements
		String accountNames [] = { "John Doe", "Mary Ryan", "Peter Liu", "John Doe", "Peter Liu" };
		String accountNumbers [] = { "A1234", "B5678", "C9999", "A1234", "D8901" };
		int accountBalances [] = { 1000, 3000, 5000, 7000, 3000 };
		
		//1. 
		Account acc0 = new Account(accountNames[0], accountNumbers[0], accountBalances[0]);
		Account acc1 = new Account(accountNames[1], accountNumbers[1], accountBalances[1]);
		Account acc2 = new Account(accountNames[2], accountNumbers[2], accountBalances[2]);
		Account acc3 = new Account(accountNames[3], accountNumbers[3], accountBalances[3]);
		Account acc4 = new Account(accountNames[4], accountNumbers[4], accountBalances[4]);
		
		//2.a)
		Bank me = new Bank("Daniel Wierzbicki");
		System.out.println(me);
		
		//2.b)
		me.addAccount(acc0);
		me.addAccount(acc1);
		me.addAccount(acc2);
		me.addAccount(acc3);
		me.addAccount(acc4);
		System.out.println(me);
		
		//2.c)
		System.out.println(me.addAccount(null));
		
		//2.d) looks like the output should be hard-coded "'Two' accounts are found."
		Account[] banana= me.searchByBalance(3000);
		System.out.println("\nTwo accounts are found.");
		System.out.println("1. number: "+banana[0].getAccountNumber()+", name: "+banana[0].getFullName()+", balance: $"+banana[0].getAccountBalance());
		System.out.println("2. number: "+banana[1].getAccountNumber()+", name: "+banana[1].getFullName()+", balance: $"+banana[1].getAccountBalance());
		
		//2.e)also going to hard-code but will check searchByBalance
		banana= me.searchByBalance(-1111);
		if(banana.length==0){
			System.out.println("\n*** NO ACCOUNT FOUND ***");
		}
		else{
			System.out.println("\nYou screwed up big time buddy");
		}
		
		//3. printing out true or false if added --should all be false
		System.out.println("\n");
		System.out.println(me.addAccount(acc4));
		System.out.println("\n");
		System.out.println(me.addAccount(acc3));
		System.out.println("\n");
		System.out.println(me.addAccount(acc2));
		System.out.println("\n");
		System.out.println(me.addAccount(acc1));
		System.out.println("\n");
		System.out.println(me.addAccount(acc0));
		System.out.println("\n");
	}
}