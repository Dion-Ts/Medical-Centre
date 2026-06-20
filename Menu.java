import java.util.List;
import java.util.Scanner;


public class Menu{
    private List<Doctor> doctors;
    private List<Patient> patients;
    private List<Exam> exams;
    private List<Appointment> appointments;
    private DataStorage storage;
    private Scanner sc;


    Menu(List<Doctor> doctors, List<Patient> patients, List<Exam> exams, List<Appointment> appointments){
        this.doctors = doctors;
        this.patients = patients;
        this.exams = exams;
        this.appointments = appointments;
        sc = new Scanner(System.in);

    }

    public void start(){
        MainMenu();
    }

    // ------------------------------------ Main Menu --------------------------------- //
    private void MainMenu(){
        int choise;
        

        do{
            System.out.println("\n1. Ιατροί");
            System.out.println("2. Ασθενείς");
            System.out.println("3. Εξετάσεις");
            System.out.println("4. Ραντεβού");
            System.out.println("5. Στατιστικά");
            System.out.println("0. Έξοδος");
            System.out.print("Please select a choise: ");


            choise = readInt();
            switch(choise){
            case 1:
                doctorsMenu();
                break;
            case 2:
                 patientMenu();
                 break;
            case 3:
                examsMenu();
                break;
            case 4:
                appointMenu();
                break;
            case 5:
                statistMenu();
                break;
            case 0:
                System.out.println("Exiting program");
                break;
            default:
                System.out.println("Invalid choise");
            }
        }while(choise!=0);
    
        }

        // ---------------------------- Finish Main Menu ------------------------------- //

        // ----------------------- Doctors Menu ------------------------ //

        private void doctorsMenu(){
            int choise;
            System.out.println("---------------------");
            System.out.println();
            System.out.println("Doctors Menu");
            do{
                System.out.println("1. Add Doctor");
                System.out.println("2. Show all Doctors");
                System.out.println("3. Show Doctor Details");
                System.out.println("4. Doctor Appointment");
                System.out.println("0. Return to Main Menu");
                
                choise = readInt();
                switch (choise) {
                    case 1:
                        addDoctor();
                        break;
                    case 2:
                        showDoctors();   // Ayto mporw na to kanw gia ola !
                        break;
                    case 3:
                        showDocDetails();
                        break;
                    default:
                        break;
                }
            }while(choise!=0);

            
        }
        // ----------------------- Finish Doctors Menu ------------------ //


        

        private void patientMenu(){
            System.out.println("Patient Menu");
        }

        private void examsMenu(){
            System.out.println("Exams Menu");
        }

        private void appointMenu(){
            System.out.println("Appointments Menu");
        }

        private void statistMenu(){
            System.out.println("Stattistics Menu");
        }
   


        // ------------------------- Extras ---------------------------- //

        private int readInt(){ 
            while(true){
                try{
                    return Integer.parseInt(sc.nextLine());
                }catch(Exception e){
                    System.out.println("Invalid input. Please try again.");
                }
            }

        }

        // --------------------- add Doctors -------------------------- //
        private void addDoctor(){
                int counter = doctors.size() +1; // ayto einai lathos. Prepei na mpei sto telos.

                System.out.println("----------------------------");
                System.out.println("Give name of the Doctor");
                String name = sc.nextLine();

                System.out.println("Give Phone Number");
                int phone = sc.nextInt();

                System.out.println("Give Years of Expirience");
                int yearsOfExp = sc.nextInt();

                System.out.println("Select Speciality");
                System.out.println("---------------------");

                System.out.println("1. Cardiology"); // Des tis swstes idikotites.
                System.out.println("2. Radiology");
                System.out.println("3. Microbiology");
                System.out.println("4. Neurology");
                String speciality = "";
                int choise = sc.nextInt();

                switch (choise) {
                    case 1:
                        speciality = "Cardiology";
                        break;
                    case 2:
                        speciality = "Radiology";
                        break;
                    case 3:
                        speciality = "Microbiology";
                        break;
                    case 4: 
                        speciality = "Neurology";
                        break;
                    default:
                        System.out.println("Invalid Choise");
                        return;
                }
                Doctor d = new Doctor(counter, name, phone, speciality, yearsOfExp);
                doctors.add(d);
                storage = new DataStorage();
                storage.SaveDocs(doctors);


            }

            private void showDoctors(){
                System.out.println("Hello");
            }

            private void showDocDetails(){
                System.out.println("Doc Details");
            }
        //------------------------- Extras -----------------------------//
}
