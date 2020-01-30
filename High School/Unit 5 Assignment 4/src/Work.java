public class Work {

	public static void main(String[] args) {
		Employee james = new Secretary("Retsim", 666, "1600 Pennsylvania Ave.",
				50);
		Employee bro = new Manager("Buddy the Elf", 1225, "Santa Clause Lane",
				12);
		Employee money = new Cashier("James Bond", 5321,
				"30 Wellington Square", 10, 20);
		Employee[] list = { james, bro, money };
		Payroll crew = new Payroll(list);
		System.out.printf("$%.2f\n", crew.weeklyPayroll());
		for (Employee i : list) {
			i.mailCheck();
			System.out.println();
		}
	}

}
