package com.github.nylle.javafixture;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SpecimenExceptionTest {

    @Test
    void withMessage() {
        var sut = new SpecimenException("message");

        assertThat(sut.getMessage()).isEqualTo("message");
    }

    @Test
    void withMessageAndCause() {
        var sut = new SpecimenException("message", new NullPointerException("null"));

        assertThat(sut.getMessage()).isEqualTo("message");
        assertThat(sut.getCause()).isInstanceOf(NullPointerException.class);
        assertThat(sut.getCause().getMessage()).isEqualTo("null");
    }
}
