package com.example.app.detect;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

public class DeadLockTest {
	public static void main(String[] args) {
		
		ThreadMXBean bean=ManagementFactory.getThreadMXBean();
		long[] threadIds=bean.findDeadlockedThreads();
		boolean isHavingDeadLock=threadIds!=null && threadIds.length>0;
		System.out.println("DeadLock FOund "+isHavingDeadLock);
	}

}
