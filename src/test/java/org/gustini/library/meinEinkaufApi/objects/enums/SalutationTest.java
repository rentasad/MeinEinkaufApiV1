package org.gustini.library.meinEinkaufApi.objects.enums;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.gustini.library.meinEinkaufApi.utility.JsonBuilder;
import org.junit.jupiter.api.Test;

public class SalutationTest {

	@Test
	public void testToString() {
		String anredeString = Salutation.NOTHING.toString();
		assertTrue(anredeString.equals(""));
	}
	@Test
	public void serializeSalutationNothing() throws Exception {
		final String COMPARE_VALUE = "\"\"";
		String jsonValue = JsonBuilder.getJsonStringFromObject(Salutation.NOTHING);
		System.out.println(jsonValue);
		assertEquals(jsonValue, COMPARE_VALUE);
	}
	@Test
	public void serializeSalutationHerr() throws Exception {
		final String COMPARE_VALUE = "\"Herr\""; 
		String jsonValue = JsonBuilder.getJsonStringFromObject(Salutation.Herr);
		System.out.println(jsonValue);
		assertEquals(jsonValue,COMPARE_VALUE);
	}
	@Test
	public void serializeSalutationFrau() throws Exception {
		final String COMPARE_VALUE = "\"Frau\"";
		String jsonValue = JsonBuilder.getJsonStringFromObject(Salutation.Frau).trim();
		assertEquals(jsonValue,COMPARE_VALUE);
	}

}
