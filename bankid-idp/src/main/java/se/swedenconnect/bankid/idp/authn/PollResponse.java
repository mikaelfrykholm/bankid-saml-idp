package se.swedenconnect.bankid.idp.authn;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PollResponse {
    public enum Status {
        IN_PROGRESS,
        ERROR,
        COMPLETE
    }

    private Status status;

    private String qrCode;
}