package com.leh.monitor_tuning.chapter3_btrace.btracescripts;

import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.*;

@BTrace
public class PrintLine {
	
	@OnMethod(
	        clazz="com.leh.monitor_tuning.chapter3_btrace.BtraceController",
	        method="exception",
	        location=@Location(value=Kind.LINE, line=-1)
	)
	public static void anyRead(@ProbeClassName String pcn, @ProbeMethodName String pmn, int line) {
		BTraceUtils.println(pcn+","+pmn + "," +line);
		BTraceUtils.println();
    }
}
