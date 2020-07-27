package com.example.app.random;

import java.util.function.Supplier;

public class OTPUtil {
	public static void main(String[] args) {
		Supplier<String> generator=()->{
			String otp="";
			for(int i=0;i<=5;i++)
			otp=otp+String.valueOf((int)(Math.random()*10));
			return otp;
		};
		for(int i=0;i<5;i++)
		System.out.println(generator.get());
	}

}
