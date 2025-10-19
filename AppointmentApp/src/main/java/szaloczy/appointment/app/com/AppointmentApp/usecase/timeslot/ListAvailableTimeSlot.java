package szaloczy.appointment.app.com.AppointmentApp.usecase.timeslot;

import szaloczy.appointment.app.com.AppointmentApp.domain.TimeSlot;
import szaloczy.appointment.app.com.AppointmentApp.usecase.base.UseCase;

import java.lang.module.ModuleDescriptor;
import java.util.List;

public class ListAvailableTimeSlot extends UseCase<ModuleDescriptor.Provides, List<TimeSlot>> {
    @Override
    public List<TimeSlot> execute(ModuleDescriptor.Provides input) {
        return null;
    }
}
