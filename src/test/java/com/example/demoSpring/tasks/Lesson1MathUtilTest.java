package com.example.demoSpring.tasks;

import com.example.demoSpring.controller.Lesson1MathUtil;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Lesson1MathUtilTest {

    @Test
    public void min_test1(){
        assertEquals(1, Lesson1MathUtil.min(2,3));
    }

    @Test
    public void abs_test2(){
        assertEquals(5, Lesson1MathUtil.abs(-5));
    }

    @Test
    public void is_even_test1(){
        assertEquals(false, Lesson1MathUtil.isEven(7));
    }

    // to avoid failing from rounding doubles
    @Test
    public void double_test(){
        double a = 1.0;
        double b = 1.000000001;
        assertEquals(a, b, 0.0001);
    }
}
