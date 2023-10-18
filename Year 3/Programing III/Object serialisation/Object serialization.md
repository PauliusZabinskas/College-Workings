
#concepts #ObjectSerialization #Java 
## What Is Serialization?
Serialization in Java is a mechanism of writing the state of an object into a byte stream. This process is utilized for multiple purposes such as persisting the object's state, sending the object between server and client in a network, or passing objects between different parts of a system in a decoupled manner. Here are some of the key aspects and steps involved in serialization in Java:

[[Steps carried out]]

1. **Preparation for Serialization**:
    
    - **Serializable Interface**: To serialize a class, it should implement the `Serializable` interface which is a marker interface (it doesn't have any methods).
    - **Version Control**: You can provide a `serialVersionUID` field in your class to help with version control during deserialization.
2. **Serialization Process**:
    
    - **Writing Object State**: The `ObjectOutputStream` class in Java is used to serialize an object. You'll use its `writeObject` method to write the object's state to a byte stream.
    - **Custom Serialization**: If needed, you can customize the serialization process by defining `writeObject` and `readObject` methods in your class.
3. **Deserialization Process**:
    
    - **Reading Object State**: The `ObjectInputStream` class is used for deserialization. Its `readObject` method reads the byte stream and recreates the object in memory.
    - **Custom Deserialization**: Similar to serialization, you can customize deserialization by defining `readObject` method in your class.
4. **Transient and Static Fields**:
    
    - Transient and static fields are not serialized. If you have fields that you don't want to serialize, you can mark them as `transient`.
5. **Handling Serialization Exceptions**:
    
    - During the serialization or deserialization processes, several exceptions like `IOException` or `ClassNotFoundException` may be thrown which need to be handled.
6. **Security Considerations**:
    
    - Serialization can potentially expose sensitive data, or be a vector for security exploits. It's important to consider the security implications and possibly look into alternative serialization methods or libraries that provide a secure way of handling object serialization and deserialization.
7. **Externalizable Interface**:
    
    - Java also provides the `Externalizable` interface which gives you more control over the serialization process compared to `Serializable`.


References:
- https://www.youtube.com/watch?v=DfbFTVNfkeI