package application;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import model.entities.Employee;

public class ProgramEmployeeFinal {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter full file path: ");
		String path = "C:\\Workspaces\\ws-eclipse\\programacao_funcional_lambda\\employees.txt";

		try (BufferedReader fileEmployees = new BufferedReader(
				new InputStreamReader(new FileInputStream(path), "UTF-8"))) {

			List<Employee> employeeList = new ArrayList<>();
			String[] employeesFields;
			String linhaTexto = fileEmployees.readLine();
			while (linhaTexto != null) {
				employeesFields = linhaTexto.split(",");
				employeeList
						.add(new Employee(employeesFields[0], employeesFields[1], Double.valueOf(employeesFields[2])));
				linhaTexto = fileEmployees.readLine();
			}
			System.out.print("Enter salary: ");
			Double salary = sc.nextDouble();

			System.out.println("Email of people whose salary is more than $" + String.format("%.2f", salary));
			List<String> emails = employeeList.stream()
					.filter(employee -> employee.getSalary() > salary)
					.map(employee -> employee.getEmail())
					.sorted()
					.collect(Collectors.toList());
			emails.forEach(System.out::println);

			Double sumSalaries = employeeList.stream()
					.filter(employee -> employee.getName().charAt(0) == 'M')
					.map(employee -> employee.getSalary())
					.reduce(0.0, (x, y) -> x + y);
			System.out.print("Sum of salary of people whose name starts with 'M': " + String.format("%.2f", sumSalaries));
			
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			sc.close();
		}
	}

}
