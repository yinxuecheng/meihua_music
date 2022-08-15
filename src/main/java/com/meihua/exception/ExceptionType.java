package com.meihua.exception;

public enum ExceptionType {

    INNER_ERROR(500,"系统内部错误"),
    BAD_REQUEST(400,"请求错误"),
    UNAUTHORIZED(401,"未登陆"),
    FORBIDDEN(403,"无权登陆"),
    NOT_FOUND(404,"未找到"),
    USER_NAME_DUPLICATE(40001001,"用户名重复"),
    USER_NOT_FOUND(40401002,"用户未存在"),
    USER_PASSWORD_NOT_MATCH(40401003,"用户名或密码错误"),
    USER_NOT_ENABLED(50001001,"用户未启用"),
    USER_LOCKED(50001002,"用户被锁定"),
    MUSIC_NOT_FOUND(40402001,"歌曲不存在")
    ;




    private final Integer code;

    private final String message;

    ExceptionType(Integer code, String message){
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
