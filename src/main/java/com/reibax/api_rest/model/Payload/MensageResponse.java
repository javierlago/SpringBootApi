package com.reibax.api_rest.model.Payload;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
/*
* Clase utilizada para enviar mensajes de respuesta al cliente.
* Se utiliza para enviar mensajes de respuesta al cliente y tambien para enviar datos al cliente despues de una peticion.
* En este caso en el data metemos el objeto ClienteDto y el mensaje de respuesta se puede personalizar para cada peticion y describir de una
* manera mas clara lo que se esta enviando al cliente.
* */
@Data
@ToString
@Builder
public class MensageResponse {
    private String message;
    private Object data;

}
