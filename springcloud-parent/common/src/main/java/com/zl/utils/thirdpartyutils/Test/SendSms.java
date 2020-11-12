package com.zl.utils.thirdpartyutils.Test;


import com.zl.utils.thirdpartyutils.component.SmsComponent;
import org.springframework.beans.factory.annotation.Autowired;

public class SendSms {

    @Autowired
    private static SmsComponent smsComponent;

    public static void main(String[] args) {
        smsComponent.sendSmsCode("17371354286", "3333");
    }
}
