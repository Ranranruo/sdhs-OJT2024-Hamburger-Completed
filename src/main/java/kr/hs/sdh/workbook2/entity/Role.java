package kr.hs.sdh.workbook2.entity;

public class Role {
    private String id;
    private String code;

    public Role(String id, String code) {
        this.id = id;
        this.code = code;
    }

    public Role() {
    }

    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
