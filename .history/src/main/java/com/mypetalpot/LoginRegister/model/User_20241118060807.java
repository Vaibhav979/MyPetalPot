package com.mypetalpot.LoginRegister.model;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long id;
    private String username;
    private String password;
    private String phonenumber;
}
