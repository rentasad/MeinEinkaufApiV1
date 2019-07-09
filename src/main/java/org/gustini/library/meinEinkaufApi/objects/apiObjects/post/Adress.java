/**
 * 
 */
package org.gustini.library.meinEinkaufApi.objects.apiObjects.post;

import org.gustini.library.meinEinkaufApi.objects.enums.Salutation;

/**
 * Gustini GmbH (2019)
 * Creation: 11.06.2019
 * application.meineinkauf
 * org.gustini.library.meinEinkaufApi.objects
 * 
 * @author Matthias Staud
 *
 *
 *         Description:
 * 
 *         Name Typ Beispiel Pflichtfeld Hinweis
 *         company String Muster GmbH Nein Die Firma des Kunden
 *         salutation Enum[String] Frau Ja Die Anrede des Kunden
 * 
 *         ["Herr", "Frau"]
 *         title String Dr. Nein Der Titel des Kunden
 *         firstName String Erika Ja Der Vorname des Kunden
 *         lastName String Musterfrau Ja Der Nachname des Kunden
 *         street String Musterstrasse Ja* Die Stra�e des Kunden
 * 
 *         Pflicht, wenn Adresse in der Schweiz oder Liechtenstein
 *         houseNumber String 28a Nein* Die Hausnummer des Kunden
 * 
 *         Nur zul�ssig, wenn Adresse in der Schweiz oder Liechtenstein
 *         addressLine String 140 Av. des Champs-�lys�es Nein* Die Adresszeile
 * 
 *         Pflicht, wenn Adresse nicht in der Schweiz oder Liechtenstein
 *         additionalAddressLine String Im Hinterhof Nein Zus�tzlicher Adresshinweis
 *         zip String 8005 Ja Die Postleitzahl des Kunden
 *         city String Z�rich Ja Die Stadt des Kunden
 *         state String Z�rich Nein* Der Verwaltungsbereich des Kunden (z.B. Kanton, Gemeinde, Bezirk, Insel, etc)
 * 
 *         Pflicht, wenn die Adresse in dem entsprechenden Land dies erfordert
 *         country String CH Nein Der L�ndercode nach ISO-3166-1 Alpha-2 Standard
 * 
 *         Default: CH
 * 
 *         Hinweis: Sollte die Rechnungsadresse in der Schweiz oder Liechtenstein liegen, muss die Stra�e in der Eigenschaft "street" �bergeben werden und die Hausnummer optional in der Eigenschaft
 *         "houseNumber". Falls die Rechnungsadresse nicht in der Schweiz oder Liechtenstein liegt, muss die Stra�enanschrift entsprechend des L�nderformats in der Eigenschaft "addressLine" �bergeben
 *         werden. Die Lieferadresse muss zwangsl�ufig in der Schweiz oder Liechtenstein liegen.
 *
 */
public class Adress
{

    private String company;
    private final Salutation salutation;
    private String title;
    private final String firstName;
    private final String lastName;
    private final String street;
    private final String houseNumber;
    private String addressLine;
    private String additionalAddressLine;
    private final String zip;
    private final String city;
    private String state;
    /**
     * Der L�ndercode nach ISO-3166-1 Alpha-2 Standard
     */
    private String country = "CH"; // DEFAULT


    /**
     * @param salutation
     * @param firstName
     * @param lastName
     * @param street
     * @param houseNumber
     * @param zip
     * @param city
     */
    public Adress(
                  Salutation salutation,
                  String firstName,
                  String lastName,
                  String street,
                  String houseNumber,
                  String zip,
                  String city)
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

    /**
     * @return the company
     */
    public String getCompany()
    {
        return company;
    }

    /**
     * @param company the company to set
     */
    public void setCompany(String company)
    {
        this.company = company;
    }

    /**
     * @return the title
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title)
    {
        this.title = title;
    }

    /**
     * @return the addressLine
     */
    public String getAddressLine()
    {
        return addressLine;
    }

    /**
     * @param addressLine the addressLine to set
     */
    public void setAddressLine(String addressLine)
    {
        this.addressLine = addressLine;
    }

    /**
     * @return the additionalAddressLine
     */
    public String getAdditionalAddressLine()
    {
        return additionalAddressLine;
    }

    /**
     * @param additionalAddressLine the additionalAddressLine to set
     */
    public void setAdditionalAddressLine(String additionalAddressLine)
    {
        this.additionalAddressLine = additionalAddressLine;
    }

    /**
     * @return the state
     */
    public String getState()
    {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state)
    {
        this.state = state;
    }

    /**
     * @return the country
     */
    public String getCountry()
    {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country)
    {
        this.country = country;
    }

    /**
     * @return the salutation
     */
    public Salutation getSalutation()
    {
        return salutation;
    }

    /**
     * @return the firstName
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName()
    {
        return lastName;
    }

    /**
     * @return the street
     */
    public String getStreet()
    {
        return street;
    }

    /**
     * @return the houseNumber
     */
    public String getHouseNumber()
    {
        return houseNumber;
    }

    /**
     * @return the zip
     */
    public String getZip()
    {
        return zip;
    }

    /**
     * @return the city
     */
    public String getCity()
    {
        return city;
    }

}
