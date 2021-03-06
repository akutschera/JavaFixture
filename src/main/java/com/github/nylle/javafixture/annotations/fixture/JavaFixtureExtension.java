package com.github.nylle.javafixture.annotations.fixture;

import com.github.nylle.javafixture.Fixture;
import com.github.nylle.javafixture.SpecimenType;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

public class JavaFixtureExtension implements ParameterResolver {
    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return true;
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return new Fixture().create(SpecimenType.fromClass(parameterContext.getParameter().getParameterizedType()));
    }
}

