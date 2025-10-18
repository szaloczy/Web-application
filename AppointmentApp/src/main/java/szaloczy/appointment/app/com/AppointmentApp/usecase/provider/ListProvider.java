package szaloczy.appointment.app.com.AppointmentApp.usecase.provider;

import szaloczy.appointment.app.com.AppointmentApp.domain.Provider;
import szaloczy.appointment.app.com.AppointmentApp.domain.User;
import szaloczy.appointment.app.com.AppointmentApp.usecase.base.UseCase;

import java.util.List;

public class ListProvider extends UseCase<User, List<Provider>> {

    @Override
    public List<Provider> execute(User input) {
        return null;
    }
}
