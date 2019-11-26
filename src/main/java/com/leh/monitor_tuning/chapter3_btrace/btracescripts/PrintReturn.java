package com.leh.monitor_tuning.chapter3_btrace.btracescripts;

import com.sun.btrace.AnyType;
import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.*;

/**
 * 拦截返回值
 */
@BTrace
public class PrintReturn {
	
	@OnMethod(
	        clazz="com.leh.monitor_tuning.chapter3_btrace.BtraceController",
	        method="arg1",
	        location=@Location(Kind.RETURN)
	)
	public static void anyRead(@ProbeClassName String pcn, @ProbeMethodName String pmn, @Return AnyType result) {
		BTraceUtils.println(pcn+","+pmn + "," + result);
		BTraceUtils.println();
    }
}
