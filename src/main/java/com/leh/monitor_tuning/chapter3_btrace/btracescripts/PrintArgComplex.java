package com.leh.monitor_tuning.chapter3_btrace.btracescripts;

import com.leh.monitor_tuning.chapter2_jvm.User;
import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.*;

import java.lang.reflect.Field;

@BTrace
public class PrintArgComplex {
	
	
	@OnMethod(
	        clazz="com.leh.monitor_tuning.chapter3_btrace.BtraceController",
	        method="arg2",
	        location=@Location(Kind.ENTRY)
	)
	public static void anyRead(@ProbeClassName String pcn, @ProbeMethodName String pmn, User user) {
		//print all fields
		BTraceUtils.printFields(user);
		//print one field
		Field filed2 = BTraceUtils.field("com.leh.monitor_tuning.chapter2_jvm.User", "name");
		BTraceUtils.println(BTraceUtils.get(filed2, user));
		BTraceUtils.println(pcn+","+pmn);
		BTraceUtils.println();
    }
}
