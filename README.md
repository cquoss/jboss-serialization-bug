# jboss-serialization-bug
Repository showing the bug that appeared in jboss-serialization when running in jdk 8 update 322 while  marshalling Hashtable objects.

Problem as shows:

Debug Log Output running with jdk8u312:

```
C:\Users\cleme\java\jdks\jdk-8-312\bin\java.exe -javaagent:C:\Users\cleme\AppData\Local\JetBrains\Toolbox\apps\IDEA-U\ch-0\221.5080.210\lib\idea_rt.jar=63880:C:\Users\cleme\AppData\Local\JetBrains\Toolbox\apps\IDEA-U\ch-0\221.5080.210\bin -Dfile.encoding=UTF-8 -classpath C:\Users\cleme\java\jdks\jdk-8-312\jre\lib\charsets.jar;C:\Users\cleme\java\jdks\jdk-8-312\jre\lib\ext\access-bridge-64.jar;C:\Users\cleme\java\jdks\jdk-8-312\jre\lib\ext\cldrdata.jar;C:\Users\cleme\java\jdks\jdk-8-312\jre\lib\ext\dnsns.jar;C:\Users\cleme\java\jdks\jdk-8-312\jre\lib\ext\jaccess.jar;C:\Users\cleme\java\jdks\jdk-8-312\jre\lib\ext\localedata.jar;C:\Users\cleme\java\jdks\jdk-8-312\jre\lib\ext\nashorn.jar;C:\Users\cleme\java\jdks\jdk-8-312\jre\lib\ext\sunec.jar;C:\Users\cleme\java\jdks\jdk-8-312\jre\lib\ext\sunjce_provider.jar;C:\Users\cleme\java\jdks\jdk-8-312\jre\lib\ext\sunmscapi.jar;C:\Users\cleme\java\jdks\jdk-8-312\jre\lib\ext\sunpkcs11.jar;C:\Users\cleme\java\jdks\jdk-8-312\jre\lib\ext\zipfs.jar;C:\Users\cleme\java\jdks\jdk-8-312\jre\lib\jce.jar;C:\Users\cleme\java\jdks\jdk-8-312\jre\lib\jfr.jar;C:\Users\cleme\java\jdks\jdk-8-312\jre\lib\jsse.jar;C:\Users\cleme\java\jdks\jdk-8-312\jre\lib\management-agent.jar;C:\Users\cleme\java\jdks\jdk-8-312\jre\lib\resources.jar;C:\Users\cleme\java\jdks\jdk-8-312\jre\lib\rt.jar;C:\Users\cleme\git\cquoss\jboss-serialization-bug\target\classes;C:\Users\cleme\.m2\repository\jboss\jboss-serialization\4.2.2.GA\jboss-serialization-4.2.2.GA.jar;C:\Users\cleme\.m2\repository\org\slf4j\slf4j-api\1.7.36\slf4j-api-1.7.36.jar;C:\Users\cleme\.m2\repository\ch\qos\logback\logback-classic\1.2.11\logback-classic-1.2.11.jar;C:\Users\cleme\.m2\repository\ch\qos\logback\logback-core\1.2.11\logback-core-1.2.11.jar;C:\Users\cleme\.m2\repository\trove\trove\1.0.2\trove-1.0.2.jar;C:\Users\cleme\.m2\repository\org\slf4j\log4j-over-slf4j\1.7.36\log4j-over-slf4j-1.7.36.jar de.quoss.bug.jboss.serialization.Main
09:27:18.944 [main] DEBUG org.jboss.serial.util.HashStringUtil - hash on field java.lang.reflect.Proxy = -1281934524198291041
09:27:18.946 [main] DEBUG org.jboss.serial.classmetamodel.ClassMetaData - lookupMethodOnHierarchy::class=java.lang.reflect.Proxy looking for readResolve
09:27:18.946 [main] DEBUG org.jboss.serial.classmetamodel.ClassMetaData - lookupMethodOnHierarchy::currentClass=class java.lang.reflect.Proxy
09:27:18.947 [main] DEBUG org.jboss.serial.classmetamodel.ClassMetaData - lookupMethodOnHierarchy::class=java.lang.reflect.Proxy looking for writeReplace
09:27:18.947 [main] DEBUG org.jboss.serial.classmetamodel.ClassMetaData - lookupMethodOnHierarchy::currentClass=class java.lang.reflect.Proxy
09:27:18.950 [main] DEBUG org.jboss.serial.util.HashStringUtil - hash on field java.lang.reflect.Proxy = -1281934524198291041
09:27:18.951 [main] DEBUG org.jboss.serial.util.HashStringUtil - hash on field java.lang.reflect.InvocationHandler$h = 3757213363974229139
09:27:18.952 [main] DEBUG org.jboss.serial.classmetamodel.FieldsManager - FieldsManager in use = org.jboss.serial.classmetamodel.UnsafeFieldsManager
09:27:18.980 [main] DEBUG org.jboss.serial.objectmetamodel.ObjectDescriptorFactory - describeObject for class=java.util.Hashtable
09:27:18.980 [main] DEBUG org.jboss.serial.util.HashStringUtil - hash on field java.util.Hashtable = 8568335707554902210
09:27:18.980 [main] DEBUG org.jboss.serial.classmetamodel.ClassMetaData - lookupMethodOnHierarchy::class=java.util.Hashtable looking for readResolve
09:27:18.980 [main] DEBUG org.jboss.serial.classmetamodel.ClassMetaData - lookupMethodOnHierarchy::currentClass=class java.util.Hashtable
09:27:18.980 [main] DEBUG org.jboss.serial.classmetamodel.ClassMetaData - lookupMethodOnHierarchy::currentClass=class java.util.Dictionary
09:27:18.980 [main] DEBUG org.jboss.serial.classmetamodel.ClassMetaData - lookupMethodOnHierarchy::class=java.util.Hashtable looking for writeReplace
09:27:18.980 [main] DEBUG org.jboss.serial.classmetamodel.ClassMetaData - lookupMethodOnHierarchy::currentClass=class java.util.Hashtable
09:27:18.980 [main] DEBUG org.jboss.serial.classmetamodel.ClassMetaData - lookupMethodOnHierarchy::currentClass=class java.util.Dictionary
09:27:18.981 [main] DEBUG org.jboss.serial.util.HashStringUtil - hash on field java.util.Hashtable = 8568335707554902210
09:27:18.981 [main] DEBUG org.jboss.serial.util.HashStringUtil - hash on field int$threshold = -81821300837738335
09:27:18.981 [main] DEBUG org.jboss.serial.util.HashStringUtil - hash on field float$loadFactor = 308335647531269238
09:27:18.981 [main] DEBUG org.jboss.serial.objectmetamodel.ObjectDescriptorFactory - describeObject::a new reference 1
09:27:18.986 [main] DEBUG org.jboss.serial.persister.RegularObjectPersister - defaultWrite::java.util.Hashtable contains 1 slots
09:27:18.986 [main] DEBUG org.jboss.serial.persister.RegularObjectPersister - defaultWrite:: slot 0 NR=java.util.Hashtable from parentClass=java.util.Hashtable
09:27:18.986 [main] DEBUG org.jboss.serial.persister.RegularObjectPersister - writeSlotWithMethod slot=java.util.Hashtable
09:27:18.986 [main] DEBUG org.jboss.serial.persister.RegularObjectPersister - writeSlotWithFields slot=java.util.Hashtable and 2 fields
09:27:18.986 [main] DEBUG org.jboss.serial.persister.RegularObjectPersister - writeSlotWithFields FieldNr=0
09:27:18.986 [main] DEBUG org.jboss.serial.persister.RegularObjectPersister - writeSlotWithFields slot=java.util.Hashtable primitiveField threshold with object=NULL
09:27:18.986 [main] DEBUG org.jboss.serial.persister.RegularObjectPersister - writeSlotWithFields FieldNr=1
09:27:18.986 [main] DEBUG org.jboss.serial.persister.RegularObjectPersister - writeSlotWithFields slot=java.util.Hashtable primitiveField loadFactor with object=NULL
09:27:18.989 [main] DEBUG org.jboss.serial.objectmetamodel.ObjectDescriptorFactory - objectFromDescription::reading new definition
09:27:18.990 [main] DEBUG org.jboss.serial.util.StringUtil - Reading string with utfSize=19 isLong=false
09:27:18.990 [main] DEBUG org.jboss.serial.util.StringUtil - readString::pulling data to Buffer at pos 0 size= 0
09:27:18.990 [main] DEBUG org.jboss.serial.util.HashStringUtil - hash on field java.util.Hashtable = 8568335707554902210
09:27:18.990 [main] DEBUG org.jboss.serial.classmetamodel.ClassMetaData - lookupMethodOnHierarchy::class=java.util.Hashtable looking for readResolve
09:27:18.990 [main] DEBUG org.jboss.serial.classmetamodel.ClassMetaData - lookupMethodOnHierarchy::currentClass=class java.util.Hashtable
09:27:18.990 [main] DEBUG org.jboss.serial.classmetamodel.ClassMetaData - lookupMethodOnHierarchy::currentClass=class java.util.Dictionary
09:27:18.990 [main] DEBUG org.jboss.serial.classmetamodel.ClassMetaData - lookupMethodOnHierarchy::class=java.util.Hashtable looking for writeReplace
09:27:18.990 [main] DEBUG org.jboss.serial.classmetamodel.ClassMetaData - lookupMethodOnHierarchy::currentClass=class java.util.Hashtable
09:27:18.990 [main] DEBUG org.jboss.serial.classmetamodel.ClassMetaData - lookupMethodOnHierarchy::currentClass=class java.util.Dictionary
09:27:18.990 [main] DEBUG org.jboss.serial.util.HashStringUtil - hash on field java.util.Hashtable = 8568335707554902210
09:27:18.990 [main] DEBUG org.jboss.serial.util.HashStringUtil - hash on field int$threshold = -81821300837738335
09:27:18.990 [main] DEBUG org.jboss.serial.util.HashStringUtil - hash on field float$loadFactor = 308335647531269238
09:27:18.991 [main] DEBUG org.jboss.serial.objectmetamodel.ObjectDescriptorFactory - Reading object for id=1 classLoader=sun.misc.Launcher$AppClassLoader@18b4aac2 className = java.util.Hashtable
09:27:18.991 [main] DEBUG org.jboss.serial.persister.RegularObjectPersister - defaultRead::class java.util.Hashtable contains 1 slots
09:27:18.991 [main] DEBUG org.jboss.serial.persister.RegularObjectPersister - defaultRead::slot[0]=java.util.Hashtable
09:27:18.991 [main] DEBUG org.jboss.serial.persister.RegularObjectPersister - readSlotWithMethod slot=java.util.Hashtable
09:27:18.991 [main] DEBUG org.jboss.serial.persister.RegularObjectPersister - readSlotWithFields slot=java.util.Hashtable
09:27:18.991 [main] DEBUG org.jboss.serial.persister.RegularObjectPersister - FieldName on Read=threshold
09:27:18.991 [main] DEBUG org.jboss.serial.persister.RegularObjectPersister - FieldName on Read=loadFactor
09:27:18.991 [main] INFO de.quoss.bug.jboss.serialization.Main - [deserialized={},deserialized.class.name=java.util.Hashtable

Process finished with exit code 0
```

And running with jdk8u322:

```
C:\Users\cleme\java\jdks\jdk-8\bin\java.exe -javaagent:C:\Users\cleme\AppData\Local\JetBrains\Toolbox\apps\IDEA-U\ch-0\221.5080.210\lib\idea_rt.jar=65433:C:\Users\cleme\AppData\Local\JetBrains\Toolbox\apps\IDEA-U\ch-0\221.5080.210\bin -Dfile.encoding=UTF-8 -classpath C:\Users\cleme\java\jdks\jdk-8\jre\lib\charsets.jar;C:\Users\cleme\java\jdks\jdk-8\jre\lib\ext\access-bridge-64.jar;C:\Users\cleme\java\jdks\jdk-8\jre\lib\ext\cldrdata.jar;C:\Users\cleme\java\jdks\jdk-8\jre\lib\ext\dnsns.jar;C:\Users\cleme\java\jdks\jdk-8\jre\lib\ext\jaccess.jar;C:\Users\cleme\java\jdks\jdk-8\jre\lib\ext\localedata.jar;C:\Users\cleme\java\jdks\jdk-8\jre\lib\ext\nashorn.jar;C:\Users\cleme\java\jdks\jdk-8\jre\lib\ext\sunec.jar;C:\Users\cleme\java\jdks\jdk-8\jre\lib\ext\sunjce_provider.jar;C:\Users\cleme\java\jdks\jdk-8\jre\lib\ext\sunmscapi.jar;C:\Users\cleme\java\jdks\jdk-8\jre\lib\ext\sunpkcs11.jar;C:\Users\cleme\java\jdks\jdk-8\jre\lib\ext\zipfs.jar;C:\Users\cleme\java\jdks\jdk-8\jre\lib\jce.jar;C:\Users\cleme\java\jdks\jdk-8\jre\lib\jfr.jar;C:\Users\cleme\java\jdks\jdk-8\jre\lib\jsse.jar;C:\Users\cleme\java\jdks\jdk-8\jre\lib\management-agent.jar;C:\Users\cleme\java\jdks\jdk-8\jre\lib\resources.jar;C:\Users\cleme\java\jdks\jdk-8\jre\lib\rt.jar;C:\Users\cleme\git\cquoss\jboss-serialization-bug\target\classes;C:\Users\cleme\.m2\repository\jboss\jboss-serialization\4.2.2.GA\jboss-serialization-4.2.2.GA.jar;C:\Users\cleme\.m2\repository\org\slf4j\slf4j-api\1.7.36\slf4j-api-1.7.36.jar;C:\Users\cleme\.m2\repository\ch\qos\logback\logback-classic\1.2.11\logback-classic-1.2.11.jar;C:\Users\cleme\.m2\repository\ch\qos\logback\logback-core\1.2.11\logback-core-1.2.11.jar;C:\Users\cleme\.m2\repository\trove\trove\1.0.2\trove-1.0.2.jar;C:\Users\cleme\.m2\repository\org\slf4j\log4j-over-slf4j\1.7.36\log4j-over-slf4j-1.7.36.jar de.quoss.bug.jboss.serialization.Main
09:31:28.961 [main] DEBUG org.jboss.serial.util.HashStringUtil - hash on field java.lang.reflect.Proxy = -1281934524198291041
09:31:28.963 [main] DEBUG org.jboss.serial.classmetamodel.ClassMetaData - lookupMethodOnHierarchy::class=java.lang.reflect.Proxy looking for readResolve
09:31:28.963 [main] DEBUG org.jboss.serial.classmetamodel.ClassMetaData - lookupMethodOnHierarchy::currentClass=class java.lang.reflect.Proxy
09:31:28.963 [main] DEBUG org.jboss.serial.classmetamodel.ClassMetaData - lookupMethodOnHierarchy::class=java.lang.reflect.Proxy looking for writeReplace
09:31:28.963 [main] DEBUG org.jboss.serial.classmetamodel.ClassMetaData - lookupMethodOnHierarchy::currentClass=class java.lang.reflect.Proxy
09:31:28.965 [main] DEBUG org.jboss.serial.util.HashStringUtil - hash on field java.lang.reflect.Proxy = -1281934524198291041
09:31:28.966 [main] DEBUG org.jboss.serial.util.HashStringUtil - hash on field java.lang.reflect.InvocationHandler$h = 3757213363974229139
09:31:28.967 [main] DEBUG org.jboss.serial.classmetamodel.FieldsManager - FieldsManager in use = org.jboss.serial.classmetamodel.UnsafeFieldsManager
09:31:28.992 [main] DEBUG org.jboss.serial.objectmetamodel.ObjectDescriptorFactory - describeObject for class=java.util.Hashtable
09:31:28.992 [main] DEBUG org.jboss.serial.util.HashStringUtil - hash on field java.util.Hashtable = 8568335707554902210
09:31:28.992 [main] DEBUG org.jboss.serial.classmetamodel.ClassMetaData - lookupMethodOnHierarchy::class=java.util.Hashtable looking for readResolve
09:31:28.992 [main] DEBUG org.jboss.serial.classmetamodel.ClassMetaData - lookupMethodOnHierarchy::currentClass=class java.util.Hashtable
09:31:28.992 [main] DEBUG org.jboss.serial.classmetamodel.ClassMetaData - lookupMethodOnHierarchy::currentClass=class java.util.Dictionary
09:31:28.992 [main] DEBUG org.jboss.serial.classmetamodel.ClassMetaData - lookupMethodOnHierarchy::class=java.util.Hashtable looking for writeReplace
09:31:28.992 [main] DEBUG org.jboss.serial.classmetamodel.ClassMetaData - lookupMethodOnHierarchy::currentClass=class java.util.Hashtable
09:31:28.992 [main] DEBUG org.jboss.serial.classmetamodel.ClassMetaData - lookupMethodOnHierarchy::currentClass=class java.util.Dictionary
09:31:28.993 [main] DEBUG org.jboss.serial.util.HashStringUtil - hash on field java.util.Hashtable = 8568335707554902210
09:31:28.993 [main] DEBUG org.jboss.serial.util.HashStringUtil - hash on field int$threshold = -81821300837738335
09:31:28.993 [main] DEBUG org.jboss.serial.util.HashStringUtil - hash on field float$loadFactor = 308335647531269238
09:31:28.993 [main] DEBUG org.jboss.serial.objectmetamodel.ObjectDescriptorFactory - describeObject::a new reference 1
09:31:28.999 [main] DEBUG org.jboss.serial.persister.RegularObjectPersister - defaultWrite::java.util.Hashtable contains 1 slots
09:31:28.999 [main] DEBUG org.jboss.serial.persister.RegularObjectPersister - defaultWrite:: slot 0 NR=java.util.Hashtable from parentClass=java.util.Hashtable
09:31:28.999 [main] DEBUG org.jboss.serial.persister.RegularObjectPersister - writeSlotWithMethod slot=java.util.Hashtable
09:31:28.999 [main] DEBUG org.jboss.serial.persister.RegularObjectPersister - writeSlotWithFields slot=java.util.Hashtable and 2 fields
09:31:28.999 [main] DEBUG org.jboss.serial.persister.RegularObjectPersister - writeSlotWithFields FieldNr=0
09:31:28.999 [main] DEBUG org.jboss.serial.persister.RegularObjectPersister - writeSlotWithFields slot=java.util.Hashtable primitiveField threshold with object=NULL
09:31:28.999 [main] DEBUG org.jboss.serial.persister.RegularObjectPersister - writeSlotWithFields FieldNr=1
09:31:28.999 [main] DEBUG org.jboss.serial.persister.RegularObjectPersister - writeSlotWithFields slot=java.util.Hashtable primitiveField loadFactor with object=NULL
09:31:29.002 [main] DEBUG org.jboss.serial.objectmetamodel.ObjectDescriptorFactory - objectFromDescription::reading new definition
09:31:29.002 [main] DEBUG org.jboss.serial.util.StringUtil - Reading string with utfSize=19 isLong=false
09:31:29.002 [main] DEBUG org.jboss.serial.util.StringUtil - readString::pulling data to Buffer at pos 0 size= 0
09:31:29.003 [main] DEBUG org.jboss.serial.util.HashStringUtil - hash on field java.util.Hashtable = 8568335707554902210
09:31:29.003 [main] DEBUG org.jboss.serial.classmetamodel.ClassMetaData - lookupMethodOnHierarchy::class=java.util.Hashtable looking for readResolve
09:31:29.003 [main] DEBUG org.jboss.serial.classmetamodel.ClassMetaData - lookupMethodOnHierarchy::currentClass=class java.util.Hashtable
09:31:29.003 [main] DEBUG org.jboss.serial.classmetamodel.ClassMetaData - lookupMethodOnHierarchy::currentClass=class java.util.Dictionary
09:31:29.003 [main] DEBUG org.jboss.serial.classmetamodel.ClassMetaData - lookupMethodOnHierarchy::class=java.util.Hashtable looking for writeReplace
09:31:29.003 [main] DEBUG org.jboss.serial.classmetamodel.ClassMetaData - lookupMethodOnHierarchy::currentClass=class java.util.Hashtable
09:31:29.003 [main] DEBUG org.jboss.serial.classmetamodel.ClassMetaData - lookupMethodOnHierarchy::currentClass=class java.util.Dictionary
09:31:29.003 [main] DEBUG org.jboss.serial.util.HashStringUtil - hash on field java.util.Hashtable = 8568335707554902210
09:31:29.003 [main] DEBUG org.jboss.serial.util.HashStringUtil - hash on field int$threshold = -81821300837738335
09:31:29.003 [main] DEBUG org.jboss.serial.util.HashStringUtil - hash on field float$loadFactor = 308335647531269238
09:31:29.003 [main] DEBUG org.jboss.serial.objectmetamodel.ObjectDescriptorFactory - Reading object for id=1 classLoader=sun.misc.Launcher$AppClassLoader@18b4aac2 className = java.util.Hashtable
09:31:29.004 [main] DEBUG org.jboss.serial.persister.RegularObjectPersister - defaultRead::class java.util.Hashtable contains 1 slots
09:31:29.004 [main] DEBUG org.jboss.serial.persister.RegularObjectPersister - defaultRead::slot[0]=java.util.Hashtable
09:31:29.004 [main] DEBUG org.jboss.serial.persister.RegularObjectPersister - readSlotWithMethod slot=java.util.Hashtable
09:31:29.007 [main] DEBUG org.jboss.serial.util.StringUtil - Reading string with utfSize=4611686018427390720 isLong=true
09:31:29.007 [main] DEBUG org.jboss.serial.util.StringUtil - readString::pulling data to Buffer at pos 0 size= 0
Exception in thread "main" java.io.IOException
	at org.jboss.serial.persister.RegularObjectPersister.readSlotWithMethod(RegularObjectPersister.java:107)
	at org.jboss.serial.persister.RegularObjectPersister.defaultRead(RegularObjectPersister.java:269)
	at org.jboss.serial.persister.RegularObjectPersister.readData(RegularObjectPersister.java:241)
	at org.jboss.serial.objectmetamodel.ObjectDescriptorFactory.readObjectDescriptionFromStreaming(ObjectDescriptorFactory.java:412)
	at org.jboss.serial.objectmetamodel.ObjectDescriptorFactory.objectFromDescription(ObjectDescriptorFactory.java:82)
	at org.jboss.serial.objectmetamodel.DataContainer$DataContainerDirectInput.readObject(DataContainer.java:643)
	at org.jboss.serial.io.JBossObjectInputStream.readObjectOverride(JBossObjectInputStream.java:163)
	at java.io.ObjectInputStream.readObject(ObjectInputStream.java:494)
	at java.io.ObjectInputStream.readObject(ObjectInputStream.java:461)
	at de.quoss.bug.jboss.serialization.Main.run(Main.java:26)
	at de.quoss.bug.jboss.serialization.Main.main(Main.java:31)
Caused by: java.lang.reflect.InvocationTargetException
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:498)
	at org.jboss.serial.persister.RegularObjectPersister.readSlotWithMethod(RegularObjectPersister.java:103)
	... 10 more
Caused by: java.io.EOFException
	at java.io.DataInputStream.readFully(DataInputStream.java:197)
	at org.jboss.serial.util.StringUtil.pullDataToBuffer(StringUtil.java:191)
	at org.jboss.serial.util.StringUtil.readString(StringUtil.java:238)
	at org.jboss.serial.objectmetamodel.DataContainer$DataContainerDirectInput.readUTF(DataContainer.java:757)
	at org.jboss.serial.persister.ObjectInputStreamProxy.readUTF(ObjectInputStreamProxy.java:196)
	at org.jboss.serial.objectmetamodel.FieldsContainer.readField(FieldsContainer.java:147)
	at org.jboss.serial.objectmetamodel.FieldsContainer.readMyself(FieldsContainer.java:218)
	at org.jboss.serial.persister.ObjectInputStreamProxy.readFields(ObjectInputStreamProxy.java:224)
	at java.util.Hashtable.readObject(Hashtable.java:1170)
	... 15 more

Process finished with exit code 1
```
