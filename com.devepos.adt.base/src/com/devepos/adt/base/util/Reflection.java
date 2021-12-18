package com.devepos.adt.base.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.eclipse.core.runtime.Assert;

public class Reflection {
  private final Object object;

  public static Reflection forObject(final Object o) {
    return new Reflection(o);
  }

  public static Reflection forClass(final Class<?> clazz) {
    return new Reflection(clazz);
  }

  public static boolean classIsAvailable(final String className, final ClassLoader classLoader) {
    return classForName(className, classLoader) != null;
  }

  public static Class<?> classForName(final String className, final ClassLoader classLoader) {
    try {
      return Class.forName(className, true, classLoader);
    } catch (ClassNotFoundException localClassNotFoundException) {
      return null;
    } catch (LinkageError e) {
    }
    return null;
  }

  private Reflection(final Object object) {
    this.object = object;
  }

  public boolean supportsMethod(final String methodName) {
    return supportsMethod(methodName);
  }

  public boolean supportsMethod(final String methodName, final Class<?>... argTypes) {
    return getMethod(methodName, argTypes) != null;
  }

  public Object invoke(final String methodName) {
    return invoke(methodName, null);
  }

  public Object invoke(final String methodName, final Class<?>[] argTypes, final Object... args) {
    try {
      Method method = getMethod(methodName, argTypes);
      if (method == null) {
        return null;
      }
      method.setAccessible(true);
      return method.invoke(object, args);
    } catch (IllegalAccessException e) {
      throw new IllegalStateException(e.getMessage(), e);
    } catch (InvocationTargetException e) {
      Throwable cause = e.getCause();
      if (cause instanceof RuntimeException) {
        throw (RuntimeException) cause;
      }
      if (cause instanceof Error) {
        throw (Error) cause;
      }
      throw new IllegalStateException(cause.getMessage(), cause);
    }
  }

  public Object getFieldValue(final String fieldName, final Class<?> clazz) {
    try {
      Class<?> cls = clazz != null ? clazz : object.getClass();
      Field field = getField(fieldName, cls);
      if (field != null) {
        field.setAccessible(true);
        return field.get(object);
      }
      return null;
    } catch (SecurityException | IllegalAccessException e) {
      throw new IllegalStateException(e.getMessage(), e);
    }
  }

  public void setFieldValue(final String fieldName, final Class<?> clazz, final Object value) {
    try {
      Class<?> cls = clazz != null ? clazz : object.getClass();
      Field field = getField(fieldName, cls);
      if (field != null) {
        field.setAccessible(true);
        field.set(object, value);
      }
    } catch (SecurityException | IllegalAccessException e) {
      throw new IllegalStateException(e.getMessage(), e);
    }
  }

  public static boolean hasField(final String fieldName, final Class<?> clazz) {
    return getField(fieldName, clazz) != null;
  }

  private Method getMethod(final String methodName, final Class<?>... argTypes) {
    Method method = getPublicMethod(methodName, argTypes);
    if (method != null) {
      return method;
    }
    return getDeclaredMethod(methodName, argTypes);
  }

  private Method getPublicMethod(final String methodName, final Class<?>... argTypes) {
    if (object == null) {
      return null;
    }
    return getPublicMethod(getEffectiveClass(), methodName, argTypes);
  }

  private Class<?> getEffectiveClass() {
    if (object instanceof Class) {
      return (Class<?>) object;
    }
    return object.getClass();
  }

  private static Method getPublicMethod(final Class<?> clazz, final String methodName,
      final Class<?>... argTypes) {
    try {
      return clazz.getMethod(methodName, argTypes);
    } catch (SecurityException | NoSuchMethodException localNoSuchMethodException) {
    }
    return null;
  }

  private Method getDeclaredMethod(final String methodName, final Class<?>... paramTypes) {
    if (object == null) {
      return null;
    }
    return getDeclaredMethod(getEffectiveClass(), methodName, paramTypes);
  }

  private static Method getDeclaredMethod(final Class<?> clazz, final String name,
      final Class<?>... paramTypes) {
    try {
      return clazz.getDeclaredMethod(name, paramTypes);
    } catch (NoSuchMethodException localNoSuchMethodException) {
      Class<?> superClass = clazz.getSuperclass();
      if (superClass != null) {
        return getDeclaredMethod(superClass, name, paramTypes);
      }
    } catch (SecurityException e) {
      throw new IllegalStateException(e.getMessage(), e);
    }
    return null;
  }

  private static Field getField(final String fieldName, final Class<?> clazz) {
    Assert.isNotNull(clazz, "class must not be null");
    try {
      return clazz.getDeclaredField(fieldName);
    } catch (NoSuchFieldException localNoSuchFieldException) {
      return null;
    } catch (SecurityException e) {
      throw new IllegalStateException(e.getMessage(), e);
    }
  }
}
