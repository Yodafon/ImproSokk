package org.improsokk;

import org.junit.Test;

import static org.junit.Assert.*;

public class MainActivityTest {

    @Test
    public void onClick() {
        MainActivity mainActivity=new MainActivity();
        mainActivity.calculate(4, 10);
    }
}