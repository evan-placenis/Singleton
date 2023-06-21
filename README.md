# Singleton (Creational)

Singleton ensures a class only has one instance, and provides a global point of access to it.

Singleton is useful when:
- There must be exactly one instance of a class, and it must be accessible to clients from a well-known access point.
- When the sole instance should be extensible by subclassing, and clients should be able to use an extended instance without modifying their code.

**Benefits:**
- Controlled access to sole instance
- Reduced name space because it avoids polluting the name space with global variables that store sole instances.
- Permits refinement of operations and representation (because of subclassing).
- More flexible than class operations.
