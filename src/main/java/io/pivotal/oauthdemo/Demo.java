package io.pivotal.oauthdemo;

import lombok.Data;

import java.util.Date;

@Data
public class Demo {
    private String demoId;
    private Date created;
    private String message;
}
