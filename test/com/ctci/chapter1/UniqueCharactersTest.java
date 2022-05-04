package com.ctci.chapter1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UniqueCharactersTest {
    @Test
    public void testIsUnique() {
        UniqueCharacters uc = new UniqueCharacters();
        assertTrue(uc.isUnique("abcdef"));
        assertFalse(uc.isUnique("qwertyuiopq"));
        assertTrue(uc.isUnique("123456789AaBbCc!@#$%"));
        assertFalse(uc.isUnique("qwerty uiopq "));
    }
}
