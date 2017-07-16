/*
 * MIT License
 *
 * Copyright (c) 2017 Donato Rimenti
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package co.aurasphere.scout.demo.model;

import co.aurasphere.scout.demo.activities.fragments.ContactListFragment;

import java.io.Serializable;

/**
 * Model class for a contact on the {@link ContactListFragment}.
 *
 * @author Donato Rimenti
 */
public class Contact implements Serializable {

    /**
     * Contact's name.
     */
    private String name;

    /**
     * Contact's phone number.
     */
    private String phoneNumber;

    /**
     * Instantiates a new Contact.
     */
    public Contact() {
    }

    /**
     * Instantiates a new Contact.
     *
     * @param name        the {@link #name}
     * @param phoneNumber the {@link #phoneNumber}
     */
    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    /**
     * Gets {@link #name}.
     *
     * @return the {@link #name}
     */
    public String getName() {
        return name;
    }

    /**
     * Sets {@link #name}.
     *
     * @param name the {@link #name}
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets {@link #phoneNumber}.
     *
     * @return the {@link #phoneNumber}
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets {@link #phoneNumber}.
     *
     * @param phoneNumber the {@link #phoneNumber}
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contact contact = (Contact) o;

        if (name != null ? !name.equals(contact.name) : contact.name != null) return false;
        return phoneNumber != null ? phoneNumber.equals(contact.phoneNumber) : contact.phoneNumber == null;

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}