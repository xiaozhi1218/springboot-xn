package com.mtl.system.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author Exrickx
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TokenUser implements Serializable{

    private String username;

    private List<String> permissions;

    private Boolean saveLogin;
}
