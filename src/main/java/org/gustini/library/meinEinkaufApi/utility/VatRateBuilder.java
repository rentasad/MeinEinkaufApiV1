/**
 * 
 */
package org.gustini.library.meinEinkaufApi.utility;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.gustini.library.meinEinkaufApi.objects.enums.CountryEnum;
import org.gustini.library.meinEinkaufApi.objects.enums.VatRate;

/**
 * Gustini GmbH (2019)
 * Creation: 04.07.2019
 * gustini.library.meinEinkaufApi
 * org.gustini.library.meinEinkaufApi.utility
 * 
 * @author Matthias Staud
 *
 *
 *         Description: Convert VatRate from Vatrate Value
 *
 */
public class VatRateBuilder
{

	/**
	 * Convert Contry and VatrateProcentValue to VatRateEnum
	 * 
	 * @param countryEnum
	 * @param vatRateProcentValue
	 * @return VatRate Enum 
	 */
    public static VatRate getVatRateFromVatRateValue(CountryEnum countryEnum, double vatRateProcentValue)
    {
        vatRateProcentValue = BigDecimal.valueOf(vatRateProcentValue).setScale(1, RoundingMode.HALF_UP).doubleValue();
        switch (countryEnum)
        {
            case CH:
                if (vatRateProcentValue == 2.4 || vatRateProcentValue == 2.5 || vatRateProcentValue == 2.6 || vatRateProcentValue == 3.7 || vatRateProcentValue == 3.8)
                {
                    return VatRate.reduced;
                } else if (vatRateProcentValue == 7.6 || vatRateProcentValue == 7.8 || vatRateProcentValue == 8|| vatRateProcentValue == 7.7)
                {
                    return VatRate.standard;
                } else if (vatRateProcentValue == 0)
                {
                    return VatRate.none;
                } else
                {
                    return null;
                }
            case DE:
                if (vatRateProcentValue == 16 || vatRateProcentValue == 19 || vatRateProcentValue == 15)
                {
                    return VatRate.standard;
                } else if (vatRateProcentValue == 7)
                {
                    return VatRate.reduced;
                } else if (vatRateProcentValue == 0)
                {
                    return VatRate.none;
                } else
                {
                    return null;
                }
            default:
                return null;
        }
    }

}
