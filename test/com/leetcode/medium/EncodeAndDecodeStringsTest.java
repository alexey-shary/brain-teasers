package com.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EncodeAndDecodeStringsTest {
    @Test
    public void testEncodeAndDecode() {
        EncodeAndDecodeStrings eads = new EncodeAndDecodeStrings();
        List<String> strs = Arrays.asList("leet", "code", "loves", "you");
        String encoded = eads.encode(strs);
        List<String> decoded = eads.decode(encoded);
        assertEquals(strs, decoded);

        strs = Arrays.asList("we","say",":","yes");
        encoded = eads.encode(strs);
        decoded = eads.decode(encoded);
        assertEquals(strs, decoded);

        strs = Arrays.asList("","","","");
        encoded = eads.encode(strs);
        System.out.println(encoded);
        decoded = eads.decode(encoded);
        assertEquals(strs, decoded);
    }
}