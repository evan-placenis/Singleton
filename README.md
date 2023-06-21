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

# Maze - Singleton Example

In this program the MazeFactory constains an "Intance" method that checks whether there is an existing instance already created. If not, the program checks the environment variables to see which mazeStyle should be instantiated (these are set in the main function). This only allows one style of maze to be created at a time.

![image](https://github.com/evan-placenis/Singleton/assets/112578037/d2e05c0f-8508-49ef-88b0-4e6e8993e3fb)


Environment variables set to bombed maze

![image](https://github.com/evan-placenis/Singleton/assets/112578037/232b8ce9-1fea-4e04-84b2-84ac731a650f)
