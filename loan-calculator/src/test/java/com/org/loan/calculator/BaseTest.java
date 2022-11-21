package com.org.loan.calculator;

import org.mockito.MockitoAnnotations;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class BaseTest extends AbstractTestNGSpringContextTests {

    @BeforeClass
    public void baseSetUp(){
        MockitoAnnotations.initMocks(this);
    }

    protected Object mockPrivateMethod(Object target, String methodName, Object[] parameterValues, Class... parameterTypes) throws Exception {
        Method method = target.getClass().getDeclaredMethod(methodName,parameterTypes);
        method.setAccessible(true);
        return method.invoke(target,parameterValues);
    }

    protected void mockPrivateMethodThrowException(Object target, String methodName,Class throwableClass, Object[] parameterValues, Class... parameterTypes) throws Exception {
        Method method = target.getClass().getDeclaredMethod(methodName,parameterTypes);
        method.setAccessible(true);
        final String[] errorMsg =  new String[1];
        Assert.assertThrows(throwableClass, () -> {
            try {
                method.invoke(target, parameterValues);
            }catch (InvocationTargetException e){
                throw e.getTargetException();
            }
        });
    }

    protected void mockPrivateMethodThrowException(Object target, String methodName,Exception exceptException, Object[] parameterValues, Class... parameterTypes) throws Exception {
        Method method = target.getClass().getDeclaredMethod(methodName,parameterTypes);
        method.setAccessible(true);
        final String[] errorMsg =  new String[1];
        Assert.assertThrows(exceptException.getClass(), () -> {
            try {
                method.invoke(target, parameterValues);
            }catch (InvocationTargetException e){
                errorMsg[0] =  e.getTargetException().getMessage();
                throw e.getTargetException();
            }
        });
        Assert.assertEquals(errorMsg[0], exceptException.getMessage());
    }
}
