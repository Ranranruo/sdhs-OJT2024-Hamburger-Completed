package kr.hs.sdh.workbook2.dto;

public class ResponseDTO<T> {
    private int code;
    private String message;
    private T data;
    private String requestURI;

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public String getRequestURI() {
        return requestURI;
    }

    public void setRequestURI(String requestURI) {
        this.requestURI = requestURI;
    }

    private String requestMethod;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    private ResponseDTO(int code, String message, T data,  String requestURI, String requestMethod) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.requestURI = requestURI;
        this.requestMethod = requestMethod;
    }

    public static class Builder<T> {
        private int code;
        private String message;
        private T data;
        private String requestURI;
        private String requestMethod;


        public Builder<T> code(int code) {
            this.code = code;
            return this;
        }

        public Builder<T> message(String message) {
            this.message = message;
            return this;
        }

        public Builder<T> data(T data) {
            this.data = data;
            return this;
        }

        public Builder<T> requestURI(String requestURI) {
            this.requestURI = requestURI;
            return this;
        }

        public Builder<T> requestMethod(String requestMethod) {
            this.requestMethod = requestMethod;
            return this;
        }

        public ResponseDTO<T> build() {
            return new ResponseDTO<T>(this.code, this.message, this.data, this.requestURI, this.requestMethod);
        }
    }

}
