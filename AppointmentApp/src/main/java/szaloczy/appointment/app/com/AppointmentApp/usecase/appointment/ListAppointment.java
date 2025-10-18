package szaloczy.appointment.app.com.AppointmentApp.usecase.appointment;

import szaloczy.appointment.app.com.AppointmentApp.domain.Appointment;
import szaloczy.appointment.app.com.AppointmentApp.domain.User;
import szaloczy.appointment.app.com.AppointmentApp.usecase.base.UseCase;

import java.util.List;

public class ListAppointment extends UseCase<User, List<Appointment>> {
    @Override
    public List<Appointment> execute(User input) {
        return null;
    }
}
