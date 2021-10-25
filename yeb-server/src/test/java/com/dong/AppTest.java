package com.dong;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Value("${jwt.expiration}")
    private String expiration;
    @Test
    public void shouldAnswerWithTrue()
    {
        System.out.println(expiration);
//        Date date = new Date(new BigDecimal(System.currentTimeMillis()).add(new BigDecimal(expiration).multiply(new BigDecimal(1000))).longValue());
//        System.out.println(date);
    }
}
