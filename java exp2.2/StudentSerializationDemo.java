
import java.io.*;
import java.util.*;
class Student implements Serializable {
    String name; int roll; double cgpa;
    Student(String n,int r,double c){name=n;roll=r;cgpa=c;}
    public String toString(){return "Student{name='"+name+"', roll="+roll+", cgpa="+cgpa+"}";}
}
public class StudentSerializationDemo {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        try{
            System.out.print("Name: ");String n=sc.nextLine();
            System.out.print("Roll: ");int r=Integer.parseInt(sc.nextLine());
            System.out.print("CGPA: ");double c=Double.parseDouble(sc.nextLine());
            Student s=new Student(n,r,c);
            ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("student.ser"));
            oos.writeObject(s);oos.close();
            ObjectInputStream ois=new ObjectInputStream(new FileInputStream("student.ser"));
            Student d=(Student)ois.readObject();ois.close();
            System.out.println("Deserialized: "+d);
        }catch(Exception e){e.printStackTrace();}
    }
}