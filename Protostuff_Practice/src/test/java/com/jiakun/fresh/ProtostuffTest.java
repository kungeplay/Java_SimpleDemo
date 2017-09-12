package com.jiakun.fresh;

import com.jiakun.fresh.pojo.People;
import com.jiakun.fresh.pojo.Sex;
import io.protostuff.LinkedBuffer;
import io.protostuff.ProtostuffIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;
import org.junit.Test;
import org.objenesis.Objenesis;
import org.objenesis.ObjenesisStd;

import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ProtostuffTest {
    private static Objenesis objenesis = new ObjenesisStd(true);

    @Test
    public void serialTest() throws Exception {
        People people=new People();
        people.setName("LIU JIAKUN");
        people.setAge(25);
        people.setSex(Sex.MALE);

        byte[] serializer = serializer2(people);
        FileOutputStream fileOutputStream = new FileOutputStream("protoStuff_");
        fileOutputStream.write(serializer);
        fileOutputStream.close();
        System.out.println(people);
    }

    public static <T> byte[] serializer(T obj) {//公司用法
        Class<T> cls = (Class<T>) obj.getClass();//获得对象的类；
        LinkedBuffer buffer = LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE);//使用LinkedBuffer分配一块默认大小的buffer空间；
        RuntimeSchema<T> schema = RuntimeSchema.createFrom(cls);//通过对象的类构建对应的schema,构建schema的过程可能会比较耗时，因此可以将使用过的类对应的schema能被缓存起来。
        byte[] bytes = ProtostuffIOUtil.toByteArray(obj, schema, buffer);//使用给定的schema将对象序列化为一个byte数组，并返回。
        buffer.clear();
        return bytes;
    }

    public static <T> byte[] serializer2(T obj) {
        Class<T> cls = (Class<T>) obj.getClass();//获得对象的类；
        LinkedBuffer buffer = LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE);//使用LinkedBuffer分配一块默认大小的buffer空间；
        Schema<T> schema = RuntimeSchema.getSchema(cls);
        byte[] bytes = ProtostuffIOUtil.toByteArray(obj, schema, buffer);//使用给定的schema将对象序列化为一个byte数组，并返回。
        buffer.clear();
        return bytes;
    }

    @Test
    public void deserialTest() throws Exception {
        byte[] data = Files.readAllBytes(Paths.get("protoStuff_"));
        People people=deserializer2(data,People.class);
        System.out.println(people.toString());
    }
    public static <T> T deserializer(byte[] data, Class<T> cls) {
        T message = objenesis.newInstance(cls);//使用objenesis实例化一个类的对象；
        RuntimeSchema<T> schema = RuntimeSchema.createFrom(cls);//通过对象的类构建对应的schema；
        ProtostuffIOUtil.mergeFrom(data, message, schema);//使用给定的schema将byte数组和对象合并
        return message;
    }

    public static <T> T deserializer2(byte[] data, Class<T> cls) {//公司用法
        Schema<T> schema = RuntimeSchema.getSchema(cls);
        T obj = schema.newMessage();
        ProtostuffIOUtil.mergeFrom(data, obj, schema);
        return obj;
    }
}
