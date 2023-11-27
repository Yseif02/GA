package edu.yu.cs.intro.ga;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorsTest {

    @Test
    void isValidAcquisition() {
        assertEquals(true, Validators.isValidAcquisition("referral"));
    }

    @Test
    void isValidPath() {
        assertEquals(true, Validators.isValidPath("abc/123.abc.html"));
    }
}