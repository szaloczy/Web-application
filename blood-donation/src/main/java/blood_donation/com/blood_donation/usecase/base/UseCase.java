package blood_donation.com.blood_donation.usecase.base;

public abstract class UseCase<I,O>{
    public abstract O execute(I input);
}
