import java.util.*;
import java.io.*;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
public class Main {

    //main
    public static void main(String[] args) {

        ArrayList<Project> ProjectArray = new ArrayList<Project>();
       // ArrayList<String> ProjectArrays = new ArrayList<String>();


        Scanner input = new Scanner(System.in);

                while (true) {
                    System.out.println("Please make a selection from the menu:" + "\n1. Create a new project:"
                            + "\n2. Change the due date of the project:" + "\n3. Change the total number of the fee paid:"
                            + "\n4. Update contractors contact details" + "\n5. View completed projects"
                            + "\n6. View uncompleted tasks" + "\n7. Finalise Project:" + "\n8. Store project details to file"+"\n9 exit the program");

                    // create object to handle user choice
                    int choice = input.nextInt();
                    double totalFee = 0.0;
                    double amountPaidDate = 0.0;

                    if (choice == 1) {
                        int projectNumber = 0;
                        while(true) {
                            try {
                                System.out.print("Enter Project Number\n");
                                projectNumber = input.nextInt();
                                input.nextLine();//clear buffer after taking the inputs before taking the strings
                                break;
                            } catch (Exception e) {
                                System.out.println("format not correct try again");
                                input.next();
                            }
                        }
                        System.out.println("Enter Project Name");
                        String projectName = input.nextLine();
                        System.out.println("Enter type of Building");
                        String buildingType = input.nextLine();
                        System.out.println("Enter address of Project");
                        String addressOfProject = input.nextLine();

                        while(true) {
                            try {
                                System.out.println("Enter total Fee");
                                totalFee = input.nextDouble();
                                break;
                            } catch (Exception e) {
                                System.out.println("format not correct!!! please try again");
                                input.next();

                            }
                        }

                        while(true) {
                            try {
                                System.out.println("Enter total Amount Paid To Date");
                                amountPaidDate = input.nextDouble();
                                input.nextLine();//clear buffer after taking the inputs before taking the strings
                                break;
                            } catch (Exception e) {
                                System.out.println("Please enter correct format");
                                input.next();
                            }
                        }
                        System.out.println("Enter due date of the project");
                        String deadline = input.nextLine();
                        String projectCompleted = "No";
                        System.out.println("Enter Architect Name");
                        String name = input.nextLine();
                        System.out.println("Enter Architect Surname");
                        String surname = input.nextLine();
                        int telephoneNumber = 0;
                        while(true){
                            try{
                                System.out.println("Enter Architect phone number");
                                telephoneNumber = input.nextInt();
                                input.nextLine();//clear buffer after taking the inputs before taking the strings
                                break;
                            }catch (Exception e) {
                                System.out.println("format not correct try again");
                                input.next();
                            } }
                        System.out.println("Enter Architect Email");
                        String emailAddress = (input.nextLine());
                        System.out.println("Enter Architect address");
                        String physicalAddress = input.nextLine();
                         Person Architect = new Person(name, surname, telephoneNumber, emailAddress, physicalAddress);
                         System.out.println("Enter Contractor Name");
                        String contractorName = input.nextLine();
                        System.out.println("Enter Contractor Surname");
                        String contractorSurname = input.nextLine();
                        int contractorNumber = 0;
                        while(true) {
                            try {
                                System.out.println("Enter Contractor phone number");
                                contractorNumber = input.nextInt();
                                input.nextLine();//clear buffer after taking the inputs before taking the strings
                                break;
                            } catch (Exception e) {
                                System.out.println("format not correct try again !!");
                                input.next();
                            }
                        }
                        System.out.println("Enter Contractor Email");
                        String contractorEmail = input.nextLine();
                        System.out.println("Enter Contractor address");
                        String contractorAddress = input.nextLine();
                        //Create Contractor
                        Person Contractor = new Person(contractorName, contractorSurname, contractorNumber, contractorEmail, contractorAddress);
                        System.out.println("Enter Customer Name");
                        String customerName = input.nextLine();
                        System.out.println("Enter Customer Surame");
                        String customerSurname = input.nextLine();
                        int customerNumber = 0;
                        while(true){
                            try{
                                System.out.println("Enter Customer number");
                                customerNumber = input.nextInt();
                                input.nextLine();//clear buffer after taking the inputs before taking the strings
                                break;
                            }catch (Exception e) {
                                System.out.println("incorrect format try again !!! ");
                                input.next();
                           }
                        }
                        System.out.println("Enter Customer Email");
                        String customerEmail = input.nextLine();
                        System.out.println("Enter Customer address");
                        String customerAddress = input.nextLine();
                        if(projectName == "")
                        {
                            projectName = customerSurname;
                        }
                        //Create Customer
                        Person Customer = new Person(customerName, customerSurname, customerNumber, customerEmail, customerAddress);
                        Project newProject = new Project(projectNumber, projectName, buildingType, addressOfProject, totalFee, amountPaidDate, deadline, projectCompleted,Architect, Contractor, Customer);
                        ProjectArray.add(newProject);
                        System.out.println("\nNew project has been created!");
                        System.out.println(newProject.toString());
                        if (projectName.equals("")) {
                            newProject.setProjectName(buildingType + " " + customerSurname);
                        }
                    }
                    if (choice == 2){

                        int number = 0;
                        while(true)

                                try{
                                    BufferedReader txt = new BufferedReader(new FileReader("projects.txt"));
                                     String str;
                                     ArrayList<String> data = new ArrayList<String>();
                                     while((str = txt .readLine()) != null){

                                         data.add(str);
                                     }

                                     txt.close();

                                   // String lines = "";
                                   // int lineNo = 0;
                                    System.out.println("enter index number of the project :");
                                    number = input.nextInt();
                                    number = number-1;
                                    input.nextLine();
                                    System.out.println("what is the new date");
                                    String due = input.nextLine();

                                    String temp = data.get(number);
                                    temp = temp.toString();
                                  //  System.out.println(data);

                                    List<String> temple = Arrays.asList(temp.split(","));
                                    temple.set(5,due);

                                   String project = temple.toString();
                                   project = project.replace("[","");
                                   project = project.replace("]","");


                                  //  temp = temp.replace("No",due);

                                   data.set(number,project);

                                 //   System.out.println(data.size());



                                    FileWriter writers = new FileWriter("projects.txt");
                                    FileWriter writerLine = new FileWriter("projects.txt",true);
                                     for(int index = 0; index<data.size();index++) {

                                         if (index > 0) {

                                             writerLine.write(data.get(index)+"\n");
                                         } else {

                                             writers.write(data.get(index)+"\n");
                                         }
                                     }
                                      //  writers.write(data);


                                    writers.close();
                                     writerLine.close();



                                    break;

                                }catch (Exception e){

                                    System.out.println("incorrect format");
                                }

                    } else if(choice == 3) {

                        int number = 0;
                        while(true)

                            try{
                                BufferedReader txt = new BufferedReader(new FileReader("projects.txt"));
                                String str;
                                ArrayList<String> data = new ArrayList<String>();
                                while((str = txt .readLine()) != null){

                                    data.add(str);
                                }

                                txt.close();

                                // String lines = "";
                                // int lineNo = 0;
                                System.out.println("enter index number of the project :");
                                number = input.nextInt();
                                number = number-1;
                                input.nextLine();
                                System.out.println("Enter the new amount format  * 20.8 *");
                                String total = input.nextLine();

                                String temp = data.get(number);
                                temp = temp.toString();
                                //  System.out.println(data);

                                List<String> temple = Arrays.asList(temp.split(","));
                                temple.set(4,total);
                                String project = temple.toString();
                                project = project.replace("[","");
                                project = project.replace("]","");
                                //  temp = temp.replace("No",due);
                                data.set(number,project);
                                //   System.out.println(data.size());
                                FileWriter writers = new FileWriter("projects.txt");
                                FileWriter writerLine = new FileWriter("projects.txt",true);
                                for(int index = 0; index<data.size();index++) {
                                    if (index > 0) {
                                        writerLine.write(data.get(index)+"\n");
                                    } else {
                                        writers.write(data.get(index)+"\n");
                                    }
                                }
                                //  writers.write(data);

                                writers.close();
                                writerLine.close();

                                break;

                            }catch (Exception e){

                                System.out.println("incorrect format");
                            }

                    } else if ( choice == 4) {

                        int number = 0;
                        while(true)

                            try{
                                BufferedReader txt = new BufferedReader(new FileReader("projects.txt"));
                                String str;
                                ArrayList<String> data = new ArrayList<String>();
                                while((str = txt .readLine()) != null){

                                    data.add(str);
                                }

                                txt.close();

                                // String lines = "";
                                // int lineNo = 0;
                                System.out.println("enter index number of the project :");
                                number = input.nextInt();
                                number = number-1;
                                input.nextLine();
                                System.out.println("enter new phone number ");
                                String total = input.nextLine();

                                String temp = data.get(number);
                                temp = temp.toString();
                                //  System.out.println(data);

                                List<String> temple = Arrays.asList(temp.split(","));
                                temple.set(14,total);
                                String project = temple.toString();
                                project = project.replace("[","");
                                project = project.replace("]","");
                                //  temp = temp.replace("No",due);
                                data.set(number,project);
                                //   System.out.println(data.size());
                                FileWriter writers = new FileWriter("projects.txt");
                                FileWriter writerLine = new FileWriter("projects.txt",true);
                                for(int index = 0; index<data.size();index++) {
                                    if (index > 0) {
                                        writerLine.write(data.get(index)+"\n");
                                    } else {
                                        writers.write(data.get(index)+"\n");
                                    }
                                }
                                //  writers.write(data);

                                writers.close();
                                writerLine.close();

                                break;

                            }catch (Exception e){

                                System.out.println("incorrect format");
                            }

                    } else if (choice == 5) {



                        while(true)

                            try{
                                BufferedReader txt = new BufferedReader(new FileReader("projects.txt"));
                                String str;
                                ArrayList<String> data = new ArrayList<String>();
                                while((str = txt .readLine()) != null){

                                    data.add(str);
                                }

                                txt.close();

                              System.out.println("List  of   incomplete   projects !!");
                              for (String element : data){
                                  if (element.contains("No")){
                                      System.out.println(element);
                                  }

                                  else{
                                      System.out.println("No outstanding projects !!");
                                  }

                                }

                                break;

                            }catch (Exception e){

                                System.out.println("error occured");
                            }

                    } else if (choice == 6 ) {


                        while(true)

                            try{
                                BufferedReader txt = new BufferedReader(new FileReader("projects.txt"));
                                String str;
                                ArrayList<String> data = new ArrayList<String>();
                                while((str = txt .readLine()) != null){

                                    data.add(str);
                                }

                                txt.close();

                                System.out.println("List  of   Complete   projects !!");
                                for (String element : data){
                                    if (element.contains("Yes")){
                                        System.out.println(element);
                                    }

                                    System.out.println("There's no complete projects !!");

                                }

                                break;

                            }catch (Exception e){

                                System.out.println("error occured");
                            }

                       } else if (choice == 7) {

                        int number = 0;
                        while(true)

                            try{
                                BufferedReader txt = new BufferedReader(new FileReader("projects.txt"));
                                String str;
                                ArrayList<String> data = new ArrayList<String>();
                                while((str = txt .readLine()) != null){

                                    data.add(str);
                                }

                                txt.close();

                                // String lines = "";
                                // int lineNo = 0;
                                System.out.println("enter index number of the project :");
                                number = input.nextInt();
                                number = number-1;
                                input.nextLine();

                                String temp = data.get(number);
                                temp = temp.toString();
                                //  System.out.println(data);

                                List<String> temple = Arrays.asList(temp.split(","));
                                temple.set(6,"Yes");
                                String project = temple.toString();
                                project = project.replace("[","");
                                project = project.replace("]","");
                                //  temp = temp.replace("No",due);
                                data.set(number,project);
                                //   System.out.println(data.size());
                                FileWriter writers = new FileWriter("projects.txt");
                                FileWriter writerLine = new FileWriter("projects.txt",true);
                                for(int index = 0; index<data.size();index++) {
                                    if (index > 0) {
                                        writerLine.write(data.get(index)+"\n");
                                    } else {
                                        writers.write(data.get(index)+"\n");
                                    }
                                }
                                //  writers.write(data);

                                writers.close();
                                writerLine.close();

                                double difference = totalFee - amountPaidDate;

                                if(difference == 0){

                                    System.out.println("No need to generate an invoice\n");
                                }

                                else if(difference > 0){

                                    System.out.println("Customer owes : "+difference+"\n");

                                }

                                else if(difference < 0){

                                    System.out.println("Customer's change is  : "+difference+"\n");

                                }

                                break;

                            }catch (Exception e){

                                System.out.println("incorrect format");
                            }



                    } else if (choice== 8) {
                        try {
                            for (int i = 0; i < ProjectArray.size(); i++) {

                                FileWriter myWriter = new FileWriter(
                                        "projects.txt",true);
                                myWriter.write(ProjectArray.get(i).projectNumber + "," + ProjectArray.get(i).projectName + ","
                                        + ProjectArray.get(i).buildingType + "," + ProjectArray.get(i).physicalAddress + ","
                                        + ProjectArray.get(i).amountPaid + "," + ProjectArray.get(i).deadline + ","
                                        + ProjectArray.get(i).projectCompleted + ","
                                        + ProjectArray.get(i).Architect.name + "," + ProjectArray.get(i).Architect.surname + " ,"
                                        + ProjectArray.get(i).Architect.telephoneNumber + ","
                                        + ProjectArray.get(i).Architect.emailAddress + ","
                                        + ProjectArray.get(i).Architect.physicalAddress + "," + ProjectArray.get(i).Customer.name
                                        + "," + ProjectArray.get(i).Customer.surname + ","
                                        + ProjectArray.get(i).Customer.telephoneNumber + ","
                                        + ProjectArray.get(i).Customer.emailAddress + ","
                                        + ProjectArray.get(i).Customer.physicalAddress + "," + ProjectArray.get(i).Contractor.name
                                        + "," + ProjectArray.get(i).Contractor.surname + ","
                                        + ProjectArray.get(i).Contractor.telephoneNumber + ","
                                        + ProjectArray.get(i).Contractor.emailAddress + ","
                                        + ProjectArray.get(i).Contractor.physicalAddress + "\n");
                                myWriter.close();
                                System.out.println("Successfully wrote to the file.");
                            }
                        } catch (IOException e) {
                            System.out.println("An error occurred.");
                            e.printStackTrace();
                        }
                    }
                    else if(choice == 9){
                        System.out.println("bye bye !!!!!!!!!!!");
                        System.exit(0);
                    }
                }
              }
       }


