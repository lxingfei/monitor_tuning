package com.leh.monitor_tuning.chapter3_btrace.btracescripts;
import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.BTrace;
import com.sun.btrace.annotations.OnMethod;
import com.sun.btrace.annotations.ProbeClassName;
import com.sun.btrace.annotations.ProbeMethodName;

/**
 * 拦截同名方法
 */
@BTrace
public class PrintSame {
	
	@OnMethod(
	        clazz="com.leh.monitor_tuning.chapter3_btrace.BtraceController",
	        method="same"
	)
	public static void anyRead(@ProbeClassName String pcn, @ProbeMethodName String pmn, String name) {
		BTraceUtils.println(pcn+","+pmn + "," + name);
		BTraceUtils.println();
    }
}
