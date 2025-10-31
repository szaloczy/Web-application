package blood_donation.com.blood_donation.framework.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class APIResponse<T> {
    private boolean success;
    private T data;
    private String message;

    public APIResponse(boolean success, T data, String message) {
        this.success = success;
        this.data = data;
        this.message = message;
    }
}
