package com.example.app;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.example.app.apis.ExternalCallTest;
import com.example.app.helper.CalculaterTest2WithParamterized;
import com.example.app.helper.CalculatorTest;

@RunWith(Suite.class)
@SuiteClasses({CalculatorTest.class,ExternalCallTest.class,CalculaterTest2WithParamterized.class})
public class AllTest {

}
