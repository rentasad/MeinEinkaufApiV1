package org.gustini.library.meinEinkaufApi.objects.apiObjects.post;

import lombok.Data;
import org.gustini.library.meinEinkaufApi.objects.enums.Salutation;

/**
 * Address information.
 *
 * Note: If the invoice address is in Switzerland or Liechtenstein, the street must be passed in the "street"
 * property and the house number optionally in the "houseNumber" property. If the invoice address is not in
 * Switzerland or Liechtenstein, the street address must be passed in the "addressLine" property according
 * to the country format. The delivery address must necessarily be in Switzerland or Liechtenstein.
 *
 * Gustini GmbH (2019)
 * Creation: 11.06.2019
 *
 * @author Matthias Staud
 */
@Data
public class Adress
{
    /** The company name (optional) */
    private String company;

    /** The salutation ["Herr", "Frau"] (required) */
    private final Salutation salutation;

    /** The title, e.g. "Dr." (optional) */
    private String title;

    /** The first name (required) */
    private final String firstName;

    /** The last name (required) */
    private final String lastName;

    /** The street name. Required if address is in Switzerland or Liechtenstein */
    private final String street;

    /** The house number. Only allowed if address is in Switzerland or Liechtenstein */
    private final String houseNumber;

    /** The address line. Required if address is not in Switzerland or Liechtenstein */
    private String addressLine;

    /** Additional address information (optional) */
    private String additionalAddressLine;

    /** The postal code (required) */
    private final String zip;

    /** The city (required) */
    private final String city;

    /** The administrative area (canton, municipality, district, island, etc.).
     * Required if the address in the corresponding country requires it */
    private String state;

    /** The country code according to ISO-3166-1 Alpha-2 standard. Default: CH */
    private String country = "CH";

    /**
     * Constructor for Adress
     *
     * @param salutation The salutation (e.g., Herr, Frau)
     * @param firstName The first name
     * @param lastName The last name
     * @param street The street name
     * @param houseNumber The house number
     * @param zip The postal code
     * @param city The city
     */
    public Adress(Salutation salutation, String firstName, String lastName,
                  String street, String houseNumber, String zip, String city)
    {
        super();
        this.salutation = salutation;
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.houseNumber = houseNumber;
        this.zip = zip;
        this.city = city;
    }
}
