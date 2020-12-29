package com.jaya.test.conversao.domain;

import lombok.Data;

import javax.persistence.Id;
import java.io.Serializable;

@Data
public class User implements Serializable {
    @Id
    private Long id;
}
