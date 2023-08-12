package com.devepos.adt.base.nameditem;

public interface INamedItemType {
  /**
   * Creates and returns named item with the given configuration
   *
   * @param discoveryTerm discovery term for proposals
   * @param caseSensitive if {@code true} the case will be considered during filtering
   * @param buffered      if {@code true} the proposals for this named item type will be buffered
   * @return a new immutable named item type
   */
  static INamedItemType create(final String discoveryTerm, final boolean caseSensitive,
      final boolean buffered) {
    return new INamedItemType() {

      @Override
      public String getDiscoveryTerm() {
        return discoveryTerm;
      }

      @Override
      public boolean isBuffered() {
        return buffered;
      }

      @Override
      public boolean isCaseSensitive() {
        return caseSensitive;
      }

    };
  }

  /**
   * Returns the discovery term of this named item type
   *
   * @return the discovery term of this named item type
   */
  String getDiscoveryTerm();

  /**
   * Signals that this named item has only a small list of available values and
   * therefore should be buffered to avoid unnecessary service calls
   *
   * @return <code>true</code> if the named items of this type should be buffered
   */
  default boolean isBuffered() {
    return false;
  }

  /**
   * Checks if the name property of the item is case sensitive or not
   *
   * @return {@code true} if the name property of the item is case sensitive
   */
  default boolean isCaseSensitive() {
    return false;
  }
}
