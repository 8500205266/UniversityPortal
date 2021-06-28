package com.example.demo.model;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Response
{
    private String reponseStatus;
    private String responseCode;
    private Object object;
}
