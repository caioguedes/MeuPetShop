package br.com.ricardosander.meupetshop.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class PaginatorCalculatorTest {

    @Test
    public void test0Register() {

        PaginatorCalculator paginatorCalculator = new PaginatorCalculator(1, 0);

        assertEquals(0, paginatorCalculator.getTotalRegister());
        assertEquals(20, paginatorCalculator.getRegistersPerPage());

        assertEquals(1, paginatorCalculator.getCurrentPage());
        assertEquals(1, paginatorCalculator.getPreviousPage());
        assertEquals(1, paginatorCalculator.getNextPage());

        assertEquals(1, paginatorCalculator.getPages());

        assertEquals(1, paginatorCalculator.getFirstPage());
        assertEquals(1, paginatorCalculator.getLastPage());

        assertEquals(1, paginatorCalculator.getFirstListedPage());
        assertEquals(1, paginatorCalculator.getLastListedPage());

        assertEquals(0, paginatorCalculator.getOffSet());

    }

    @Test
    public void test77RegisterFirstPage() {

        PaginatorCalculator paginatorCalculator = new PaginatorCalculator(1, 77);

        assertEquals(77, paginatorCalculator.getTotalRegister());
        assertEquals(20, paginatorCalculator.getRegistersPerPage());

        assertEquals(1, paginatorCalculator.getCurrentPage());
        assertEquals(1, paginatorCalculator.getPreviousPage());
        assertEquals(2, paginatorCalculator.getNextPage());

        assertEquals(4, paginatorCalculator.getPages());

        assertEquals(1, paginatorCalculator.getFirstPage());
        assertEquals(4, paginatorCalculator.getLastPage());

        assertEquals(1, paginatorCalculator.getFirstListedPage());
        assertEquals(4, paginatorCalculator.getLastListedPage());

        assertEquals(0, paginatorCalculator.getOffSet());

    }

    @Test
    public void test77RegisterThirdPage() {

        PaginatorCalculator paginatorCalculator = new PaginatorCalculator(3, 77);

        assertEquals(77, paginatorCalculator.getTotalRegister());
        assertEquals(20, paginatorCalculator.getRegistersPerPage());

        assertEquals(3, paginatorCalculator.getCurrentPage());
        assertEquals(2, paginatorCalculator.getPreviousPage());
        assertEquals(4, paginatorCalculator.getNextPage());

        assertEquals(4, paginatorCalculator.getPages());

        assertEquals(1, paginatorCalculator.getFirstPage());
        assertEquals(4, paginatorCalculator.getLastPage());

        assertEquals(1, paginatorCalculator.getFirstListedPage());
        assertEquals(4, paginatorCalculator.getLastListedPage());

        assertEquals(40, paginatorCalculator.getOffSet());

    }

}
