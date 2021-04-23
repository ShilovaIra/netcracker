package com.netcracker.utils.jaxb;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;

/**
 *  Adapter helps to convert LocalDate variables to String type when writing xml
 *  and String to LocalDate type while parsing xml
 */
public class LocalDateAdapterForXML extends XmlAdapter<String, LocalDate> {

    @Override
    public LocalDate unmarshal(String dateString) throws Exception {
        return LocalDate.parse(dateString);
    }

    @Override
    public String marshal(LocalDate localDate) throws Exception {
        return localDate.toString();
    }
}
