package kr.hs.sdh.workbook2.entity;

import java.beans.ConstructorProperties;

public class SignIn {
    private final String id;
    private final String password;

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    @ConstructorProperties({
            "id",
            "password"
    })
    public SignIn(String id, String password) {
        this.id = id;
        this.password = password;
    }
}
