// Jad Seaidoun - 200340278
package registrationsystem;

import java.time.LocalDate;
import java.time.Period;

    //abstract class
abstract class Person {
    //variables
    protected String first;
    protected String last;
    protected String address;
    protected String city;
    protected String zip;
    protected LocalDate dob;
    protected LocalDate start;

    // SETTERS AND GETTERS ------------------------------------------------------------------------------------
    protected int getAge() {
        return Period.between(dob, LocalDate.now()).getYears();
    }


    /**
     * returns full address spaced out once
     *
     * @param separator a space
     * @author Jad Seaidoun
     * @since 1.1
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

    // METHODS -----------------------------------------------------------------------------------------------
    /**
     * StringBuilder
     *
     * @return returns full name spaced out
     * @author Jad Seaidoun
     * @since 1.1
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
     * @param address address (street and number)
     * @param city city
     * @param zip zip or postal code
     * @return sets address, city and zip code when changed
     * @author Jad Seaidoun
     * @since 1.1
     */
    public void changeAddress(String address, String city, String zip) {
        this.address = address;
        this.city = city;
        this.zip = zip;
    }
}
