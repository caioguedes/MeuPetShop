package br.com.ricardosander.meupetshop.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class PaginatorTest {

    @Test
    public void test77RegisterFirstPage() {

        Paginator paginator = new Paginator(1, 77);

        assertEquals(77, paginator.getTotalRegister());
        assertEquals(20, paginator.getRegistersPerPage());

        assertEquals(1, paginator.getCurrentPage());
        assertEquals(1, paginator.getPreviousPage());
        assertEquals(2, paginator.getNextPage());

        assertEquals(4, paginator.getPages());

        assertEquals(1, paginator.getFirstPage());
        assertEquals(4, paginator.getLastPage());

        assertEquals(1, paginator.getFirstListedPage());
        assertEquals(4, paginator.getLastListedPage());

        assertEquals(0, paginator.getOffSet());

    }

}
