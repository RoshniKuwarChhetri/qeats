package com.jsp.qeats.dto;

import com.jsp.qeats.entity.Role;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

    private Integer id;
    private String userName;
    private String eMail;
    private Role role;
}