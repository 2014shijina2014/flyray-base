package me.flyray.rest.utiltest;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;
import me.flyray.rest.util.MailUtil;

public class MailUtilTest {

	@Test
	public void testSendMail() {
		assertEquals(MailUtil.sendMail(), "send email");
	}
}
