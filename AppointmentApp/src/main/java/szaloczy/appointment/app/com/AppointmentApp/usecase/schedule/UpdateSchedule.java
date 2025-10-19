package szaloczy.appointment.app.com.AppointmentApp.usecase.schedule;

import szaloczy.appointment.app.com.AppointmentApp.domain.Schedule;
import szaloczy.appointment.app.com.AppointmentApp.usecase.base.UseCase;

public class UpdateSchedule extends UseCase<Schedule, Boolean> {
    @Override
    public Boolean execute(Schedule input) {
        return false;
    }
}
