import java.util.*;

class Employee {
    private int empno;
    private String ename;
    private int salary;

    Employee(int empno, String ename, int salary) {
        this.empno = empno;
        this.ename = ename;
        this.salary = salary;
    }

    public int getEmpno() {
        return empno;
    }

    public int getSalary() {
        return salary;
    }

    public String getEname() {
        return ename;
    }

    @Override
    public String toString() {
        return empno + " " + ename + " " + salary;
    }
}

class Crud {
    public static void main(String[] args) {
        List<Employee> c = new ArrayList<>();
        try (Scanner s = new Scanner(System.in)) {
            int ch;
            do {
                System.out.println("1.INSERT");
                System.out.println("2.DISPLAY");
                System.out.println("3.SEARCH");
                System.out.println("4.DELETE");
                System.out.println("5.UPDATE");
                System.out.println("Enter Your Choice (0 to Exit):");

                while (!s.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a number:");
                    s.next();
                }
                ch = s.nextInt();
                s.nextLine(); // Consume newline

                switch (ch) {
                    case 1:
                        System.out.println("Enter Empno:");
                        while (!s.hasNextInt()) {
                            System.out.println("Invalid input. Please enter a number:");
                            s.next();
                        }
                        int eno = s.nextInt();
                        s.nextLine();

                        System.out.println("Enter Employee Name:");
                        String ename = s.nextLine();

                        System.out.println("Enter Salary:");
                        while (!s.hasNextInt()) {
                            System.out.println("Invalid input. Please enter a number:");
                            s.next();
                        }
                        int salary = s.nextInt();
                        s.nextLine();

                        c.add(new Employee(eno, ename, salary));
                        break;

                    case 2:
                        System.out.println("----------");
                        for (Employee emp : c) {
                            System.out.println(emp);
                        }
                        System.out.println("----------");
                        break;

                    case 3:
                        System.out.print("Enter Empno to search: ");
                        while (!s.hasNextInt()) {
                            System.out.println("Invalid input. Please enter a number:");
                            s.next();
                        }
                        eno = s.nextInt();
                        s.nextLine();

                        boolean found = false;
                        for (Employee e : c) {
                            if (e.getEmpno() == eno) {
                                System.out.println(e);
                                found = true;
                            }
                        }
                        if (!found) {
                            System.out.println("Record Not Found");
                        }
                        break;

                    case 4:
                        System.out.print("Enter Empno to delete: ");
                        while (!s.hasNextInt()) {
                            System.out.println("Invalid input. Please enter a number:");
                            s.next();
                        }
                        eno = s.nextInt();
                        s.nextLine();

                        Iterator<Employee> it = c.iterator();
                        found = false;
                        while (it.hasNext()) {
                            Employee e = it.next();
                            if (e.getEmpno() == eno) {
                                it.remove();
                                found = true;
                            }
                        }
                        if (!found) {
                            System.out.println("Record Not Found");
                        } else {
                            System.out.println("Record is deleted successfully");
                        }
                        break;

                    case 5:
                        System.out.print("Enter Empno to update: ");
                        while (!s.hasNextInt()) {
                            System.out.println("Invalid input. Please enter a number:");
                            s.next();
                        }
                        eno = s.nextInt();
                        s.nextLine();

                        ListIterator<Employee> li = c.listIterator();
                        found = false;
                        while (li.hasNext()) {
                            Employee e = li.next();
                            if (e.getEmpno() == eno) {
                                System.out.println("Enter new Name:");
                                ename = s.nextLine();

                                System.out.println("Enter new Salary:");
                                while (!s.hasNextInt()) {
                                    System.out.println("Invalid input. Please enter a number:");
                                    s.next();
                                }
                                salary = s.nextInt();
                                s.nextLine();

                                li.set(new Employee(eno, ename, salary));
                                found = true;
                            }
                        }
                        if (!found) {
                            System.out.println("Record Not Found");
                        } else {
                            System.out.println("Record is updated successfully");
                        }
                        break;

                    default:
                        if (ch != 0) {
                            System.out.println("Invalid choice, please try again.");
                        }
                        break;
                }
            } while (ch != 0);
        }
    }
}
