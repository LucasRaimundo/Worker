package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner ler = new Scanner(System.in);
		
		System.out.print("Enter department's name: ");
		String departmentName = ler.nextLine();
		System.out.print("Enter worker data: ");
		System.out.print("Name: ");
		String workerName = ler.nextLine();
		System.out.print("Level: ");
		String workerLevel = ler.nextLine();
		System.out.print("Base salary: ");
		double baseSalary = ler.nextDouble();
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(departmentName));
		
		System.out.print("Hoy many contracts to this worker? ");
		int n = ler.nextInt();
		for(int i =0; i<=n;i++) {
			System.out.println("Enter contract #" + i + "data:");
			System.out.print("Date (DD/MM/YYYY: ");
			Date contractDate = sdf.parse(ler.next());
		}
		
		ler.close();
	}

}
