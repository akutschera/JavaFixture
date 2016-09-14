package com.github.nylle.javafixture;

import java.lang.reflect.Array;
import java.lang.reflect.Field;


public class Reflector<T> {
  private final Class<T> typeReference;

  public Reflector(Class<T> typeReference) {
    this.typeReference = typeReference;
  }

  public void setField(T instance, String fieldName, Object value) {
    try {
      Field field = typeReference.getDeclaredField(fieldName);

      if (value == null) {
        value = getDefaultValue(field.getType());
      }

      field.setAccessible(true);
      field.set(instance, value);
    } catch (Exception e) {
      throw new RuntimeException(
        "Cannot populate field '" + fieldName + "' on '" + typeReference.getName() + "'. Inner exception: " +
        e.toString(),
        e);
    }
  }

  private static <T> T getDefaultValue(Class<T> clazz) {
    return clazz.isPrimitive() ? (T) Array.get(Array.newInstance(clazz, 1), 0) : null;
  }
}
