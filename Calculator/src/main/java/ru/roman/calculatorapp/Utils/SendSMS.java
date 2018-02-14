package ru.roman.calculatorapp.Utils;

import android.telephony.SmsManager;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Roman on 13.02.2018.
 */

public class SendSMS {

    private final String SEND_SMS_LOG = "send_sms_log";

    public SendSMS(String textSms) {
        final String telOleg = "+79221814534";
        final String telMoy = "+79045458632";

        SmsManager smsManager = SmsManager.getDefault();

        ArrayList<String> messageArray = smsManager.divideMessage(textSms);
        Log.d(SEND_SMS_LOG, "Отправка СМС: " + messageArray.size());
        Log.d(SEND_SMS_LOG, "Длина смс: " + String.valueOf(textSms.length()));
        Log.d(SEND_SMS_LOG, "Сообщение: " + textSms);

        smsManager.sendTextMessage(telOleg, null, textSms, null, null);
    }
}
