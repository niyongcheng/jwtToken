package com.herbalife.is.jwtdemo.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

@Slf4j
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Payload implements Serializable {
    //
    /*private String sub;
    private String name;
    private Integer iat;
    private Boolean admin;*/
    private String iss;

}
