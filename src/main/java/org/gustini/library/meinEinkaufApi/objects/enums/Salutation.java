package org.gustini.library.meinEinkaufApi.objects.enums;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 
 * @author mst
 *
 */

public enum Salutation
{
    Herr("Herr"),
    Frau("Frau"),
    /* Wenn keine Anrede vorhanden ist, wird ein leerer String zurückgegeben! */
    
    NOTHING("");
	
	
	
	 // Assigning a value to each enum
    private final String salutationStringValue;
    Salutation(String salutationValue){
        this.salutationStringValue = salutationValue;
    }
	
    @JsonValue
    /**
     * Method for Serialisation
     * @return Stringvalue from Enum
     */
    public String getStringValue()
    {
    	return this.salutationStringValue;
    }
    
    
	@Override
    public String toString(){
        return this.salutationStringValue;
    }
	

}
