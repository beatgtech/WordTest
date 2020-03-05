package com.sen.wordtest;

import org.junit.Assert;
import org.junit.Test;

public class WordTestTest {

    @Test
    public void testStage1_1() {
        Assert.assertEquals("i like ice cream and man go\n", WordTest.stage1Method("ilikeicecreamandmango"));
    }

    @Test
    public void testStage1_2() {
        Assert.assertEquals("i like sam sung mobile\ni like samsung mobile\n", WordTest.stage1Method("ilikesamsungmobile"));
    }

    @Test
    public void testStage1_3() {
        Assert.assertEquals("", WordTest.stage1Method(""));
    }

    @Test
    public void testStage1_4() {
        Assert.assertEquals("", WordTest.stage1Method(null));
    }

    @Test
    public void testStage1_5() {
        Assert.assertEquals("", WordTest.stage1Method("THISISATEST"));
    }

    @Test
    public void testStage1_6() {
        Assert.assertEquals("", WordTest.stage1Method("thisisatest"));
    }

    @Test
    public void testStage1_7() {
        Assert.assertEquals("i\n", WordTest.stage1Method("i"));
    }

    @Test
    public void testStage2_1() {
        Assert.assertEquals("", WordTest.stage2Method("asdfasd", new String[]{}));
    }

    @Test
    public void testStage2_2() {
        Assert.assertEquals("", WordTest.stage2Method("asdfasdf", null));
    }

    @Test
    public void testStage2_3() {
        Assert.assertEquals("this is a test\n", WordTest.stage2Method("thisisatest", new String[]{"is", "this", "a", "test", "good", "score"}));
    }

    @Test
    public void testStage2_4() {
        Assert.assertEquals("", WordTest.stage2Method("", new String[]{"is", "this", "a", "test", "good", "score"}));
    }

    @Test
    public void testStage2_5() {
        Assert.assertEquals("", WordTest.stage2Method(null, new String[]{"is", "this", "a", "test", "good", "score"}));
    }

    @Test
    public void testStage3_1() {
        Assert.assertEquals("", WordTest.stage3Method("asdfasd", new String[]{}));
    }

    @Test
    public void testStage3_2() {
        Assert.assertEquals("", WordTest.stage3Method("asdfasdf", null));
    }

    @Test
    public void testStage3_3() {
        Assert.assertEquals("this is a test\n", WordTest.stage3Method("thisisatest", new String[]{"is", "this", "a", "test", "good", "score"}));
    }

    @Test
    public void testStage3_4() {
        Assert.assertEquals("", WordTest.stage3Method("", new String[]{"is", "this", "a", "test", "good", "score"}));
    }

    @Test
    public void testStage3_5() {
        Assert.assertEquals("", WordTest.stage3Method(null, new String[]{"is", "this", "a", "test", "good", "score"}));
    }
}
