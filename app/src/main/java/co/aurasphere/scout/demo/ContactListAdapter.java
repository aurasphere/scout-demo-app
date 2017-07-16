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

package co.aurasphere.scout.demo;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import co.aurasphere.scout.demo.activities.fragments.ContactListFragment;
import co.aurasphere.scout.demo.model.Contact;

/**
 * Adapter for a {@link Contact} used in the {@link ContactListFragment}.
 *
 * @author Donato Rimenti
 */
public class ContactListAdapter extends ArrayAdapter<Contact> {

    /**
     * The context of this element.
     */
    private Context context;

    /**
     * The id of the layout element of this adapter.
     */
    private int layoutResourceId;

    /**
     * The contacts handled by this adapter.
     */
    private Contact contacts[];

    /**
     * Instantiates a new Contact list adapter.
     *
     * @param context          the {@link #context}
     * @param layoutResourceId the {@link #layoutResourceId}
     * @param contacts         the {@link #contacts}
     */
    public ContactListAdapter(Context context, int layoutResourceId, Contact[] contacts) {
        super(context, layoutResourceId, contacts);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.contacts = contacts;
    }

    /**
     * {@inheritDoc}
     */
    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view.
        if (convertView == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            convertView = inflater.inflate(layoutResourceId, parent, false);
        }

        // Sets the contact data into the view.
        TextView contactNameView = (TextView) convertView.findViewById(R.id.contact_name);
        TextView contactPhoneView = (TextView) convertView.findViewById(R.id.contact_phone_number);

        Contact contact = contacts[position];
        contactNameView.setText(contact.getName());
        contactPhoneView.setText(contact.getPhoneNumber());

        return convertView;
    }

}