package webshop.shopapi.enums;


public enum OrderStatusEnum implements CodeEnum {
    CEKA_POTVRDU(0, "New OrderMain"),
    POTVRDJENO(1, "Finished"),
    ODBIJENO(2, "Canceled")
    ;

    private  int code;
    private String msg;

    OrderStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public Integer getCode() {
        return code;
    }
}
