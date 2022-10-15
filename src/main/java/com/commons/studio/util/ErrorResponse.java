package com.commons.studio.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "error")
@AllArgsConstructor
@Getter @Setter
public class ErrorResponse {
    private String message;
    private List<String> details;

}
