package org.hxj.dsa_java.xml;

import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * Created by hxj on 2017/2/5.
 */
public class DateConverter implements Converter {

    private Locale locale;

    public DateConverter(Locale locale) {
        super();
        this.locale = locale;
    }
    //java到xml
    public void marshal(Object o, HierarchicalStreamWriter hierarchicalStreamWriter, MarshallingContext marshallingContext) {
        DateFormat format = DateFormat.getDateInstance(DateFormat.FULL, this.locale );
        hierarchicalStreamWriter.setValue(format.format(o));
    }
    //xml到java
    public Object unmarshal(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext) {
        GregorianCalendar calendar = new GregorianCalendar();
        DateFormat format = DateFormat.getDateInstance(DateFormat.DAY_OF_YEAR_FIELD, this.locale);

        try {
            calendar.setTime(format.parse(hierarchicalStreamReader.getValue()));
        } catch (ParseException e) {
            throw new ConversionException( e.getMessage(),e);
        }

        return calendar.getGregorianChange();
    }

    public boolean canConvert(Class aClass) {
        return Date.class.isAssignableFrom(aClass);
    }
}
