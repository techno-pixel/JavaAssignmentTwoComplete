// Jad Seaidoun - 200340278
package registrationsystem;

import java.time.LocalDate;
import java.time.Period;

abstract class Person {
    //variables
    protected String first;
    protected String last;
    protected String address;
    protected String city;
    protected String zip;
    protected LocalDate dob;
    protected LocalDate start;

    /**
     * returns dob as an int
     *
     * @author Jad Seaidoun
     */
    protected int getAge() {
        return Period.between(dob, LocalDate.now()).getYears();
    }


    /**
     * returns full address spaced out once
     *
     * @author Jad Seaidoun
     */
    protected String getAddress(String separator) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.address);
        sb.append(separator);
        sb.append(this.city);
        sb.append(separator);
        sb.append(this.zip);
        return sb.toString();
    }

    /**
     * returns full name spaced out
     *
     * @author Jad Seaidoun
     */
    public StringBuilder stringBuilder() {
        StringBuilder sb = new StringBuilder();
        sb.append(first);
        sb.append(" ");
        sb.append(last);
        return sb;
    }

    /**
     * sets address, city and zip code when changed
     *
     * @author Jad Seaidoun
     */
    public void changeAddress(String address, String city, String zip) {
        this.address = address;
        this.city = city;
        this.zip = zip;
    }
}
