import Mode.ConsolePrint;
import Mode.Print;
import database.DoctorsRepository;
import database.PatientsRepository;
import model.Doctor;
import model.Patient;
import model.Specialization;
import model.TimeSlot;
import service.BookingService;
import service.DoctorService;
import service.PatientService;

import java.util.HashMap;

public class driver {
    public static void main(String[] args) throws CloneNotSupportedException {

        Print print = new ConsolePrint();
        DoctorsRepository doctorsRepository = new DoctorsRepository();
        PatientsRepository patientsRepository = new PatientsRepository();
        DoctorService doctorService = new DoctorService(print, doctorsRepository);
        PatientService patientService = new PatientService(print,patientsRepository);
        BookingService bookingService = new BookingService(print, doctorsRepository, patientsRepository);

        // Doctors
        Doctor doctorCurious = new Doctor(1, "curious",new HashMap<>(), Specialization.CARDIOLOGIST);
        Doctor doctorDreadful = new Doctor(2, "Dreadful",new HashMap<>(), Specialization.Dermatologist);
        Doctor doctorDaring = new Doctor(3, "Daring",new HashMap<>(), Specialization.Dermatologist);

        // Patients
        Patient patientA = new Patient(1, "PatientA");
        Patient patientB = new Patient(2, "PatientB");
        Patient patientC = new Patient(3, "PatientC");


        // Registering doctor
        doctorService.registerDoctor(doctorCurious);
        doctorService.registerDoctor(doctorDreadful);
        // Add invalid Availability
        doctorService.addAvailability(doctorCurious.getDoctorId(), new TimeSlot("9:30","10:30"));
        // Add Valid Availabilities 9:30-10:00, 12:30-13:00, 16:00-16:30
        doctorService.addAvailability(doctorCurious.getDoctorId(), new TimeSlot("9:30","10:00"));
        doctorService.addAvailability(doctorCurious.getDoctorId(), new TimeSlot("12:30","13:00"));
        doctorService.addAvailability(doctorCurious.getDoctorId(), new TimeSlot("16:00","16:30"));
        doctorService.addAvailability(doctorDreadful.getDoctorId(), new TimeSlot("12:30","13:00"));
        doctorService.addAvailability(doctorDreadful.getDoctorId(), new TimeSlot("13:07","13:37"));

        doctorService.showAvailableSlotsBySpeciality(Specialization.CARDIOLOGIST);

        patientService.registerPatient(patientA);
        patientService.registerPatient(patientB);
        patientService.registerPatient(patientC);

        bookingService.bookAppointment(patientA,doctorCurious,"12:30");

        doctorService.showAvailableSlotsBySpeciality(Specialization.CARDIOLOGIST);

        bookingService.bookAppointment(patientB,doctorCurious,"12:30");
        bookingService.bookAppointment(patientC,doctorCurious,"12:30");

        bookingService.ShowBookedAppointments();

        bookingService.cancelBooking(1);

        doctorService.showAvailableSlotsBySpeciality(Specialization.CARDIOLOGIST);

        bookingService.ShowBookedAppointments();

        bookingService.cancelBooking(2);

        bookingService.ShowBookedAppointments();

        bookingService.bookAppointment(patientC,doctorDreadful,"13:07");

       // bookingService.bookAppointment(patientC,doctorCurious,"13:07");

        doctorService.showAvailableSlotsBySpeciality(Specialization.Dermatologist);

        bookingService.cancelBooking(1);

    }
}
