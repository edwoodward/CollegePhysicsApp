/**
 * Copyright (c) 2017 Rice University
 *
 * This software is subject to the provisions of the GNU Lesser General
 * Public License Version 2.1 (LGPL).  See LICENSE.txt for details.
 */
package org.openstax.collegephysics.beans;

import java.util.ArrayList;

/**
 * Holds list of content (Book) objects
 * @author Ed Woodward
 */
public class BookList
{
    ArrayList<Content> bookList;

    public ArrayList<Content> getBookList()
    {
        return bookList;
    }

    public void setBookList(ArrayList<Content> bookList)
    {
        this.bookList = bookList;
    }
}
