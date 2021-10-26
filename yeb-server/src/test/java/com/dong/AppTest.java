package com.dong;

import static org.junit.Assert.assertTrue;

import com.dong.server.entity.TMenu;
import com.dong.server.mapper.TMenuMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Unit test for simple App.
 */
@Component
public class AppTest 
{
    @Autowired
    private  TMenuMapper mapper;

    @Test
    public void shouldAnswerWithTrue()
    {
        System.out.println(mapper.getMenuByAdminId(1)==null?1:0);
    }
}
