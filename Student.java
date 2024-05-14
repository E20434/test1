import java.util.Random;

public class Student{

    //these variables with private access modifier are only accessible in this class
    private String name;
    private int attendance;

    // Static variables to keep track of student count and total attendance value to generate average attendance
    protected static int totalAttendance = 0;
    protected static int studentCount = 0;

    //create Random object
    private Random randomGen = new Random(); 

    //constructor
    public Student(String name){
        studentCount++; // Increment student count
        this.name = name;
        this.attendance = randomGen.nextInt(46);//nextInt of randomGen object generates random numbers between 0 to 45
        totalAttendance += this.attendance; // Adding to total attendance
    }
    
    //getter for attendance percentage of the student
    public int GetStudentAttendancePercentage(){
        return this.attendance*100/45;
    }
    //this method has static access modifier so that if average attendance percentage of all the students is needed it can be access from this method without creating a object.
    public static int GetClassAttendancePercentage() {
        return totalAttendance * 100 / (studentCount * 45);
    }
    //getter to get the name of the student
    public String GetName(){
        return this.name;
    }
    //getter to get the attendance of the student
    public int GetAttendance(){
        return this.attendance;
    }
    //setter to set the name of the student
    public void SetName(String newName){
        this.name = newName;
    }
}