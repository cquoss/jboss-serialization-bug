package de.quoss.bug.jboss.serialization;

import org.jboss.serial.io.JBossObjectInputStream;
import org.jboss.serial.io.JBossObjectOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Map;

public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
    private void run() throws Exception {
        // object to serialize
        Map<String, Object> toSerialize = new Hashtable<>();
        // serialize object
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        JBossObjectOutputStream objectOutputStream = new JBossObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(toSerialize);
        // log byte array
        byte[] buf = byteArrayOutputStream.toByteArray();
        LOGGER.info("[buf.length={},buf.hashCode={}]", buf.length, Arrays.hashCode(buf));
        // deserialize object
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(buf);
        JBossObjectInputStream objectInputStream = new JBossObjectInputStream(byteArrayInputStream);
        Object deserialized = objectInputStream.readObject();
        LOGGER.info("[deserialized={},deserialized.class.name={}", deserialized, deserialized.getClass().getName());
    }

    public static void main(final String[] args) throws Exception {
        new Main().run();
    }

}
