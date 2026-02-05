package org.gustini.library.meinEinkaufApi.utility;

import org.gustini.library.meinEinkaufApi.objects.enums.CountryEnum;
import org.gustini.library.meinEinkaufApi.objects.enums.VatRate;

import java.io.FileNotFoundException;
import java.util.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.stream.Collectors;

public class VatRateBuilder
{

	private static Properties vatRatesProps = null;

	/**
     * Retrieves the VatRate enumeration value corresponding to the given country and VAT rate percentage value.
     *
     * @param countryEnum The country for which the VAT rate is queried.
     * @param vatRateProcentValue The VAT rate percentage value.
     * @return Optional<VatRate> The VatRate enumeration value if a match is found, otherwise an empty Optional.
     * @throws IOException If there is an error loading the VatRates.properties file.
     */
    public static Optional<VatRate> getVatRateFromVatRateValue(CountryEnum countryEnum, double vatRateProcentValue) throws IOException
    {
        if (vatRatesProps == null)

        {
            vatRatesProps = new Properties();
            vatRatesProps.load(VatRateBuilder.class.getClassLoader().getResourceAsStream("VatRates.properties"));
        }
		vatRateProcentValue = BigDecimal.valueOf(vatRateProcentValue)
										.setScale(1, RoundingMode.HALF_UP)
										.doubleValue();
		for (VatRate vatRate : VatRate.values())
		{
			String key = "vatRate." + countryEnum.name() + "." + vatRate.name();
			List<Double> vatRates = Arrays.stream(vatRatesProps.getProperty(key)
															   .split(","))
										  .map(Double::parseDouble)
										  .toList();
			if (vatRates.contains(vatRateProcentValue))
			{
				return Optional.of(vatRate);
			}
		}
		return Optional.empty();
	}
}