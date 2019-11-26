package com.leh.monitor_tuning.chapter3_btrace.btracescripts;

import com.sun.btrace.AnyType;
import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.*;


/**
 * 拦截普通方法
 */
@BTrace
public class PrintArgSimple {


    @OnMethod(
            clazz = "com.leh.monitor_tuning.chapter3_btrace.BtraceController",
            method = "arg1",
            location = @Location(Kind.ENTRY)
    )
    public static void anyRead(@ProbeClassName String pcn, @ProbeMethodName String pmn, AnyType[] args) {
        BTraceUtils.printArray(args);
        BTraceUtils.println(pcn + "," + pmn);
        BTraceUtils.println();
    }
}
