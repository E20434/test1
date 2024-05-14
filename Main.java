import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {


        //create a ArrayList 

        ArrayList<Student> students = new ArrayList<Student>(); 

        //BufferedReader is used to read

        try(BufferedReader reader_input = new BufferedReader(new FileReader("co225-classlist.txt"))){

            String line;

            while((line = reader_input.readLine())!=null){
                students.add(new Student(line)); 
            }

        //exception handling

        }catch(FileNotFoundException e){
            System.err.println("File not found: "+e.getMessage());

        }catch(IOException e){
            e.printStackTrace();
            
        }
        //Because of the automatic resource management, no need to close the resources
        //because of BufferedWriter

        try(BufferedWriter inEligibleWriter = new BufferedWriter(new FileWriter("co225-classlist-ineligible.txt"));BufferedWriter classListWriter = new BufferedWriter(new FileWriter("co225-classlist.txt"))){

            for(Student student :students){

                if(student.GetStudentAttendancePercentage()<80){

                    //student who has less than 80% attendence is writing to the ineligible txt file
                    inEligibleWriter.write(student.GetName()+"\n"); 

                    //Updating the classlist file who is ineligible
                    classListWriter.write(student.GetName() + "-ineligible\n");
                }else{


                    //if the student has more than 80% attendence, just name will be written to the classList file
                    classListWriter.write(student.GetName() + "\n"); 
                }
            }
            
        // catch IOExceptions
        }catch(IOException e){
            e.printStackTrace();
        }
        System.out.println("Average attendance percentage of a student : "+Student.GetClassAttendancePercentage()+"%");
    }
}
