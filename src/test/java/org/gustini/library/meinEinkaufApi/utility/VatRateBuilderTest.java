package org.gustini.library.meinEinkaufApi.utility;

import org.gustini.library.meinEinkaufApi.objects.enums.CountryEnum;
import org.gustini.library.meinEinkaufApi.objects.enums.VatRate;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * VatRateBuilderTest is used to test the functionality of the VatRateBuilder class.
 * It focuses specifically on testing the getVatRateFromVatRateValue method, ensuring that the method correctly retrieves
 * the VatRate enumeration value that corresponds to a given CountryEnum and VAT rate percentage value.
 */
public class VatRateBuilderTest {
    
    @Test
    public void testGetVatRateFromVatRateValue_GermanyStandardRate() throws IOException {
        Optional<VatRate> result = VatRateBuilder.getVatRateFromVatRateValue(CountryEnum.DE, 19.0);
        assertTrue(result.isPresent());
        assertEquals(VatRate.standard, result.get());
    }
    
    @Test
    public void testGetVatRateFromVatRateValue_GermanyReducedRate() throws IOException {
        Optional<VatRate> result = VatRateBuilder.getVatRateFromVatRateValue(CountryEnum.DE, 7.0);
        assertTrue(result.isPresent());
        assertEquals(VatRate.reduced, result.get());
    }
    
    @Test
    public void testGetVatRateFromVatRateValue_SwitzerlandStandardRate() throws IOException {
        Optional<VatRate> result = VatRateBuilder.getVatRateFromVatRateValue(CountryEnum.CH, 7.7);
        assertTrue(result.isPresent());
        assertEquals(VatRate.standard, result.get());
    }
    
    @Test
    public void testGetVatRateFromVatRateValue_SwitzerlandReducedRate() throws IOException {
        Optional<VatRate> result = VatRateBuilder.getVatRateFromVatRateValue(CountryEnum.CH, 2.5);
        assertTrue(result.isPresent());
        assertEquals(VatRate.reduced, result.get());
    }
    
    @Test
    public void testGetVatRateFromVatRateValue_NonExistentRate() throws IOException {
        Optional<VatRate> result = VatRateBuilder.getVatRateFromVatRateValue(CountryEnum.CH, 5.0);
        assertTrue(result.isEmpty());
    }

}