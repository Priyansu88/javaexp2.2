
import java.io.*;
import java.util.*;
class Employee implements Serializable{
    int id;String name,dept;double salary;
    Employee(int i,String n,String d,double s){id=i;name=n;dept=d;salary=s;}
    public String toString(){return "Employee{id="+id+", name='"+name+"', dept='"+dept+"', salary="+salary+"}";}
}
public class EmployeeManager{
    static String FILE="employees.dat";
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args){
        while(true){
            System.out.println("1.Add 2.Display 3.Search 4.Update 5.Delete 6.Exit");
            String ch=sc.nextLine();
            switch(ch){
                case "1":add();break;
                case "2":display();break;
                case "3":search();break;
                case "4":update();break;
                case "5":delete();break;
                case "6":return;
            }
        }
    }
    static List<Employee> read(){
        try(ObjectInputStream o=new ObjectInputStream(new FileInputStream(FILE))){
            return (List<Employee>)o.readObject();
        }catch(Exception e){return new ArrayList<>();}
    }
    static void write(List<Employee> l){
        try(ObjectOutputStream o=new ObjectOutputStream(new FileOutputStream(FILE))){o.writeObject(l);}catch(Exception e){}
    }
    static void add(){
        List<Employee> l=read();
        System.out.print("ID: ");int id=Integer.parseInt(sc.nextLine());
        System.out.print("Name: ");String n=sc.nextLine();
        System.out.print("Dept: ");String d=sc.nextLine();
        System.out.print("Salary: ");double s=Double.parseDouble(sc.nextLine());
        l.add(new Employee(id,n,d,s));write(l);
    }
    static void display(){for(Employee e:read())System.out.println(e);}
    static void search(){
        System.out.print("ID: ");int id=Integer.parseInt(sc.nextLine());
        for(Employee e:read())if(e.id==id)System.out.println(e);
    }
    static void update(){
        List<Employee> l=read();
        System.out.print("ID: ");int id=Integer.parseInt(sc.nextLine());
        for(Employee e:l)if(e.id==id){
            System.out.print("New Name: ");e.name=sc.nextLine();
            System.out.print("New Dept: ");e.dept=sc.nextLine();
            System.out.print("New Salary: ");e.salary=Double.parseDouble(sc.nextLine());
        }
        write(l);
    }
    static void delete(){
        List<Employee> l=read();
        System.out.print("ID: ");int id=Integer.parseInt(sc.nextLine());
        l.removeIf(e->e.id==id);write(l);
    }
}