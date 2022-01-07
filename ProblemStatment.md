# Machine Coding Round: FLIPMED

** Link: https://docs.google.com/document/d/e/2PACX-1vSbAgRng_p5UOJVuTraFgvLRE9YtELDZXrMQbcUslIBLLvK7yEq5ncKIRC7Zz1hk5PzGA-F_suQMYcn/pub


### Description:

We are required to build an app that lets patients connect to doctors and book appointments. The day is divided into time slots of 30 mins each, starting from 9 am to 9 pm. Doctors can login to the portal and declare their availability for the given day in terms of slots.  Patients can book appointments/ cancel existing appointments. For simplicity you can assume that the doctors’ availability is declared for that particular day only.


### Features:

1. A new doctor should be able to register, and mention his/her speciality among (Cardiologist, Dermatologist, Orthopedic, General Physician)
2. A doctor should be able to declare his/her availability in each slot for the day. For example, the slots will be of 30 mins like 9am-9.30am, 9.30am-10am..
3. Patients should be able to register. Patients should be able to search available slots based on speciality.  
4. The slots should be displayed in a ranked fashion. Default ranking strategy should be to rank by start time. But we should be able to plugin more strategies like Doctor’s rating etc in future.
5. Patients should be able to book appointments with a doctor for an available slot.A patient can book multiple appointments in a day.  A patient cannot book two appointments with two different doctors in the same time slot.
6. Patients can also cancel an appointment, in which case that slot becomes available for someone else to book.
7. Build a waitlist feature:
   * If the patient wishes to book a slot for a particular doctor that is already booked, then add this patient to the waitlist.
   * If the patient with whom the appointment was booked originally cancels the appointment, then the first in the waitlist gets the appointment.
8. A patient/doctor should be able to view his/her booked appointments for the day.

### Bonus requirements:

Trending Doctor: Maintain at any point of time which doctor has the most appointments.
Different ranking strategy - use rating of doctor as a strategy to display a list of available doctors for a given specialization.

### Expectations and guidelines:
Time: 120mins
You are allowed to access the internet only for syntax purposes.
You are free to use any language of your choice.
Do not use any external libraries. All of the code should be your own.
Implement the code using only in-memory data structures or basic file handling. The use of databases is not allowed.
Do not create any UI for the application.
Write a driver class for demo purpose which will execute all the commands at one place in the code and test cases.
Create the sample data yourself. You can put it into a file, test cases or the main driver program itself.
Make sure that you can execute your code and show that it is working.
Please prioritize code compilation, execution and completion.
Make sure that code is functionally correct.
Work on the expected output first and then add good-to-have features of your own.
Code should be modular and readable.
Separation of concern should be addressed.
Code should easily accommodate new requirements with minimal changes.
Code should be modular and have the correct abstractions.
Code should be legible, readable, and DRY.
Code should be easily testable.
Please focus on the Bonus requirement only after ensuring the required features are complete and demoable. The bonus portion would not be evaluated if any of the required functionality is missing

### Sample Test cases:

The input/output need not be exactly in this format but the functionality should remain intact


i: input  <br />
o: output  <br />
i:registerDoc -> Curious-> Cardiologist <br />
o: Welcome Dr. Curious !! <br />
i: markDocAvail: Curious 9:30-10:30 <br />
o: Sorry Dr. Curious slots are 30 mins only <br />
i: markDocAvail: Curious 9:30-10:00, 12:30-13:00, 16:00-16:30 <br />
o: Done Doc! <br />
i:registerDoc -> Dreadful-> Dermatologist <br />
o: Welcome Dr. Dreadful !! <br />
i: markDocAvail: Dreadful 9:30-10:00, 12:30-13:00, 16:00-16:30 <br />
o: Done Doc! <br />
i: showAvailByspeciality: Cardiologist <br />
o: Dr.Curious: (9:30-10:00) <br />
o: Dr.Curious: (12:30-13:00) <br />
o: Dr.Curious: (16:00-16:30) <br />
i: registerPatient ->PatientA <br />
o: PatientA registered successfully. <br />
i:  bookAppointment: (PatientA, Dr.Curious, 12:30) <br />
O: Booked. Booking id: 1234 <br />
i:showAvailByspeciality: Cardiologist <br />
o: Dr.Curious: (9:30-10:00) <br />
o: Dr.Curious: (16:00-16:30) <br />
i: cancelBookingId: 1234 <br />
o: Booking Cancelled <br />
i: showAvailByspeciality: Cardiologist <br />
o: Dr.Curious: (9:30-10:00) <br />
o: Dr.Curious: (12:30-13:00) <br />
o: Dr.Curious: (16:00-16:30) <br />
i: bookAppointment: (PatientB, Dr.Curious, 12:30) <br />
o: Booked. Booking id: 5678 <br />
i:registerDoc -> Daring-> Dermatologist <br />
o: Welcome Dr. Daring !! <br />
i: markDocAvail: Daring 11:30-12:00 14:00-14:30 <br />
o: Done Doc! <br />
i: showAvailByspeciality: Dermatologist <br />
o: Dr.Dreadful: (9:30-10:00) <br />
o: Dr.Daring: (11:30-12:00) <br />
o: Dr.Dreadful: (12:30-13:00) <br />
o:Dr.Daring:(14:00-14:30) <br />
o: Dr.Dreadful: (16:00-16:30) <br />
i: bookAppointment: (PatientF, Dr.Daring, 11:30) <br />
o: Booked. Booking id: 5587 <br />
i: bookAppointment: (PatientA, Dr.Curious, 12:30) <br />
o: Booked. Booking id: 5678 <br />
i: bookAppointment: (PatientF, Dr.Curious, 9:30) <br />
o: Booked. Booking id: 5280 <br />
i: bookAppointment: (PatientC, Dr.Curious, 16:00) <br />
o: Booked. Booking id: 5701 <br />
i: showAvailByspeciality: Cardiologist <br />
o: Dr.Curious: No slots available <br />
i: bookAppointment: (PatientD, Dr.Curious, 16:00, waitlist=true) <br />
o: Added to the waitlist. Booking id: 5710 <br />
i: cancelBookingId: 5701 <br />
o: Booking Cancelled <br />
o: Booking confirmed for Booking id: 5710 <br />
i: showAppointmentsBooked(PatientF) <br />
o: Booking id: 5280, Dr Curious 9:30 <br />
o: Booking id: 5587 , Dr Daring 11:30 <br />
