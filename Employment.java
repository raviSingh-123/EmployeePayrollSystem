package Project;
import java.util.*;

public class Employment{
 public static void main(String[] args){
    PayrollSystem payrollSystem = new PayrollSystem();
    FullTimeEmployee emp1 = new FullTimeEmployee("Tanish", 1, 29000);
    PartTimeEmployee emp2 = new PartTimeEmployee("Atul", 2, 40, 100);

    payrollSystem.addEmployee(emp1);
    payrollSystem.addEmployee(emp2);

    System.out.println("Initial employee details: ");
    payrollSystem.displayEmployee();
    System.out.println("Remove employee: ");
    payrollSystem.removeEmployee(2);
    System.out.println("Remaining employee: ");
    payrollSystem.displayEmployee();
  }
}

abstract class Employee{
   private String name;
   private int id;

   public Employee(String name, int id){
     this.name = name;
     this.id = id;
   }

   public String getName(){
    return name;
   }

   public int getId(){
    return id;
   }

   public abstract double calculateSalary();

   @Override
   public String toString(){
    return "Employee[name="+name+", id="+id+", salary="+calculateSalary()+"]";
   }
}

class FullTimeEmployee extends Employee{
    private double monthlySalary;
    
    public FullTimeEmployee(String name, int id, double monthlySalary){
        super(name, id);
        this.monthlySalary = monthlySalary;
    }
    
    @Override
    public double calculateSalary(){
        return monthlySalary;
    }
}

class PartTimeEmployee extends Employee{
    private int hoursWorked;
    private int hourlyRate;

    public PartTimeEmployee(String name,int id, int hoursWorked, int hourlyRate){
        super(name,id);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary(){
        return hoursWorked*hourlyRate;
    }
}

class PayrollSystem{
    private ArrayList<Employee>employeeList;

    public PayrollSystem(){
        employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee){
        employeeList.add(employee);
    }
    
    public void removeEmployee(int id){
        Employee employeToRemove = null;
        for(Employee employee: employeeList){
            if(employee.getId()==id){
                employeToRemove = employee;
                break;
            }
        }

        if(employeToRemove!=null){
            employeeList.remove(employeToRemove);
        }else{
            System.out.println("Employee does not exits in our company");
        }
    }


    public void displayEmployee(){
        for(Employee employee:employeeList){
            System.out.println(employee);
        }
    }
}    