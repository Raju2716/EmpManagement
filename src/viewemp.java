
import java.util.Scanner;
import static java.lang.System.*;

//creating a class to consume a connection to business logic
//view

public class viewemp {

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        // creating scanner object to take users input
        Scanner obj = new Scanner(System.in);
        out.println("\t\t\t--------WELCOME TO EMPLOYEE MANAGEMENT SYSTEM----------- ");
        out.println("Press 1 to  add emp to the database \n Press 2 to retrive employee data from database");
        int opt = obj.nextInt();
        // creating object of empdaocontroller class
        empDaoController empdao = new empDaoController();
        empdao.connect();
        // out.println("Press 1 for add emp \n Press 2 for retrive emp");

        switch (opt) {
            case 1 -> {
                empl e1 = new empl();
                out.println("Enter Employee id ");
                int empid = obj.nextInt();
                e1.eId = empid;
                out.println("Enter Employee Name ");
                String empName = obj.next();
                e1.eName = empName;
                out.println("Enter Employee Domain ");
                String empDomain = obj.next();
                e1.eDomain = empDomain;
                out.println("Enter Employee Salary ");
                int empSalary = obj.nextInt();
                e1.eSalary = empSalary;

                empdao.addEmp(e1);
            }
            // case 2 to retrieve the data
            case 2 -> {
                out.println("Enter Employee Id for the details ");
                int eid = obj.nextInt();

                // Calling get employee method
                empl e2 = empdao.getEmp(eid);
                out.println(
                        e2.eId + " is " + e2.eName + " working in domain " + e2.eDomain + " with a salary " + e2.eSalary
                                + " per month.");
            }

        }
        obj.close(); // closing the scanner object
    }

}
