package com.hnaprojects.testswipe.data;

import android.support.test.filters.SmallTest;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertEquals;

/**
 * Created by humayun on 4/21/2017.
 */

@RunWith(AndroidJUnit4.class)
@SmallTest
public class TestPracticeInstrumentationTest {

//    @Rule
//    public ActivityTestRule mActivityRule = new ActivityTestRule<>(
//            TestPractice.class);

    @Test
    public void sayHello(){
        int a = 5;
        int c = 5;

        assertEquals("X should be equal", a, c);
    }
}
