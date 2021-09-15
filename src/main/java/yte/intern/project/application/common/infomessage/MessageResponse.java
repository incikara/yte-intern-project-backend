package yte.intern.project.application.common.infomessage;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MessageResponse {

    private final String message;
    private final MessageType messageType;
}
