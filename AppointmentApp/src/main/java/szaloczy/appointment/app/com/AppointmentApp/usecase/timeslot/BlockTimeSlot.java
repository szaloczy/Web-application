package szaloczy.appointment.app.com.AppointmentApp.usecase.timeslot;

import szaloczy.appointment.app.com.AppointmentApp.domain.TimeSlot;
import szaloczy.appointment.app.com.AppointmentApp.usecase.base.UseCase;

public class BlockTimeSlot extends UseCase<TimeSlot, Boolean> {
    @Override
    public Boolean execute(TimeSlot input) {
        return false;
    }
}
