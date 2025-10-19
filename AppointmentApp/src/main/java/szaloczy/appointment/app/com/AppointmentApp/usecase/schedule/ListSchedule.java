package szaloczy.appointment.app.com.AppointmentApp.usecase.schedule;

import szaloczy.appointment.app.com.AppointmentApp.domain.Schedule;
import szaloczy.appointment.app.com.AppointmentApp.domain.User;
import szaloczy.appointment.app.com.AppointmentApp.usecase.base.UseCase;

import java.util.List;

public class ListSchedule extends UseCase<User, List<Schedule>> {
    @Override
    public List<Schedule> execute(User input) {
        return null;
    }
}
