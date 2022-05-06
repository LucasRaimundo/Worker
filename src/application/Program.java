package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner ler = new Scanner(System.in);
		
		System.out.print("Enter department's name: ");
		String departmentName = ler.nextLine();
		System.out.println("Enter worker data: ");
		System.out.print("Name: ");
		String workerName = ler.nextLine();
		System.out.print("Level: ");
		String workerLevel = ler.nextLine();
		System.out.print("Base salary: ");
		double baseSalary = ler.nextDouble();
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(departmentName));
		
		System.out.print("Hoy many contracts to this worker? ");
		int n = ler.nextInt();
		for(int i =1; i<=n;i++) {
			System.out.println("Enter contract #" + i + " data:");
			System.out.print("Date (DD/MM/YYYY: ");
			Date contractDate = sdf.parse(ler.next());
			System.out.print("Value per Hour: ");
			double valuePerHour = ler.nextDouble();
			System.out.print("Duration (hours): ");
			int hours = ler.nextInt();
			HourContract contract = new HourContract(contractDate, valuePerHour, hours);
			worker.addContract(contract);
		}
		System.out.println();
		System.out.print("Enter month and year to calculate income (MM/YYYY): ");
		String monthAndYear = ler.next();
		int month = Integer.parseInt(monthAndYear.substring(0, 2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		System.out.println("Name: " + worker.getName());
		System.out.println("Department: " + worker.getDepartment().getName());
		System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", worker.incame(year, month)));
		
		
		ler.close();
	}

}
