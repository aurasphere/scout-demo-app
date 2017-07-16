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

package co.aurasphere.scout.demo.activities.fragments;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import co.aurasphere.scout.demo.ContactListAdapter;
import co.aurasphere.scout.demo.R;
import co.aurasphere.scout.demo.model.Contact;

/**
 * A fragment containing a list of contacts. Contacts can be loaded from a Server (using a REST Web Service for example). For the sake of this demo, contacts are manually added to the list.
 *
 * @author Donato Rimenti
 */
public class ContactListFragment extends ListFragment {

    /**
     * A list of demo contacts to be showed.
     */
    private static final Contact demoContacts[] = new Contact[]{
            new Contact("Joseph Murrill", "435-210-5256"),
            new Contact("Michael Quiroz", "432-517-2913"),
            new Contact("Warren Sage", "646-957-7295"),
            new Contact("Louise Valentine", "847-296-1725"),
            new Contact("Hyman Ramos", "661-406-8296"),
            new Contact("Valerie Shortridge", "856-405-3813"),
            new Contact("Christopher Fryer", "573-568-6533"),
            new Contact("Billie Ott", "205-289-8459")
    };

    /**
     * {@inheritDoc}
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.contactlist_fragment, container,
                false);

        // Adds the demo contact to the view.
        ContactListAdapter adapter = new ContactListAdapter(getActivity(), R.layout.contact_row, demoContacts);
        setListAdapter(adapter);

        return v;
    }
}