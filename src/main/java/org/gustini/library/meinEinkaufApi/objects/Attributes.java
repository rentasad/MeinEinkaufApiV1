/**
 * 
 */
package org.gustini.library.meinEinkaufApi.objects;

/**
 * Gustini GmbH (2019)
 * Creation: 11.06.2019
 * application.meineinkauf
 * org.gustini.library.meinEinkaufApi.objects
 * 
 * @author Matthias Staud
 *
 *
 * Description:Artikel-Attribute (Attributes-Object)
 *
 */
public class Attributes
{

    private String color;
    private String description;
    private String material;
    private String url;
    private String ean;     
    private String upc;
    private String asin;
    private String customIdentCode;
    private String size;
    
    /**
     * @return the color
     */
    public String getColor()
    {
        return color;
    }
    /**
     * @param color the color to set
     */
    public void setColor(String color)
    {
        this.color = color;
    }
    /**
     * @return the description
     */
    public String getDescription()
    {
        return description;
    }
    /**
     * @param description the description to set
     */
    public void setDescription(String description)
    {
        this.description = description;
    }
    /**
     * @return the material
     */
    public String getMaterial()
    {
        return material;
    }
    /**
     * @param material the material to set
     */
    public void setMaterial(String material)
    {
        this.material = material;
    }
    /**
     * @return the url
     */
    public String getUrl()
    {
        return url;
    }
    /**
     * @param url the url to set
     */
    public void setUrl(String url)
    {
        this.url = url;
    }
    /**
     * @return the ean
     */
    public String getEan()
    {
        return ean;
    }
    /**
     * @param ean the ean to set
     */
    public void setEan(String ean)
    {
        this.ean = ean;
    }
    /**
     * @return the upc
     */
    public String getUpc()
    {
        return upc;
    }
    /**
     * @param upc the upc to set
     */
    public void setUpc(String upc)
    {
        this.upc = upc;
    }
    /**
     * @return the asin
     */
    public String getAsin()
    {
        return asin;
    }
    /**
     * @param asin the asin to set
     */
    public void setAsin(String asin)
    {
        this.asin = asin;
    }
    /**
     * @return the customIdentCode
     */
    public String getCustomIdentCode()
    {
        return customIdentCode;
    }
    /**
     * @param customIdentCode the customIdentCode to set
     */
    public void setCustomIdentCode(String customIdentCode)
    {
        this.customIdentCode = customIdentCode;
    }
    /**
     * @return the size
     */
    public String getSize()
    {
        return size;
    }
    /**
     * @param size the size to set
     */
    public void setSize(String size)
    {
        this.size = size;
    }
    /**
     * 
     */
    public Attributes()
    {
        super();
    }

}
