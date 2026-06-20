import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DataStorage {

    // ----------------------------- Patients ------------------------------- //

    public void savePatients(List<Patient> patients){
        try(PrintWriter pw = new PrintWriter(new FileWriter("patients.txt"))){
            for (var p : patients)
                pw.println(p.getPatientID() + "," +
                        p.getPatientName() + "," +
                    p.getPatientPhone() + "," +
                p.getEmail());

        }
        catch(IOException e){
            System.err.println("Error getting patient" + e.getMessage());
        }    
    }

    public List<Patient> loadPatients(){
        List<Patient> patients = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader("patients.txt"))){
            String line;
            while ((line = br.readLine()) != null){
                String[] part = line.split(",");
                int id = Integer.parseInt(part[0]);
                String name = part[1];
                int phone = Integer.parseInt(part[2]);
                String email = part[3];

                Patient p = new Patient(id, name, phone, email);
                patients.add(p);
            }
        }catch(FileNotFoundException e){
            System.err.println(e.getMessage());
        }
        catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return patients;
    }

    // ----------------------------- Doctors -------------------------------------- //

    public void SaveDocs(List<Doctor> doctors){
        try(PrintWriter pw = new PrintWriter(new FileWriter("doctors.txt"))){
            for(var d : doctors){
                pw.println(d.getDoctorID()+ "," +
                d.getDoctorName() + "," + 
                d.getDoctorPhone() + "," + 
                d.getSpeciality() + "," + d.getYearsOfExp());
            }
        }catch (IOException e) {
            System.err.println(e.getMessage());
        }
        System.out.println("Doctor saved...");
    }

    public List<Doctor> loadDoctors(){
        List<Doctor> docs = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader("doctors.txt"))){
            String line;
            while((line = br.readLine()) != null){
                String[] part = line.split(",");
                int id = Integer.parseInt(part[0]);
                String name = part[1];
                int phone = Integer.parseInt(part[2]);
                String speciality = part[3];
                int yearsOfExp = Integer.parseInt(part[4]);
                Doctor d = new Doctor(id, name, phone, speciality, yearsOfExp);
                docs.add(d);
            }
        }catch(FileNotFoundException e){
            System.err.println(e.getMessage());
        }
        catch (IOException e) {
            System.err.println(e.getMessage());
        }
        
        return docs;

    }

    // ----------------------------- Appointment ------------------------------ //

    public void SaveAppointment(List<Appointment> appointments){
        try(PrintWriter pw = new PrintWriter(new FileWriter("appointments.txt"))) {
            for (var a : appointments){
                pw.println(a.getAppointmentID() + "," +
                            a.getPatient().getPatientID() + "," +
                            a.getExam().getExamID() + "," +
                        a.getFastResults() + "," +
                    a.getExamDate());  
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public List<Appointment> loadAppointments(List<Patient> patients, List<Exam> exams){
        List<Appointment> appointments = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader("appointments.txt"))){
            String line;
            while((line = br.readLine()) != null){
                String[] part = line.split(",");
                int id = Integer.parseInt(part[0]);
                int pID = Integer.parseInt(part[1]);
                int eID = Integer.parseInt(part[2]);
                boolean fR = Boolean.parseBoolean(part[3]);
                LocalDate eDate = LocalDate.parse(part[4]);

                Patient findPatient = null;
                for(var p : patients){
                    if (p.getPatientID() == pID)
                        findPatient = p;
                    break;
                }
                Exam findExam = null;
                for(var e : exams){
                    if(e.getExamID()== eID)
                        findExam = e;
                    break;
                }
                Appointment a = new Appointment(id, findPatient, findExam, fR, eDate);
                appointments.add(a);
            }
        }catch(FileNotFoundException e){
            System.err.println(e.getMessage());
        }catch(IOException e){
            System.err.println(e.getMessage());
    }
    return appointments;    
}

// --------------------------------- Exams ---------------------------------------- //

    public void SaveExam(List<Exam> exams){
        try(PrintWriter pw = new PrintWriter(new FileWriter("exams.txt"))){
            for(var e : exams){
                String one = e.getExamID() + "," + e.getExamName() + "," +  e.getCategoryName() + "," ; 
                String two = e.getMaxSlotsPerDay() + "," + e.getCost() + "," + e.getDoctor().getDoctorID();
                
                if (e instanceof ImagingExamination)
                    pw.println(one + ((ImagingExamination) e).getMachineType() + two);
                else if (e instanceof MicrobiologicalExamination)
                    pw.println(one + ((MicrobiologicalExamination) e).getSampleType() + two);
                else if (e instanceof SpecializedExamination)
                    pw.println(one + ((SpecializedExamination) e).getDoctor().getSpeciality() + two);

            }
        }catch(IOException ex){
            System.err.println(ex.getMessage());
    }
}

    public List<Exam> LoadExam(List<Doctor> doctors){
        List<Exam> exams = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader("exams.txt"))){

            String line;
            while((line = br.readLine()) != null){
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                String categName = parts[2];
                String extra;
                int maxSlotsPerDay = Integer.parseInt(parts[4]);
                double cost = Double.parseDouble(parts[5]);
                int dID = Integer.parseInt(parts[6]);

            Doctor findDoc = null;
            for (var d : doctors){
                if(d.getDoctorID() == dID){
                    findDoc = d;
                    break;
                }
            }
            Exam e = null;
            if (categName.equals("Imaging")){
                extra = parts[3];
                e = new ImagingExamination(dID, name, categName, maxSlotsPerDay, extra, cost, findDoc);
            }
            else if(categName.equals("Microbiological")){
                extra = parts[3];
                e = new MicrobiologicalExamination(dID, name, categName, maxSlotsPerDay, extra, cost, findDoc);
            }
            else if(categName.equals("Specialized")){
                extra = parts[3];
                e = new SpecializedExamination(dID, name, categName, maxSlotsPerDay, cost, findDoc);
            }
            
            exams.add(e);
        }

        }catch(FileNotFoundException ex){
            System.err.println(ex.getMessage());
        }catch(IOException ex){
            System.err.println(ex.getMessage());
        }
         return exams;
    }
       

    }

