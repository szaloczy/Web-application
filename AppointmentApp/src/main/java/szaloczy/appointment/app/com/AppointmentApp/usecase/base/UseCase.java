package szaloczy.appointment.app.com.AppointmentApp.usecase.base;

public abstract class UseCase<I, O> {
    public abstract O execute(I input);
}
