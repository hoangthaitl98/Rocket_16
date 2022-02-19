package com.vtii.form;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountFormForCreating {
    private String email;
    private String username;
    private String fullname;
    private short departmentId;
    private short positionId;
}
